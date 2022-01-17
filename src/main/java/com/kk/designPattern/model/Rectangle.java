package com.kk.designPattern.model;

public class Rectangle extends Shape {

	private int width;
	private int height;
	

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
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
