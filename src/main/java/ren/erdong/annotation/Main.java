package ren.erdong.annotation;

import ren.erdong.util.io.IOUtil;

import java.io.File;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException {
        Class<Person> personClass = Person.class;
        Method work = personClass.getMethod("work");
        Erdong erdong = work.getDeclaredAnnotation(Erdong.class);
        System.out.println(erdong);

        IOUtil.object2File(new File("/home/erdong/Projects/erdong/runtime/class/Erdong.class"), erdong);
    }
}
