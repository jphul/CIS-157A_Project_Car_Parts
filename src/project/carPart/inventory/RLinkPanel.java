package project.carPart.inventory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import project.carPart.gui.CarPartMainScreen;

@SuppressWarnings("serial")
public class RLinkPanel extends JPanel {
    static JFrame frameCreate = new JFrame();
    static JFrame frameUpdate = new JFrame();

    public RLinkPanel() {
        add(new JLabel("Select an option    "));
        JButton create = new JButton("Create New RLink");
        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                frameCreate = new JFrame("Create RLink");
                frameCreate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameCreate.add(new RLinkCreatePanel());
                frameCreate.setSize(600, 300);
                frameCreate.setVisible(true);
            }
        });

        JButton update = new JButton("Update RLink");
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                frameUpdate = new JFrame("Update RLink");
                frameUpdate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameUpdate.add(new RLinkUpdatePanel());
                frameUpdate.setSize(600, 300);
                frameUpdate.setVisible(true);
            }
        });

        JButton close = new JButton("Close");
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenu.frameRLink.dispose();
                CarPartMainScreen.closeJPane_RLink();
            }
        });

        add(create);
        add(update);
        add(close);
    }
}
