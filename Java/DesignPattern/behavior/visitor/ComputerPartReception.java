package kasei.javase.designpattern.behavior.visitor;


/**
 * 访问者模式：我认为称为  接待者模式  更为恰当
 * 实现原理就是重载方法，根据参数类型的不同实现不同的逻辑
 * */
public interface ComputerPartReception {
    public void visit(Computer computer);
    public void visit(ComputerPartMouse mouse);
    public void visit(ComputerPartKeyboard keyboard);
    public void visit(ComputerPartMonitor monitor);

}
