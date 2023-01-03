package com.qsp.prepared_statement_project_service;

import java.util.List;

import com.qsp.prepared_statement_project_Dao.StudentDao;
import com.qsp.prepared_statement_project_dto.Student;

public class StudentService {
	StudentDao dao=new StudentDao();
	public void insertStudent(List<Student> students) 
	{
	  dao.insertStudent(students);	
	}
		//this method used  for update name from table
		public void updateStudentName(Student student)
		{
			dao.updateStudentName(student);
		}
		// this method used for update email
		 public void updateStudentEmail(Student student)
		 {
			 dao.updateStudentEmail(student);
		 }
		//this method used delete from table
		public void deleteStudent(Student student)
		{
			dao.deleteStudent(student);
		}
		//this method used for display all member
		public void displayStudent(Student student)
		{
			dao.displayStudent(student);
		}
		// othe method for display
		public List<Student> display()
		{
			return dao.display();
		}
		
		
		
}

