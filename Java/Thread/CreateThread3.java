package kasei.javase.se.thread;

import java.util.concurrent.Callable;

/**使用 Callable 创建线程
 * 1、实现 Callable 接口，重写 call() 方法
 * 2、借助 执行调度服务 ExecutorService，获取 Future 对象
 * 		ExecutorService ser = Executors.newFixedThreadPool(2);
 * 		Future result = ser.submit(实现类对象);
 * 3、获取值 result.get()
 * 4、停止服务 ser.shutdownNow();
 * 
 * 用处：可以设置返回值，和对外声明异常
 */
public class CreateThread3 implements Callable<String> {


    private String name;

    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String call() throws Exception {
		
		System.out.println("使用实现Callable 接口来创建线程");

		for(int i=0; i<10; i++){
			System.out.println(this.name+": "+i);
		}
		return "Callable 结束！";
	}

}
