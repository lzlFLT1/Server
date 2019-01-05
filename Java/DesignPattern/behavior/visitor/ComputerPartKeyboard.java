package kasei.javase.designpattern.behavior.visitor;

public class ComputerPartKeyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartReception computerPartReception) {
        computerPartReception.visit(this);
    }
}
