package com.nagarro.configuration;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
//@EnableWebMvc
@ComponentScan({ "com.nagarro.controllers" })
public class AppConfig extends WebMvcConfigurerAdapter {

}