package ua;

import java.util.List;

public class Person implements Comparable<Person>{

	private String name;
	
	private int age;
	
	private List<Pet> pets;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	@Override
	public int compareTo(Person o) {
		return 0;
	}
	
	
}
