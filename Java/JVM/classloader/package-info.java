package kasei.javase.jvm.classloader;


/****************************** Java 类加载器 *****************************************
 * 什么是类加载器： 类加载器是用于加载 java 程序中所有使用到的资源的类
 *
 *
 * Java 类加载器的层次结构：
 * Bootstrap Class Loader(启动类加载器):
 *    └─ Extension Class Loader(扩展类加载器):ExtClassLoader
 *         └─ Application Class Loader(应用程序类加载器):
 *             └─ User Class Loader(用户自定义类加载器):
 *
 * Bootstrap: 启动类加载器
 *      1. 使用原生代码实现的，并不继承自java.lang.ClassLoader.
 *      2. Bootstrap 类不用专门的类加载器加载
 *      3. Bootstrap 类负责加载 JAVA_HOME/jre/lib/rt.jar 或 sun.boot.class.path 路径下的内容
 *      4. 加载扩展类和应用程序类加载器，并制定他们的父类加载器
 *      5. 由 Bootstrap 类加载器加载的类 Class.getClassLoader() 方法返回 null
 *
 * sun.misc.Launcher$ExtClassLoader: 扩展类加载器
 *      1. 加载 JAVA_HOME/jre/ext/*.jar 或 java.ext.dirs 路径下的内容
 *      2. 该类加载器类全路径：
 *
 * sun.misc.Launcher$AppClassLoader: 应用程序类加载器
 *      1. 加载 java 应用的类路径（classpath，java.class.path 路径下的类），
 *      2. 一般来说，java应用的类都是由它加载的
 *
 * 自定义类加载器：开发人员可以通过继承java.lang.ClassLoader类的方式实现自己的类加载器，以满足一些特殊的需求
 *
 * **************************** JVM 类唯一性标识 *********************************
 * 一个类在 JVM 的唯一性标识 = 类加载器 + 类名
 * 如果同一个类被不同的 类加载器 加载，那 jvm 认为是不相同的类
 *
 * **************************** Java类加载器的调用顺序 *********************************
 * 双亲委托机制（即先由上层加载器加载，如果上层加载不了才使用子层加载器加载）
 *
 * **************************** 双亲委托机制的破坏 ******************************
 * 第一种：重写 java.lang.ClassLoader 类的 loadClass() 方法
 * 第二种：
 *      线程上下文类加载器：为了抛弃掉双亲委托机制的类加载模式
 *      这个类加载器可以通过java.lang.Thread类的setContextClassLoader()方法进行设置，
 *      如果创建线程时还未设置，他将会从父线程中继承一个，
 *      如果在应用程序的全局范围内都没有设置过的话，那这个类加载器默认就是应用程序类加载器。
 * 第三种：OSGi(Open Service Gateway Initiative)
 * */