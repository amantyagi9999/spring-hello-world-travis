package com.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import com.core.controller.HelloController;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class CoreApplication {

	private static Logger logger = LogManager.getLogger(HelloController.class);

	public static void main(String[] args) {

		logger.debug("Hello test log");
		logger.info("Hello test log");
		logger.error("Hello test log");

		SpringApplication.run(CoreApplication.class, args);
	}

}
