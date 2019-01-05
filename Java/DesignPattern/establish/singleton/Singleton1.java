package kasei.javase.designpattern.establish.singleton;

//单例模式：饿汉式
public class Singleton1 {

	private Singleton1(){}
	private Singleton1 instance = new Singleton1();
	
	public Singleton1 getInstance(){
		return instance;
	}
}

//单例模式：静态内部类
class Singleton2{
	
	private Singleton2(){}
	private static class Singleton2Instance{
		private static final Singleton2 instance = new Singleton2();
	}
	
	public Singleton2 getInstance(){
		return Singleton2Instance.instance;
	}
}


//单例模式：枚举方式
enum Singleton3{
	
	INSTANCE;
	public void whateverFunction(){}
}

//单例模式：双重检验锁
class Singleton4{
	
	private static Singleton4 instance = null;
	private Singleton4(){}
	public Singleton4 getInstance(){
		if(instance == null){
			synchronized(Singleton4.class){
				if(instance == null){
					instance = new Singleton4();
				}
			}
		}
		return instance;
	}
}





