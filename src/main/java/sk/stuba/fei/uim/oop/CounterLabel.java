package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

public class CounterLabel extends JLabel {
    @Getter @Setter private int counter;
    @Getter private final String labelString;

    public CounterLabel(){
        this.counter = 0;
        this.labelString = "Counter: ";
        setText(this.labelString + this.counter);
    }

    public void resetCounter(){
        this.counter = 0;
        setText(this.labelString + this.counter);
    }

    public void incrementCounterLabel(){
        this.counter++;
        setText(this.labelString + this.counter);
    }
}
