package com.example.demo;

import com.example.demo.payload.Result;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarApplication {

	@Bean
	public Result result(){
		return new Result();
	}

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}

}
