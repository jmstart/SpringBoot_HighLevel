package com.jiaming.mapper;

import com.jiaming.bean.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author jmstart
 * @create 2020-05-17 10:54
 */
public interface EmployeeMapper {

    @Select("select * from employee where id=#{id}")
    public Employee getEmpById(Integer id);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    public void updateEmp(Employee employee);

    @Delete("delete from employee where id=#{id}")
    public void deleteEmpById(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmp(Employee employee);

    @Select("select * from employee where lastName=#{lastName}")
    public Employee getEmpByLastName(String lastName);
}
