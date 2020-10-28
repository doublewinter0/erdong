package me.hoobaler.annotation;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException {
        Class<Person> personClass = Person.class;
        Method work = personClass.getMethod("work");
        Erdong erdong = work.getDeclaredAnnotation(Erdong.class);
        System.out.println(erdong);
    }
}
