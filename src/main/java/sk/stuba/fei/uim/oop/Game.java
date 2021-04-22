package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame{
    private Maze maze;
    private Menu menu;

    private KeyMoveListener keyMove;

    public Game(){
        super("Maze Game");
        setLayout(new GridLayout(2,1));
        setSize(500,500);

        this.maze = new Maze();

        this.menu = new Menu(this.maze);
        this.maze.setMenu(this.menu);

        this.add(this.menu.getMenu());
        this.add(this.maze.getMazePanel());

        this.maze.showMaze();

        this.keyMove = new KeyMoveListener(this.menu);
        addKeyListener(this.keyMove);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
