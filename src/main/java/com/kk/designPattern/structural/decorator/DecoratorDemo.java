package com.kk.designPattern.structural.decorator;

public class DecoratorDemo {
	public static void main(String[] args) {
		Dragon dragon = new Dragon();
		dragon.setAge(15);
		System.out.println(dragon.crawl());
		System.out.println(dragon.fly());
	}
}

class Bird {
    public int age;

    public String fly() {
        return age < 10 ? "flying" : "too old";
    }
}

class Lizard {
    public int age;

    public String crawl() {
        return (age > 1) ? "crawling" : "too young";
    }
}

class Dragon {
    Bird bird = new Bird();

    Lizard lizard = new Lizard();

    private int age;

    public void setAge(int age) {
        this.age = age;
        bird.age = age;
        lizard.age = age;
    }

    public String fly() {
        return bird.fly();
    }

    public String crawl() {
        return lizard.crawl();
    }
}
