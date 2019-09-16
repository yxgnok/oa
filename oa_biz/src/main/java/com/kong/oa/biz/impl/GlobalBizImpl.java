package com.kong.oa.biz.impl;

import com.kong.oa.biz.GlobalBiz;
import com.kong.oa.dao.EmployeeDao;
import com.kong.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("globalBiz")
public class GlobalBizImpl implements GlobalBiz {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee login(String sn, String password) {
        Employee employee = employeeDao.select(sn);
        if (employee != null && employee.getPassword().equals(password)) {
            return employee;
        }
        //登录失败
        return null;
    }

    @Override
    public void changePassword(Employee employee) {
        employeeDao.update(employee);
    }
}
