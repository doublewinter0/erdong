/*
 * This line is for God!
 * Created by SYSTEM on 2018/7/30 19:43
 * One is Gauss, and another is Évariste Galois.
 */

package ren.erdong.test037;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    private static Map<String, Integer> map = new HashMap<>();

    // 初始化
    private static void init() {
        map.put("语文", 1);
        map.put("数学", 2);
        map.put("化学", 5);
        map.put("英语", 3);
        map.put("物理", 4);
        map.put("生物", 6);
        map.put("历史", 7);
        map.put("地理", 8);
        map.put("az", 10);
        map.put("b[", 20);
        map.put("c<", 30);
        map.put("政治", 9);
		map.put("体育", 0);
    }

    public static void main(String[] args) throws Exception {

        disableWarning();

        init();
        // exporeHash();
        exploreHashMap();
    }

    private static void disableWarning() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Unsafe u = (Unsafe) theUnsafe.get(null);

            Class cls = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field logger = cls.getDeclaredField("logger");
            u.putObjectVolatile(cls, u.staticFieldOffset(logger), null);
        } catch (Exception exp) {
            // ignore
        }
    }

    // 对 HashMap 中 static int hash 变量的探究
    private static void exporeHash() throws Exception {
        Class<HashMap> mapClass = HashMap.class;
        Method hash = mapClass.getDeclaredMethod("hash", Object.class);
        hash.setAccessible(true);
        System.out.println("aO = " + Integer.toBinaryString((int) hash.invoke(null, "aO")));
        System.out.println("b0 = " + Integer.toBinaryString((int) hash.invoke(null, "b0")));
        System.out.println("数学 = " + Integer.toBinaryString((int) hash.invoke(null, "数学")));
        System.out.println("化学 = " + Integer.toBinaryString((int) hash.invoke(null, "化学")));
    }

    private static void exploreHashMap() throws Exception {
        Class<HashMap> mapClass = HashMap.class;
        // Class<?> nodeClass = Class.forName("java.util.HashMap$Node");
        Field table = mapClass.getDeclaredField("table");
        // Field[] nodeFields = nodeClass.getDeclaredFields();
        table.setAccessible(true);
        Object nodes = table.get(map);
        HashMap.Entry[] entries = (HashMap.Entry[]) nodes;
        System.out.println("nodes.length = " + entries.length);
        for (int i = 0; i < entries.length; i++) {
            Map.Entry entry;
            if ((entry = entries[i]) == null) {
                System.out.println("nodes[" + i + "] is null");
                continue;
            }
            Field[] entryFields = entry.getClass().getDeclaredFields();
            int j;
            for (j = 1; j < entryFields.length; j++) {
                entryFields[j].setAccessible(true);
                switch (j) {
                    case 1:
                        System.out.print("nodes[" + i + "].key = " + entry.getKey() + ", ");
                        break;
                    case 2:
                        System.out.println("nodes[" + i + "].value = " + entry.getValue());
                        break;
                    case 3:
                        if (entryFields[j].get(entry) == null)  System.out.println("nodes[" + i + "].next is null");
                        else {
                            System.out.print("nodes[" + i + "].next");
                            exploreLink(entry);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private static void exploreLink(Map.Entry entry) throws Exception {
        Class<? extends Map.Entry> entryClass = entry.getClass();
        Field next = entryClass.getDeclaredField("next");
        next.setAccessible(true);
        Map.Entry nodeObj;
        if ((nodeObj = (Map.Entry) next.get(entry)) == null) {
            System.out.println();
            return;
        }
        System.out.print(" --> key = " + nodeObj.getKey() + ", value = " + nodeObj.getValue());
        exploreLink(nodeObj);
    }
}
