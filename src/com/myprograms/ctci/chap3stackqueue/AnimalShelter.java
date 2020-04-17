package com.myprograms.ctci.chap3stackqueue;

public class AnimalShelter {
	public static void main(String[] args) {
		Animal a1 = new Animal("A", AnimalType.DOG);
		Animal a2 = new Animal("B", AnimalType.DOG);
		Animal a3 = new Animal("C", AnimalType.CAT);
		Animal a4 = new Animal("D", AnimalType.CAT);
		Animal a5 = new Animal("E", AnimalType.CAT);
		
		MyAnimalShelter shelter = new MyAnimalShelter();
		shelter.enqueue(a1);
		shelter.enqueue(a2);
		shelter.enqueue(a3);
		shelter.enqueue(a4);
		shelter.enqueue(a5);
		shelter.dequeueAny();
		shelter.dequeueAny();
		shelter.dequeueOfType(AnimalType.CAT);
		shelter.dequeueOfType(AnimalType.DOG);
		shelter.dequeueOfType(AnimalType.CAT);
		shelter.dequeueAny();
		shelter.dequeueAny();
	}
}

class MyAnimalShelter{
	Animal first;
	Animal last;
	
	void enqueue(Animal animal) {
		if(first == null)
			first = animal;
		if(last != null)
			last.next = animal;
		last = animal;
		System.out.println("Added:"+animal);
	}
	
	void dequeueAny() {
		if(first == null) {
			System.out.println("No animal!");
			return;
		}
		Animal firstAnimal = first;
		if(first == last)
			last = null;
		first = first.next;
		System.out.println(firstAnimal);
	}
	
	void dequeueOfType(AnimalType type) {
		if(first == null) {
			System.out.println("No animal!");
			return;
		}
		Animal start = first;
		Animal previous = null;
		
		while(start != null) {
			if(start.type == type) {
				break;
			}
			previous = start;
			start = start.next;
		}
		if(start == null) {
			System.out.println("No animal of type "+type+" found.");
			return;
		}
		Animal animalFound = first;
		
		if(start == first) {
			if(start == last) {
				last = null;
			}
			first = first.next;
		}else if(start == last) {
			previous.next = start.next;
			last = previous;
		}else {
			previous.next = start.next;
		}
		System.out.println("Animal found:"+animalFound);
	}
}

class Animal{
	AnimalType type;
	Animal next;
	String name;
	
	public Animal(String name, AnimalType type) {
		this.type = type;
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Animal [type=");
		builder.append(type);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
}

enum AnimalType{
	DOG, CAT;
}