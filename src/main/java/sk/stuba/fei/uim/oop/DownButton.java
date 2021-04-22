package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.awt.event.ActionEvent;

public class DownButton extends MyButton{
    public DownButton(String name, Maze maze){
        super(name, maze);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.maze.findActualPosition();
        Point actualPosition = this.maze.getActualPosition();
        int x = actualPosition.x;
        int y = actualPosition.y;
        MazeCell[][] maze = this.maze.getMaze().getMaze();
        maze[x][y].setPressed(false);
        System.out.println("You pressed DOWN button!");
        if (maze[x + 1][y].isPassable()) {
            maze[x][y].setPlayer(false);
            this.maze.getActualPosition().setLocation(x + 1, y);
            maze[x + 1][y].setPlayer(true);
            this.maze.showMaze();
            checkWin();
        }
    }
}
