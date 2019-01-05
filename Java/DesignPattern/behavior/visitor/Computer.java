package kasei.javase.designpattern.behavior.visitor;

public class Computer implements ComputerPart {

    ComputerPart[] computerParts ;

    public Computer(){
        computerParts = new ComputerPart[] {new ComputerPartKeyboard(), new ComputerPartMouse(), new ComputerPartMonitor()};
    }


    @Override
    public void accept(ComputerPartReception computerPartReception) {

        for (int i = 0; i < computerParts.length; i++) {
            computerParts[i].accept(computerPartReception);
        }
        computerPartReception.visit(this);
    }
}
