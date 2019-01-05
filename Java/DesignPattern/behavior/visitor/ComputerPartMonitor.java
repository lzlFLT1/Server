package kasei.javase.designpattern.behavior.visitor;

public class ComputerPartMonitor implements ComputerPart {
    @Override
    public void accept(ComputerPartReception computerPartReception) {
        computerPartReception.visit(this);
    }
}
