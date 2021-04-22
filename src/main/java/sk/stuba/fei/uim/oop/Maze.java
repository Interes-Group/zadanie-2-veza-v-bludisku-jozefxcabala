package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Maze extends JPanel{
    private final Border line;
    @Getter private final JPanel mazePanel;
    @Getter private MazeCreation maze;
    @Getter @Setter private boolean win;
    @Getter private Point actualPosition;
    @Getter @Setter Menu menu;
    @Getter @Setter private boolean reset;
    @Getter @Setter private boolean playerPressed;

    public Maze(){
        this.actualPosition = new Point();
        this.mazePanel = new JPanel();
        createMaze(13,13);
        this.mazePanel.setLayout(new GridLayout(this.maze.getRow()+2,this.maze.getCol()+2));
        this.line = new LineBorder(Color.BLACK, 1, false);
        this.win = false;
        this.reset = false;
    }

    private void setEntrance(){
        for(int i = 1; i < this.maze.getRow() + 1; i++){
            for(int j = 1; j < this.maze.getCol() + 1; j++){
                if(this.maze.getMaze()[i][j].isPassable()){
                    this.maze.getMaze()[i][j].setPlayer(true);
                    return;
                }
            }
        }
    }

    private void createMaze(int row, int col){
        this.maze = new MazeCreation(row, col);
        setEntrance();
        setExit();
        findActualPosition();
        this.win = false;
        this.mazePanel.revalidate();
    }

    private void setExit(){
        for(int i = this.maze.getRow() + 1; i > 0 ; i--){
            for(int j = this.maze.getCol() + 1; j > 0 ; j--){
                if(this.maze.getMaze()[i][j].isPassable()){
                    this.maze.getMaze()[i][j].setFinish(true);
                    return;
                }
            }
        }
    }

    public void showMaze(){
        for (int i = 0; i < this.maze.getRow() + 2; ++i){
            for (int j = 0; j < this.maze.getCol() + 2; ++j) {
                this.maze.getMaze()[i][j].setBorder(this.line);
                if (this.maze.getMaze()[i][j].isPassable()) {
                    if(this.maze.getMaze()[i][j].isPlayer())
                        this.maze.getMaze()[i][j].setBackground(Color.green);
                    else if(this.maze.getMaze()[i][j].isFinish())
                        this.maze.getMaze()[i][j].setBackground(Color.red);
                    else
                        this.maze.getMaze()[i][j].setBackground(Color.white);
                }
                else{
                    this.maze.getMaze()[i][j].setBackground(Color.black);
                }
                this.mazePanel.add(this.maze.getMaze()[i][j]);
            }
        }
    }

    public void generateNewMaze(){
        this.mazePanel.removeAll();

        if(!this.reset)
            this.getMenu().getCounterLabel().incrementCounterLabel();
        else
            this.reset = false;

        createMaze(13, 13);
        showMaze();
    }

    public void findActualPosition(){
        for(int i = 1; i < this.maze.getRow() + 1; i++){
            for(int j = 1; j < this.maze.getCol() + 1; j++){
                if(this.maze.getMaze()[i][j].isPassable() && this.maze.getMaze()[i][j].isPlayer()){
                    this.actualPosition.setLocation(i,j);
                    return;
                }
            }
        }
    }
}
