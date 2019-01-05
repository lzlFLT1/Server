package kasei.javase.se.thread;

/** 使用 继承 Tread 类的方法创建线程*/
public class CreateThread1 extends Thread{


    private static String sharedResource; // 继承 Thread 类 使用 static 类字段实现资源共享

	@Override //重写父类run方法
	public void run(){
		System.out.println("使用继承 Thread 类的方法创建线程");
		for(int i=0; i<10; i++){
			System.out.println(currentThread().getName()+ "=Thread: "+i);
		}
	}
}
