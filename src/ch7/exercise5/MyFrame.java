package ch7.exercise5;

/**
 * Created by kenta_nakajima on 2017/09/15.
 */

import java.io.IOException;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
    public MyFrame() {
        super("MyFrame");
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(new JLabel("Thread per message sample"));
        JButton button = new JButton("Execute");

        getContentPane().add(button);
        button.addActionListener(this);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pack();

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        Service.service();
    }
}
