/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudin.as.dao;

import com.sudin.as.entity.Employee;
import java.util.List;

/**
 *
 * @author ranji
 */
public interface EmployeeDAO {
    List<Employee> getaAll();
    void insert(Employee e);
    Employee getById(int id);
    
    
}
