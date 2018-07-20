package ren.erdong;

/*
 *
 *
 */

public class Test003 {
	public static void main(String[] args) {
		Student stu1 = new Student("张三", 20);
		Student stu2 = new Student("李四", 18);
		stu1.go();
		stu2.go();
	}
}

class Student {
	private String name;
	private int age;

	public Student() {
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	private void show() {
		System.out.println(name + "---" + age);
	}

	public void go() {
		show();
	}
}
