package kasei.javase.se.thread;

/** 使用实现Runnable 接口来创建线程
 * 实现原理：静态代理设计模式
 * 1.真实角色
 * 2.代理角色：组合真实角色的引用
 * 3.二者实现相同的接口
 * */
public class CreateThread2 implements Runnable {

    // 实现 Runnable 接口的线程，用 3 个 Thread 对象包装同一个 Runnable 实现对象，字段就实现了资源共享

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
	public void run() {
		System.out.println("使用实现Runnable 接口来创建线程");
		for(int i=0; i<10; i++){
			System.out.println(this.name+": "+i);
		}
	}
}
