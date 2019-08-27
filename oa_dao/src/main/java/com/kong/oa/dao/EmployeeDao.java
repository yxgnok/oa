package com.kong.oa.dao;

import com.kong.oa.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("EmployeeDao")
public interface EmployeeDao {
    void insert(Employee employee);

    void update(Employee employee);

    void delete(String sn);

    Employee select(String sn);

    List<Employee> selectAll();

}
