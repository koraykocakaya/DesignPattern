package com.kk.designPattern.behavioral.nullObject;

public class NullObjectDemo {

	public static void main(String[] args) {
		System.out.println("Type: " + AnimalFactory.getAnimal("cat").getType());
		System.out.println("Type: " + AnimalFactory.getAnimal("lion").getType());
		System.out.println("Type: " + AnimalFactory.getAnimal("asdf").getType());
		System.out.println("Type: " + AnimalFactory.getAnimal("ewasdasdasd").getType());
	}
}
interface Animal{
	public String getType();
}

class Lion implements Animal{
	
	@Override
	public String getType() {
		return "Lion";
	}
}

class Cat implements Animal{
	
	@Override
	public String getType() {
		return "Cat";
	}
}

class NullAnimal implements Animal{
	
	@Override
	public String getType() {
		return "";
	}
}

class AnimalFactory{
	public static Animal getAnimal(String name) {
		if("lion".equals(name)) {
			return new Lion();
		} else if("cat".equals(name)) {
			return new Cat();
		}
		return new NullAnimal();
	}
}
