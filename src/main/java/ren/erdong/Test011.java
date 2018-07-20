package ren.erdong;

import java.io.*;

/*
 *	利用字节流将非文本文件的字节码用字符流写到文件上,再用字符流读取该字节码文件,最后再用字节流写出.
 */
public class Test011 {

	public static void main(String[] args) throws Exception {
		File srcFile = new File("15.gif");
		// File destFile_1 = new File("C:\\Users\\RED\\Desktop\\red.gif");
		File destFile_2 = new File("C:\\Users\\RED\\Desktop\\byte.txt");// 值的范围 (0-255)
		File destFile_3 = new File("C:\\Users\\RED\\Desktop\\red.txt");
		// writeByteToFile(srcFile, destFile);
		writeByteToFile(srcFile, destFile_2, destFile_3);
		// readFileFromByte(destFile_2);
	}

	public static void writeByteToFile(File srcFile, File destFile_1, File destFile_2) throws Exception {
		FileInputStream fis_1 = new FileInputStream(srcFile);
		// FileOutputStream fos = new FileOutputStream(destFile);
		BufferedWriter bw = new BufferedWriter(new FileWriter(destFile_1));

		int b = 0;
		while ((b = fis_1.read()) != -1) {

			// 为了验证我的猜想
			if (b >= 256) {
				bw.close();
				fis_1.close();
				throw new Exception("艹腻骂");
			}

			// System.out.println(b);
			bw.write(b + "");
			bw.newLine();
			bw.flush();
		}
		bw.close();
		fis_1.close();

		// int b = -1;
		FileInputStream fis_2 = new FileInputStream(srcFile);
		PrintWriter pw = new PrintWriter(new FileWriter(destFile_2, true), true);
		byte[] bys = new byte[1024];
		while (fis_2.read(bys) != -1) {
			break;
		}
		for (byte bs : bys) {
			pw.println(bs + "");
		}
		pw.close();
		fis_2.close();
	}

	public static void readFileFromByte(File srcFile) throws IOException {
		// FileInputStream fis = new FileInputStream(srcFile);
		BufferedReader br = new BufferedReader(new FileReader(srcFile));
		FileOutputStream fos = new FileOutputStream("C:\\Users\\RED\\Desktop\\der.gif");
		String line = null;
		while ((line = br.readLine()) != null) {
			int b = Integer.parseInt(line);
			fos.write(b);
		}
		fos.close();
		br.close();
	}
}