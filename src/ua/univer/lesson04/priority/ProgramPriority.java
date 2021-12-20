package ua.univer.lesson04.priority;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramPriority {
    static Thread thL;
    static Thread thR;
    public static void main(String[] args) {
        JFrame win = new JFrame("THPrior");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(500,400);

        JPanel panel = new JPanel();
        JSlider slider = new JSlider(0,100,50);
        JButton btnLM = new JButton("-");
        JButton btnLP = new JButton("+");
        JButton btnRP = new JButton("+");
        JButton btnRM = new JButton("-");
        JButton btn = new JButton("Ok");
        JButton btnStop = new JButton("Stop");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                thL = new Thread(() -> {
                        while(true)
                            slider.setValue(slider.getValue()-1);
                });

                thR = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(true)
                            slider.setValue(slider.getValue()+1);
                    }
                });
                thL.start();
                thR.start();
            }
        });

        panel.add(btnLM);
        panel.add(btnLP);
        panel.add(slider);
        panel.add(btnRP);
        panel.add(btnRM);
        panel.add(btn);
        win.setContentPane(panel);
        win.setVisible(true);
    }
}
