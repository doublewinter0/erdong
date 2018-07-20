package ren.erdong;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

// 利用反射技术查看 String 私有变量
public class Test016 {

	public static void main(String[] args) throws SecurityException,
			NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		// ...
		String str_1 = new String("zhaoxue");
		String str_2 = "赵雪";
		peep(str_1);
		peep(str_2);
		// str_2.value;
		System.out.println("------------------");
		ponder();

	}

	// 反射 String
	public static void peep(String str) throws SecurityException,
			NoSuchFieldException, IllegalArgumentException, IllegalAccessException {

		Class<? extends String> cla = str.getClass();
		Constructor<?>[] constructors = cla.getDeclaredConstructors();
		Field[] fields = cla.getDeclaredFields();
		System.out.println(constructors.length);
		System.out.println(fields.length);
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}
		for (Field field : fields) {
			System.out.println(field);
		}
		Field field = cla.getDeclaredField("value");
		field.setAccessible(true);
		System.out.println("===" + field.toString());
		Object obj = field.get(str);
		if (obj instanceof char[]) {
			char[] chs = (char[]) obj;
			for (char c : chs) {
				System.out.println(c);
			}
		}
		// char[] chs = (char[]) field;
		// System.out.println("***" + field.getClass().getName() + "***");
		/*
		 * if (field instanceof char[]) for (char[] v : field) {
		 *
		 * }
		 */
	}

	// 对反射的一些思考
	public static void ponder() {
		char[] chs = {'l', 'i', 'k', 'e'};
		String str_1 = "zhaoxue";
		// String str_2 = str_1;
		Class<String> stringClass = String.class;

		try {
			Field field = stringClass.getDeclaredField("value");
			field.setAccessible(true);
			System.out.println(field.get(str_1));
			if (field.get(str_1) instanceof char[]) {
				System.out.println(new String((char[]) field.get(str_1)));
				char[] str_1Value = (char[]) field.get(str_1);
				for (int i = 0; i < str_1Value.length; i++) {
					switch (i) {
						case 0: {
							str_1Value[i] = 'l';
							break;
						}
						case 1: {
							str_1Value[i] = 'i';
							break;
						}
						case 2: {
							str_1Value[i] = 'k';
							break;
						}
						case 3: {
							str_1Value[i] = 'e';
							break;
						}
						default:
							break;
					}
				}
			}
			System.out.println(field.get(str_1));
			if (field.get(str_1) instanceof char[]) {
				System.out.println(new String((char[]) field.get(str_1)));
			}
			field.set(str_1, chs);
			System.out.println(field.get(str_1));
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		System.out.println("str_1: " + str_1);
		// System.out.println("str_2: " + str_2);
		// System.out.println("str_1 == str_2: " + (str_1 == str_2));
	}
}
