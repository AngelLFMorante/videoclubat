package com.videoclubat.videoclubat.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.videoclubat.videoclubat")
@EntityScan("com.videoclubat.videoclubat.entity")
@EnableJpaRepositories("com.videoclubat.videoclubat.repository")
public class VideoclubatApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoclubatApplication.class, args);
	}

}
