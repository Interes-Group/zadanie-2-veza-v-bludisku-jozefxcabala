package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.awt.event.ActionEvent;

public class LeftButton extends MyButton{
    public LeftButton(String name, Maze maze){
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
        System.out.println("You pressed Left button!");
        if (maze[x][y - 1].isPassable()) {
            maze[x][y].setPlayer(false);
            this.maze.getActualPosition().setLocation(x, y - 1);
            maze[x][y - 1].setPlayer(true);
            this.maze.showMaze();
            checkWin();
        }
    }
}
