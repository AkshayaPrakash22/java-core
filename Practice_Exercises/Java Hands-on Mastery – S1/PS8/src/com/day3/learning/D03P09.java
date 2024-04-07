package com.day3.learning;

import java.util.Hashtable;
import java.util.Objects;

class Employee {
	private int id;
	private String name;
	private String department;
	private String designation;

	public Employee(int id, String name, String department, String designation) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.designation = designation;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", designation=" + designation
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(department, designation, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(department, other.department) && Objects.equals(designation, other.designation)
				&& id == other.id && Objects.equals(name, other.name);
	}

}

public class D03P09 {
	public static void main(String[] args) {
		Hashtable<Integer, Employee> table = new Hashtable<>();
		table.put(1001, new Employee(1001, "Daniel", "Analyst", "L&D"));
		table.put(1002, new Employee(1002, "Thomas", "Tester", "Testing"));
		table.put(1003, new Employee(1003, "Robert", "Project Manager", "Development"));
		table.put(1004, new Employee(1004, "Grace", "Tech support", "Hr"));

		if (table.isEmpty()) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}

}
