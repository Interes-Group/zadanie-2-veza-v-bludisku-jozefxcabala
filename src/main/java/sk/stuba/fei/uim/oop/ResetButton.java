package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButton extends MyButton {
    private CounterLabel counterLabel;

    public ResetButton(String name, Maze maze, CounterLabel counterLabel){
        super(name, maze);
        addActionListener(this);
        this.counterLabel = counterLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You pressed RESET button!");
        this.maze.setReset(true);
        this.counterLabel.resetCounter();
        this.maze.generateNewMaze();
    }

}
