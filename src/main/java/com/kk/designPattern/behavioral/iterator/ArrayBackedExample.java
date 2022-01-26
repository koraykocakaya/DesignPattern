package com.kk.designPattern.behavioral.iterator;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class ArrayBackedExample {
	public static void main(String[] args) {
		CreatureItr creature = new CreatureItr();
		creature.setAgility(10);
		creature.setIntelligence(20);
		creature.setStrength(28);
		
		creature.forEach(System.out::println);
		
		System.out.println(creature.sum());
		System.out.println(creature.max());
		System.out.println(creature.average());
	}
}

class CreatureItr implements Iterable<Integer>{

	int[] properties = new int[3];
	
	public int getStrength() {
		return properties[0];
	}
	
	public void setStrength(int strength) {
		properties[0] = strength;
	}
	
	public int getAgility() {
		return properties[1];
	}
	
	public void setAgility(int agility) {
		properties[1] = agility;
	}
	
	public int getIntelligence() {
		return properties[2];
	}
	
	public void setIntelligence(int intelligence) {
		properties[2] = intelligence;
	}
	
	public int max() {
		return IntStream.of(properties).max().getAsInt();
	}
	
	public int sum() {
		return IntStream.of(properties).sum();
	}
	
	public double average() {
		return IntStream.of(properties).average().getAsDouble();
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return IntStream.of(properties).iterator();
	}
	
	@Override
	public void forEach(Consumer<? super Integer> action) {
		for(int property: properties) {
			action.accept(property);
		}
	}
}
