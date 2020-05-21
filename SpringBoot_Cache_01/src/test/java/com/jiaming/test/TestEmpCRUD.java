package com.jiaming.test;

import com.jiaming.bean.Employee;
import com.jiaming.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jmstart
 * @create 2020-05-17 11:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEmpCRUD {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void getEmp() {
        Employee employee = employeeMapper.getEmpById(1);
        System.out.println(employee);
    }


}
