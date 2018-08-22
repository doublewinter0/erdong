package ren.erdong.entertain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// Given a positive integer N(>1), find all consecutive positive integer sequences with a sum of N
public class Sum2N {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入正整数n:");
        List<int[]> seqList = getAllSeqs(scanner.nextInt());
        seqList.forEach(ele -> System.out.println(Arrays.toString(ele)));
    }

    private static List<int[]> getAllSeqs(int n) {

        if (n < 2) throw new RuntimeException("your input " + "(" + n + ")" + " is illegal");
        List<int[]> ansList = new LinkedList<>();
        int firstTerm;
        int maxFirstTerm = n / 2;
        for (firstTerm = 1; firstTerm <= maxFirstTerm; firstTerm++) {
            int delta = (int) Math.pow(2 * firstTerm - 1, 2) + 8 * n;
            int numOfTerms;
            if ((numOfTerms = getRoot(delta, firstTerm)) > 0) {
                ansList.add(new int[]{firstTerm, numOfTerms});
            }
        }
        return ansList;
    }

    private static boolean isSquareNum(int n) {
        return Math.pow((int) Math.sqrt(n), 2) == n;
    }

    private static int getRoot(int delta, int firstTerm) {
        if (isSquareNum(delta)) {
            int temp;
            if (((temp = (int) (1 + Math.sqrt(delta)))) % 2 == 0) {
                return temp / 2 - firstTerm;
            }
        }
        return -1;
    }
}
