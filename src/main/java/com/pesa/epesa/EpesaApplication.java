package com.pesa.epesa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@EntityScan("come.epesa.model")
public class EpesaApplication {

	public static void main(String[] args) {
	SpringApplication.run(EpesaApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	  //Enable a "live" profile
	  context.getEnvironment().setActiveProfiles("live");
	 // context.register(AppConfig.class);
	  context.refresh();

	}
}
