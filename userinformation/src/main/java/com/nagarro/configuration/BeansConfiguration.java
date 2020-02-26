package com.nagarro.configuration;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.nagarro.authenticator.Authenticator;
import com.nagarro.constants.Constants;
import com.nagarro.dao.HrUtil;
import com.nagarro.dao.HrUtilDao;
import com.nagarro.hibernateUtil.HibernateUtil;
import com.nagarro.service.Service;

@Configuration
//@ComponentScan(basePackages="com.nagarro")
//@EnableScheduling
public class BeansConfiguration {

	@Bean
	public HibernateUtil getHibernateUtil() {
		return new HibernateUtil();
	}

	@Bean
	public Authenticator getAuthenticator() {
		return new Authenticator();
	}

	@Bean
	public Service getService() {
		return new Service();
	}

	@Bean
	public HrUtilDao getHrUtilDao() {
		return new HrUtil();
	}

	@Bean
	public Constants getConstants() {
		return new Constants();
	}
}
