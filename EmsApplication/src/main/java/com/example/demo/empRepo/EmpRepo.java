package com.example.demo.empRepo;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.example.demo.empEntity.EmpEntity;

@Repository
public interface EmpRepo extends JpaRepository<EmpEntity, Integer> {

	//public EmpEntity getbyEmpName(String str);
	public EmpEntity findByEmpName(String name);
}
