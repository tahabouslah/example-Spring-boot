package com.BouslahTaha.example;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class ExampleApplication {

	private final CustomerRepository cr;

	public ExampleApplication(CustomerRepository cr) {
		this.cr = cr;
	}

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

	// @GetMapping("/greet")
	// public GreetRespone greet() {
	// GreetRespone response = new GreetRespone(
	// "hello",
	// List.of("Java", "Python", "PHP"),
	// new Person("taha"));
	// return response;
	// }

	// record Person(String name) {
	// }

	// record GreetRespone(String greet, List<String> favProgLang, Person person) {
	// }

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

	@GetMapping
	public List<Customer> getcustomers() {
		return cr.findAll();
	}

	/**
	 * InnerExampleApplication
	 */
	public record Crequest(String name, String email, Integer age) {

	}

	@PostMapping
	public void AddCustomer(@RequestBody Crequest request) {
		Customer c = new Customer();
		c.setAge(request.age());
		c.setName(request.name());
		c.setEmail(request.email());
		cr.save(c);
	}

	@DeleteMapping("{customerId}")
	public void DeleteCustomer(@PathVariable("customerId") Integer id) {
		// TODO: process POST request
		cr.deleteById(id);

	}

	@PutMapping("{customerId}")
	public void Update(@PathVariable("customerId") Integer id) {
		// TODO: process PUT request
		cr.deleteById(id);
		Customer c = new Customer();
		c.setAge(request.age());
		c.setName(request.name());
		c.setEmail(request.email());
		cr.save(c);

	}

}
