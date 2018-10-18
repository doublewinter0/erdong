package com.trasepi.utils;

import javafx.beans.binding.BooleanBinding;

import java.awt.*;
import java.util.Collection;
import java.util.Random;

public class ColorUtil {

    static {
        RANGE = 266;
    }

    private static final int RANGE;

    private static int getCosOfVector() {

    }

    public static Color randomColor(Collection<Color> collection) {
        double rate = 0.9D;
        boolean valid = false;
        Random random = new Random();
        Color color = new Color(random.nextInt(RANGE), random.nextInt(RANGE), random.nextInt(RANGE));
        collection.stream().mapToDouble(item -> ((color.getRed() * item.getRed()) + (color.getGreen() * item.getGreen()) + (color.getBlue() * item.getBlue()))
                / (Math.sqrt((color.getRed() * color.getRed()) + (color.getGreen() * color.getGreen()) + (color.getBlue() * color.getBlue()))
                * Math.sqrt((item.getRed() * item.getRed()) + (item.getGreen() * item.getGreen()) + (item.getBlue() * item.getBlue()))).forEach(cos -> {

        });
    }

}
