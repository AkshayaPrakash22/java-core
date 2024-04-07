package com.day3.learning;

import java.util.Objects;
import java.util.TreeSet;

class Person implements Comparable<Person> {
	private int id;
	private String name;
	private int age;
	private double salary;

	public Person(int id, String name, int age, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Person{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", salary=" + salary + '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, id, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && id == other.id && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}

	@Override
	public int compareTo(Person other) {
		return Integer.compare(this.id, other.id);
	}
}

public class D03P05 {

	public static void main(String[] args) {
		TreeSet<Person> personSet = new TreeSet<>();

		// Predefined person information
		Person person1 = new Person(1, "Jerry", 20, 999.0);
		Person person2 = new Person(2, "Smith", 25, 2999.0);
		Person person3 = new Person(3, "Popeye", 23, 5999.0);
		Person person4 = new Person(4, "Jones", 18, 6999.0);
		Person person5 = new Person(5, "John", 32, 1999.0);
		Person person6 = new Person(6, "Tom", 42, 3999.0);

		// Storing persons in TreeSet
		personSet.add(person1);
		personSet.add(person2);
		personSet.add(person3);
		personSet.add(person4);
		personSet.add(person5);
		personSet.add(person6);

		// Print persons whose age is greater than 25
		System.out.println("Persons whose age is greater than 25:");
		for (Person person : personSet) {
			if (person.getAge() > 25) {
				System.out.println("Id=" + person.getId() + ",name=" + person.getName() + ",age=" + person.getAge()
						+ ",salary=" + person.getSalary());
			}
		}
	}

}
