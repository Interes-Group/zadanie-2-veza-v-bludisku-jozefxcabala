package sk.stuba.fei.uim.oop;

import lombok.Getter;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Menu extends JPanel {
    @Getter private final ArrayList<MyButton> buttons;
    @Getter private final JPanel menu;
    @Getter private final CounterLabel counterLabel;


    public Menu(Maze maze){
        this.menu = new JPanel();
        this.menu.setLayout(new GridLayout(2,3));

        this.counterLabel = new CounterLabel();
        this.menu.add(this.counterLabel);

        this.buttons = new ArrayList<>();
        this.buttons.add(new UpButton("up", maze));
        this.buttons.add(new ResetButton("reset", maze, this.counterLabel));
        this.buttons.add(new LeftButton("left", maze));
        this.buttons.add(new DownButton("down", maze));
        this.buttons.add(new RightButton("right", maze));

        createMenu();
        setFocusable(false);
    }

    private void createMenu(){
        for (MyButton button : this.buttons) {
            this.menu.add(button);
        }
    }

    public MyButton getButtonByCommand(String command){
        for (MyButton button : this.buttons) {
            if (button.getActionCommand().equals(command))
                return button;
        }
        return null;
    }
}
