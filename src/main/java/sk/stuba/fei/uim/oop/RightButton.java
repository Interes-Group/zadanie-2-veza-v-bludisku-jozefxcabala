package sk.stuba.fei.uim.oop;

import java.awt.event.ActionEvent;

public class RightButton extends MyButton{
    public RightButton(String name){
        super(name);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setUsed(true);
        System.out.println("You pressed RIGHT button!");
    }
}
