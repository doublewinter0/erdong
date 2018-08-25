package com.trasepi;

import javax.swing.*;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {
        method1();
        // reflectDouble();
    }

    private static void method1() {
        long l = 123456789876L;
        int i = (int) l; // -1097261708
        long lower32bit = l << 32 >>> 32;
        System.out.println(Integer.toHexString(i).equals(Long.toHexString(lower32bit)));

        System.out.println("--- I am split line ---");
        Double dd1 = 1234567898763.123456;
        System.out.println(dd1.intValue() + "===");
        System.out.println(dd1.toString() + "+++");
        System.out.println(Integer.MAX_VALUE);
        double d1 = 123456789876.123456;
        double d2 = 123.1234;
        double d3 = 123456789.1234;
        int i1 = (int) d1;
        int i2 = (int) d2;
        int i3 = (int) d3;
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(Long.toHexString(Double.doubleToLongBits(d1)));
        System.out.println(Long.toHexString(Double.doubleToLongBits(d2)));
        System.out.println(Long.toHexString(Double.doubleToLongBits(d3)));
        // System.out.println(Double.doubleToRawLongBits(d1));
        // System.out.println(Double.doubleToRawLongBits(d2));
        // System.out.println(Double.doubleToRawLongBits(d3));
        System.out.println(Integer.toHexString(i1));
        System.out.println(Integer.toHexString(i2));
        System.out.println(Integer.toHexString(i3));
        // String sqrtStr = Double.toString(Math.sqrt(d1));
        // System.out.println(sqrtStr.indexOf(46));
    }

    private static void reflectDouble() {
        Method[] doubleMethods = Double.class.getDeclaredMethods();
        for (Method doubleMethod : doubleMethods) {
            doubleMethod.setAccessible(true);
            System.out.println(doubleMethod.getName());
        }
    }
}
