package ren.erdong;

import java.io.*;
import java.net.URL;

/*
 *	getPath()
 *	getAbsolutePath()
 *	getCanonicalPath()
 */
public class Test023 {

	public static void main(String[] args) throws Exception {
		new Test023_Test01().show();
		/*
		File file_3 = new File("/path_3");
		String path_1 = file_1.getPath();
		String absolutePath_1 = file_1.getAbsolutePath();
		String canonicalPath_1 = file_1.getCanonicalPath();
		System.out.println(path_1);
		System.out.println(absolutePath_1);
		System.out.println(canonicalPath_1);
		System.out.println("==============================");
		String path_2 = file_2.getPath();
		String absolutePath_2 = file_2.getAbsolutePath();
		String canonicalPath_2 = file_2.getCanonicalPath();
		System.out.println(path_2);
		System.out.println(absolutePath_2);
		System.out.println(canonicalPath_2);
		System.out.println("==============================");
		String path_3 = file_3.getPath();
		String absolutePath_3 = file_3.getAbsolutePath();
		String canonicalPath_3 = file_3.getCanonicalPath();
		System.out.println(path_3);
		System.out.println(absolutePath_3);
		System.out.println(canonicalPath_3);
		*/
	}
}

class Test023_Test01 {

	public void show() throws Exception {
		File file = new File("resource/red/15.gif");
		URL url = this.getClass().getResource("/resources/red.txt");
		String urlpath = url.getPath();
		String urlfile = url.getFile();
		System.out.println("file: " + file.getCanonicalPath());
		System.out.println("url: " + url);
		System.out.println("urlpath: " + urlpath);
		System.out.println("urlfile: " + urlfile);
		File file_1 = new File("path_1/der.txt");
		File file_2 = new File("resources/red.txt");
		System.out.println("file_1: " + file_1.getCanonicalPath());
		// System.out.println("file_2: " + file_2.getCanonicalPath());

		if (file_2.exists()) {
			System.out.println("流弊");
		} else {
			System.out.println("辣鸡");
		}
		BufferedReader br = new BufferedReader(new FileReader(urlpath.substring(5)));
		BufferedWriter bw = new BufferedWriter(new FileWriter(file_1));
		String line = null;
		while ((line = br.readLine()) != null) {
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		bw.close();
		br.close();
	}
}