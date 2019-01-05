package kasei.javase.se.thread;


import kasei.javase.se.thread.CreateThread1;

/* join:把该线程合并到当前线程中 */
public class Join {
	public static void main(String[] args) throws InterruptedException {
        CreateThread1 t = new CreateThread1();
		t.start();
		
		for(int i=0; i<10; i++){//主线程
			if(i==5) {
				System.out.println("join()执行");
				t.join();//把 t 线程合并到当前（main）线程 中，main线程阻塞，等待t线程执行完成
			}
			System.out.println("Main: "+i);
		}
	}
}
