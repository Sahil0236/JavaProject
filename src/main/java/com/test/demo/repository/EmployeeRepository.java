package com.test.demo.repository;

import com.test.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e JOIN e.country c WHERE c.name = :countryName AND (:deptName IS NULL OR e.dept.name = :deptName)")
    List<Employee> findByCountryNameAndOptionalDeptName(@Param("countryName") String countryName, @Param("deptName") String deptName);
}
