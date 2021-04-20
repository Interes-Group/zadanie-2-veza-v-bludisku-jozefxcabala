package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class MazeCell extends JPanel {
    @Getter @Setter boolean start;
    @Getter @Setter boolean finish;
    @Getter @Setter boolean player;
    @Getter @Setter private boolean passable;
    @Getter @Setter private Point father;

    public MazeCell(){
        setPassable(false);
        setFather(null);
        setStart(false);
        setFinish(false);
        setPlayer(false);
    }
}
