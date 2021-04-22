package sk.stuba.fei.uim.oop;

import lombok.Getter;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract public class MyButton extends JButton implements ActionListener {
    @Getter protected Maze maze;

    public MyButton(String name, Maze maze){
        super(name);
        this.maze = maze;
        setFocusable(false);
    }

    abstract public void actionPerformed(ActionEvent e);

    protected void checkWin(){
        int x = this.maze.getActualPosition().x;
        int y = this.maze.getActualPosition().y;
        if(this.maze.getMaze().getMaze()[x][y].isPlayer() && this.maze.getMaze().getMaze()[x][y].isFinish()){
            this.maze.generateNewMaze(maze);
        }
    }
}
