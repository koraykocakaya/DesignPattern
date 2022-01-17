package com.kk.designPattern.structural.adapter;

import com.kk.designPattern.model.Circle;
import com.kk.designPattern.model.Rectangle;

public class CircleAdapter extends Rectangle{

	private Circle circle;
	
	public CircleAdapter(Circle circle) {
		this.circle = circle;

	}
	
	@Override
	public int getHeight() {
		return circle.radius*2;
	}
	
	@Override
	public int getWidth() {
		return circle.radius*2;
	}
}
