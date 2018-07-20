package ren.erdong.test034;

import java.util.function.Predicate;

public class Person extends Animal {

	public Person(int age) {
		super(age);
	}

	public int getAge() {
		return age + 1;
	}

	public void show(Predicate<Person> predicate) {
		System.out.println(predicate.test(new Worker(6)));
	}
}

