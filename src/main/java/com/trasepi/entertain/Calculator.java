package com.trasepi.entertain;

/**
 * @author erdong
 * @date 下午12:59 19-3-2
 * 题目: 请写出可以计算简单四则运算法则的程序
 * 要求: 可以支持加减乘除法及圆括号
 * 输入: 四则运算的字符串表达式
 * 输出: 数字类型计算结果
 * 例如: 输入 1+2-3*4+(5-6)*7/8; 输出结果为?
 **/
public class Calculator {

    public static void main(String[] args) {

        String str = "12/3*9+6*6/2";
        String srt2 = "6/((3-2)*2)*12/3*(9+6+5)";

        System.out.println("result = " + go(srt2));

        // String str = "12+300-90+16*2";
        // int result = goo(str);
        // System.out.println(result);


        // int replace = calculate(int2s);
        // sb.append(str).replace(int2s[1][0], int2s[2][0], replace + "");
        // System.out.println(sb);

        /*assert int2s != null;
        System.out.println(Arrays.toString(int2s[0]));
        System.out.println(Arrays.toString(int2s[1]));
        System.out.println(Arrays.toString(int2s[2]));*/
        // System.out.println(Arrays.toString(goo));
    }

    private static int go(String str) {
        int index = str.indexOf(')');
        if (index > 0) {
            StringBuilder sb = new StringBuilder();
            String substring = str.substring(0, index);
            int indexOf = substring.lastIndexOf('(');
            StringBuilder sbStr = sb.append(str).replace(indexOf, index + 1, goo(str.substring(indexOf + 1, index)) + "");
            return go(sbStr.toString());
        } else {
            return goo(str);
        }
    }

    private static int goo(String str) {
        // String str = "12+300/90+1+6-2";
        // String str = "12/3*9+6*6/2";
        // String str = "12+300-90+16*2";
        StringBuilder sb = new StringBuilder();

        Integer[] indexs = new Integer[4];
        indexs[0] = str.indexOf('+');
        indexs[1] = str.indexOf('-');
        indexs[2] = str.indexOf('*');
        indexs[3] = str.indexOf('/');

        if ((indexs[2] * indexs[3] > 0 && indexs[2] - indexs[3] < 0) || (indexs[2] * indexs[3] < 0 && indexs[2] - indexs[3] > 0)) {
            int[] ints1 = parse1(str, indexs[2]);
            int[] ints2 = parse2(str, indexs[2]);
            int replace = calculate('*', ints1, ints2);
            StringBuilder sbStr = sb.append(str).replace(ints1[0], ints2[0], replace + "");
            // System.out.println(sbStr);
            return goo(sbStr.toString());
            // return new int[][]{new int[]{'*'}, ints1, ints2};
        } else if ((indexs[2] * indexs[3] > 0 && indexs[3] - indexs[2] < 0) || (indexs[2] * indexs[3] < 0 && indexs[3] - indexs[2] > 0)) {
            int[] ints1 = parse1(str, indexs[3]);
            int[] ints2 = parse2(str, indexs[3]);
            int replace = calculate('/', ints1, ints2);
            StringBuilder sbStr = sb.append(str).replace(ints1[0], ints2[0], replace + "");
            // System.out.println(sbStr);
            return goo(sbStr.toString());
            // return new int[][]{new int[]{'/'}, ints1, ints2};
        } else {
            //
            return calculate(str);
        }
    }

    private static int[] parse1(String str, int index) {
        // StringBuilder sb = new StringBuilder();
        String replace1 = str.replace('+', '?');
        String replace2 = replace1.replace('-', '?');
        int begin = index - 1;
        int i = -1;
        while (true) {
            try {
                i = Integer.parseInt(replace2.substring(begin, index));
            } catch (Exception exp) {
                // exp.printStackTrace();
                return new int[]{begin + 1, i};
            }
            begin--;
        }
    }

    private static int[] parse2(String str, int index) {
        int begin = index + 1;
        int end = begin + 1;
        int i = -1;
        while (true) {
            try {
                i = Integer.parseInt(str.substring(begin, end));
                end++;
            } catch (Exception exp) {
                // exp.printStackTrace();
                return new int[]{end - 1, i};
            }
        }
    }

    private static int calculate(char ch, int[] parsePrefix, int[] parseSufix) {
        switch (ch) {
            case '*':
                // System.out.println("chengfa");
                return parsePrefix[1] * parseSufix[1];
            case '/':
                // System.out.println("chufa");
                return parsePrefix[1] / parseSufix[1];
            /*case '+':
                System.out.println("jiafa");
                return '+';
            case '-':
                System.out.println("jianfa");
                return '-';
            */
            default:
                // System.out.println("weizhi");
                throw new RuntimeException("weizhifuhao");
        }
    }

    private static int calculate(String str) {

        if (str.indexOf('+') > 0) {
            String[] split = str.split("\\+");
            int sum = 0;
            for (String s : split) {
                sum += calculate(s);
            }
            return sum;
        }

        if (str.indexOf('-') > 0) {
            String[] split = str.split("-");
            int sum = Integer.parseInt(split[0]);
            for (int i = 1; i < split.length; i++) {
                sum -= Integer.parseInt(split[i]);
            }
            return sum;
        }

        return Integer.parseInt(str);
    }
}
