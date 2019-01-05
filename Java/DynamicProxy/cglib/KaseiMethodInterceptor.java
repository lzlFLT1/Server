package kasei.javase.se.dynamicproxy.cglib;


import java.util.Arrays;

public class KaseiMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("CGLIB Dynamic Proxy: 动态代理生成");
        return proxy.invokeSuper(obj, args);
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloConcrete.class);
        enhancer.setCallback(new KaseiMethodInterceptor());

        Entruster hello = (Entruster)enhancer.create();
        System.out.println(hello.sayHello("I love you!"));
    }
}
