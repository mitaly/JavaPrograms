package com.myprograms;

import java.util.Objects;

public class Person {
	int id;
	String name;
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("equals");
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(this.getClass() != obj.getClass())
			return false;
		Person person = (Person)obj;
		return (Objects.equals(name, person.name) && Objects.equals(id, person.id));
	}
	@Override
	public int hashCode() {
		System.out.println("hashcode");
		return id;
	}
}
