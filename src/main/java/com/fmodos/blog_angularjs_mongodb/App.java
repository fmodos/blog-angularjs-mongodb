package com.fmodos.blog_angularjs_mongodb;

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fmodos.blog_angularjs_mongodb.rest.DishRest;

@SpringBootApplication
@EnableAutoConfiguration
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Named
	public static class JerseyConfig extends ResourceConfig {

		public JerseyConfig() {
			this.register(DishRest.class);
		}
	}

}
