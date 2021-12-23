package com.kk.designPattern.creational.prototype;

public class Circle extends Shape {

	public int radius;
	
	public Circle() {
		
	}
	
	private Circle(Circle circle) {
		super(circle);
		this.radius = circle.radius;
	}
	
	public Shape clone() {
		return new Circle(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj) || !(obj instanceof Circle) ) {
			return false;
		}
		Circle circleObj = (Circle) obj;
		return circleObj.radius == this.radius;
	}
}
