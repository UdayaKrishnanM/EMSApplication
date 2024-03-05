package com.example.demo.emscontroller;

import com.example.demo.customException.UserDataNotFound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.demo.empEntity.EmpEntity;
import com.example.demo.service.EmpService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.*;


@RestController
public class EmsController {
	@Autowired
	EmpService service;

	private static final Logger logger = LoggerFactory.getLogger(EmsController.class);


	@Value("${ID}")
	public int employeeId;

	@Value("${Name}")
	public String employeeName;



	@Operation(
            summary = "Retrieve Emp deatils",
            description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description, and published status.",
            tags = {"Employee"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successful retrieval", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = "Tutorial not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
	@GetMapping("/employee-details")
	public String getEmployeeDetails() {
		return "Employee ID: " + employeeId + ", Employee Name: " + employeeName;
	}
//	@GetMapping("/get-emp-records")
//	public String display() {
//
//		return "hello spring Application";
//	}

//	This is used for getting one data
	@PostMapping("/savesingle-emprecords")
	//@RequestBody acts like api which  changes Java to JSON file and vice versa
	public EmpEntity saveSingleEmprecords(@RequestBody EmpEntity emprec) {
		return service.empsave(emprec);

	}



	@PostMapping("/save-emprecords")
	//@RequestBody acts like api which  changes Java to JSON file and vice versa
	public ResponseEntity<EmpEntity> saveEmprecords(@RequestBody EmpEntity emprec) {
		logger.info("Performing the logger method....****..");
		EmpEntity save = service.empsave(emprec);
		return new ResponseEntity<EmpEntity>(save, HttpStatus.OK);

	}







//	this is used for getting all data from db
	@PostMapping("/get-alldata")
	public List<EmpEntity> getAllData(@RequestBody List<EmpEntity> emp){

		return service.getAllRecords(emp);
	}


//	get the particular data from db using ID
//	PathVariable is used to get a PK id from postman
	@GetMapping("/get-uniqueId/{id}")
	public EmpEntity getuniqueData(@PathVariable int id) throws UserDataNotFound {

		return service.getuniqueRecords(id);
	}




//	this is used for getting list of datas

	@GetMapping("/list-allrecords")
	public List<EmpEntity> listAllRecords(){
		return service.listRecords();
	}

//this is used to delete a data from db using id
	@DeleteMapping("/deletebyid/{id}")
	public void deleteById(@PathVariable int id){

		service.deleteById(id);
	}


//	update a particular data from table using id, and json

	@PutMapping("/updatebyid/{id}")
	public EmpEntity updateById(@PathVariable int id, @RequestBody EmpEntity emp){
		return service.updateById(id, emp);

	}
//method for getting the names with similar in db


	@GetMapping("/getbyname/{name}")
	public EmpEntity getbyname(@PathVariable String str){
		return service.getbyname(str);
	}


//



}

