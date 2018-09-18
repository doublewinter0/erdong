/*
package com.trasepi.entertain;

*/
/**
 * 扑克牌实体
 *//*

// @Data
public class Poker {

    private Poker() {}

    public byte[] init() {

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
*/
