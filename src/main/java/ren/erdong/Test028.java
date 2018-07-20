package ren.erdong;


import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

// 创建子类对象有没有创建父类对象? 看起来不是个容易的问题...
public class Test028 {

	@Test
	public void arrayCopyTest() {
		Dog_Test028 dog = new Dog_Test028("阿黄", 2);
		System.out.println(dog.isCute);
		Class<? extends Dog_Test028> dogClass = dog.getClass();
		Field[] dogFields = dogClass.getDeclaredFields();
		Method[] dogMethods = dogClass.getDeclaredMethods();
		System.out.println(dogFields.length);
		System.out.println(Arrays.toString(dogFields));
		System.out.println(dogMethods.length);
		System.out.println(Arrays.toString(dogMethods));
		// Cat cat = new Cat("阿花", 2);

	}
}

class Animal_Test028 {
	boolean isCute = true;
	private String name;
	private int age;

	Animal_Test028(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("Animal: " + this);
		show();
	}

	String getName() {
		return name;
	}

	int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Animal{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	private void show() {
		System.out.println("this is a parent private function..." + this);
	}
}

class Dog_Test028 extends Animal_Test028 {

	Dog_Test028(String name, int age) {
		super(name, age);
        /*
        System.out.println(this.hashCode());
        System.out.println(super.hashCode());
        System.out.println(this.toString());
        System.out.println(super.toString());
        */

	}

	@Override
	public String toString() {
		return "Dog{" +
				"name='" + this.getName() + '\'' +
				", age=" + this.getAge() +
				'}';
	}
}

class Cat_Test028 extends Animal_Test028 {

	Cat_Test028(String name, int age) {
		super(name, age);
	}

	@Override
	public String toString() {
		return "Cat{" +
				"name='" + this.getName() +
				"age=" + this.getAge() +
				'}';
	}
}
