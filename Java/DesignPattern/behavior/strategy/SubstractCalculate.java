package kasei.javase.designpattern.behavior.strategy;

public class SubstractCalculate implements Calculate {

    @Override
    public Integer calculate(Integer i1, Integer i2) {
        return i1-i2;
    }
}
