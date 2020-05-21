package com.jiaming.service;

import com.jiaming.bean.Employee;
import com.jiaming.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;


/**
 * @author jmstart
 * @create 2020-05-17 11:18
 */
//@CacheConfig它可以抽取定义一些公共属性,下面的注解就不用定义了
@CacheConfig(cacheNames = "emp")
@Service
public class EmpService {

    @Autowired
    private EmployeeMapper employeeMapper;

    //将方法的运行结果放到缓存中 @Cacheable
    //常用属性:
    //cacheNames&value: 是缓存组件的名字
    //key = "#id" : key是缓存数据的key值(缓存数据是 key_value形式的),默认是方法参数的值
    //keyGenerator = "myKeyGenerator" 使用自己定义的主键生成策略
    //key默认使用keyGenerator策略生成
    //condition: 符合条件的情况下才缓存
    //(条件:一号员工不缓存,二号员工缓存) condition = "#id>1"或者condition = "#a0>1"或者condition = "#p0>1"
    //unless: 不符合条件的情况下才缓存
    //unless = "#a0==2" 如果是二号员工就不缓存了
    @Cacheable(/*cacheNames = "emp",*/ /*condition = "#p0>1"*/)
    public Employee getEmp(Integer id) {
        System.out.println("查询" + id + "号员工");
        Employee employee = employeeMapper.getEmpById(id);
        return employee;
    }

    //CachePut: 即调用了方法,又更新了缓存,如数据库更新了,缓存也自动更新
    //key要更换一下,这样缓存才会更新
    @CachePut(/*cacheNames = "emp", */key = "#employee.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("updateEmp: " + employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    //CacheEvict: 缓存清除
    //key 要清除的数据
    //allEntries = true 清除缓存中所有的key和value
    // beforeInvocation = true 在方法执行前清除缓存,这样方法内有异常也干扰不到缓存清除
    @CacheEvict(/*cacheNames = "emp",*/ key = "#id")
    public void deleteEmp(Integer id) {
        System.out.println("deleteEmp: " + id);
        employeeMapper.deleteEmpById(id);
    }

    //一个注解相当于上面的三个注解的结合体
    @Caching(
            cacheable = {
                    @Cacheable(/*cacheNames = "emp",*/ key = "#lastName")
            },
            put = {
                    @CachePut(/*cacheNames = "emp",*/ key = "#result.id"),
                    @CachePut(/*value = "emp",*/ key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName) {

        Employee employee = employeeMapper.getEmpByLastName(lastName);
        return employee;
    }
}
