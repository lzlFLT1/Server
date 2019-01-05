package kasei.javase.se.thread.concurrent;
/** Java 多线程并发同步
 * 主要解决的问题：多个线程在同一个时间访问和修改同一个资源的问题
 *
 * Java 中通过锁实现多线程并发同步问题：
 * 1. 类锁:不能在其他线程使用该类
 * 2. 对象锁：不能在其他线程使用该对象
 *
 *
 * 线程的同步（并发）：多个线程访问同一个资源
 * 1、用synchronized修饰方法，锁住的是当前对象this
 * 		synchronized void fun(){} 相当于  synchronized(this){ void fun(){} }
 * 
 * 2、synchronized(引用类型的变量|this|类.class){}
 * */

class ConcurrentSynchronized {

    /* synchronized 用法一：在静态(类)方法上
     * 这种情况下 synchronized 获取的是 类锁
     * */
    synchronized public static void aa(){

    }


    /* synchronized 用法二：在普通方法上
     * 这种情况下 synchronized 获取的是 对象锁
     * */
    synchronized public void bb(){ //实例锁：相当于  synchronized(this){ public void bb(){} },不能在其他线程使用该实例

    }


    /* synchronized 用法三：在代码块上，且  synchronized () 括号内是 类
     * 这种情况下 synchronized 获取的是 类锁
     * */
    public void cc(){
        synchronized (Size.class) { //类锁：不能在其他线程使用该类

            System.out.println("test开始..");
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test结束..");
        }
    }


    /* synchronized 用法三：在代码块上，且  synchronized () 括号内是 对象
     * 这种情况下 synchronized 获取的是 对象锁
     * */
    public void dd(){

        Object obj = new Object();
        synchronized (obj){

        }

    }

}  

