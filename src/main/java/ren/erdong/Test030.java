package ren.erdong;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// <T> T[] toArray(T[] a); 对该行代码的探究
public class Test030 {

	private Animal_Test030[] animal_test030s = {new Animal_Test030("Animal_Test030_1", 1),
			new Animal_Test030("animal_test030_2", 2), new Animal_Test030("animal_test030_3", 3)};
	private Dog_Test030[] dogs_test030s = {new Dog_Test030("dog_1", 1), new Dog_Test030("dog_2", 2), new Dog_Test030
			("dog_3", 3)};
	private List<Dog_Test030> dogList = new ArrayList<>();

	@Test
	public void arrayCopyTest_1() {

		Dog_Test030 dog = new Dog_Test030("阿黄", 2);
		Cat_Test030 cat = new Cat_Test030("阿花", 2);
		System.arraycopy(dog, 0, cat, 0, 1); // java.lang.ArrayStoreException
	}

	@Test
	public void arrayCopyTest_2() {

		Dog_Test030[] dogs = {new Dog_Test030("dog_1", 1), new Dog_Test030("dog_2", 2), new Dog_Test030("dog_3", 3)};
		Cat_Test030[] cats = {new Cat_Test030("cat_1", 1), new Cat_Test030("cat_2", 2), new Cat_Test030("cat_3", 3)};
		System.out.println(Arrays.toString(dogs));
		System.out.println(Arrays.toString(cats));
		System.arraycopy(cats, 1, dogs, 1, 2); // java.lang.ArrayStoreException
	}

	@Test
	public void arrayCopyTest_3() {
		int[] ins = new int[3];
		Integer[] integers = new Integer[3];
		char[] chs = new char[3];
		String[] strs = new String[3];
		System.out.println("------ " + ins.getClass() + " ------");
		System.out.println("------ " + integers.getClass() + " ------");
		System.out.println("------ " + chs.getClass() + " ------");
		System.out.println("------ " + strs.getClass() + " ------");
		System.out.println(dogs_test030s.length + ": " + Arrays.toString(dogs_test030s));
		System.out.println(animal_test030s.length + ": " + Arrays.toString(animal_test030s));
		System.arraycopy(dogs_test030s, 1, animal_test030s, 1, 2);
		System.out.println(dogs_test030s.length + ": " + Arrays.toString(dogs_test030s));
		System.out.println(animal_test030s.length + ": " + Arrays.toString(animal_test030s));

	}

	@Test
	public void arrayCopyTest_4() {

        /*
        List<Animal_Test030> animal_test030List = Arrays.asList(animal_test030s);
        List<Dog_Test030> dogList = Arrays.asList(dogs); //class java.util.Arrays$ArrayList
            注意: 此 ArrayList 并非 java.util.ArrayList, 而是 Arrays 的一个内部类, 且继承了 AbstractList!
        */

		List<Animal_Test030> animal_test030List = new ArrayList<>();
		List<Dog_Test030> dogList = new ArrayList<>();
        /*
        for (Animal_Test030 animal_test030 : animal_test030s) {
            animal_test030List.add(animal_test030);
        }
        */

		// 直接将引用传递给集合(换句话说, 集合与数组中的对象是同一个对象)
		Collections.addAll(animal_test030List, animal_test030s);
		Collections.addAll(dogList, dogs_test030s);
		// System.arraycopy(dogList, 1, Animal_Test030List, 1, 2); // java.lang.ArrayStoreException

		animal_test030List.get(0).setName("阿黄");
		System.out.println(Arrays.toString(animal_test030s));
		animal_test030s[1].setName("阿白");
		System.out.println(animal_test030List);

		Object[] objects = dogList.toArray();
		for (Object obj : objects) {
			if (obj instanceof Dog_Test030) {
				Dog_Test030 dog = (Dog_Test030) obj;
				System.out.println(dog);
			}
		}
	}

	@Test
	public void arrayCopyTest_5() {
		dogList.add(new Dog_Test030("灰狗", 1));
		dogList.add(new Dog_Test030("黑狗", 2));
		System.out.println(dogList);
		Animal_Test030[] anis_1 = new Dog_Test030[1];
		Dog_Test030[] anis_2 = new Dog_Test030[4];
		anis_1[0] = new Dog_Test030("土狗", 3);
		anis_2[2] = new Dog_Test030("狼狗", 1.5);
		anis_2[3] = new Dog_Test030("小白", 0.5);

		Animal_Test030[] aniss_1 = dogList.toArray(anis_1);
		dogList.get(0).setName("白狗");
		if (aniss_1 != anis_1) {
			for (Animal_Test030 animal_test030 : anis_1) {
				System.out.println(animal_test030);
			}
		}
		System.out.println(aniss_1.getClass());
		System.out.println("------" + (aniss_1 == anis_1) + "------");
		for (Animal_Test030 animal_test030 : aniss_1) {
			System.out.println(animal_test030);
		}

		Animal_Test030[] aniss_2 = dogList.toArray(anis_2);
		if (aniss_2 != anis_2) {
			for (Animal_Test030 animal_test030 : anis_2) {
				System.out.println(animal_test030);
			}
		}
		System.out.println(aniss_2.getClass());
		System.out.println("------" + (aniss_2 == anis_2) + "------");
		for (Animal_Test030 animal_test030 : aniss_2) {
			System.out.println(animal_test030);
		}
	}
}

class Animal_Test030 {
	private String name;
	private double age;

	Animal_Test030(String name, double age) {
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}
    /*
    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }
    */

	@Override
	public String toString() {
		return "{name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}

class Dog_Test030 extends Animal_Test030 {

	Dog_Test030(String name, double age) {
		super(name, age);
	}

    /*
    @Override
    public String toString() {
        return "{name='" + this.getName() + '\'' +
                ", age=" + this.getAge() +
                '}';
    }
    */
}

class Cat_Test030 extends Animal_Test030 {

	Cat_Test030(String name, double age) {
		super(name, age);
	}

    /*
    @Override
    public String toString() {
        return "{name='" + this.getName() +
                "age=" + this.getAge() +
                '}';
    }
    */
}
