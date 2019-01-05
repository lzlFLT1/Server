package kasei.javase.se.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class KaseiInvocationHandler implements InvocationHandler {

    private Entruster entruster;

    public KaseiInvocationHandler(Entruster entruster) {
        this.entruster = entruster;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(this.entruster, args);
        System.out.println("after");
        return result;
    }


    public static void main(String[] args) {
        //创建中介类实例
        KaseiInvocationHandler kih = new KaseiInvocationHandler(new Entruster());
        //加上这句将会产生一个$Proxy0.class文件，这个文件即为动态生成的代理类文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        //获取代理类实例sell
        CommonProxyInterface sell = (CommonProxyInterface)(Proxy.newProxyInstance(CommonProxyInterface.class.getClassLoader(), new Class[] {CommonProxyInterface.class}, kih));

        //通过代理类对象调用代理类方法，实际上会转到invoke方法调用
        sell.sell();
        sell.ad();
    }
}
