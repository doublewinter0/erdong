package com.trasepi.util.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * my math util class
 */
public class IMath {

    static {
        LOGGER = LoggerFactory.getLogger(IMath.class);
        random = new Random();
    }

    private static final Logger LOGGER;
    private static Random random;

    /**
     * to produce a random sequence which hsa no duplicated elements
     *
     * @param amount the num of generated elements
     * @param range  elements should between 1 and range
     * @return sequence array
     */
    public static int[] getNonRRS2(int amount, int range, boolean isZeroBased) {

        if (amount > range) {
            throw new IllegalArgumentException(String
                    .format("the first arg amount (%d )should less than the second arg range (%d )", amount, range));
        }

        int[] ints = new int[amount];
        ints[0] = isZeroBased ? random.nextInt(range) : random.nextInt(range) + 1;
        boolean flag = false;

        for (int i = 1; i < amount; ++i) {
            ints[i] = isZeroBased ? random.nextInt(range) : random.nextInt(range) + 1;
            while (true) {
                for (int j = 0; j < i; ++j) {
                    if (ints[j] == ints[i]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) break;
                flag = false;
                ints[i] = isZeroBased ? random.nextInt(range) : random.nextInt(range) + 1;
            }
        }
        // LOGGER.info(Arrays.toString(ints));
        return ints;
    }

    /**
     * @param amount      the num of generated elements
     * @param range       the range of these elements
     * @param isZeroBased from 0 or 1
     * @return sequence array
     */
    public static int[] getNonRRS(int amount, int range, boolean isZeroBased) {
        if (amount > range) {
            throw new IllegalArgumentException(String
                    .format("the first arg amount (%d )should less than the second arg range (%d )", amount, range));
        }

        List<Integer> numList = new LinkedList<>();
        if (isZeroBased) {
            for (int i = 0; i < range; i++) {
                numList.add(i);
            }
        } else {
            for (int i = 0; i < range; i++) {
                numList.add(i + 1);
            }
        }

        int[] ints = new int[amount];
        int length = ints.length;
        for (int i = 0; i < length; i++) {
            ints[i] = numList.remove(random.nextInt(numList.size()));
        }
        return ints;
    }

    public static String timeFormat(long timeMillis) {
        long secondUnit = 1000;
        long minuteUnit = 60 * secondUnit;
        long hourUnit = 60 * minuteUnit;
        long dayUnit = 24 * hourUnit;

        long count4Day = timeMillis / dayUnit;
        timeMillis %= dayUnit;
        long count4Hour = timeMillis / hourUnit;
        timeMillis %= hourUnit;
        long count4Minute = timeMillis / minuteUnit;
        timeMillis %= minuteUnit;
        long count4Second = timeMillis / secondUnit;

        String dayStr = count4Day == 0 ? "" : count4Day + "天, ";
        String hourStr = count4Hour == 0 ? "" : count4Hour + "小时, ";
        String minuteStr = count4Minute == 0 ? "" : count4Minute + "分钟, ";
        String secondStr = count4Second == 0 ? "" : count4Second + "秒.";
        return dayStr + hourStr + minuteStr + secondStr;
    }
}
