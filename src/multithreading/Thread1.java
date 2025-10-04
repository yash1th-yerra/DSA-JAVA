package src.multithreading;

public class Thread1 extends Thread {

    public Thread1(String thread1) {
        super(thread1);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
//            if (i % 2 == 0) {
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
            System.out.println("Inside Thread1 : "+Thread.currentThread().getName() +" "+i);


        }
    }
}
