package me.hoobaler;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Test031 {

	public static void main(String[] args) throws Exception {

		chars();
		reflect1();
		// reflect2();
	}

	private static void chars() {

		// '\0' 代表空字符
		char[] chs = {'r', 'e', 'd', '\0', '\0', '\0', '\0', '\0'};
		String str = "666";
		str.getChars(0, str.length(), chs, 2);
		System.out.println(Arrays.toString(chs));
	}

	private static void reflect1() throws Exception {

		// 这段代码非常重要, 它揭示了 Java 反射的某种特性!
		String string = "trasepi";
		Class<String> stringClass = String.class;
		Field field = stringClass.getDeclaredField("hash");
		field.setAccessible(true);
		// System.out.println("string.hashCode = " + string.hashCode());
		Object obj = field.get(string);
		System.out.println(field.getType() + "\40" + field.getName());
		System.out.println("string.hashCode = " + string.hashCode());
		System.out.println("obj = " + obj);

	}

	private static void reflect2() throws Exception {

		Person p = new Person("zs", 18);
		// Person p2 = new Person("ls", 17);
		Class<Person> personClass = Person.class;
		Field nameField = personClass.getDeclaredField("name");
		Field ageField = personClass.getDeclaredField("age");
		nameField.setAccessible(true);
		ageField.setAccessible(true);

		Object name1 = nameField.get(p);
		Object name2 = nameField.get(p);
		System.out.println(name1 == name2);
		System.out.println(name1 == p.getName());

		System.out.println("------------");
		Object age1 = ageField.get(p);
		Object age2 = ageField.get(p);
		System.out.println(age1 == age2);
		// System.out.println(age1 == p.getAge());
	}

}


class Person {

	private String name;
	private Integer age;
	// private int age;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}

