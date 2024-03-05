package com.example.demo.service;
import java.util.*;
import ch.qos.logback.core.model.conditional.ElseModel;
import com.example.demo.customException.UserDataNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.empEntity.EmpEntity;
import com.example.demo.empRepo.EmpRepo;

@Service
public class EmpService {
	@Autowired
	EmpRepo repo;
	
	public EmpEntity empsave(EmpEntity emp) {
		return repo.save(emp);

	}

	public List<EmpEntity> getAllRecords(List<EmpEntity> emp){

		return repo.saveAll(emp);
	}

	public void deleteById(int id){
		repo.deleteById(id);
		System.out.println("Deleted successfully");
	}


	public List<EmpEntity> listRecords(){
		return repo.findAll();
	}

	public EmpEntity getuniqueRecords(int id) throws UserDataNotFound {
//		old Method
//		if(repo.findById(id).isPresent())
//			return repo.findById(id).get();
//        return null;

		return repo.findById(id).orElseThrow(()->new UserDataNotFound("userdata not found"));
    }


	public EmpEntity updateById(int id, EmpEntity emp) {
		EmpEntity empt = repo.findById(id).get();
		empt.setSalary(emp.getSalary()!=0?emp.getSalary() :empt.getSalary() );
		empt.setEmpName(emp.getEmpName()!=null?emp.getEmpName():empt.getEmpName());
		empt.setRelivingDate(emp.getRelivingDate()!=null?emp.getRelivingDate(): empt.getRelivingDate());
		return repo.save(empt);

	}

	public EmpEntity getbyname(String str) {
		return repo.findByEmpName(str);
	}


}
