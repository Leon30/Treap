package test;

import java.util.Comparator;

import dinamics.Treap;

public class Test {

	public static void main(String[] args) {
		Treap<Integer> treap = new Treap<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer intA, Integer intB) {
				return intA.compareTo(intB);
			}
		}, 100);
		
		treap.add(50);
		treap.add(45);
		treap.add(75);
		treap.add(25);
	}
}
