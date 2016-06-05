/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudin.as;

import com.sudin.as.dao.EmployeeDAO;
import com.sudin.as.dao.impl.EmployeeDAOImpl;
import com.sudin.as.entity.Employee;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ranji
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ring;
        StringBuilder build = null;

        Scanner scan = new Scanner(System.in);
        while (true) {
            while (true) {
                System.out.println("enter file location and name:[example: g:/filename.csv]");
                ring = scan.next();
                File file = new File(ring);
                if (file.exists()) {
                    break;
                }
                System.out.println("file not found");
            }
            try{
                BufferedReader reader =new BufferedReader(new FileReader("f:/Employee.csv"));
                EmployeeDAO employeeDAO=new EmployeeDAOImpl();
                String line="";
                StringBuilder builder=new StringBuilder();
                while((line = reader.readLine()) != null){
                    String[] tokens = line.split(",");
                    if (tokens.length >= 7) {
                       Employee employee = new Employee();
                        employee.setId(Integer.parseInt(tokens[0]));
                        employee.setFname(tokens[1]);
                        employee.setLname(tokens[2]);
                       employee.setEmail(tokens[3]);
                       employee.setContact(tokens[4]);
                       employee.setStatus(tokens[5].equals("1") ? true : false);
//                        if (employeeDAO.getById(employee.getId()==null)) {
//
//                            employeeDAO.insert(employee);
//                        }
//                    } else {
                        builder.append(line + "\r\n");
                 }
                }
                reader.close();
                employeeDAO.getaAll().forEach(c -> {
                    System.out.println(c);
                });
                           while (true) {
                    FileWriter writer = new FileWriter("F:/Employee.csv");
                   
                    writer.write(builder.toString());
                    System.out.println("what do you want to do:");
                    System.out.println("1. Insert");
                    System.out.println("2. Showall");
                    System.out.println("3. getById");
                    System.out.println("enter your choice 1-3");
                    switch (scan.nextInt()) {
                        case 1:
                            System.out.println("enter ID:");
                            int id = scan.nextInt();

                            System.out.println("enter First Name:");
                            String fName = scan.next().trim();

                            System.out.println("enter last name:");
                            String lName = scan.next();
                            
                            System.out.println("enter email:");
                            String email=scan.next().trim();
                            
                            System.out.println("enter contact number :");
                            String contact=scan.next().trim();
                         
                            System.out.println("enter salary:");
                            String salary=scan.next().trim();
                            
                            System.out.println("enter status:");
                            String status=scan.next().trim();
                            
                            employeeDAO.insert(new Employee(id, fName, lName, email, salary, contact, true));
                            
                            break;
                     
//                          case 2:
//                            System.out.println("Enter id");
//                           for(Employee s:employeeDAO)
                     
//                          case 2:
//                            System.out.println("Enter id");
//                           for(Employee s:employeeDAO)
                            
                    
                    
                            
                    }
                    writer.close();
                }
              
                
            }catch(IOException ie){
                System.out.println(ie.getMessage());
            }
    }// while loop
    } 
}
