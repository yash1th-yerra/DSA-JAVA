package src.multithreading;

public class ThreadTester {
    public static void main() {

        System.out.println("main start");
//        Thread t1 = new Thread1("Thread1");
//        t1.start();
//        Thread thread2 = new  Thread(new Thread2(),"Thread2");
        Thread thread2 = new  Thread(() ->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }

        },"Thread2");
        thread2.start();

        System.out.println("main end");

    }
}
