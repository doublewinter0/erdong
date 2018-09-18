package com.trasepi.entertain;

import org.junit.Test;

import java.util.Arrays;

/**
 * 模拟诈金花游戏, 来验证一些特殊牌出现的概率
 */
public class Fraudulent {

    public static void main(String[] args) {
        byte[] pokers = init();
        // System.out.println(Arrays.toString(pokers));
    }

    private static boolean isFlush(byte[] bts) {
        return false;
    }

    private static boolean isStraight(byte[] bts) {
        return false;
    }

    private static boolean isLeopard(byte[] bts) {
        return false;
    }

    // initialize
    private static byte[] init() {

        byte length = 52;
        byte subLength = 13;
        byte interval = 20;

        // 所有牌
        byte[] pokers = new byte[length];
        // 红桃
        byte[] hearts = new byte[subLength];
        // 黑桃
        byte[] spades = new byte[subLength];
        // 方片
        byte[] diamonds = new byte[subLength];
        // 草花
        byte[] clubs = new byte[subLength];

        for (byte i = 0; i < subLength; i++) {
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
