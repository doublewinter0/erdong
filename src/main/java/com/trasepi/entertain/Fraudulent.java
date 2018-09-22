package com.trasepi.entertain;

import com.trasepi.utils.math.IMath;

import java.util.Arrays;

/**
 * 模拟诈金花游戏, 来验证一些特殊牌出现的概率
 */
public class Fraudulent {

    static {
        CARDINAL = 3;
        LENGTH = 52;
        SUBLENGTH = 13;
        INTERVAL = 20;
    }

    private static final int CARDINAL;
    private static final int LENGTH;
    private static final int SUBLENGTH;
    private static final int INTERVAL;

    private static long count4StraightFlush;
    private static long count4Leopard;

    public static void main(String[] args) {
        // int[] pokers = init();
        // System.out.println(Arrays.toString(pokers));
        int tabCardsNum = 4;
        int allCardsNum = 52;
        long begin = System.currentTimeMillis();
        for (int s = 1; s <=  1000000000; s++) {
            int[][] cards = dealCards(tabCardsNum, allCardsNum);
            for (int[] card : cards) {
                if (isStraightFlush(card)) count4StraightFlush++;
                if (isLeopard(card)) count4Leopard++;
            }
            if (s % 10000000 == 0) {
                System.out.println("count4StraightFlush = " + count4StraightFlush);
                System.out.println("      count4Leopard = " + count4Leopard);
                long semiend = System.currentTimeMillis();
                System.out.println("进度: " + (s / 10000000)+ "%, 已耗时: " + (semiend - begin) / 1000.0D + " 秒");
            }
        }
    }

    // 同花
    private static boolean isFlush(int[] cardinal) {
        if (cardinal.length != 3) throw new IllegalArgumentException("Please Intput Correct Args!");
        Arrays.sort(cardinal);
        boolean isHearts = cardinal[cardinal.length - 1] <= SUBLENGTH;
        boolean isSpades = cardinal[0] > INTERVAL && cardinal[2] <= (INTERVAL + SUBLENGTH);
        boolean isDiamonds = cardinal[0] > INTERVAL * 2 && cardinal[2] <= (INTERVAL * 2 + SUBLENGTH);
        boolean isClubs = cardinal[0] > INTERVAL * 3 && cardinal[2] <= (INTERVAL * 3 + SUBLENGTH);
        return isHearts || isSpades || isDiamonds || isClubs;
    }

    // 顺子
    private static boolean isStraight(int[] cardinal) {
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
        residue(cardinal);
        return (cardinal[0] == cardinal[1]) && (cardinal[1] == cardinal[2]);
    }

    private static void residue(int[] cardinal) {
        if (cardinal.length != 3) throw new IllegalArgumentException("Please Intput Correct Args!");
        for (int i = 0; i < 3; i++) {
            cardinal[i] = cardinal[i] % 20;
        }
    }

    // 模拟发牌
    private static int[][] dealCards(int tabCardsNum, int allCardsNum) {
        int handCardsNum = allCardsNum - tabCardsNum;
        if ((handCardsNum) % (CARDINAL * 2) != 0) throw new IllegalArgumentException("Please Intput Correct Args!");
        int[] initCards = init();
        int[] ranseq = IMath.getNonRRS(handCardsNum, allCardsNum, true);
        int ranseqLength = ranseq.length;
        int[] handCards = new int[ranseqLength];
        for (int i = 0; i < ranseqLength; i++) {
            handCards[i] = initCards[ranseq[i]];
        }
        int round = handCardsNum / CARDINAL;
        int[][] handCardss = new int[round][CARDINAL];
        for (int i = 0; i < handCardss.length; i++) {
            if (handCardss[i].length >= 0) {
                System.arraycopy(handCards, CARDINAL * i, handCardss[i], 0, handCardss[i].length);
                Arrays.sort(handCardss[i]);
            }
        }
        return handCardss;
    }

    // 初始化
    private static int[] init() {

        // 所有牌
        int[] pokers = new int[LENGTH];
        // 红桃
        int[] hearts = new int[SUBLENGTH];
        // 黑桃
        int[] spades = new int[SUBLENGTH];
        // 方片
        int[] diamonds = new int[SUBLENGTH];
        // 草花
        int[] clubs = new int[SUBLENGTH];

        for (int i = 0; i < SUBLENGTH; i++) {
            hearts[i] += (i + 1);
            spades[i] += (i + 1 + INTERVAL);
            diamonds[i] += (i + 1 + INTERVAL * 2);
            clubs[i] += (i + 1 + INTERVAL * 3);

            pokers[i] = hearts[i];
            pokers[i + SUBLENGTH] = spades[i];
            pokers[i + SUBLENGTH * 2] = diamonds[i];
            pokers[i + SUBLENGTH * 3] = clubs[i];
        }
        return pokers;
    }

}
