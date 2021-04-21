package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import java.awt.event.ActionEvent;

public class DownButton extends MyButton{
    public DownButton(String name){
        super(name);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setUsed(true);
        System.out.println("You pressed DOWN button!");
    }
}
