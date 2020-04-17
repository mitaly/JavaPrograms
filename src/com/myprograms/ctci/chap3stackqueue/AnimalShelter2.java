package com.myprograms.ctci.chap3stackqueue;

import java.util.LinkedList;

public class AnimalShelter2 {
	public static void main(String[] args) {
		Animal2 a1 = new Dog("A");
		Animal2 a2 = new Dog("B");
		Animal2 a3 = new Cat("C");
		Animal2 a4 = new Cat("D");
		Animal2 a5 = new Cat("E");
		
		MyAnimalShelter2 shelter = new MyAnimalShelter2();
		shelter.enqueue(a1);
		shelter.enqueue(a2);
		shelter.enqueue(a3);
		shelter.enqueue(a4);
		shelter.enqueue(a5);
		
		System.out.println(shelter.dequeueAny());
		System.out.println(shelter.dequeueAny());
		System.out.println(shelter.dequeueDog());
		System.out.println(shelter.dequeueDog());
		System.out.println(shelter.dequeueCat());
		System.out.println(shelter.dequeueAny());
		System.out.println(shelter.dequeueDog());
	}
}

class MyAnimalShelter2{
	LinkedList<Animal2> dogs;
	LinkedList<Animal2> cats;
	private int order = 0;
	
	MyAnimalShelter2(){
		dogs = new LinkedList<Animal2>();
		cats = new LinkedList<Animal2>();
	};
	
	void enqueue(Animal2 animal) {
		animal.order = order;
		order++;
		if(animal instanceof Dog) {
			dogs.add(animal);
		}else {
			cats.add(animal);
		}
		System.out.println("Pushed "+animal);
	}
	
	Animal2 dequeueAny() {
		if(dogs.isEmpty()) {
			return cats.poll();
		}else if(cats.isEmpty()) {
			return dogs.poll();
		}
		if(dogs.peek().order < cats.peek().order) {
			return dogs.poll();
		}else{
			return cats.poll();
		}
	}
	
	Animal2 dequeueDog() {
		if(dogs.isEmpty()) {
			System.out.println("No Dogs!");
			return null;
		}
		return dogs.poll();
	}
	
	Animal2 dequeueCat() {
		if(cats.isEmpty()) {
			System.out.println("No Cats!");
			return null;
		}
		return cats.poll();
	}
}

abstract class Animal2{
	String name;
	int order;
	
	Animal2(String name){
		this.name = name;
	}
	
	abstract String name();
	
	@Override
	public String toString() {
		return name();
	}
}

class Dog extends Animal2{

	Dog(String name) {
		super(name);
	}

	@Override
	String name() {
		return "Dog "+name;
	}
}

class Cat extends Animal2{

	Cat(String name) {
		super(name);
	}

	@Override
	String name() {
		return "Cat "+name;
	}
	
}