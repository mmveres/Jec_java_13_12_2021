package ua.univer.lesson04.priority;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramThSync {
    public static void main(String[] args) {
        JFrame win = new JFrame("THPrior");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(500,400);

        JPanel panel = new JPanel();
        JTextField txt = new JTextField("                  ");
        JButton btn = new JButton("Ok");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(
                        () -> {
                     //       synchronized (txt){
                        for (int i = 0; i < 100; i++) {
                            txt.setText("hi"+i+ " : " +Thread.currentThread().getId());
                            try {
                                Thread.sleep(40);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                   //         }

                }).start();


            }
        });
        panel.add(txt);
        panel.add(btn);
        win.setContentPane(panel);
        win.setVisible(true);
    }
}
