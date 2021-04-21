package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private Maze maze;
    private Menu menu;

    public Game(){
        super("Maze Game");
        setLayout(new GridLayout(2,1));
        setSize(500,500);

        this.menu = new Menu();
        this.add(this.menu.getMenu());

        this.maze = new Maze();
        this.add(this.maze.getMazePanel());
        this.maze.showMaze();

        pack();
        setVisible(true);

        game();
    }

    private void game(){
        while(true){
            movingByButton();
        }
    }

    private void movingByButton(){
        for(int i = 0; i < this.menu.getButtons().size(); i++){
            if(this.menu.getButtons().get(i).isUsed()){
                this.menu.getButtons().get(i).setUsed(false);
                checkMove(this.menu.getButtons().get(i));
                this.maze.showMaze();
                break;
            }
        }
    }

    private void checkMove(MyButton button){
        Point actualPoisition = this.maze.getActualPosition();
        int x = actualPoisition.x;
        int y = actualPoisition.y;
        MazeCell[][] maze = this.maze.getMaze().getMaze();

        switch (button.getActionCommand()) {
            case "up":
                if (maze[x - 1 ][y].isPassable()){
                    maze[x][y].setPlayer(false);
                    this.maze.getActualPosition().setLocation(x - 1, y);
                    maze[x - 1][y].setPlayer(true);
                }
                break;
            case "left":
                if (maze[x][y - 1].isPassable()) {
                    maze[x][y].setPlayer(false);
                    this.maze.getActualPosition().setLocation(x, y - 1);
                    maze[x][y - 1].setPlayer(true);
                }
                break;
            case "down":
                if (maze[x + 1][y].isPassable()) {
                    maze[x][y].setPlayer(false);
                    this.maze.getActualPosition().setLocation(x + 1, y);
                    maze[x + 1][y].setPlayer(true);
                }
                break;
            case "right":
                if (maze[x][y + 1].isPassable()) {
                    maze[x][y].setPlayer(false);
                    this.maze.getActualPosition().setLocation(x, y + 1);
                    maze[x][y + 1].setPlayer(true);
                }
                break;
        }

    }


}
