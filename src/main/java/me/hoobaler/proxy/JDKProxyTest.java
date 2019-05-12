package me.hoobaler.proxy;

import me.hoobaler.util.ProxyUtil;
import me.hoobaler.util.ReflectUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxyTest {

    public static void main(String[] args) throws Exception {

        ReflectUtil.disableWarning();

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        HelloWorld helloWorld = name -> System.out.println("你好, " + name);

        // this is a simplified way
        /*
        HelloWorld iproxy = (HelloWorld) Proxy.newProxyInstance(JDKProxyTest.class.getClassLoader(), new Class<?>[]{HelloWorld.class},
                (proxy, method, arg2s) -> {
                    System.out.println("before invoke");
                    Object obj = method.invoke(helloWorld, arg2s);
                    System.out.println("after invoke");
                    return obj;
                });
        */

        // this is a general way
        InvocationHandler handler = (proxy, method, arg3s) -> {
            System.out.println("proxy = " + proxy.getClass());
            System.out.println(proxy.getClass().getName());
            System.out.println(arg3s.length);
            System.out.println(Arrays.toString(arg3s));
            System.out.println("before invoke");
            Object obj = method.invoke(helloWorld, arg3s);
            System.out.println("after invoke");
            return obj;
        };
        Class<?> proxyClass = Proxy.getProxyClass(JDKProxyTest.class.getClassLoader(), HelloWorld.class);
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        HelloWorld iproxy = (HelloWorld) constructor.newInstance(handler);
        System.out.println("iproxy = " + iproxy.getClass());
        ProxyUtil.generateClassFile(iproxy.getClass(), "IProxy");
        iproxy.sayHello("二冬");
    }
}
