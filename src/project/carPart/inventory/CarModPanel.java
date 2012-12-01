package project.carPart.inventory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class CarModPanel extends JPanel {
    static JFrame frameInsert = new JFrame();
    static JFrame frameDelete = new JFrame();
    static JFrame frameUpdate = new JFrame();

    public CarModPanel() {
        JLabel des = new JLabel("Select an option   ");
        JPanel btnPanel = new JPanel();
        JButton btnInsert = new JButton("Create New Car");
        JButton btnDelete = new JButton("Delete Car");
        JButton btnUpdate = new JButton("Update Car");
        JButton btnClose = new JButton("Close");

        btnPanel.add(btnInsert);
        btnPanel.add(btnDelete);
        btnPanel.add(btnUpdate);
        btnPanel.add(btnClose);
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                frameInsert = new JFrame("Create New Car");
                frameInsert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameInsert.add(new CarInsertPanel());
                frameInsert.setSize(600, 450);
                // frame.pack();
                frameInsert.setVisible(true);

            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                frameDelete = new JFrame("Delete Car");
                frameDelete.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameDelete.add(new CarDeletePanel());
                frameDelete.setSize(600, 450);
                // frame.pack();
                frameDelete.setVisible(true);

            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                frameUpdate = new JFrame("Update Car");
                frameUpdate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameUpdate.add(new CarUpdatePanel());
                frameUpdate.setSize(600, 720);
                frameUpdate.setVisible(true);

            }
        });
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                MainMenu.frameCarMod.dispose();
            }
        });

        add(des);
        add(btnPanel);
    }
}
