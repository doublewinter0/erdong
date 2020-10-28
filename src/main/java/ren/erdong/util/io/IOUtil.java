package ren.erdong.util.io;

import java.io.*;

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

	public static boolean object2File(File file, Object target) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(target);
		} catch (IOException exp) {
			exp.printStackTrace();
			return false;
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException exp) {
					exp.printStackTrace();
				}
			} else if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

}
