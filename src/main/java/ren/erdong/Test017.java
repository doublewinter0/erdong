package ren.erdong;

// 对 String 类的一些探讨
public class Test017 {

	public static void main(String[] args) {
		Test_1 test_1 = new Test_1();
		Test_2 test_2 = new Test_2();
		System.out.println(test_1.str == test_2.str); // true

		ponder();
	}

	/*
	 *	探究不同的 String 有没有可能有一样的 hashCode
	 *	事实上, 在了解了 String 类的 hashCode() 源码之后, 这个问题的答案是显而易见的
	 *	但是我却花了很长时间才意识到
	 */

	public static void ponder() {

		System.out.println((int) 'a');
		System.out.println((int) 'A');
		System.out.println((int) '1');
		String str_1 = "b1";
		String str_2 = "aP";
		System.out.println(str_1.hashCode());
		System.out.println(str_2.hashCode());
		System.out.println(str_1 == str_2); // false
	}
}

class Test_1 {

	public String str = "red";

	public void show() {
		// System.out.println("red".value);
	}
}

class Test_2 {

	public String str = "red";
}
