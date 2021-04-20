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
    }

}
