package ren.erdong;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

// 有关集合中泛型的问题
public class Test019 {

    public static void main(String[] args) {

        ArrayList<Dog> dogList = new ArrayList<>();
        ArrayList<Animal> aniList = new ArrayList<>();
        // System.out.println(dogList.getClass() == aniList.getClass()); // true
        dogList.add(new Dog("dog_1"));
        dogList.add(new Dog("dog_2"));
        aniList.add(new Animal("动物"));
        aniList.add(new Dog("狗"));
        aniList.add(new Cat("猫"));
        // System.out.println(dogList);
        // System.out.println(aniList);

        ((List<? super Dog>) aniList).add(new Dog("辉子"));
        // list.add(new Dog("阿黄"));

        // 利用反射跳过泛型检查, 具体原理?
        Class<? extends List> cla_1 = ((List<? extends Animal>) dogList).getClass();
        Class<? extends List> cla_2 = dogList.getClass();
        // Class 重写了 toString()
        System.out.println("cla_1 = " + cla_1);
        System.out.println("cla_2 = " + cla_2);
        System.out.println("cla_1 == cla_2 : " + (cla_1 == cla_2)); // true
        try {
            //Class cla = ArrayList.class;
            // Method method = list.getClass().getDeclaredMethod("add");
            Method method = cla_1.getDeclaredMethod("add", Object.class);
            method.invoke(dogList, new Dog("啊黄"));
            method.invoke(dogList, "艹腻骂");
            method.invoke(aniList, "red");
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        // 通过反射加进来的非 Dog 类在这里会出现异常
        // java.lang.ClassCastException: java.lang.String cannot be cast to com.red.Animal
        for (Animal ani : dogList) {
            ani.shout();
        }

        // objList.add(new Animal());
        System.out.println(dogList);
        System.out.println(aniList);
    }
}

class Animal {

    private String name;

    public Animal() {
        super();
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void shout() {
        System.out.println(name + ": 流弊...");
    }

    @Override
    public String toString() {
        return name;
    }
}

class Dog extends Animal {

    public Dog() {
        super();
    }

    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {

    public Cat() {
        super();
    }

    public Cat(String name) {
        super(name);
    }
}