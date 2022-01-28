package com.kk.designPattern.behavioral.templateMethod;

public class TemplateMethodDemo {
	public static void main(String[] args) {
		
		Creature cr1 = new Creature(1, 2);
		Creature cr2 = new Creature(1, 3);
		CardGame cardGame = new PermanentCardDamageGame(new Creature[] {cr1,cr2});
		System.out.println(cardGame.combat(0, 1));
		System.out.println(cardGame.combat(0, 1));
		
		cr1 = new Creature(1, 2);
		cr2 = new Creature(1, 3);
		cardGame = new TemporaryCardDamageGame(new Creature[] {cr1,cr2});
		
		System.out.println(cardGame.combat(0, 1));
		System.out.println(cardGame.combat(0, 1));
		System.out.println(cardGame.combat(0, 1));
		System.out.println(cardGame.combat(0, 1));
		System.out.println(cardGame.combat(0, 1));
		System.out.println(cardGame.combat(0, 1));
	}
}

class Creature {
	public int attack, health;

	public Creature(int attack, int health) {
		this.attack = attack;
		this.health = health;
	}
}

abstract class CardGame {
	public Creature[] creatures;

	public CardGame(Creature[] creatures) {
		this.creatures = creatures;
	}

	// returns -1 if no clear winner (both alive or both dead)
	public int combat(int creature1, int creature2) {
		Creature first = creatures[creature1];
		Creature second = creatures[creature2];
		hit(first, second);
		hit(second, first);

		int returnVal = -1;
		if ((first.health > 0 && second.health > 0) || (first.health <= 0 && second.health <= 0)) {
			
		}

		else if (first.health > 0) {
			returnVal = creature1;
		} else {
			returnVal = creature2;
		}
		
		reset(first, second);
		reset(second, first);
		return returnVal;
	}

	// attacker hits other creature
	protected abstract void hit(Creature attacker, Creature other);
	protected abstract void reset(Creature attacker, Creature other);	
}

class TemporaryCardDamageGame extends CardGame {

	Creature first;
	Creature second;
	
	public TemporaryCardDamageGame(Creature[] creatures) {
		super(creatures);
		first = creatures[0];
		second = creatures[1];
	}

	@Override
	protected void hit(Creature attacker, Creature other) {
		other.health -= attacker.attack;
	}
	
	@Override
	protected void reset(Creature attacker, Creature other) {
		other.health += attacker.attack;
	}

}

class PermanentCardDamageGame extends CardGame {

	public PermanentCardDamageGame(Creature[] creatures) {
		super(creatures);
	}

	@Override
	protected void hit(Creature attacker, Creature other) {
		other.health -= attacker.attack;
	}
	
	@Override
	protected void reset(Creature attacker, Creature other) {
		
	}
}
