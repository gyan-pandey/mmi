package com.mmi.service;

import java.sql.Connection;
import java.util.List;

import com.mmi.bean.EmployeeDetails;

public interface EmployeeService {

	public List<EmployeeDetails> getEmployeeDetails();

	public void insertEmployeeDetails(EmployeeDetails emp);

	public void deleteEmployeeDetails(int d);

	public List<EmployeeDetails> updateEmployeeDetails(int id);
	
	/*public List<EmployeeDetails> updateData(int id,String name,String designation,float salary) ;*/

	public List<EmployeeDetails> updateData(EmployeeDetails employeeDetails);

}
