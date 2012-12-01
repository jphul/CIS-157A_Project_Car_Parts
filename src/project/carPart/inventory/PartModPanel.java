package project.carPart.inventory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import project.carPart.gui.CarPartMainScreen;

@SuppressWarnings("serial")
public class PartModPanel extends JPanel {
    static JFrame frameAdd = new JFrame();
    static JFrame frameDel = new JFrame();
    static JFrame frameUpd = new JFrame();

    public PartModPanel() {
        JButton addBut = new JButton("Add New Part");
        addBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                frameAdd = new JFrame("Add New Part");
                frameAdd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameAdd.add(new PartAddPanel());
                frameAdd.setSize(600, 400);
                frameAdd.setVisible(true);
            }
        });

        JButton delBut = new JButton("Delete Part");
        delBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                frameDel = new JFrame("Delete Part");
                frameDel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameDel.add(new PartDelPanel());
                frameDel.setSize(600, 200);
                frameDel.setVisible(true);
            }
        });

        JButton updBut = new JButton("Update Part");
        updBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                frameUpd = new JFrame("Update Part");
                frameUpd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameUpd.add(new PartUpdatePanel());
                frameUpd.setSize(600, 400);
                frameUpd.setVisible(true);
            }
        });

        JButton cancelBut = new JButton("Close");
        cancelBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenu.framePartMod.dispose();
                CarPartMainScreen.closeJPane_modifyPart();
            }
        });
        add(new JLabel("Select an option    "));
        add(addBut);
        add(delBut);
        add(updBut);
        add(cancelBut);

    }
}
