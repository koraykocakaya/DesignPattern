package com.kk.designPattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatRoomExample {
	public static void main(String[] args) {
		ChatRoom room = new ChatRoom();
		Person tom = new Person("Tom");
		Person zack = new Person("Zack");
		
		room.join(tom);
		room.join(zack);
		
		tom.say("Hello");
		zack.say("Welcome Tom");
		 
		Person joshua = new Person("Joshua");
		room.join(joshua);
		
		joshua.privateMessage("Tom", "Hi Tom, private");
	}
}
class Person{
	public String name;
	public ChatRoom room;
	List<String> chatLog = new ArrayList<>();
	
	public Person(String name) {
		this.name = name;
	}
	
	public void receive(String sender, String message) {
		String fullMsg = sender + ": '" + message + "'";
		System.out.println(name + " received message from " + fullMsg );
		chatLog.add(fullMsg);
	}
	
	public void say(String message) {
		room.broadcast(name, message);
	}
	
	public void privateMessage(String destination, String message) {
		room.message(name, destination, message);
	}
}

class ChatRoom{
	private List<Person> personList = new ArrayList<>();
	
	public void join(Person person) {
		broadcast("Room", person.name + " joined");
		personList.add(person);
		person.room = this;
	}
	
	public void broadcast(String source, String message) {
		personList.stream()
				  .filter(p -> !p.name.equals(source))
				  .forEach(x -> x.receive(source, message));
	}
	
	public void message(String source, String destination, String message) {
		personList.stream()
				  .filter(p -> p.name.equals(destination))
				  .findFirst()
				  .ifPresent(p -> p.receive(source, message));
	}
}
