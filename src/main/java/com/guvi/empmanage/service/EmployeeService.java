package com.guvi.empmanage.service;

import com.guvi.empmanage.model.Employee;


import java.util.List;

public interface EmployeeService {
    //define services
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    void updateEmployee(Long id, Employee updatedEmployee);

    void deleteEmployee(Long id);



}
