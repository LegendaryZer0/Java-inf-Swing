package ru.itis;

import javax.swing.*;

public class SimpleGui  extends JFrame {
    private JPanel mainPanel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTextField statusDoneTextField;
    public SimpleGui(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

    }

    public static void main(String[] args) {
        SimpleGui simpleGui = new SimpleGui();
        simpleGui.setVisible(true);
    }
}
