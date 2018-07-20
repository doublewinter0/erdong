package ren.erdong;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Arrays;

// 表单请求参数的中文乱码的一些思考
public class Test018 {

	public static void main(String[] args) throws IOException {
		System.out.println(Charset.defaultCharset().name());

		// char ch_1 = '赵';
		// char ch_2 = '雪';
		// charToByteTest(ch_1);
		// charToByteTest(ch_2);

		// en_decode();
		test();
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

	public static void en_decode() throws IOException {
		String name = "任二冬";
		System.out.println((char) 63);
		// 以 GBK 编码
		byte[] bytes_1 = name.getBytes("GBK");
		System.out.println("bytes_1: " + Arrays.toString(bytes_1));
		// 以 ISO-8859-1 编码
		byte[] bytes_2 = name.getBytes("ISO-8859-1");
		System.out.println("bytes_2: " + Arrays.toString(bytes_2));
		// 尝试以 ISO-8859-1 解码 bytes_1
		String name_1 = new String(bytes_1, "ISO-8859-1");
		System.out.println("name_1: " + name_1);
		// 尝试以 ISO-8859-1 解码 bytes_2
		String name_2 = new String(bytes_2, "ISO-8859-1");
		System.out.println("name_2: " + name_2);
		// 尝试以 ISO-8859-1 编码 name_1
		byte[] bytes_3 = name_1.getBytes("ISO-8859-1");
		System.out.println("bytes_3: " + Arrays.toString(bytes_3));
		// 尝试以 GBK 编码 name_1
		byte[] bytes_4 = name_1.getBytes("GBK");
		System.out.println("bytes_4: " + Arrays.toString(bytes_4));
		// 尝试以 ISO-8859-1 编码 name_2
		byte[] bytes_5 = name_2.getBytes("ISO-8859-1");
		System.out.println("bytes_5: " + Arrays.toString(bytes_5));

		System.out.println("=========================");
		byte[] bytes = {66, -43, -67, 63, -99};
		// 尝试以 ISO-8859-1 解码 bytes
		String str_1 = new String(bytes, "ISO-8859-1");
		System.out.println(str_1); // B????
		// 再次以 ISO-8859-1 编码str_1
		System.out.println(Arrays.toString(str_1.getBytes("ISO-8859-1"))); // [66, -43, -67, 63, -99]
		System.out.println("-------------------------");
		// 尝试以 GBK 解码 bytes
		String str_2 = new String(bytes, "GBK");
		System.out.println(str_2); // B战??
		// 再次以 GBK 编码str_2
		System.out.println(Arrays.toString(str_2.getBytes("GBK"))); // [66, -43, -67, 63, 63]
	}

	public static void test() throws IOException {
		String name = "任二冬";
		byte[] gbk = name.getBytes("GBK");
		String name_1 = new String(gbk, "UTF-8");
		System.out.println(Arrays.toString(name_1.getBytes("GBK")));
		System.out.println(name_1);
		System.out.println(URLEncoder.encode(name, "UTF-8"));
		System.out.println(URLEncoder.encode(name, "GBK"));
		System.out.println(URLEncoder.encode(name, "Unicode"));
		System.out.println(URLEncoder.encode(name, "ISO-8859-1"));
		System.out.println(URLEncoder.encode(name, "ISO-8859-6"));
		System.out.println("+++++++++++++++++++++++++");
	}
}