package com.kk.designPattern.behavioral.chainOfResponsbility;

public class MethodChainExample {
	
	public static void main(String[] args) {
		CreatureEx creature1 = new CreatureEx("Creature1", 2, 3);
		System.out.println(creature1);
		CreatureModifier root = new CreatureModifier(creature1);
		root.add(new DoubleAttackModifier(creature1));
		root.add(new NoBonusModifier(creature1));
		// defense after nobonus wont be executed
		root.add(new DefenseModifier(creature1));
		root.handle();
		
		System.out.println(creature1);
	}
}

class CreatureEx{
	String name;
	int attack, defense;
	
	public CreatureEx(String name, int attack, int defense) {
		super();
		this.name = name;
		this.attack = attack;
		this.defense = defense;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + ", attack: " + attack + ", defense: " + defense;
	}
}

// base
class CreatureModifier {
	
	CreatureEx creature;
	CreatureModifier next;
	public CreatureModifier(CreatureEx creature) {
		this.creature = creature;
	}
	
	public void add(CreatureModifier modifier) {
		if(next == null) {
			next = modifier;
		} else {
			next.add(modifier);
		}
	}
	
	public void handle() {
		if(next != null) {
			next.handle();
		}
	}
}

class DoubleAttackModifier extends CreatureModifier{
	
	public DoubleAttackModifier(CreatureEx creature) {
		super(creature);
	}
	
	public void handle() {
		creature.attack *= 2;
		System.out.println("Creature " + creature.name + " attack increased");
		super.handle();
	}
}

class DefenseModifier extends CreatureModifier{
	
	public DefenseModifier(CreatureEx creature) {
		super(creature);
	}
	
	public void handle() {
		creature.defense += 2;
		System.out.println("Creature " + creature.name + " defense increased");
		super.handle();
	}
	
}

class NoBonusModifier extends CreatureModifier{
	
	public NoBonusModifier(CreatureEx creature) {
		super(creature);
	}
	
	public void handle() {
		System.out.println("You can't get any bonus further");
		return;
	}
}
