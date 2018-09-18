package com.trasepi.test033;

// 有关 try catch finally 的测试
public class Test033 {

	public static void main(String[] args) {
		System.out.println(go());
	}

	public static int go() {

		try {
			System.out.println(1 / 0);
			return 0;
		} catch (Exception exp) {
			exp.printStackTrace();
			return 1;
		} finally {
			return 2;
		}
	}
}
