package editor;

import javax.swing.*;
import java.awt.*;

public class TextEditor extends JFrame {
    public TextEditor() {
        initUI();
    }

    private void initUI(){
        JTextArea ta = new JTextArea();
        ta.setName("TextArea");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 350);
        setTitle("The first stage");
        ta.setBounds(10,10,300, 250);
        ta.setVisible(true);
        add(ta, BorderLayout.CENTER);
        setLayout(null);
    }
}
