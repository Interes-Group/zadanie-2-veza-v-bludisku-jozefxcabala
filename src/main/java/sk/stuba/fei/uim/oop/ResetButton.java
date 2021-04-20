package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButton extends JButton implements ActionListener {
    @Getter @Setter boolean reset;

    public ResetButton(String name){
        super(name);
        this.reset = false;

        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You pressed RESET button!");
    }

}
