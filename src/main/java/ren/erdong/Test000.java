package ren.erdong;

/*
 * 2. 补全代码
 *
 * public class Student {
 *
 * public void show(Student s) { s.method(); }
 *
 * private void method(){ System.out.println("哈哈...method方法被调用了....") ; }
 *
 * }
 *
 * public class StudentDemo {
 *
 * public static void main(String[] args) {
 *
 * // 在此处写代码,要求在控制台打印"哈哈...method方法被调用了...." Student s = new Student() ; }
 *
 * }
 *
 */
class Students {

	public void show(Students s) {
		s.method();
	}

	private void method() {
		System.out.println("哈哈...method方法被调用了....");
	}

}

public class Test000 {

	public static void main(String[] args) {

		// 在此处写代码,要求在控制台打印"哈哈...method方法被调用了...." Student s = new Student() ;
		Students stu = new Students();
		stu.show(stu);
		Students stu2 = new Students();
		stu.show(stu2);

	}
}
