package com.guvi.empmanage.repository;

import com.guvi.empmanage.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
