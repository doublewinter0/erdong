package me.hoobaler.util;

import java.awt.*;
import java.util.Collection;
import java.util.Random;


public class ColorUtil {

    private static final int RANGE;

    static {
        RANGE = 1 << 8;
    }

    private static int getCosOfVector() {
        return 0;
    }

    /**
     * 产生一系列颜色, 这些颜色与给定的颜色相互之间色差明显
     * @param originColorList 已有颜色集合
     * @return 新颜色集合
     */
    public static Collection<Color> randomColor(Collection<Color> originColorList) {

        /*
         * 如何去定义两种颜色的色差明显呢? 我们定义了一种简单算法.
         * 通过测试我们发现, (1,0,0) 和 (0,1,0) 这两种颜色非常接近, 而 (1,1,1) 和 (255,255,255) 这两种颜色色差十分明显.
         * 我们就打算通过这种思路来实施计算!
         */
        boolean valid = false;
        Random random = new Random();
        Color color = new Color(random.nextInt(RANGE), random.nextInt(RANGE), random.nextInt(RANGE));
        originColorList.forEach(item -> {

        });
        return null;
    }

}
