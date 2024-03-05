package com.example.demo.empEntity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@Entity
@Table(name="Emp_Table")
public class EmpEntity {


//@GeneratedValue used for setting auto increament the data
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;

	private int dob;
	private String empName;
	private double salary;

//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
//	(or)
//	@JsonFormat(pattern = "dd/MM/yyyy")
//	private Date joiningDate;
//	private Date relivingDate;


	private String joiningDate;
	private String relivingDate;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getRelivingDate() {
		return relivingDate;
	}

	public void setRelivingDate(String relivingDate) {
		this.relivingDate = relivingDate;
	}

	public int getDob() {
		return dob;
	}

	public void setDob(int dob) {
		this.dob = dob;
	}

	public void setId(int i) {
	}

	public EmpEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpEntity(int empId, int dob, String empName, double salary, String joiningDate, String relivingDate) {
		super();
		this.empId = empId;
		this.dob = dob;
		this.empName = empName;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.relivingDate = relivingDate;
	}

	@Override
	public String toString() {
		return "EmpEntity [empId=" + empId + ", dob=" + dob + ", empName=" + empName + ", salary=" + salary
				+ ", joiningDate=" + joiningDate + ", relivingDate=" + relivingDate + "]";
	}

	//	public Date getJoiningDate() {
//		return joiningDate;
//	}
//
//	public void setJoiningDate(Date joiningDate) {
//		this.joiningDate = joiningDate;
//	}
//
//	public Date getRelivingDate() {
//		return relivingDate;
//	}
//
//	public void setRelivingDate(Date relivingDate) {
//		this.relivingDate = relivingDate;
//	}
	
}
