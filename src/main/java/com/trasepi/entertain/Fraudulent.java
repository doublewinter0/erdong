package com.trasepi.entertain;

import com.trasepi.utils.math.IMath;

import javax.swing.plaf.basic.BasicScrollPaneUI;

/**
 * 模拟诈金花游戏, 来验证一些特殊牌出现的概率
 */
public class Fraudulent {

    public static void main(String[] args) {
        int[] pokers = init();
        // System.out.println(Arrays.toString(pokers));
    }

    // 牌为同花
    private static boolean isFlush(int[] bts) {
        return false;
    }

    // 牌为顺子
    private static boolean isStraight(int[] bts) {
        return false;
    }

    // 牌为豹子
    private static boolean isLeopard(int[] bts) {
        return false;
    }

    // 模拟发牌
    public static int[][] dealCards(int tabCardsNum, int allCardsNum) {
        int[][] handCardss = new int[16][3];
        int[] handCards = IMath.getNonRRS(allCardsNum - tabCardsNum, allCardsNum, false);
        for (int i = 0; i < handCards.length; i++) {
            // int
        }
    }

    // 初始化
    private static int[] init() {

        int length = 52;
        int subLength = 13;
        int interval = 20;

        // 所有牌
        int[] pokers = new int[length];
        // 红桃
        int[] hearts = new int[subLength];
        // 黑桃
        int[] spades = new int[subLength];
        // 方片
        int[] diamonds = new int[subLength];
        // 草花
        int[] clubs = new int[subLength];

        for (int i = 0; i < subLength; i++) {
            hearts[i] += (i + 1);
            spades[i] += (i + 1 + interval);
            diamonds[i] += (i + 1 + interval * 2);
            clubs[i] += (i + 1 + interval * 3);

            pokers[i] = hearts[i];
            pokers[i + subLength] = spades[i];
            pokers[i + subLength * 2] = diamonds[i];
            pokers[i + subLength * 3] = clubs[i];
        }
        return pokers;
    }

}
