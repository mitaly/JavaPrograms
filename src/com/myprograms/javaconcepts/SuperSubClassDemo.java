package com.myprograms.javaconcepts;

public class SuperSubClassDemo {
	public static void main(String[] args) {
		Parent ch = new Child();
		// Not visible
//		ch.pPrivate();
		// ch.a is Parent accessing its own variable which is string here.
		System.out.println(ch.a + 13);
		((Child) ch).myDefaultMethod();
		Child c = new Child();
		Parent pp = (Parent)c;
		System.out.println("using child ref:"+pp.a);
	}
}

class Parent {
	protected String a = "sonia";

	private void pPrivate() {
		System.out.println("parent private");
	}
}

class Child extends Parent {
	// this is hiding. not overriding
	// we can create a variable using same name but different DT
	private int a = 200;
	int b = 233;

	protected void pPrivate() {
		System.out.println("child private");
	}

	void myDefaultMethod() {
		System.out.println("child's a: " + a);
		System.out.println("parent's a: " + super.a);
		System.out.println("parent's a: " + ((Parent) this).a);
	}
}
