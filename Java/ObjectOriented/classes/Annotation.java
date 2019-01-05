package kasei.javase.se.objectoriented.classes;

/**
 * 内置注解：
 * @Override  //告知编译器其标记的方法是由父类定义的——即方法重写
 * @Deprecated  //表示其标记的 类、方法、字段，不推荐使用
 * @SuppressWarning  //告知编译器忽略被该注解所标记的代码中的某些警告
 * 
 * 元注解：
 * @Retention()
 * @Documented
 * @Inherited
 * @Target(value={ElementType.FIELD, ElementType.METHOD}) //元注解：指定了Decscription 注解 只能用于（）内的类型
 * */
public @interface Annotation {

	//属性对应的抽象方法不能带参数，也不能声明抛出异常
	//属性的类型只能是基本类型、String、Class、枚举、注解及这些类型的数组
	String name() default "Kasei";
	int age() default 22;
	String[] str() default {"Haku", "木可川页金夆"};
}
