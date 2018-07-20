package ren.erdong;

/*
 *	构造函数能不能调用成员函数? // 可以! 6 的一笔
 */
public class Test008 {
	public static void main(String[] args) {
		new Test08_Test();
	}
}

class Test08_Test {
	int i;

	public Test08_Test() {
		i = 7;
		print();
	}

	public void print() {
		System.out.println("你好");
		i += 8;
		System.out.println(i);
	}
}
