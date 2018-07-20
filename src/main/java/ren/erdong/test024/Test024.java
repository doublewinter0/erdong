package ren.erdong.test024;

/*
 *	多态中引用的实际类型
 */
public class Test024 {

	public static void main(String[] args) {
		Person person = new Worker();
		String type = person.getClass().getName();
		System.out.println(type);
	}
}

