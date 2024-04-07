package com.day3.learning;

import java.util.Hashtable;

public class D03P10 {

	public static void main(String[] args) {
		Hashtable<Integer, Employee> table = new Hashtable<>();
		table.put(1001, new Employee(1001, "Daniel", "Analyst", "L&D"));
		table.put(1002, new Employee(1002, "Thomas", "Tester", "Testing"));
		table.put(1003, new Employee(1003, "Robert", "Project Manager", "Development"));
		table.put(1004, new Employee(1004, "Grace", "Tech support", "Hr"));

		int searchId = 1003;
		Employee foundEmployee = table.get(searchId);

		if (foundEmployee != null) {
			System.out.println(foundEmployee);
		} else
			System.out.println("Not Found");

	}
}
