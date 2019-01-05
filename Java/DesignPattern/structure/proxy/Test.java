package kasei.javase.designpattern.structure.proxy;

//代理模式：一个对象A可以由另一个对象B完全代理，A中的所有方法在B中都会被覆盖，且A和B属于同一个类的子类
public class Test {

	public static void main(String[] args) {
		CustomerProxy p = new CustomerProxy();
		p.print();
	}
}
