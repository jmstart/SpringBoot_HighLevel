package com.jiaming.controller;

import com.jiaming.bean.Department;
import com.jiaming.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jmstart
 * @create 2020-05-20 9:23
 */
@RestController
public class DepController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dep/{id}")
    public Department getDepById(@PathVariable("id") Integer id) {
        Department department = deptService.getDepById(id);
        return department;
    }
}
