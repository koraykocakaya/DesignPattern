package com.kk.designPattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Application {
	public static void main(String[] args) {
		
		List<Shape> shapeList = new ArrayList<>();
		Circle c1 = new Circle();
		c1.radius = 12;
		c1.fieldX = 14;
		shapeList.add(c1);
		
		Rectangle r1 = new Rectangle();
		r1.fieldX = 33;
		r1.height = 10;
		r1.width = 44;
		shapeList.add(r1);
		
		List<Shape> cloneList = cloneList(shapeList);
		
		// copies of same objects, their fields are same but not same objects
		for(int i=0; i<shapeList.size(); i++) {
			if(shapeList.get(i) == cloneList.get(i)) {
				System.out.println("They are same");
			} else {
				if(shapeList.get(i).equals(cloneList.get(i))) {
					System.out.println("They are identical");
				} else {
					System.out.println("They are not identical");
				}
			}
		}
	}
	
	public static List<Shape> cloneList(List<Shape> originialList) {
		List<Shape> returnList = new ArrayList<Shape>();
		for (Shape shape : originialList) {
			returnList.add(shape.clone());
		}
		return returnList;
	}
}
