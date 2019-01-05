package kasei.javase.designpattern.behavior.visitor;

public class ComputerPartReceptionImpl implements ComputerPartReception {
    @Override
    public void visit(Computer computer) {
        System.out.println("Displaying Computer.");
    }

    @Override
    public void visit(ComputerPartMouse mouse) {
        System.out.println("Displaying Mouse.");
    }

    @Override
    public void visit(ComputerPartKeyboard keyboard) {
        System.out.println("Displaying Keyboard.");
    }

    @Override
    public void visit(ComputerPartMonitor monitor) {
        System.out.println("Displaying Monitor.");
    }
}
