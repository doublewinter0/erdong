package ren.erdong.test002;

public class Worker implements Runnable {

    @Override
    public void run() {
        try {
            someMethod();

        } catch (RuntimeException expected) {
            System.out.println(expected.getMessage());
        }
    }

    private void someMethod() {
        System.out.println("线程名: " + Thread.currentThread().getName());
        throw new RuntimeException("子线程的运行时异常!");
    }
}
