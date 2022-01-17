package com.kk.designPattern.structural.bridge;

public class BridgeDemo {
	
	public static void main(String[] args) {
		BridgeDemo demo = new BridgeDemo(); 
		demo.testBridgePattern();
	}
	
	public void testBridgePattern() {
		Renderer vectorRenderer = new VectorRenderer();
		Shape triangle = new Triangle(vectorRenderer);
		System.out.println(triangle.toString());
		
		Renderer rasterRenderer = new RasterRenderer();
		Shape square = new Square(rasterRenderer);
		System.out.println(square.toString());
	}
	
	abstract class Shape {
		Renderer renderer;
		Shape(Renderer renderer){
			this.renderer = renderer;
		}
		
		public abstract String getName();
	}

	class Triangle extends Shape {
		
		Triangle(Renderer renderer){
			super(renderer);
		}
		
		@Override
		public String getName() {
			return "Triangle";
		}
		
		@Override
		public String toString() {
			return "Drawing Triangle as " + renderer.whatToRenderAs();
		}
	}

	class Square extends Shape {
		
		Square(Renderer renderer){
			super(renderer);
		}
		
		@Override
		public String getName() {
			return "Square";
		}
		
		@Override
		public String toString() {
			return "Drawing Square as " + renderer.whatToRenderAs();
		}
	}
	
	interface Renderer{
		public String whatToRenderAs();
	}
	
	class VectorRenderer implements Renderer{

		@Override
		public String whatToRenderAs() {
			return "lines";
		}
		
	}
	
	class RasterRenderer implements Renderer{

		@Override
		public String whatToRenderAs() {
			return "pixels";
		}
		
	}
	
}
