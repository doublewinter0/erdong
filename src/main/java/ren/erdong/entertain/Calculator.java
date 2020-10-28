package ren.erdong.entertain;

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
        String expression = "1-3+4*(8/(1+3)-5*(7+3)*4+10)/5";
        System.out.println("result = " + calculate(beautify(expression)));
    }

    // 计算带有 "()" 的四则混合运算
    private static int calculate(String expression) {
        int index = expression.indexOf(')');
        if (index > 0) {
            StringBuilder builder = new StringBuilder();
            String substring = expression.substring(0, index);
            int indexOf = substring.lastIndexOf('(');
            builder.append(expression).replace(indexOf, index + 1, calculateBasic(expression.substring(indexOf + 1, index)) + "");
            return calculate(builder.toString());
        } else {
            return calculateBasic(expression);
        }
    }

    // 计算基本的四则混合运算
    private static int calculateBasic(String expression) {

        Integer[] indexs = new Integer[]{expression.indexOf('*'), expression.indexOf('/')};

        StringBuilder builder = new StringBuilder();
        // 乘法在前面
        if ((indexs[0] * indexs[1] > 0 && indexs[0] - indexs[1] < 0) || (indexs[0] * indexs[1] < 0 && indexs[0] - indexs[1] > 0)) {
            int[] prefix = parsePrefix(expression, indexs[0]);
            int[] suffix = parseSuffix(expression, indexs[0]);
            int replace = calculatemMltiplication('*', prefix, suffix);
            StringBuilder sbStr = builder.append(expression).replace(prefix[0], suffix[0], replace + "");
            // System.out.println(sbStr);
            return calculateBasic(sbStr.toString());
        } /* 除法在前面 */ else if ((indexs[0] * indexs[1] > 0 && indexs[1] - indexs[0] < 0) || (indexs[0] * indexs[1] < 0 && indexs[1] - indexs[0] > 0)) {
            int[] prefix = parsePrefix(expression, indexs[1]);
            int[] suffix = parseSuffix(expression, indexs[1]);
            int replace = calculatemMltiplication('/', prefix, suffix);
            builder.append(expression).replace(prefix[0], suffix[0], replace + "");
            // System.out.println(builder);
            return calculateBasic(builder.toString());
        } /* 不含乘除法 */ else {
            return calculateAddition(expression);
        }
    }

    // 解析运算符前面的数
    private static int[] parsePrefix(String str, int index) {
        String replace = str.replace('+', '?');
        int begin = index - 1;
        int i = -1;
        while (true) {
            try {
                i = Integer.parseInt(replace.substring(begin, index));
            } catch (Exception exp) {
                // exp.printStackTrace();
                String operator = "?-";
                if (begin < 0 || operator.contains(replace.charAt(begin) + "")) {
                    return new int[]{begin + 1, i};
                }
                return new int[]{begin + 2, -i};
            }
            begin--;
        }
    }

    // 解析运算符后面的数
    private static int[] parseSuffix(String str, int index) {
        int begin = index + 1;
        int end = begin + 1;
        int i = 0;
        while (true) {
            try {
                i = Integer.parseInt(str.substring(begin, end));
            } catch (Exception exp) {
                // exp.printStackTrace();
                if (end == begin + 1) {
                    end++;
                    continue;
                } else {
                    // return (flag ? new int[]{end - 1, i} : new int[]{end - 2, i});
                    return new int[]{end - 1, i};
                }
            }
            end++;
        }
    }

    // 计算两个整数的乘法或除法
    private static int calculatemMltiplication(char ch, int[] parsePrefix, int[] parseSufix) {
        switch (ch) {
            case '*':
                return parsePrefix[1] * parseSufix[1];
            case '/':
                return parsePrefix[1] / parseSufix[1];
            default:
                throw new RuntimeException("weizhifuhao");
        }
    }

    // 计算加减法
    private static int calculateAddition(String expression) {

        // 运算结果可能出现负数, 比如 1+2-a, a 为一个负数! 针对这种情况, 我们作如下处理
        expression = expression.replaceAll("--", "\\+");

        // 表达式含加, 减法
        if (expression.indexOf('+') > 0) {
            String[] split = expression.split("\\+");
            int sum = 0;
            for (String s : split) {
                sum += calculateAddition(s);
            }
            return sum;
        }

        // 表达式只含减法
        if (expression.indexOf('-') >= 0) {
            String[] split = expression.split("-");
            int sum;
            try {
                sum = Integer.parseInt(split[0]);
            } catch (NumberFormatException exp) {
                sum = 0;
            }

            for (int i = 1; i < split.length; i++) {
                sum -= Integer.parseInt(split[i]);
            }
            return sum;
        }

        return Integer.parseInt(expression);
    }

    private static String beautify(String expession) {
        return expession.replaceAll("\\s*", "");
    }
}
