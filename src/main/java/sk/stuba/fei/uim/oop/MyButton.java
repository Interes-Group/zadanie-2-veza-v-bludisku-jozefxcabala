package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract public class MyButton extends JButton implements ActionListener {
    @Getter @Setter private boolean used;
    public MyButton(String name){
        super(name);
        this.used = false;
    }

    abstract public void actionPerformed(ActionEvent e);
}
