package sk.stuba.fei.uim.oop;

import java.awt.event.ActionEvent;

public class ResetButton extends MyButton {
    private final CounterLabel counterLabel;

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
        this.maze.generateNewMaze(maze);
    }

}
