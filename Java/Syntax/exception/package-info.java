package kasei.javase.se.syntax.exception;

/* Java 异常层次结构:********************************************************
 * Throwable
 *  │
 *  ├─ Error                            (Error 类及其子类，程序员无法处理，也不必处理)
 *  └─ Exception                        (Checked类异常，必须处理)
 *        ├─ Exception及其子类           (Checked类异常，必须处理，外部错误，比如文件读取失败、网络连接错误等)
 *        └─ RuntimeException及其子类    (Unchecked类异常，处不处理均可，如果出现该类型异常，那么一定是程序员代码写错了)
 * */
