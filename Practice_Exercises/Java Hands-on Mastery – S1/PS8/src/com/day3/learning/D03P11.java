package com.day3.learning;

import java.util.Hashtable;

public class D03P11 {
	
	public static void main(String[] args) {
		Hashtable<Integer, Employee> table = new Hashtable<>();
		table.put(1001, new Employee(1001, "Daniel", "Analyst", "L&D"));
		table.put(1002, new Employee(1002, "Thomas", "Tester", "Testing"));
		table.put(1003, new Employee(1003, "Robert", "Project Manager", "Development"));
		table.put(1004, new Employee(1004, "Grace", "Tech support", "Hr"));
		
		
        int newEmployee = 1005;
        Employee newEmp = table.get(newEmployee);

        // Print the found employee details if found
        if (newEmp != null) {
            System.out.println("Already in the table");
            System.out.println(newEmployee);
        } else {
            Employee employee= new Employee(1005, "Charles", "QA", "Lead Testing");
            table.put(1005, employee);
        }
        System.out.println("After adding new employee:");
        for (Employee employee : table.values()) {
            System.out.println(employee);
        }

	}
}
