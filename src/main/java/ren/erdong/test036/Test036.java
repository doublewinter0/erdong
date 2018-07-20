/*
 * This line is for God!
 * Created by erdong on 2018/7/2 14:47
 * One is Gauss, and another is Évariste Galois.
 */

package ren.erdong.test036;

import java.io.File;
import java.io.IOException;

// 关于 Java 路径的疑惑
public class Test036 {

	public static void main(String[] args) throws IOException {
		File file = new File("./customPath");
		System.out.println("path = " + file.getPath());
		System.out.println("adsPath = " + file.getAbsolutePath());
		System.out.println("canonicalPath = " + file.getCanonicalPath());
	}
}
