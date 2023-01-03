package com.qsp.prepared_statement_project_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qsp.prepared_statement_project_connection.StudentConnection;
import com.qsp.prepared_statement_project_dto.Student;

public class StudentDao {
	Connection connection=null;
	public void insertStudent(List<Student> students)
	{
		connection=StudentConnection.getConnection();
		try {
		String insert="insert into student values(?,?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(insert);
	     for (Student student : students) 
	     {
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getEmail());
			preparedStatement.addBatch();
		 }
	     preparedStatement.executeBatch();
	     System.out.println("Data inserted...");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
	//this method used  for update name from table
	public void updateStudentName(Student student) {
	 
	 try {
		connection=StudentConnection.getConnection();
		String update="update student set name=? where id =?";
		PreparedStatement preparedStatement=connection.prepareStatement(update);
		preparedStatement.setString(1, student.getName());
		preparedStatement.setInt(2, student.getId());
		preparedStatement.executeUpdate();
		System.out.println("name is updated.....");
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		
	}
	// this method used for update eamil
	 public void updateStudentEmail(Student student) {
	 
	 try {
		 connection=StudentConnection.getConnection();
		 String update="update student set email=? where id =?";
		PreparedStatement preparedStatement=connection.prepareStatement(update);
		preparedStatement.setString(1, student.getEmail());
		preparedStatement.setInt(2, student.getId());
		preparedStatement.executeUpdate();
		System.out.println("email is updated.....");
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
 }
		
	
	//this method used delete from table
	public void deleteStudent(Student student)
	{
		connection=StudentConnection.getConnection();	
		
		try {
			String delete="delete from student where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(delete);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.executeUpdate();
			System.err.println("Data is deleted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//this method used for display all member
	public void displayStudent(Student student)
	{
	
	try {
		connection=StudentConnection.getConnection();
		String display="select * from student";
		PreparedStatement preparedStatement=connection.prepareStatement(display);
		ResultSet resultSet= preparedStatement.executeQuery();
		while(resultSet.next())
		{
		  System.out.println(resultSet.getInt(1));
		  System.out.println(resultSet.getString(2));
		  System.out.println(resultSet.getString(3));
		  System.out.println("....................");
		}
			
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	}
	// othe method for display
	public List<Student> display()
	{
		
		try {
			connection=StudentConnection.getConnection();
			String display="select * from student";
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(display);
			ResultSet resultSet= preparedStatement.executeQuery();
			List<Student> list=new ArrayList<Student>();
			while(resultSet.next())
			{
				Student student=new Student();
				student.setId(resultSet.getInt("id"));
				student.setName(resultSet.getString("name"));
				student.setEmail(resultSet.getString("email"));
				list.add(student);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	

}
