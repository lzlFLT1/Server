package kasei.demo;

public class Interrupt implements Runnable {

    long i=0L;

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted() && i<100000000L) {
                // 如果当前线程没有被其他线程打断
                System.out.println(i++);
                Thread.sleep(1000);
            }

            System.out.println("正常退出");
        } catch (Exception e) {
            System.out.println("被打断了");
        }

    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Interrupt());
        t1.start();
        Thread.sleep(5000);
        t1.interrupt(); // 1秒后打断 t1 线程

    }
}
