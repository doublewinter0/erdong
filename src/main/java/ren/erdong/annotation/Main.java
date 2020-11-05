package ren.erdong.annotation;

import ren.erdong.util.ProxyUtil;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {
         System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        Class<Person> personClass = Person.class;
        Method work = personClass.getMethod("work");
        Erdong erdong = work.getDeclaredAnnotation(Erdong.class);

        // ProxyUtil.generateClassFile(personClass.getClassLoader(), erdong.getClass(), "Erdong");
    }
}
