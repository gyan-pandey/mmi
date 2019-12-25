package com.mmi.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mmi.bean.EmployeeDetails;


public interface EmployeeDao {
	
	public Connection getDatabaseConnection();
	public void insert(EmployeeDetails emp);
	public void delete(int id);
	public List<EmployeeDetails> update(int d);
	public List<EmployeeDetails> updateData(EmployeeDetails employeeDetails);
	public List<EmployeeDetails> getEmployeeDetails();
	
	

}
