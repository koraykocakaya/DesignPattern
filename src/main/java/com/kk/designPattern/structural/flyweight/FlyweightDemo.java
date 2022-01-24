package com.kk.designPattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightDemo {
	public static void main(String[] args) {
		FlyweightDemo fd = new FlyweightDemo();
		fd.testFlyweight();
	}

	public void testFlyweight() {
		Sentence sentence = new Sentence("hello world");
		sentence.getWord(1).capitalize = true;
		System.out.println(sentence);
	}

}

class Sentence {
	private String plainText;
	private Map<Integer, WordToken> wordTokenMap = new HashMap<>();

	public Sentence(String plainText) {
		this.plainText = plainText;
	}

	public WordToken getWord(int index) {
		WordToken token = new WordToken();
		wordTokenMap.put(index, token);
		return token;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String[] words = plainText.split(" ");

		for (int i = 0; i < words.length; i++) {
			if(wordTokenMap.containsKey(i) && wordTokenMap.get(i).capitalize == true) {
				sb.append(words[i].toUpperCase());
			} else {
				sb.append(words[i]);
			}
			
			if (i != words.length - 1) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	class WordToken {
		public boolean capitalize;
	}
}
