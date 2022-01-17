package com.kk.designPattern.model;

import java.util.Objects;

public abstract class Shape {
		
	
	public int fieldX;
	public int fieldY;
	public String color;
	
	public Shape() {
		
	}
	
	public Shape(Shape shape){
		super();
		this.fieldX = shape.fieldX;
		this.fieldY = shape.fieldY;
		this.color = shape.color;
	}
	
	public abstract Shape clone();
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Shape)) {
			return false;
		}
		Shape shapeObj = (Shape)obj;
		return shapeObj.fieldX == this.fieldX && shapeObj.fieldY == this.fieldY && Objects.equals(shapeObj.color, this.color);
	}
}
