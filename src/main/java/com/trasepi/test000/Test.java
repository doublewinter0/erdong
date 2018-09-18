/*
 * This line is for God!
 * Created by trasepi on 2018/7/4 18:20
 * One is Gauss, and another is Évariste Galois.
 */

package com.trasepi.test000;

public class Test {

	public static void main(String[] args) {
		expolreDouble();
	}

	// 对 Double 类的探究
	// 注意其遵守了 IEEE 754 标准
	private static void expolreDouble() {
		System.out.println((0.1 + 0.1) == 0.2);
		System.out.println((0.1 + 0.2) == 0.3);
		System.out.println((0.1 + 0.5) == 0.6);
		System.out.println((0.2 + 0.4) == 0.6);
		System.out.println((0.3 + 0.3) == 0.6);
	}
}
