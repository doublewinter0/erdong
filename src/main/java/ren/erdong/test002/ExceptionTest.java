package ren.erdong.test002;

/**
 * @author erdong
 * @description 多线程异常的探究
 * @date 8:01 PM 8/4/20
 **/
public class ExceptionTest {
    public static void main(String[] args) {
        try {
            Thread th2 = new Thread(new Worker());
            Thread th1 = new Thread(new Worker());
            th1.setName("worker-1");
            th2.setName("worker-2");
            th1.start();
            th2.start();

            throw new RuntimeException("主线程的运行时异常!");
        } catch (RuntimeException exp) {
            System.out.println(exp.getMessage());
        }
    }
}
