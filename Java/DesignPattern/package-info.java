package kasei.javase.designpattern;

/**
 1、开闭原则（Open Close Principle）
 开闭原则的意思是：对扩展开放，对修改关闭。
 在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。
 简言之，是为了使程序的扩展性好，易于维护和升级。想要达到这样的效果，我们需要使用接口和抽象类，后面的具体设计中我们会提到这点。


 2、里氏代换原则（Liskov Substitution Principle）
 里氏代换原则是面向对象设计的基本原则之一。
 里氏代换原则中说，任何基类可以出现的地方，子类一定可以出现。
 LSP 是继承复用的基石，只有当派生类可以替换掉基类，且软件单位的功能不受到影响时，基类才能真正被复用，而派生类也能够在基类的基础上增加新的行为。
 里氏代换原则是对开闭原则的补充。实现开闭原则的关键步骤就是抽象化，而基类与子类的继承关系就是抽象化的具体实现，所以里氏代换原则是对实现抽象化的具体步骤的规范。


 3、依赖倒转原则（Dependence Inversion Principle）
 这个原则是开闭原则的基础，具体内容：针对接口编程，依赖于抽象而不依赖于具体。


 4、接口隔离原则（Interface Segregation Principle）
 这个原则的意思是：使用多个隔离的接口，比使用单个接口要好。
 它还有另外一个意思是：降低类之间的耦合度。
 由此可见，其实设计模式就是从大型软件架构出发、便于升级和维护的软件设计思想，它强调降低依赖，降低耦合。


 5、迪米特法则，又称最少知道原则（Demeter Principle）
 最少知道原则是指：一个实体应当尽量少地与其他实体之间发生相互作用，使得系统功能模块相对独立。


 6、合成复用原则（Composite Reuse Principle）
 合成复用原则是指：尽量使用合成/聚合的方式，而不是使用继承。
 */


/*
设计模式的分类：{
	创建型：创建对象时不再由我们直接实例化对象，而是根据传入参数，由程序创建对象并返回 {
		简单工厂模式（并不是23中设计模式之一）{
			给工厂类传入一个表明所需对象类型的参数 type
			工厂类根据这个参数返回该参数对应的对象
		}
		抽象工厂模式：工厂的工厂喽 {
			给工厂的工厂传入一个表明所需工厂类型的参数 type
			工厂的工厂根据这个参数返回 该参数对应的工厂
		}
		单例模式：{
			私有化构造器
			提供 public Kasei getInstance(); 方法给外部获取唯一的实例
		}
		生成器模式
		原型模式
	}

	结构型：帮助将多个对象组织成更大的结构 {
		适配器模式
		桥接模式：{}
		组合器模式
		装饰器模式
		门面模式
		享元模式
		代理模式：{
			方法一：代理类 A，被代理类 B，
				同时实现接口 I，A 中组合一个 B 类的对象，
				且 B 中所有的方法，在 A 中都有同名的方法，
				在程序中需要 B 的时候返回 A，这就叫代理了

			方法二：代理类 A，被代理对类 B，
				A 是 B 的子类，也 tm 叫被代理了（但是这种方法更好）
		}
	}

	行为型：用于帮助系统间各对象的通信 {
		命令模式：向一个方法中直接传代码，这代码会嵌入在方法中的某处运行，着就是命令模式 {
			java 中不支持传代码，所以实现方式如下：
			创建一个接口 Command ，Command 中有个方法 customCode();
			调用时采用匿名内部类的方式，例如 execute(new Command(){sysout("我自定义的代码")});
		}
		解释器模式
		迭代器模式
		中介者模式
		备忘录模式
		观察者模式：{}
		状态模式
		策略模式: 用于封装系列的算法，这些算法通常被封装在一个被称为Context的类中 {
			传入一个参数给类 Context，Context 调用不同的策略返回
		}
		模板模式
		访问者模式
	}
}


*/

