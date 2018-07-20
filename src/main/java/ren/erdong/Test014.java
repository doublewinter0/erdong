package ren.erdong;

import com.red.resources.Resource;

import java.io.*;

/*
 *	jar 包资源访问测试(这基吧真他妈难搞)
 */
public class Test014 {

	public static void main(String[] args) throws IOException {
		Resource re = new Resource();
		InputStream is = re.getStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		// BufferedWriter bw = new BufferedWriter(new FileWriter("zhaoxuewoxihuanni.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("zhaoxuewoxihuanni.txt"), true);
		String line = null;
		while ((line = br.readLine()) != null) {
			pw.println(line);
		}
		br.close();
		pw.close();
	}
}