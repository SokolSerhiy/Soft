package ua;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		
	}
	
	void some() {
		List<Person> persons = new ArrayList<>();
		int reduce = persons.stream().filter(this::checkPersonName)
			.filter(p->p.getPets().size()>3)
			.map(Person::getPets)
			.flatMap(List::stream)
			.filter(p->p.getName().startsWith("B"))
			.map(Pet::getName)
			.flatMapToInt(String::chars)
			.reduce(0, Integer::sum);
		List<Person> list = persons.stream().sorted(Comparator.comparing(Person::getName).reversed().thenComparingInt(Person::getAge).reversed()).collect(Collectors.toList());
	}
	
	boolean checkPersonName(Person p) {
		return p.getName().startsWith("A");
	}

}
