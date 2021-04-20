package sk.stuba.fei.uim.oop;

import lombok.Getter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Maze extends JPanel {
    private final Border line;
    @Getter private final JPanel mazePanel;
    @Getter private final MazeCreation maze;

    public Maze(){
        this.maze = new MazeCreation(13,13);

        this.mazePanel = new JPanel();
        this.mazePanel.setLayout(new GridLayout(this.maze.getRow()+2,this.maze.getCol()+2));
        this.line = new LineBorder(Color.BLACK, 1, false);

        setEntrance();
        setExit();
    }

    private void setEntrance(){
        for(int i = 1; i < this.maze.getRow() + 1; i++){
            for(int j = 1; j < this.maze.getCol() + 1; j++){
                if(this.maze.getMaze()[i][j].isPassable()){
                    this.maze.getMaze()[i][j].setStart(true);
                    return;
                }
            }
        }
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
                    if(this.maze.getMaze()[i][j].isStart())
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

}
