package com.trasepi.entertain;

import com.trasepi.utils.math.IMath;

import java.util.Arrays;

/**
 * 模拟诈金花游戏, 来验证一些特殊牌出现的概率
 */
public class Fraudulent {
    private static long count4StraightFlush;
    private static long count4Leopard;

    public static void main(String[] args) {
        int tabCardsNum = 4;
        int allCardsNum = 52;
        long begin = System.currentTimeMillis();

        for (int s = 1; s <= 1000000000; s++) {
            int[][] cardinals = dealCards(tabCardsNum, allCardsNum);
            for (int[] cardinal : cardinals) {
                int[] quotients = quomodSort(cardinal);
                if (isStraightFlush(cardinal)) count4StraightFlush++;
                if (isLeopard(cardinal)) count4Leopard++;
            }
            if (s % 10000000 == 0) {
                System.out.println("count4StraightFlush = " + count4StraightFlush);
                System.out.println("      count4Leopard = " + count4Leopard);
                long semiend = System.currentTimeMillis();
                System.out.println("已完成 : " + (s / 10000000) + "%, 已耗时: " + IMath.timeFormat(semiend - begin));
            }
        }
    }

    // 同花
    private static boolean isFlush(int[] quotients, int[] modules) {
        // if (cardinal.length != 3) throw new IllegalArgumentException("Please Intput Correct Args!");

        // quomodSort(cardinal);
        // Arrays.sort(cardinal);
        // boolean isHearts = cardinal[2] <= 13;
        // boolean isSpades = cardinal[0] > 20 && cardinal[2] <= (20 + 13);
        // boolean isDiamonds = cardinal[0] > 20 * 2 && cardinal[2] <= (20 * 2 + 13);
        // boolean isClubs = cardinal[0] > 20 * 3 && cardinal[2] <= (20 * 3 + 13);
        return (quotients[0] == quotients[2]) && (modules[2] <= 13);
    }

    // 顺子
    private static boolean isStraight(int[] modules) {
        // if (cardinal.length != 3) throw new IllegalArgumentException("Please Intput Correct Args!");

        // quomodSort(cardinal);
        // Arrays.sort(cardinal);
        boolean general = (modules[0] + 1 == modules[1]) && (modules[1] + 1 == modules[2]);
        boolean special = (modules[0] == 1) && (modules[1] == 12) && (modules[2] == 13);
        return general || special;
    }

    // 同花顺
    private static boolean isStraightFlush(int[] quotients, int[] modules) {
        return isFlush(quotients, modules) && isStraight(modules);
    }

    // 豹子
    private static boolean isLeopard(int[] quotient) {
        // if (cardinal.length != 3) throw new IllegalArgumentException("Please Intput Correct Args!");

        // quomodSort(cardinal);
        return (quotient[0] == quotient[1]) && (quotient[0] == quotient[2]);
    }

    private static int[][] quomodSort(int[] cardinals) {
        if (cardinals.length != 3) throw new IllegalArgumentException("Please Intput Correct Args!");

        int length = cardinals.length;
        int[] quotients = new int[length];
        int[] modules = new int[length];
        for (int i = 0; i < length; i++) {
            quotients[i] = cardinals[i] / 20;
            modules[i] = cardinals[i] % 20;
        }
        Arrays.sort(modules);
        Arrays.sort(quotients);
        return quotients;
    }

    // 模拟发牌
    private static int[][] dealCards(int tabCardsNum, int allCardsNum) {
        int handCardsNum = allCardsNum - tabCardsNum;
        if ((handCardsNum) % (3 * 2) != 0) throw new IllegalArgumentException("Please Intput Correct Args!");
        int[] initCards = initCards();
        int[] ranseq = IMath.getNonRRS(handCardsNum, allCardsNum, true);
        int[] handCards = new int[handCardsNum];
        for (int i = 0; i < handCardsNum; i++) {
            handCards[i] = initCards[ranseq[i]];
        }

        int round = handCardsNum / 3;
        int[][] handCardss = new int[round][3];
        for (int i = 0; i < handCardss.length; i++) {
            if (handCardss[i].length >= 0) {
                System.arraycopy(handCards, 3 * i, handCardss[i], 0, handCardss[i].length);
            }
        }
        return handCardss;
    }

    // 初始化
    private static int[] initCards() {
        // 所有牌
        int[] pokers = new int[52];

        // 红桃
        int[] hearts = new int[13];

        // 黑桃
        int[] spades = new int[13];

        // 方片
        int[] diamonds = new int[13];

        // 草花
        int[] clubs = new int[13];

        for (int i = 0; i < 13; i++) {
            hearts[i] += (i + 1);
            spades[i] += (i + 1 + 20);
            diamonds[i] += (i + 1 + 20 * 2);
            clubs[i] += (i + 1 + 20 * 3);

            pokers[i] = hearts[i];
            pokers[i + 13] = spades[i];
            pokers[i + 13 * 2] = diamonds[i];
            pokers[i + 13 * 3] = clubs[i];
        }
        return pokers;
    }
}
