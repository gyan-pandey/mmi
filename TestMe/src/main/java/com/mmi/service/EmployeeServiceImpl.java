package com.mmi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmi.bean.EmployeeDetails;
import com.mmi.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {
   
	@Autowired
	EmployeeDao employeeDao ;

	public void insertEmployeeDetails(EmployeeDetails emp) {

		employeeDao.insert(emp);
	}

	public void deleteEmployeeDetails(int d) {

		employeeDao.delete(d);
	}

	@Override
	public List<EmployeeDetails> getEmployeeDetails() {

		return employeeDao.getEmployeeDetails();
	}

	@Override
	public List<EmployeeDetails> updateEmployeeDetails(int id) {
		return employeeDao.update(id);

	}

	/*@Override
	public List<EmployeeDetails> updateData(int id, String name, String designation, float salary) {
		// TODO Auto-generated method stub
	  return employeeDao.updateData(id, name, designation, salary);
	  //return employeeDao.update(id);
	}*/
	@Override
	public List<EmployeeDetails> updateData(EmployeeDetails employeeDetails) {
		// TODO Auto-generated method stub
	  return employeeDao.updateData(employeeDetails);
	  //return employeeDao.update(id);
	}

	

}
