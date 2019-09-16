package com.kong.oa.biz;

import com.kong.oa.entity.Employee;

public interface GlobalBiz {

    Employee login(String sn, String password);

    void changePassword(Employee employee);
}
