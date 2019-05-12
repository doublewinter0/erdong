package me.hoobaler.entertain;

/**
 * @author erdong
 * @description 整数开平方
 * @date 下午9:16 19-4-5
 **/
public class Sqrt {

	public static void main(String[] args) {
		// long num = 4234567890123456789L;
		// long num = 234567890123456789L;
		long num = 48L;
		int basePowerOf2 = getBasePowerOf2(num) / 2;
		long integerPart = getIntegerPart((long) Math.pow(2, basePowerOf2), (long) Math.pow(2, basePowerOf2 + 1), num);
		if (integerPart * integerPart == num) {
			System.out.println(integerPart);
		} else {
			System.out.println(integerPart + getDecimalPart(num, integerPart, 0.1D, 0, 18));
		}
	}

	/**
	 * @param num 待开平方数
	 * @return int 参见 @description
	 * @description 这个函数用于缩小待开平方数的整数部分的范围, 基本原理很简单!
	 * 比如 Math.pow(2, 9) < 1000 < Math.pow(2, 10), 这个函数的返回值就是 9
	 * @author erdong
	 * @date 9:48 2019/4/9
	 **/
	private static int getBasePowerOf2(long num) {
		long quotient = num / 2L;
		return quotient > 1 ? getBasePowerOf2(quotient) + 1 : 1;
	}

	/**
	 * @param inf 参见 @description
	 * @param sup 参见 @description
	 * @param num 参见 @description
	 * @return long 待开平方数的整数部分
	 * @description 这个函数用于确定待开平方数的整数部分, 基本原理很简单: 二分法!
	 * 直接从 (0, num) 二分是不理想的, 当 num 很大时尤为明显!
	 * 所以使用 getBasePowerOf2(long num) 这个函数给缩小了二分法的范围, 下界为 inf, 上界为 sup, num 为待开平方数
	 * @author erdong
	 * @date 10:56 2019/4/9
	 **/
	private static long getIntegerPart(long inf, long sup, long num) {
		if (sup - inf == 1L) return inf;
		long middle = (inf + sup) / 2L;
		return middle * middle > num ? getIntegerPart(inf, middle, num) : getIntegerPart(middle, sup, num);
	}

	/**
	 * @param num       待开平放数
	 * @param inf       二分法整数下界
	 * @param decimal   小数分位
	 * @param predicate 候选数
	 * @param precision 精度
	 * @return double 算数平方根
	 * @description 这个函数用于确定待开平方数的小数部分, 基本原理很简单: 递归
	 * @author erdong
	 * @date 11:58 2019/4/9
	 **/
	private static double getDecimalPart(long num, long inf, double decimal, double predicate, int precision) {
		if (precision == 0) return predicate;
		if ((Math.pow(inf + predicate + decimal, 2) > num)) {
			return getDecimalPart(num, inf, decimal / 10, predicate, precision - 1);
		} else if ((Math.pow(inf + predicate + 9 * decimal, 2)) < num) {
			return getDecimalPart(num, inf, decimal / 10, predicate + 9 * decimal, precision - 1);
		} else {
			return getDecimalPart(num, inf, decimal / 10, getDecimal(1, 9, num, inf, decimal, predicate), precision - 1);
		}
	}

	/**
	 * @param start     分位起始数字 [1,4]
	 * @param end       分位结束数字 [5,8]
	 * @param num       待开平放数
	 * @param inf       二分法整数下界
	 * @param decimal   小数分位
	 * @param predicate 候选数
	 * @return double 分位值
	 * @description 这个函数用于服务 @getDecimalPart(long num, long start, double decimal, double predicate, int precision)
	 * 当某一分位的数字在 [1,8] 之间用该函数递归得到该分位的准确值, 基本原理很简单: 二分法!
	 * @author erdong
	 * @date 15:44 2019/4/12
	 **/
	private static double getDecimal(int start, int end, long num, long inf, double decimal, double predicate) {
		int middle = (start + end) / 2;
		if (end - start == 1) return predicate + start * decimal;
		return Math.pow(inf + predicate + middle * decimal, 2) > num ?
				getDecimal(start, middle, num, inf, decimal, predicate) : getDecimal(middle, end, num, inf, decimal, predicate);
	}
}
