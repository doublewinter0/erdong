package ren.erdong;

import java.io.IOException;
import java.util.Arrays;

/*
 *	对编码的一些思考...
 */
public class Test022 {

	public static void main(String[] args) throws IOException {
		int count = 128 - 97 + 1;
		byte[] bys = new byte[count];
		byte b = -128;
		for (int i = 0; i < bys.length; i++) {
			bys[i] = b;
			b += 1;
		}
		String str = new String(bys, "ISO-8859-1");
		byte[] byss = str.getBytes("ISO-8859-1");
		System.out.println(str);
		System.out.println(Arrays.toString(byss));
	}
}
