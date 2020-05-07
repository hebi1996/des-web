package com.xmh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@MapperScan("com.xmh.mapper")
@SpringBootApplication
@EnableWebMvc
public class DesWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesWebApplication.class, args);
	}

}
