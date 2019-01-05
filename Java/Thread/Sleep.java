package main.java.se.thread;

import kasei.javase.se.thread.CreateThread1;

/* sleep:让本线程休眠指定的时间，sleep的时候并不释放锁 */
public class Sleep {
	public static void main(String[] args) throws InterruptedException {
        CreateThread1 t = new CreateThread1();
		t.start();
		
		for(int i=0; i<10; i++){//主线程
			if(i==5) {
				System.out.println("sleep()执行");
				Thread.sleep(5000);//让main线程休眠3秒
			}
			System.out.println("Main: "+i);
		}
	}
}
