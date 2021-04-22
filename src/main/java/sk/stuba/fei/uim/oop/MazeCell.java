package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MazeCell extends JPanel{
    @Getter @Setter private boolean finish;
    @Getter @Setter private boolean player;
    @Getter @Setter private boolean pressed;
    @Getter @Setter private boolean passable;
    @Getter  private final Point coordination;
    @Getter  private final ArrayList<MazeCell> possibleRoutes;
    @Getter  private final MouseMoveListener mouseMove;
    @Getter private final Maze maze;

    public MazeCell(Maze maze){
        super();
        setPassable(false);
        setFinish(false);
        setPlayer(false);
        this.possibleRoutes = new ArrayList<>();
        this.coordination = new Point();
        this.pressed = false;
        this.maze = maze;

        this.mouseMove = new MouseMoveListener();
        addMouseListener(this.mouseMove);
    }
}
