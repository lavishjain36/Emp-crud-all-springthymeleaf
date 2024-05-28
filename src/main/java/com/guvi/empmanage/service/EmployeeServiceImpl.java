package com.guvi.empmanage.service;

import com.guvi.empmanage.model.Employee;
import com.guvi.empmanage.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

    //inject repository to into service layer
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {

        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new RuntimeException("Employee not found "+id);
        }
    }

//    @Override
//    public void updateEmployee(Long id, Employee updatedEmployee) {
//        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
//
//            Employee existingEmployee = optionalEmployee.get();
//            existingEmployee.setFirstName(updatedEmployee.getFirstName());
//            existingEmployee.setLastName(updatedEmployee.getLastName());
//            existingEmployee.setEmail(updatedEmployee.getEmail());
//            // Update other fields as needed
//            employeeRepository.save(existingEmployee);
//        }

    public void updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
            existingEmployee.setLastName(updatedEmployee.getLastName());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            // Update other fields as needed
            employeeRepository.save(existingEmployee);
        }
    }



    @Override
    public void deleteEmployee(Long id) {

        employeeRepository.deleteById(id);
    }




}
