package com.jiaming.controller;

import com.jiaming.bean.Employee;
import com.jiaming.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author jmstart
 * @create 2020-05-17 11:22
 */

//@Controller
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        Employee emp = empService.getEmp(id);
        return emp;
    }

    @GetMapping("/emp")
    public Employee updateEmp(Employee employee) {
        Employee emp = empService.updateEmp(employee);
        return emp;
    }

    @GetMapping("/delemp")
    public String deleteEmp(Integer id) {
        empService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/lastName/{lastName}")
    public Employee getEmpLastName(@PathVariable("lastName") String lastName) {
        Employee employee = empService.getEmpByLastName(lastName);
        return employee;
    }
}
