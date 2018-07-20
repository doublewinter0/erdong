package ren.erdong;

import java.io.IOException;
import java.nio.charset.Charset;

/*
 *	String getBytes()
 *		// 源码实现
 *	String(byte[] bytes)
 */
public class Test012 {

	public static void main(String[] args) throws IOException {
		String str_1 = "任二冬";
		char ch_1 = '赵';
		char ch_2 = '雪';
		getBytesTest(str_1);
		charToByteTest(ch_1);
		charToByteTest(ch_2);
		byte[] bys = {-43, -44, -47, -87,};
		String str_2 = new String(bys, "GBK");
		System.out.println(str_2);
		System.out.println(Charset.defaultCharset().name());
	}

	public static void getBytesTest(String str) {
		byte[] bys = str.getBytes();
		for (byte b : bys) {
			System.out.println(b);
		}
		System.out.println("======");
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i) + " = " + (int) str.charAt(i));
		}
		System.out.println("++++++");
	}

	public static void charToByteTest(char ch) {
		byte[] bys = (ch + "").getBytes();
		System.out.println(ch + " = " + Integer.toBinaryString(ch));
		for (byte b : bys) {
			System.out.println(b + " = " + Integer.toBinaryString(b));
		}
	}
}