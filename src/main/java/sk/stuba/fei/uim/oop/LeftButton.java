package sk.stuba.fei.uim.oop;

import java.awt.event.ActionEvent;

public class LeftButton extends MyButton{
    public LeftButton(String name){
        super(name);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setUsed(true);
        System.out.println("You pressed Left button!");
    }
}
