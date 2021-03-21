package com.henrique.boockstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.henrique.boockstore.servise.DBServise;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBServise dbServise;
	
	@Bean
	public void instanciaBaseDeDados() {
		this.dbServise.instanciaBaseDeDados();
	}
	
}
