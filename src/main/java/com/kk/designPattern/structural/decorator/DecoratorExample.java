package com.kk.designPattern.structural.decorator;

public class DecoratorExample {

	interface Shape {
		public String info();
	}
	
	class Circle implements Shape{
		
		float radius;
		Circle(float radius){
			this.radius = radius;
		}
		
		public String info() {
			return "Circle with radius: " + radius;
		}
	}
	
	class ColoredShape implements Shape{
		private String color;
		private Shape shape;
		
		ColoredShape(Shape shape, String color){
			this.shape = shape;
			this.color = color;
		}
		
		public String info() {
			return shape.info() + ", with color: " + color;
		}
	}
	
	class TransparentShape implements Shape{
		
		private int transparency;
		private Shape shape;
		
		public TransparentShape(Shape shape, int transparency) {
			this.shape = shape;
			this.transparency = transparency;
		}
		
		@Override
		public String info() {
			return shape.info() + ", with transparency: %" + transparency;
		}
	}

	public void testDecoratorPattern() {
		
		// open for extension, closed for modification
		Shape shape = new TransparentShape(
				new ColoredShape(
						new Circle(13), "Red"), 40);
		System.out.println(shape.info());
	}
	
	public static void main(String[] args) {
		DecoratorExample de  = new DecoratorExample();
		de.testDecoratorPattern();
	}
}
