package com.learn.nbaplayer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chengpengfei
 */
@SpringBootApplication
@MapperScan("com.learn.nbaplayer.dao.mysql")
public class NbaPlayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NbaPlayerApplication.class, args);
	}

}
