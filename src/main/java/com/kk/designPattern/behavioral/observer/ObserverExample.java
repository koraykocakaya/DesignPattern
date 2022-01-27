package com.kk.designPattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverExample {
	public static void main(String[] args) {
		Person p1 = new Person();
		Observer<Person> observer1 = new ObserverConcrete1();
		Observer<Person> observer2 = new ObserverConcrete2();
		
		p1.subscribe(observer1);
		p1.subscribe(observer2);
		
		p1.setAge(44);
		p1.setAge(71);
	}
}

class PropertyChangedEventArgs<T>{
	T object;
	String propertyName;
	Object newValue;
	
	public PropertyChangedEventArgs(T object, String propertyName, Object newValue) {
		super();
		this.object = object;
		this.propertyName = propertyName;
		this.newValue = newValue;
	}
}

interface Observer<T>{
	void handle(PropertyChangedEventArgs<T> args);
}

class Observable <T>{
	
	List<Observer<T>> observers = new ArrayList<>(); 
	
	void subscribe(Observer<T> observer) {
		observers.add(observer);
	}
	
	protected void propertyChanged(T object, String propertyName, Object newValue) {
		for (Observer<T> observer : observers) {
			observer.handle(new PropertyChangedEventArgs<T>(object, propertyName, newValue));
		}
	}
}

class Person extends Observable<Person>{
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age == this.age) return;
		this.age = age;
		propertyChanged(this, "age", age);
	}
}

class ObserverConcrete1 implements Observer<Person>{

	@Override
	public void handle(PropertyChangedEventArgs<Person> args) {
		System.out.println("Concrete1 called, " + args.propertyName + " new value is: " + args.newValue);
	}
}

class ObserverConcrete2 implements Observer<Person>{

	@Override
	public void handle(PropertyChangedEventArgs<Person> args) {
		System.out.println("Concrete2 called, " + args.propertyName + " new value is: " + args.newValue);
	}
}
