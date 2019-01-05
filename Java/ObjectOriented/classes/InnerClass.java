package kasei.javase.se.objectoriented.classes;


//在另一个类中创建内部类对象语法：必须先存在外部类对象，才能创建内部类对象,
//OuterClass.InnerClass innerObj = outerObj.new InnerClass();
public class InnerClass {
	private int i;
	private void ddl(){
		System.out.println("内部类访问外部类成员函数：InnerClass.ddl()");
	}
	
	//内部类
	public class Hh{
		//1、内部类中可直接访问外部类的所有成员
		void print(){
			System.out.println("内部类访问外部类成员变量：i = " + i);
			ddl();
		}
		
		//2、不能在内部类中定义静态成员
		//static int i;//方法也不行
		
		// 在内部类中调用外部类当前对象  InnerClass.this == 外部类当前对象
		public void innerPrint(){
			InnerClass.this.ddl();
		}	
	}
}


