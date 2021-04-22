package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.awt.event.ActionEvent;

public class RightButton extends MyButton{
    public RightButton(String name, Maze maze){
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
        System.out.println("You pressed RIGHT button!");
        if (maze[x][y + 1].isPassable()) {
            maze[x][y].setPlayer(false);
            this.maze.getActualPosition().setLocation(x, y + 1);
            maze[x][y + 1].setPlayer(true);
            this.maze.showMaze();
            checkWin();
        }
    }
}
