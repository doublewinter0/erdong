package ren.erdong.annotation;

public class Person {
    private String name;

    @Erdong(type = 1, value = "worker")
    public void work() {
        System.out.println("work method");
    }
}
