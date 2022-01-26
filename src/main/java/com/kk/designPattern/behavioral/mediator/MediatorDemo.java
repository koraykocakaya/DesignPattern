package com.kk.designPattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorDemo {
	public static void main(String[] args) {
		
		Mediator mediator = new Mediator();
		Participant p1 = new Participant(mediator);
		Participant p2 = new Participant(mediator);
		
		p1.say(10);
		System.out.println(p1.value);
		System.out.println(p2.value);
		
		p2.say(4);
		System.out.println(p1.value);
		System.out.println(p2.value);
	}
}

class Participant
{
  int value = 0;
  Mediator mediator;
  public Participant(Mediator mediator)
  {
	  this.mediator = mediator;
    mediator.participantList.add(this);
  }

  public void say(int n)
  {
	  mediator.broadcast(this, n); 
  }
}

class Mediator
{
  List<Participant> participantList = new ArrayList<>();
  
  public void broadcast(Participant participant, int increasedValue){
	  participantList.stream()
	  				 .filter(p -> !p.equals(participant))
	  				 .forEach(p -> p.value += increasedValue);
  }
}
