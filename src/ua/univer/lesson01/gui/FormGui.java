package ua.univer.lesson01.gui;

import javax.swing.*;
import java.awt.event.*;


public class FormGui {

    public static void main(String[] args) {
        JFrame win = new JFrame(" First ");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(300,400);
        JPanel panel = new JPanel();
        JTextField txt1 = new JTextField("                                ");
        JTextField txt2 = new JTextField("                                ");
        JTextField txt3 = new JTextField("                                ");
        JButton btn1 = new JButton("+");
        btn1.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = Integer.parseInt(txt1.getText().trim());
                int y = Integer.parseInt(txt2.getText().trim());
                txt3.setText(String.valueOf(x+y));
            }
        });
        JButton btn2 = new JButton("*");
        btn2.addActionListener(
                e -> {
                int x = Integer.parseInt(txt1.getText().trim());
                int y = Integer.parseInt(txt2.getText().trim());
                txt3.setText(String.valueOf(x+y));
        });
        JButton btn3 = new JButton("-");

        btn3.addActionListener(e -> txt3.setText("hi"));

        panel.add(txt1);
        panel.add(txt2);
        panel.add(txt3);
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        win.setContentPane(panel);
        win.setVisible(true);
    }

}
