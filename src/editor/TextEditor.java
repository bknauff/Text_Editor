package editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditor extends JFrame implements ActionListener{
    JTextArea ta;
    JTextField f;
    JButton s, l;
    JFileChooser fileChooser = new JFileChooser(System.getProperty("user.fir"));
    String curFile = "Untitled";
    JScrollPane scroll;
    public TextEditor() {
        getContentPane().setLayout(new FlowLayout());
        setSize(500, 500);
        setTitle("Text Editor");
        ta = new JTextArea(20, 35);
        f = new JTextField("",15);
        s = new JButton("Save");
        l = new JButton("Load");
        scroll = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        add(f);
        add(s);
        add(l);
        add(scroll);
        s.addActionListener(this);



        ta.setName("TextArea");
        f.setName("FilenameField");
        s.setName("SaveButton");
        l.setName("LoadButton");
        scroll.setName("ScrollPane");



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

    }
}
