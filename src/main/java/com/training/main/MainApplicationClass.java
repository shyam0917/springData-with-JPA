package com.training.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.training.controller.MovieController;

@SpringBootApplication
@ComponentScan(basePackageClasses = MovieController.class)
public class MainApplicationClass {

	public static void main(String[] args) {
SpringApplication.run(MainApplicationClass.class, args);
	}

}
