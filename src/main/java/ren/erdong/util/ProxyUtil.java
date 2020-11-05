package ren.erdong.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ProxyUtil {

    public static void generateClassFile(ClassLoader loader, Class<?> clazz, String proxyName) throws Exception {

        // byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());
        Class<?> proxyGenerator = Class.forName("java.lang.reflect.ProxyGenerator");
        Method proxyMethod = proxyGenerator.getDeclaredMethod("generateProxyClass", ClassLoader.class, String.class, List.class, int.class);
        proxyMethod.setAccessible(true);
        byte[] classFile = (byte[]) proxyMethod.invoke(null, loader, proxyName, Arrays.asList(clazz.getInterfaces()), 17);
        // String paths = ProxyUtil.class.getResource("/").getPath();
        String rootDir = new File(".").getCanonicalPath();
        String parentDir = rootDir + "/" + "runtime/class/";
        File file = new File(parentDir, proxyName + ".class");
        System.out.println("file = " + file.getPath());
        FileOutputStream out = null;

        try {
            // 保留到硬盘中
            out = new FileOutputStream(file);
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
