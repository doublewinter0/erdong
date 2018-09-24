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
            int[][] cards = dealCards(tabCardsNum, allCardsNum);
            for (int[] card : cards) {
                if (isStraightFlush(card)) count4StraightFlush++;
                if (isLeopard(card)) count4Leopard++;
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
    private static boolean isFlush(int[] cardinal) {
        if (cardinal.length != 3) throw new IllegalArgumentException("Please Intput Correct Args!");

        Arrays.sort(cardinal);
        boolean isHearts = cardinal[2] <= 13;
        boolean isSpades = cardinal[0] > 20 && cardinal[2] <= (20 + 13);
        boolean isDiamonds = cardinal[0] > 20 * 2 && cardinal[2] <= (20 * 2 + 13);
        boolean isClubs = cardinal[0] > 20 * 3 && cardinal[2] <= (20 * 3 + 13);
        return isHearts || isSpades || isDiamonds || isClubs;
    }

    // 顺子
    private static boolean isStraight(int[] cardinal) {
        if (cardinal.length != 3) throw new IllegalArgumentException("Please Intput Correct Args!");

        residue(cardinal);
        Arrays.sort(cardinal);
        boolean general = (cardinal[0] + 1 == cardinal[1]) && (cardinal[1] + 1 == cardinal[2]);
        boolean special = (cardinal[0] == 1) && (cardinal[1] == 12) && (cardinal[2] == 13);
        return general || special;
    }

    // 同花顺
    private static boolean isStraightFlush(int[] cardinal) {
        return isFlush(cardinal) && isStraight(cardinal);
    }

    // 豹子
    private static boolean isLeopard(int[] cardinal) {
        if (cardinal.length != 3) throw new IllegalArgumentException("Please Intput Correct Args!");

        residue(cardinal);
        return (cardinal[0] == cardinal[1]) && (cardinal[1] == cardinal[2]);
    }

    private static void residue(int[] cardinal) {
        int length = cardinal.length;
        for (int i = 0; i < length; i++) {
            cardinal[i] = cardinal[i] % 20;
        }
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
