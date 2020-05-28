package com.jiaming.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author jmstart
 * @create 2020-05-28 18:51
 */
@EnableWebSecurity //开启注解支持
public class mySecurityConfig extends WebSecurityConfigurerAdapter {

    //定义授权规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        /**
         * formLogin(): 开启自动配置登录功能,如果没有登录权限会自动跳转到登录页面
         * 1. 访问/login请求 来到登录页
         * 2. 访问/login?error 登录失败重定向到登录错误页面
         * loginPage("/userlogin"): 自定义登录页
         */
        http.formLogin()/*.loginPage("/userlogin")*/;

        /**
         * logout(): 开启自动配置注销功能
         * 1. 访问/logout 表示用户注销, 清空session
         * 2. 默认注销成功会返回到 /login?logout页面
         * logoutSuccessUrl("/"): 自己定义注销成功后返回首页
         */
        http.logout().logoutSuccessUrl("/");

        /**
         * 开启记住我功能
         * 登录成功后,将Cookie发送给浏览器保存,以后登录就带这个Cookie,检查通过免登录
         * 点击注销,会删除这个Cookie
         * .rememberMeParameter("remeber"): 自定义记住我
         */
        http.rememberMe()/*.rememberMeParameter("remeber")*/;

    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //从内存里查用户密码
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("root")).roles("VIP1", "VIP2")
                .and()
                .withUser("xiaoming").password(new BCryptPasswordEncoder().encode("root")).roles("VIP1","VIP2", "VIP3");

    }

}
