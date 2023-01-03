package com.qsp.prepared_statement_project_Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.qsp.prepared_statement_project_dto.Student;
import com.qsp.prepared_statement_project_service.StudentService;

public class StudentController {
	
	public static void main(String[] args)
	
	{   Scanner scanner=new Scanner(System.in);
		
		
		System.out.println("Enter your choice....");
	    System.out.println("1.insert");
	    System.out.println("2. update");
	    System.out.println("3.delete");
	    System.out.println("4.display");
	    System.out.println("5.display in controller");
		int choice=scanner.nextInt();

		List<Student> list=new ArrayList<Student>();
		StudentService studentService=new StudentService();
		Student student=new Student();
		
		switch(choice)
		{
		case 1:{
			System.out.println("how many student you want to add");
			int size=scanner.nextInt();
			for(int i=0;i<size;i++)
			{
				
				System.out.println("Enter the student id");
				student.setId(scanner.nextInt());
				System.out.println("Enter the student name");
				student.setName(scanner.next());
				System.out.println("Enter the student email");
				student.setEmail(scanner.next());
				list.add(student);
				
			}
			studentService.insertStudent(list);
			
		}break;
		
        case 2:
                 for(int i=0;i<2;i++) {
        	    System.out.println("1.update name");
        	    System.out.println("2.update email");
        	    System.out.println("Enter your choice");
        	    int ch=scanner.nextInt();
        	switch(ch)
        	{
        	case 1:{
        		 System.out.println("Enter the new name you want to update from table");
        	     student.setName(scanner.next());
        	     System.out.println("Enter the id..");
        	     student.setId(scanner.nextInt());
        	     studentService.updateStudentName(student);
        	       }break;
        	case 2:{
        		   System.out.println("Enter the new email you want to update from table");
       	           student.setEmail(scanner.next());;
       	           System.out.println("Enter the id..");
       	           student.setId(scanner.nextInt());
       	           studentService.updateStudentEmail(student);
        		
 	               }break;
 	        
        	}
        { 
        	    
        }	
		}break;
		
        case 3:{  System.out.println("Enter the id you want to delete column");
                  student.setId(scanner.nextInt());
                  studentService.deleteStudent(student);
			
		}break;
		
        case 4:{
        	studentService.displayStudent(student);
			
		}break;
        case 5:
        {
        	System.out.println("Id\t\tName\t\tEmail");
        	for (Student student1 : studentService.display()) {
        		
        		System.out.print(student1.getId()+"\t\t");
        		System.out.print(student1.getName()+"\t\t");
        		System.out.print(student1.getEmail());
        		System.out.println();
				
			}
        }
		
		}
	}

}
