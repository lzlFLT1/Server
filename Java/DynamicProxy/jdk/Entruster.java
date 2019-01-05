package kasei.javase.se.dynamicproxy.jdk;

// 委托类
public class Entruster implements CommonProxyInterface {
    @Override
    public void sell() {
        System.out.println("JDK: 我是委托类！");
    }

    @Override
    public void ad() {
        System.out.println("ad method");
    }
}
