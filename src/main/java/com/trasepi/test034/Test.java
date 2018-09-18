package com.trasepi.test034;

import java.util.function.Predicate;

public class Test {

	public static void main(String[] args) {
		Predicate<Person> predicate = person -> person.getAge() > 2;
		new Person(0).show(predicate);
	}
}
