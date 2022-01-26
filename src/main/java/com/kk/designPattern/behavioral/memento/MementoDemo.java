package com.kk.designPattern.behavioral.memento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MementoDemo {
	public static void main(String[] args) {
		TokenMachine tm = new TokenMachine();
		Token token1 = new Token(100);
		Memento m1 = tm.addToken(token1);
		// bu yuzden mementoya atarken kopyalamamiz gerekmekte
		token1.value = 123;		
		
		Token token2 = new Token(200);
		tm.addToken(token2);
		
		tm.revert(m1);
		System.out.println(tm.tokens.get(0).value);
	}
}

class Token
{
  public int value = 0;

  public Token(int value)
  {
    this.value = value;
  }
}

class Memento
{
  public List<Token> tokens = new ArrayList<>();
}

class TokenMachine
{
  public List<Token> tokens = new ArrayList<>();

  public Memento addToken(int value)
  {
	  return addToken(new Token(value));
  }

  public Memento addToken(Token token)
  {
	tokens.add(token);
	Memento memento = new Memento();
	
	// map satiri kritik, kopyalamak zorundayiz cunku mementoya attiktan sonra state'i degisebilir
	memento.tokens =  tokens
						.stream()
						.map(tk -> new Token(tk.value))
						.collect(Collectors.toList());

	return memento;
  }

  public void revert(Memento m)
  {
    this.tokens = m.tokens
    				.stream()
    				.map(tk -> new Token(tk.value))
    				.collect(Collectors.toList());
  }
}
