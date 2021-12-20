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
        btnLM.addActionListener(e -> {
            if (thL.getPriority()>Thread.MIN_PRIORITY)
                thL.setPriority(thL.getPriority()-1);
            System.out.println("L"+ thL.getPriority());
        });
        JButton btnLP = new JButton("+");
        btnLP.addActionListener(e -> {
            if (thL.getPriority()<Thread.MAX_PRIORITY)
                thL.setPriority(thL.getPriority()+1);
            System.out.println("L"+thL.getPriority());
        });
        JButton btnRP = new JButton("+");
        btnRP.addActionListener(e -> {
            if (thR.getPriority()<Thread.MAX_PRIORITY)
                thR.setPriority(thR.getPriority()+1);
            System.out.println("R"+thR.getPriority());
        });
        JButton btnRM = new JButton("-");
        btnRM.addActionListener(e -> {
            if (thR.getPriority()>Thread.MIN_PRIORITY)
                thR.setPriority(thR.getPriority()-1);
            System.out.println("R"+thR.getPriority());
        });
        JButton btn = new JButton("Ok");
        JButton btnStop = new JButton("Stop");
        btnStop.addActionListener((e) -> {
                thL.interrupt();
                thR.interrupt();
        });
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                thL = new Thread(() -> {
                        while(!Thread.interrupted())
                            synchronized (slider){
                            slider.setValue(slider.getValue()-1);
                        }
                });

                thR = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(!Thread.interrupted())
                            synchronized (slider){
                            slider.setValue(slider.getValue()+1);
                        }
                    }
                });
                thL.setDaemon(true);
                thR.setDaemon(true);
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
        panel.add(btnStop);
        win.setContentPane(panel);
        win.setVisible(true);
        System.out.println("main end");
    }
}
