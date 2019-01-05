package kasei.javase.designpattern.behavior.observer;

import java.util.ArrayList;
import java.util.List;

public class BeLooked {

    List<Observer> observers = new ArrayList<>() ;

    public void attachObserver(Observer observer){
        this.observers.add(observer);
    }

    public void notifyAllObserver(){
        for (Observer item: observers) {
            item.update();
        }
    }
}
