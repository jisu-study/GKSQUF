package com.example.demo.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class WebSecurityConfig {


    protected void configure(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
                .csrf().disable()
                .authorizeHttpRequests()
                .anyRequest().permitAll()   //모든 요청에 대해 접근 허용
                .and()
                .formLogin().disable()  //로그인 과정 비활성화
                .httpBasic().disable();  //기본 인증도 비활성화
    }

}
