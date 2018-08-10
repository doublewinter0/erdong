package ren.erdong;

import com.red.util.NoRRS;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 *	性能测试
 */
public class Test013 {

    public static void main(String[] args) {
        try {
            int[] arr = NoRRS.getNonRepeRanSeq(88888, 100000);
            long l_1 = System.currentTimeMillis();
            method_1(arr);
            long l_2 = System.currentTimeMillis();
            method_2(arr);
            long l_3 = System.currentTimeMillis();
            System.out.println(l_2 - l_1);
            System.out.println(l_3 - l_2);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public static Map<Integer, Integer> method_1(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // map.put(key, value)
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> keys = map.keySet();
            boolean flag = true;
            for (Integer integer : keys) {
                if (integer == arr[i]) {
                    flag = false;
                    map.put(arr[i], map.get(arr[i]) + 1);
                    break;
                }
            }
            if (flag) {
                map.put(arr[i], 1);
            }
        }
        return map;
    }

    public static Map<Integer, Integer> method_2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        return map;
    }
}