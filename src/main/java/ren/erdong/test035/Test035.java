/*
 * This line is for God!
 * Created by erdong on 2018/6/30 9:05
 * One is Gauss, and another is Évariste Galois.
 */

package ren.erdong.test035;

public class Test035 {

	public static void main(String[] args) {
		// System.out.println("aP".hashCode() == "b1".hashCode());
		go("b1");
	}

	public static void go(String str) {
		switch (str) {
			case "aP":
				System.out.println("aP");
				break;
			case "b1":
				System.out.println("b1");
				break;
			default:
				System.out.println("艹腻骂");
				break;
		}
	}
}
