package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MazeCell extends JPanel{
    @Getter @Setter private boolean finish;
    @Getter @Setter private boolean player;
    @Getter @Setter private boolean pressed;
    @Getter @Setter private boolean passable;
    @Getter @Setter private Point father;
    @Getter @Setter private Point coordination;
    @Getter @Setter private ArrayList<MazeCell> possibleRoutes;

    @Getter @Setter private MouseMoveListener mouseMove;



    public MazeCell(){
        super();
        setPassable(false);
        setFather(null);
        setFinish(false);
        setPlayer(false);
        this.possibleRoutes = new ArrayList<>();
        this.coordination = new Point();
        this.pressed = false;

        this.mouseMove = new MouseMoveListener();
        addMouseListener(this.mouseMove);
    }
}
