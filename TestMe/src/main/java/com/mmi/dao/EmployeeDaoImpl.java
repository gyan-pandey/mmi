package com.mmi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mmi.bean.EmployeeDetails;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	
	Connection connection = null;
	PreparedStatement ps = null;

	public Connection getDatabaseConnection() {
		try {

			/*InputStream f = this.getClass().getClassLoader().getResourceAsStream("db.properties");
			Properties p = new Properties();
			String jdbcUrl =p.getProperty("url");
			String user =p.getProperty("user");
			String password =p.getProperty("password");*/
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mmi","postgres","postgres");
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException s) {
			s.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		  
		return connection;
	}

	public void insert(EmployeeDetails emp) {
		try {
			getDatabaseConnection();
			Statement statement = connection.createStatement();
			ps = connection.prepareStatement("insert into emp99 values (? , ? , ? , ?)");
			ps.setInt(1, emp.getId());

			ps.setString(2, emp.getName());
			ps.setFloat(3, emp.getSalary());
			ps.setString(4, emp.getDesignation());

			ps.executeUpdate();
			System.out.println("inserted succefully");
		} catch (SQLException s) {
			s.printStackTrace();
		}

		finally {
			if (ps != null & connection != null) {
				try {
					ps.close();
					connection.close();
				} catch (SQLException s) {

				}
			}
		}
	}

	public void delete(int id) {
		try {
			getDatabaseConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from emp99 where id = " + id + "");
			System.out.println("data deleted");
		} catch (SQLException s) {
			s.printStackTrace();
		}

		finally {
			if (ps != null & connection != null) {
				try {
					ps.close();
					connection.close();
				} catch (SQLException s) {

				}
			}
		}
	}

	public List<EmployeeDetails> update(int d) {
		List<EmployeeDetails> employeeDetailsList = new ArrayList<EmployeeDetails>();
		try {
			getDatabaseConnection();
			Statement statement = connection.createStatement();
			String sql = "select * from emp99 where id = " + d + "";
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				EmployeeDetails employeeDetails = new EmployeeDetails();
				employeeDetails.setId(Integer.parseInt(resultSet.getString("id")));
				employeeDetails.setName(resultSet.getString("name"));
				employeeDetails.setSalary(Integer.parseInt(resultSet.getString("salary")));
				employeeDetails.setDesignation(resultSet.getString("designation"));
			
				employeeDetailsList.add(employeeDetails);
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}

		finally {
			if (ps != null & connection != null) {
				try {
					ps.close();
					connection.close();
				} catch (SQLException s) {

				}
			}
		}
		return employeeDetailsList;
	}
	
	
	
	public List<EmployeeDetails> updateData(EmployeeDetails employeeDetails) {
		List<EmployeeDetails> employeeDetailsList = new ArrayList<EmployeeDetails>();
		try {
			getDatabaseConnection();
			
			ps = connection.prepareStatement("UPDATE emp99 SET name=?,salary=?,designation=? WHERE id="+employeeDetails.getId());
			ps.setString(1, employeeDetails.getName());
            ps.setFloat(2,employeeDetails.getSalary());
			ps.setString(3,employeeDetails.getDesignation() );
			ps.executeUpdate();
			System.out.println("updated succefully");
			
		} catch (SQLException s) {
			s.printStackTrace();
		}

		finally {
			if (ps != null & connection != null) {
				try {
					ps.close();
					connection.close();
				} catch (SQLException s) {

				}
			}
		}
		return employeeDetailsList;
	}
	
	/*public List<EmployeeDetails> updateData(int id,String name,String designation,float salary) {
		
		List<EmployeeDetails> employeeDetailsList = new ArrayList<EmployeeDetails>();
		try {
			getDatabaseConnection();
			Statement statement = connection.createStatement();
			ps = connection.prepareStatement("UPDATE emp99 SET name=?,salary=?,designation=? WHERE id="+id);
			ps.setString(1, name);
            ps.setFloat(2, salary);
			ps.setString(3, designation);
		//	ps.setInt(4, id);

			ps.executeUpdate();
			System.out.println("updated succefully");
			
			getDatabaseConnection();
			statement = connection.createStatement();
			String sql = "select * from emp99" ;
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				EmployeeDetails employeeDetails = new EmployeeDetails();
				employeeDetails.setId(Integer.parseInt(resultSet.getString("id")));
				employeeDetails.setName(resultSet.getString("name"));
				employeeDetails.setSalary(Integer.parseInt(resultSet.getString("salary")));
				employeeDetails.setDesignation(resultSet.getString("designation"));

				employeeDetailsList.add(employeeDetails);
			}
		}
			
		 catch (SQLException s) {
			s.printStackTrace();
		}

		finally {
			if (ps != null & connection != null) {
				try {
					ps.close();
					connection.close();
				} catch (SQLException s) {

				}
			}
		}
		
		
		return employeeDetailsList;
	}*/
	

	public List<EmployeeDetails> getEmployeeDetails() {
		List<EmployeeDetails> employeeDetailsList = new ArrayList<EmployeeDetails>();
		try {
			getDatabaseConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from emp99");

			while (resultSet.next()) {
				EmployeeDetails employeeDetails = new EmployeeDetails();
				employeeDetails.setId(Integer.parseInt(resultSet.getString("id")));
				employeeDetails.setName(resultSet.getString("name"));
				employeeDetails.setSalary(Float.parseFloat(resultSet.getString("salary")));
				employeeDetails.setDesignation(resultSet.getString("designation"));

				employeeDetailsList.add(employeeDetails);
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}

		finally {
			if (ps != null & connection != null) {
				try {
					ps.close();
					connection.close();
				} catch (SQLException s) {

				}
			}
		}
		return employeeDetailsList;
	}
	
	
	

}
