package kasei.javase.se.syntax.exception;

/** Java 异常层次结构:********************************************************
 * Throwable
 *  │
 *  ├─ Error                            (Error 类及其子类，程序员无法处理，也不必处理)
 *  └─ Exception                        (Checked类异常，必须处理)
 *        ├─ Exception及其子类           (Checked类异常，必须处理，外部错误，比如文件读取失败、网络连接错误等)
 *        └─ RuntimeException及其子类    (Unchecked类异常，处不处理均可，如果出现该类型异常，那么一定是程序员代码写错了)
 * */

/** Java 异常抛出原则
 * 1. 调用函数 需要 知道 被调函数 的执行状态：被调函数 应该抛出 Checked 异常
 * 2. 如果被调函数碰到了不可预知的异常，那么应该抛出 Unchecked (Error 或 RuntimeException)异常
 * */

