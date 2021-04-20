package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveButton extends JButton implements ActionListener {
    @Getter @Setter boolean up;
    @Getter @Setter boolean down;
    @Getter @Setter boolean right;
    @Getter @Setter boolean left;

    public MoveButton(String name){
        super(name);
        this.up = false;
        this.down = false;
        this.right = false;
        this.left = false;

        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "up":
                setUp(true);
                System.out.println("You pressed UP button!");
                break;
            case "down":
                setDown(true);
                System.out.println("You pressed DOWN button!");
                break;
            case "right":
                setRight(true);
                System.out.println("You pressed RIGHT button!");
                break;
            case "left":
                setLeft(true);
                System.out.println("You pressed LEFT button!");
                break;
        }
    }
}
