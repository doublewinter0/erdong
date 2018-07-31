/*
 * This line is for God!
 * Created by SYSTEM on 2018/7/30 19:43
 * One is Gauss, and another is Évariste Galois.
 */

package ren.erdong.test037;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	private static Map<String, Integer> map = new HashMap<>();

	// 初始化
	private static void init() {
		map.put("语文", 1);
		map.put("数学", 2);
		map.put("化学", 5);
		map.put("英语", 3);
		map.put("物理", 4);
		map.put("生物", 6);
		map.put("历史", 7);
		map.put("地理", 8);
		map.put("aP", 10);
		map.put("b1", 20);
		map.put("政治", 9);
	}

	public static void main(String[] args) throws Exception{

		System.out.println("数学".hashCode());

		// init();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		System.out.println("------我是分割线------");
		exporeHash();
	}

	// 对 HashMap 中 static int hash 变量的探究
	private static void exporeHash() throws Exception {
		Class<HashMap> mapClass = HashMap.class;
		Method hash = mapClass.getDeclaredMethod("hash", Object.class);
		System.out.println(Integer.toBinaryString("aO".hashCode() ^ ("aO".hashCode() >>> 16)));
		System.out.println("数学".hashCode() ^ ("数学".hashCode() >>> 16));
		System.out.println(Integer.toBinaryString("数学".hashCode() ^ ("数学".hashCode() >>> 16)));
		hash.setAccessible(true);
		System.out.println("aO = " + Integer.toBinaryString((int) hash.invoke(null, "aO")));
		System.out.println("b0 = " + Integer.toBinaryString((int) hash.invoke(null, "b0")));
		System.out.println("数学 = " + Integer.toBinaryString((int) hash.invoke(null, "数学")));
		System.out.println("化学 = " + Integer.toBinaryString((int) hash.invoke(null, "化学")));
		// System.out.println(hash.invoke(null, "数学"));
	}

}
