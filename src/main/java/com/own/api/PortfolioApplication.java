package com.own.api;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan(basePackages = "com.own.api")
public class PortfolioApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(PortfolioApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
		LOGGER.info("API START");
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
