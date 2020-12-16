package ru.itis;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

@Slf4j
public class SimpleGui  extends JFrame {
    private JPanel mainPanel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JButton button1;
    private JButton createRectangleBtn;
    private JTextField statusDoneTextField;
    private JPanel visionPanel;
    private JButton twistRectangleBtn;
    private JPanel rectangle;
    private  Rectangle rect;


    public SimpleGui(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        comboBox1.addItem("Information");
        comboBox1.addItem("About");
        comboBox1.addItem("Contact Us");

        this.pack();


        button1.addActionListener(e -> {
            visionPanel.removeAll();
            visionPanel.repaint();
            JPanel formPanel = new JPanel(new GridBagLayout());

             JLabel nameLabel = new JLabel("Ваше Имя", JLabel.LEFT);
            formPanel.add(nameLabel);

            JTextField nameField = new JTextField(15);
            nameLabel.setLabelFor(nameField);
            formPanel.add(nameField );

            JLabel categoryLabel = new JLabel("Ваш возраст", JLabel.LEFT);
            formPanel.add(categoryLabel);

            JTextField categoryField = new JTextField(15);
            categoryLabel.setLabelFor(categoryField);
            formPanel.add(categoryField );


            GridBagConstraints spacer = new GridBagConstraints();
            spacer.fill = GridBagConstraints.BOTH;
            spacer.gridwidth = GridBagConstraints.REMAINDER;
            spacer.weighty = 1.0;
            formPanel.add(new JPanel(), spacer);
             JButton saveButton = new JButton("Сохранить");
            formPanel.add(saveButton );
            formPanel.setBorder(new TitledBorder("Заполните форму"));
            formPanel.setSize(300, 300);
            visionPanel.add(formPanel);
            statusDoneTextField.setText("Заполнение формы");
            /*visionPanel.validate();*/
            visionPanel.repaint();

        });
        comboBox1.addItemListener(e -> {
            String item = (String) comboBox1.getSelectedItem();
            if(item.equals("About")){
                JFrame frame = new JFrame("form");
                frame.setSize(350,150);
                frame.setVisible(true);
                /*frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
                JLabel label = new JLabel("Information there");
                frame.add(label);
                frame.repaint();
            }
        });

        createRectangleBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                visionPanel.removeAll();
                visionPanel.repaint();

                Space space = new Space();
                log.info("vision panel {}",visionPanel);
                log.info("space {}",space);

                visionPanel.add(space);
                statusDoneTextField.setText("Показ прямоугольника");
                space.validate();
                space.repaint();


            }
        });
        twistRectangleBtn.addActionListener((event)->{
            RealTimeRotateSpace space2 = new RealTimeRotateSpace();
            visionPanel.repaint();
            visionPanel.removeAll();
            /*visionPanel.removeAll();*/
            visionPanel.add(space2);
            Timer time=new Timer(25, e -> {
                space2.repaint();

            });
            time.start();
            statusDoneTextField.setText("Вращение прямоугольнник");
            space2.repaint();


        });
    }

    public static void main(String[] args) {
        SimpleGui simpleGui = new SimpleGui();
        simpleGui.setVisible(true);
    }





    private class Space extends JPanel  {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D graphics2D = (Graphics2D) g;
            graphics2D.setColor(Color.RED);
            int h =visionPanel.getHeight()/2;
            int w =visionPanel.getWidth()/2;
            graphics2D.fillRect(50, 50, w, h);
        }
        public Space()
        {
            setVisible(true);
            setFocusable(true);
            setSize(640, 480);
            /*setBackground(Color.BLACK);*/
            pack();

        }


    }


    private class RealTimeRotateSpace extends JPanel {
        private double i = 0;
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            i+=0.1;
            Graphics2D graphics2D = (Graphics2D) g;
            graphics2D.setColor(Color.RED);
            /*graphics2D.fillRect(50, 50, 100, 100);*/
            int h =visionPanel.getHeight()/2;
            int w =visionPanel.getWidth()/2;
            this.setAlignmentX(h);
            this.setAlignmentY(w);
            graphics2D.setTransform(AffineTransform.getRotateInstance(i,
                    (this.getPreferredSize().getWidth() + w)/2,
                    (this.getPreferredSize().getHeight() + h)/2));
            graphics2D.fillRect((int) (this.getPreferredSize().getWidth()/2),
                    (int) (this.getPreferredSize().getHeight()/2),
                    w, h);
        }
        public RealTimeRotateSpace()
        {
            setLocation(50,50);
            setVisible(true);
            setFocusable(true);
            setSize(640, 480);
            /*setBackground(Color.BLACK);*/
            pack();

        }

    }

}




