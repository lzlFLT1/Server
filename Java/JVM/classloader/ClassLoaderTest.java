package kasei.javase.jvm.classloader;

public class ClassLoaderTest {

    public static void main(String[] args) {


        System.out.println("当前系统的类加载器："+ClassLoader.getSystemClassLoader());
        System.out.println("当前系统的类加载器的父类："+ClassLoader.getSystemClassLoader().getParent());
        System.out.println("当前系统的类加载器的父类的父类（由于bootstrap类加载器是由原生代码实现所以获取不到）："+ClassLoader.getSystemClassLoader().getParent().getParent());

        System.out.println("当前程序的类路径："+System.getProperty("java.class.path"));

        String a = "gg";
        System.out.println("加载a对象对应类的类加载器是："+a.getClass().getClassLoader());//结果为null，因为是bootstrap加载器
    }
}
