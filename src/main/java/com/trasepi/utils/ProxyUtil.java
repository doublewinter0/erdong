package com.trasepi.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class ProxyUtil {

    public static void generateClassFile(Class clazz, String proxyName) throws Exception {

        //根据类信息和提供的代理类名称，生成字节码
        // byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());
        Class<?> proxyGenerator = Class.forName("java.lang.reflect.ProxyGenerator");
        Method proxyMethod = proxyGenerator.getDeclaredMethod("generateProxyClass", String.class, Class[].class);
        proxyMethod.setAccessible(true);
        byte[] classFile = (byte[]) proxyMethod.invoke(null, proxyName, clazz.getInterfaces());
        // String paths = ProxyUtil.class.getResource("/").getPath();
        String rootDir = new File(".").getCanonicalPath();
        String parentDir = rootDir + "/" + "generated/com/trasepi/";
        File file = new File(parentDir , proxyName + ".class");
        System.out.println("file = " + file.getPath());
        // boolean flag = false;
        // if (file.exists()) System.out.println(file.delete());
        // else flag = file.createNewFile();
        // System.out.println(flag);
        FileOutputStream out = null;

        try {
            //保留到硬盘中
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
