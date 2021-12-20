package ua.univer.lesson04;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" start");
        System.out.println("do smth");
        Thread th1 = new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" start");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" end");
            }
        };
        th1.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" start");
                System.out.println(Thread.currentThread().getName()+" end");
            }
        }).start();

        th1.join();
        System.out.println(Thread.currentThread().getName()+" end");
    }
}
