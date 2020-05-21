package com.jiaming.service;

import com.jiaming.bean.Department;
import com.jiaming.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author jmstart
 * @create 2020-05-20 9:16
 */
@Service
public class DeptService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Cacheable(cacheNames = "dep")
    public Department getDepById(Integer id) {
        System.out.println("查询部门" + id);
        Department department = departmentMapper.getDepById(id);
        return department;
    }

}
