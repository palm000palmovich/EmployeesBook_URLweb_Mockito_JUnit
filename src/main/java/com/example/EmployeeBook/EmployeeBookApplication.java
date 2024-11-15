package com.example.EmployeeBook;

import com.example.EmployeeBook.Services.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EmployeeBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeBookApplication.class, args);

		List<Employee> emplList = new ArrayList<>();
		Employee em = new Employee(1,"her", 43);
		emplList.add(em);
		System.out.println(emplList.contains(em));
	}

}
