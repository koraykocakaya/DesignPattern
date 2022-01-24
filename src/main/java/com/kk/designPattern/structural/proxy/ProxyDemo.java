package com.kk.designPattern.structural.proxy;

public class ProxyDemo {
	
	public void printDetail(ResponsiblePerson respPerson) {
		System.out.println(respPerson.drink());
		System.out.println(respPerson.drive());
	}
	
	public void testProxyDesignPattern() {
		Person person = new Person(33);
		ResponsiblePerson respPerson = new ResponsiblePerson(person);
		
		printDetail(respPerson);
		
		respPerson.setAge(14);
		
		printDetail(respPerson);
	}
	
	public static void main(String[] args) {
		ProxyDemo pd = new ProxyDemo();
		pd.testProxyDesignPattern();
	}
}

class Person {
	private int age;

	public Person(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String drink() {
		return "drinking";
	}

	public String drive() {
		return "driving";
	}

	public String drinkAndDrive() {
		return "driving while drunk";
	}
}

class ResponsiblePerson {
	private Person person;

	public ResponsiblePerson(Person person) {
		this.person = person;
	}

	public String drink() {
		return person.getAge() < 18 ? "too young" : person.drink();
	}

	public String drive() {
		return person.getAge() < 16 ? "too young" : person.drive();
	}

	public String drinkAndDrive() {
		return "dead";
	}

	public void setAge(int age) {
		person.setAge(age);
	}

}
