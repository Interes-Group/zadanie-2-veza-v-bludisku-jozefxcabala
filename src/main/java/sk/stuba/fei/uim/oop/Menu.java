package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    @Getter @Setter private MoveButton up;
    @Getter @Setter private MoveButton down;
    @Getter @Setter private MoveButton right;
    @Getter @Setter private MoveButton left;
    @Getter @Setter private ResetButton reset;
    @Getter private JPanel menu;
    @Getter @Setter private JLabel counter;

    public Menu(){
        this.menu = new JPanel();
        this.menu.setLayout(new GridLayout(2,3));

        this.counter = new JLabel("Counter: 0");
        this.menu.add(this.counter);

        this.up = new MoveButton("up");
        this.menu.add(this.up);

        this.reset = new ResetButton("reset");
        this.menu.add(this.reset);

        this.left = new MoveButton("left");
        this.menu.add(this.left);

        this.down = new MoveButton("down");
        this.menu.add(this.down);

        this.right = new MoveButton("right");
        this.menu.add(this.right);
    }
}
