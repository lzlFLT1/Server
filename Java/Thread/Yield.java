package kasei.javase.se.thread;

import kasei.javase.se.thread.CreateThread1;

/* yield:暂停自己的线程，并执行其他的线程，但是不能阻止CPU再次调用自己的线程 */
public class Yield {
	
	public static void main(String[] args) throws InterruptedException {
		CreateThread1 t = new CreateThread1();
		t.start();
		
		for(int i=0; i<10; i++){//主线程
			if(i%2==0) {
				System.out.println("yield()执行");
				Thread.yield();//暂停本线程，这条语句写在谁的线程体中就暂停谁
			}
			System.out.println("Main: "+i);
		}
	}
}
