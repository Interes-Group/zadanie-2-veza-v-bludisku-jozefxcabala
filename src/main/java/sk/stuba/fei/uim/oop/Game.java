package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame{

    public Game(int row, int col){
        super("Maze Game");
        setLayout(new GridLayout(2,1));
        setSize(500,500);

        Maze maze = new Maze(row, col);

        Menu menu = new Menu(maze);
        maze.setMenu(menu);

        this.add(menu.getMenu());
        this.add(maze.getMazePanel());

        maze.showMaze();

        KeyMoveListener keyMove = new KeyMoveListener(menu);
        addKeyListener(keyMove);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
