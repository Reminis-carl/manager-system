package com.swpu.system_manager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        authorizeRequests所有security全注解实现的开端，表示开始说明需要的权限。
//        需要的权限分两部分，第一部分是拦截路径，第二部分访问该路径需要的权限
//        anyRequest任何的请求，authenticated认证后才能访问
//        .and().csrf().disable();固定写法，表示csrf拦截失效
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
//                .anyRequest().permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
