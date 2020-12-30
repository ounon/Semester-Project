package com.compiler.maincontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
@ComponentScan("com.compiler")
public class MaincontrollerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaincontrollerApplication.class, args);
	}

       
}
