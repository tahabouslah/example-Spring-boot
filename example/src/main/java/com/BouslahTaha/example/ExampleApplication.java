package com.BouslahTaha.example;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

	@GetMapping("/greet")
	public GreetRespone greet() {
		GreetRespone response = new GreetRespone(
				"hello",
				List.of("Java", "Python", "PHP"),
				new Person("taha"));
		return response;
	}

	record Person(String name) {
	}

	record GreetRespone(String greet, List<String> favProgLang, Person person) {
	}

	// class GreetRespone {
	// private String greet;

	// GreetRespone(String greet) {
	// this.greet = greet;
	// }

	// public String getGreet() {
	// return greet;
	// }

	// @Override
	// public String toString() {
	// // TODO Auto-generated method stub
	// return super.toString();
	// }

	// @Override
	// public boolean equals(Object obj) {
	// // TODO Auto-generated method stub
	// return super.equals(obj);
	// }

	// }

}
