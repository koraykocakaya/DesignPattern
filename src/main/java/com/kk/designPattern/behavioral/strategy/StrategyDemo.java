package com.kk.designPattern.behavioral.strategy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StrategyDemo {

	public static String getListAsStr(List<Person> personList) {
		String delimeter = " - ";
		return 			 personList.stream()
								   .map(x -> x.toString())
								   .collect(Collectors.joining(delimeter));
	}
	
	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(
			new Person("John", "Schurman", 41),
			new Person("Kevin", "Afobe", 33),
			new Person("Jack", "Hesse", 55)
		);
		
		personList.sort(new AgeComparator());
		System.out.println(getListAsStr(personList));
		
		personList.sort(new NameComparator());
		System.out.println(getListAsStr(personList));
		
		personList.sort((x1, x2) -> 
							x1.getSurname().compareTo(x2.getSurname()));
		
		System.out.println(getListAsStr(personList));
	}
}

class AgeComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		return (o1.getAge() - o2.getAge());
	}
}


class NameComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getName().compareTo(o2.getName());
	}
}

class Person{
	private String name;
	private String surname;
	private int age;
	
	public Person(String name, String surname, int age) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + ", surname: " + surname + ", age: " + age;
	}
}
