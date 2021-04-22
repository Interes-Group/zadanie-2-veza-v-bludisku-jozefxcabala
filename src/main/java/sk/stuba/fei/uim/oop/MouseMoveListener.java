package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseMoveListener implements MouseListener {
    public MouseMoveListener(){
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if(source instanceof MazeCell){
            MazeCell panelPressed = (MazeCell) source;
            if(panelPressed.isPlayer() && !panelPressed.isPressed()) {
                System.out.println("Player was clicked - is marked");
                panelPressed.setPressed(true);
            }
            else if(panelPressed.isPlayer() && panelPressed.isPressed()) {
                panelPressed.setPressed(false);
                System.out.println("Player was clicked again - is not marked");
            }
            else if(!panelPressed.isPlayer() && checkPlayer(panelPressed)){
                for(int i = 0; i < panelPressed.getPossibleRoutes().size(); i++){
                    if(panelPressed.getPossibleRoutes().get(i).isPlayer() && panelPressed.getPossibleRoutes().get(i).isPressed()) {
                        panelPressed.getPossibleRoutes().get(i).setPlayer(false);
                        panelPressed.getPossibleRoutes().get(i).setPressed(false);
                        panelPressed.getPossibleRoutes().get(i).setBackground(Color.white);
                    }
                }
                panelPressed.setPlayer(true);
                panelPressed.setBackground(Color.green);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        if(source instanceof MazeCell){
            MazeCell panelPressed = (MazeCell) source;
            if(checkPlayer(panelPressed))
                panelPressed.setBackground(Color.yellow);

        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();
        if(source instanceof MazeCell){
            MazeCell panelPressed = (MazeCell) source;
            if(panelPressed.isPassable() && checkPlayer(panelPressed))
                panelPressed.setBackground(Color.white);

        }
    }

    private boolean checkPlayer(MazeCell panelPressed){
        for(int i = 0; i < panelPressed.getPossibleRoutes().size(); i++){
            if(panelPressed.getPossibleRoutes().get(i).isPlayer() && panelPressed.getPossibleRoutes().get(i).isPressed())
                return true;
        }
        return false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println("pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("released");
    }
}
