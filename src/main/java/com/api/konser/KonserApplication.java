package com.api.konser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@RestController
public class KonserApplication {

	public static void main(String[] args) {
		SpringApplication.run(KonserApplication.class, args);
	}

	@GetMapping("hello")
	public String hello(@RequestParam(value = "name", defaultValue = "world") String name){
		return String.format("Hello %s!", name);
	}

}
