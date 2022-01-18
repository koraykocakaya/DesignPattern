package com.kk.designPattern.structural.composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class CompositeDemo {

	interface ValueContainer extends Iterable<Integer> {
	}

	class SingleValue implements ValueContainer {

		public int value;

		public SingleValue(int value) {
			this.value = value;
		}

		@Override
		public Iterator<Integer> iterator() {
			return Collections.singleton(value).iterator();
		}
	}

	class ManyValues extends ArrayList<Integer> implements ValueContainer {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	}

	class MyList extends ArrayList<ValueContainer> {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int mySum = 0;
		
		public MyList(Collection<? extends ValueContainer> c) {
			super(c);
		}

		public int getSum(ValueContainer vc) {
			int sum = 0;
			for (Integer value : vc) {
				sum += value;
			}
			return sum;
		}
		
		public int sum()
	    {
			forEach(itr -> mySum += getSum(itr));
			return mySum;
	    }
	}
	
	public void testCompositePattern() {
		SingleValue sv1 = new SingleValue(1);
		SingleValue sv2 = new SingleValue(2);
		SingleValue sv3 = new SingleValue(3);
		
		ManyValues mv = new ManyValues();
		mv.add(40);
		mv.add(50);
		mv.add(60);
		
		MyList myList = new MyList(Arrays.asList(mv, sv1, sv2,sv3));
		System.out.println(myList.sum());
	}
	
	public static void main(String[] args) {
		CompositeDemo demo = new CompositeDemo();
		demo.testCompositePattern();
	}

}