/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudin.as.dao.impl;

import com.sudin.as.dao.EmployeeDAO;
import com.sudin.as.entity.Employee;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ranji
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public List<Employee> getaAll() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("f:/Employee.csv"));
            System.out.println(employeeList);

        } catch (IOException ex) {

        }
        return employeeList;
    }

    @Override
    public void insert(Employee e) {
        employeeList.add(e);
        System.out.println(employeeList);

    }

    @Override
    public Employee getById(int id) {
    for (Employee s : employeeList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;    
    }

}
