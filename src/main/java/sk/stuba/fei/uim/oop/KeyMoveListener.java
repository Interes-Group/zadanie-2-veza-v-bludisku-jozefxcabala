package sk.stuba.fei.uim.oop;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyMoveListener implements KeyListener {
    private Menu menu;

    public KeyMoveListener(Menu menu){
        this.menu = menu;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                System.out.println("Key UP was pressed!");
                this.menu.getButtonByCommand("up").doClick();
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("Key LEFT was pressed!");
                this.menu.getButtonByCommand("left").doClick();
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Key DOWN was pressed!");
                this.menu.getButtonByCommand("down").doClick();
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Key RIGHT was pressed!");
                this.menu.getButtonByCommand("right").doClick();
                break;
            default:
                System.out.println("Key " + e.getKeyChar() + " was pressed!");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
