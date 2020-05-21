package com.jiaming.test;

import com.jiaming.bean.Employee;
import com.jiaming.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jmstart
 * @create 2020-05-19 10:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private RedisTemplate redisTemplate; //操作key-value都是对象

    @Autowired
    private StringRedisTemplate stringRedisTemplate; //操作key-value都是字符串

    @Autowired
    private RedisTemplate<Object,Employee> employeeRedisTemplate; //自定义序列化器

    /**
     * Redis常见五大数据类型:
     *   操作 String(字符串)、list(列表)、set(集合)、Hash(散列)、Zset(有序集合)
     *
     * stringRedisTemplate.opsForValue(); 操作字符串
     * stringRedisTemplate.opsForHash(); 操作散列
     * stringRedisTemplate.opsForList(); 操作列表
     * stringRedisTemplate.opsForSet(); 操作集合
     * stringRedisTemplate.opsForZSet(); 操作有序集合
     */
    @Test
    public void test01() {

        //测试向 Redis中保存数据
        stringRedisTemplate.opsForValue().append("msg", "testRedis");
    }

    @Test
    public void test02() {

        //测试读 Redis
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
    }

    @Test
    public void test03() {

        //测试 Redis 列表
       stringRedisTemplate.opsForList().leftPush("mylist", "1");
       stringRedisTemplate.opsForList().leftPush("mylist", "2");
       stringRedisTemplate.opsForList().leftPush("mylist", "3");
       stringRedisTemplate.opsForList().leftPush("mylist", "4");
       stringRedisTemplate.opsForList().leftPush("mylist", "5");
    }

    @Test
    public void test04() {

        //测试 Redis 保存对象
        Employee employee01 = employeeMapper.getEmpById(1);
        Employee employee02 = employeeMapper.getEmpById(2);
        //对象需要序列化,否则会报错,
        //默认使用jdk的序列化器,人类是看不懂的,所以要自己写个配置改一下序列化器
        //把序列化的对象保存到 Redis中
        //redisTemplate.opsForValue().set("emp-01", employee);

        //1. 将数据以 json方式保存
        // (1). 自己将对象转换成json,可以用jackson
        // (2). redisTemplate默认的序列化规则,重写序列化器
        employeeRedisTemplate.opsForValue().set("emp-01",employee01);
        employeeRedisTemplate.opsForValue().set("emp-02",employee02);

    }







}
