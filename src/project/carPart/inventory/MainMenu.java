package project.carPart.inventory;
        
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainMenu extends JPanel {
    static JFrame frame = new JFrame();
    static JFrame frameRetrieve = new JFrame();
    static JFrame frameCarMod = new JFrame();
    static JFrame frameRLink = new JFrame();
    static JFrame framePartMod = new JFrame();
    static JFrame frameLog = new JFrame();

    public MainMenu() {

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(new JLabel("CS 157A Project: Auto Parts Inventory"));
        panel1.add(new JLabel("Professor: Dr. Lin"));
        panel1.add(new JLabel("Group 31"));
        panel1.add(new JLabel("\n"));
        panel1.add(new JLabel("\n"));

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(6, 2));

        JButton btnRetrieve = new JButton("Retrieve Car Part");
        JButton btnRLink = new JButton("Modify RLink");
        JButton btnCarMod = new JButton("Modify Car");
        JButton btnPartMod = new JButton("Modify Part");
        JButton btnLog = new JButton("Show History");
        JButton btnClose = new JButton("Exit");

        btnPanel.add(new JLabel("Retrieve Car Part Info    "));
        btnPanel.add(btnRetrieve);
        btnPanel.add(new JLabel("Add New, Delete, or Update Car    "));
        btnPanel.add(btnCarMod);
        btnPanel.add(new JLabel("Add New or Update RLink    "));
        btnPanel.add(btnRLink);
        btnPanel.add(new JLabel("Add New, Delete, or Update Part    "));
        btnPanel.add(btnPartMod);
        btnPanel.add(new JLabel("Show Modification Activities    "));
        btnPanel.add(btnLog);
        btnPanel.add(new JLabel("Wanna exit?    "));
        btnPanel.add(btnClose);

        btnRetrieve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                frameRetrieve = new JFrame("Retrieve Car Part Info");
                frameRetrieve.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameRetrieve.add(new RetrievePanel());
                frameRetrieve.setSize(800, 450);
                frameRetrieve.setVisible(true);

            }
        });

        btnCarMod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                frameCarMod = new JFrame("Modify Car");
                frameCarMod.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameCarMod.add(new CarModPanel());
                frameCarMod.setSize(300, 100);
                frameCarMod.setVisible(true);
                frameCarMod.pack();
            }
        });

        btnRLink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                frameRLink = new JFrame("Modify RLink");
                frameRLink.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameRLink.add(new RLinkPanel());
                frameRLink.setSize(300, 100);
                frameRLink.setVisible(true);
                frameRLink.pack();
            }
        });

        btnPartMod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                framePartMod = new JFrame("Modify Part");
                framePartMod.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                framePartMod.add(new PartModPanel());
                framePartMod.setSize(800, 450);
                framePartMod.setVisible(true);
                framePartMod.pack();

            }
        });

        btnLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                frameLog = new JFrame("History");
                frameLog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameLog.add(new Log());
                frameLog.setSize(550, 300);
                frameLog.setVisible(true);
                frameLog.pack();

            }
        });

        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        // setLayout(new FlowLayout());
        add(panel1, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) throws Exception {
        frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MainMenu());
        frame.setSize(600, 300);
        frame.setVisible(true);

    }
}
