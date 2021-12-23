package com.kk.designPattern.creational.prototype;

public class Rectangle extends Shape {

	public int width;
	public int height;
	
	public Rectangle() {
		
	}
	
	private Rectangle(Rectangle rectangle) {
		super(rectangle);
		this.width = rectangle.width;
		this.height = rectangle.height;
	}
	
	@Override
	public Shape clone() {
		return new Rectangle(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj) || !(obj instanceof Rectangle) ) {
			return false;
		}
		Rectangle rectangleObj = (Rectangle) obj;
		return rectangleObj.width == this.width && rectangleObj.height == this.height; 
	}

}
