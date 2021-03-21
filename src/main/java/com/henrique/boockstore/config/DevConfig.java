package com.henrique.boockstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.henrique.boockstore.servise.DBServise;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBServise dbServise;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean intaciaBaseDeDados() {
		if(strategy.equals("create")) {
			this.dbServise.instanciaBaseDeDados();
		}
		return false;
	}
	
	
}
