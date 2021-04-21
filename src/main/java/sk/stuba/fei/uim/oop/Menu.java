package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Menu extends JPanel {
    @Getter private final ArrayList<MyButton> buttons;
    @Getter private final JPanel menu;
    @Getter @Setter private JLabel counter;

    public Menu(){
        this.menu = new JPanel();
        this.menu.setLayout(new GridLayout(2,3));

        this.counter = new JLabel("Counter: 0");
        this.menu.add(this.counter);

        this.buttons = new ArrayList<>();
        this.buttons.add(new UpButton("up"));
        this.buttons.add(new ResetButton("reset"));
        this.buttons.add(new LeftButton("left"));
        this.buttons.add(new DownButton("down"));
        this.buttons.add(new RightButton("right"));

        createMenu();
    }

    private void createMenu(){
        for (MyButton button : this.buttons) {
            this.menu.add(button);
        }
    }
}
