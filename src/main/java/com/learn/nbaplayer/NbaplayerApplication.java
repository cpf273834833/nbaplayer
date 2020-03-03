package com.learn.nbaplayer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.learn.nbaplayer.dao.mysql")
public class NbaplayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NbaplayerApplication.class, args);
	}

}
