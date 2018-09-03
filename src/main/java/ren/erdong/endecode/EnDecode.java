package ren.erdong.endecode;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class EnDecode {

    public static void main(String[] args) throws UnsupportedEncodingException {
        // -46 -> 11010010
        // -58 -> 11000110
        // -74 -> 10110110
        // -81 -> 10101111
        String str = "移动"; // [-46, -58, -74, -81]
        System.out.println(Arrays.toString(str.getBytes("GBK")));
        String str2 = new String(str.getBytes("GBK"), StandardCharsets.UTF_8);
        System.out.println(str2);
        for (int i = 0; i < str2.length(); i++) {
            System.out.println((int) str2.charAt(i));
        }
        System.out.println(new String(str2.getBytes(StandardCharsets.UTF_8), "GBK"));
        byte[] bts1 = {-58, -74};
        byte[] bts2 = {-46, -58};
        byte[] bts3 = {-74};
        System.out.println(new String(bts1, StandardCharsets.UTF_8));
        System.out.println(new String(bts2, StandardCharsets.UTF_8));
        System.out.println(new String(bts3, StandardCharsets.UTF_8));
    }
}
