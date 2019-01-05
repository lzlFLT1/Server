package kasei.javase.designpattern.behavior.state;

public class StateStop implements State{

    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    public String toString(){
        return "Stop State";
    }
}
