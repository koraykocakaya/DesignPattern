package com.kk.designPattern.structural.adapter;

import com.kk.designPattern.model.Circle;
import com.kk.designPattern.model.Rectangle;

public class AdapterDemo {

	public static void main(String[] args) {
		Circle circle = new Circle();
		
		circle.radius = 80;
		// Bu cemberin icine girebilecegi kare olarak dusunebiliriz
		Rectangle rec = new CircleAdapter(circle);
		System.out.println(rec.getHeight());
		System.out.println(rec.getWidth());
		
	}
}
