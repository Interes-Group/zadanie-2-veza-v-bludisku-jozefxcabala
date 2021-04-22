package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.event.ActionEvent;

public class UpButton extends MyButton{
    public UpButton(String name, Maze maze){
        super(name, maze);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.maze.findActualPosition();
        Point actualPoisition = this.maze.getActualPosition();
        int x = actualPoisition.x;
        int y = actualPoisition.y;
        MazeCell[][] maze = this.maze.getMaze().getMaze();
        maze[x][y].setPressed(false);
        System.out.println("You pressed UP button!");
        if (maze[x - 1 ][y].isPassable()){
            maze[x][y].setPlayer(false);
            this.maze.getActualPosition().setLocation(x - 1, y);
            maze[x - 1][y].setPlayer(true);
            this.maze.showMaze();
            checkWin();
        }
    }
}
