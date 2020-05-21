package com.jiaming.mapper;

import com.jiaming.bean.Department;
import org.apache.ibatis.annotations.Select;

/**
 * @author jmstart
 * @create 2020-05-17 10:55
 */
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDepById(Integer id);
}
