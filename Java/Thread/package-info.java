package kasei.javase.se.thread;


/** 线程间通信：
 * 轮询：自己不断的去查看某个标志是否存在
 * 监听（等待/通知）：如果某个事件发生，由监听者通知自己
 * 回调：事件发生之后，调用自己
 * */


/** 创建线程的方法
 * 1，继承Thread类，重写run方法；
 * 2，实现Runnable接口，重写run方法，但是比继承Thread类好用，实现接口还可以继承类，避免了单继承带来的局限性；
 * 3，实现callable接口，重写call方法，有返回值。
 * 4，使用实现了Executor接口的ThreadPoolExecutor来创建线程池。
 * */


