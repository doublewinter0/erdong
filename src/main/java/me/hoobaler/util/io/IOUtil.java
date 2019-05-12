package me.hoobaler.util.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IOUtil {

	private IOUtil() {
	}

	public static void write2File(File file, Iterable<?> target) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
			for (Object obj : target) {
				bw.write(obj.toString());
				bw.newLine();
				bw.flush();
			}
		} catch (IOException ioExp) {
			ioExp.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException ioExp) {
					ioExp.printStackTrace();
				}
			}
		}
	}

}
