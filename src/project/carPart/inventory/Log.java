package project.carPart.inventory;

import java.util.ArrayList;

import javax.swing.*;

public class Log extends JPanel {
    static ArrayList<String> log = new ArrayList<String>();
    static JTextArea hist = new JTextArea(10, 25);

    public Log() {
        hist.setText(displayLog());
        JScrollPane a = new JScrollPane(hist);
        add(a);
    }

    public String displayLog() {
        String out = "";
        for (int i = 0; i < this.log.size(); i++) {
            out += (i + 1) + "." + log.get(i) + "\n";
        }
        return out;
    }
}
