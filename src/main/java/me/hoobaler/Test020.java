package me.hoobaler;

/*
 *	由 String 的构造函数而引发的一些思考
 *		public String(String original) {
 *			this.value = original.value; // value 在 String 中私有, 那么 original.vlaue 为什么不报错?
 *			this.hash = original.hash;	// hash 同理
 *		}
 */
public class Test020 {

	public static void main(String[] args) {
		Test020_Test t_1 = new Test020_Test("雪", 1);
		Test020_Test t_2 = new Test020_Test(t_1);
		System.out.println(t_2.getStr() + "\t" + t_2.getI());
	}
}

class Test020_Test {

	private String str;
	private int i;

	public Test020_Test() {
		super();
	}

	public Test020_Test(String str, int i) {
		super();
		this.str = str;
		this.i = i;
	}

	public Test020_Test(Test020_Test test) {
		super();
		str = test.str;
		i = test.i;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}
