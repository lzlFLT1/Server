package kasei.javase.se.objectoriented.classes;

import java.util.Arrays;

public enum Enumeration {

	//枚举类型是 常量 跟 'a' 一样，不能实例化的（即不能 new 和 Colors colors 定义引用）
	RED(1), GREEN(2), BULE(3), YELLOW(4), PURPLE(5), PINK(6);//这些就是枚举类的实例，括号内的相当于构造函数的参数


    private Integer value;


    private Enumeration(Integer value){
            this.value = value;
    }


	public static void main(String[] args) {

        Enumeration color = null;

        // 枚举类 类方法
        Enumeration[] ary = Enumeration.values();
        Enumeration color1 = Enumeration.valueOf(Enumeration.class, "PURPLE");
        Enumeration color2 = Enumeration.valueOf("GREEN");

        System.out.println(Arrays.toString(ary));
        System.out.println(color1);
        System.out.println(color2);

        // 枚举类 实例方法
        System.out.println(
                "Instance:\n"+
                Enumeration.RED.ordinal()+"\n"+
                Enumeration.RED.getDeclaringClass()+"\n"+
                Enumeration.RED.name()+"\n"+
                Enumeration.RED.toString()+"\n"+
                Enumeration.RED.compareTo(Enumeration.GREEN)
        );
	}
}
