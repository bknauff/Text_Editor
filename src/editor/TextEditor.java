package editor;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Paths;

public class TextEditor extends JFrame{
    JTextArea textArea;
    JTextField textField;
    JButton sButton, lButton;
    JScrollPane scroll;

    public TextEditor() {
        getContentPane().setLayout(new FlowLayout());
        setSize(500, 500);
        setTitle("Text Editor");
        textArea = new JTextArea(20, 35);
        textField = new JTextField("", 15);
        sButton = new JButton("Save");
        lButton = new JButton("Load");
        scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        textArea.setName("TextArea");
        textField.setName("FilenameField");
        sButton.setName("SaveButton");
        lButton.setName("LoadButton");
        scroll.setName("ScrollPane");


        add(textField);
        add(sButton);
        add(lButton);
        add(scroll);

        lButton.addActionListener(actionEvent -> {
            String text = textField.getText();
            File file = Paths.get(text).toFile();

            try {
                FileReader stream = new FileReader(file);
                StringBuilder str = new StringBuilder();
                while (stream.ready()) {
                    str.append((char)stream.read());
                }
                textField.setText(str.toString());
            }catch (FileNotFoundException e){
                textField.setText("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        sButton.addActionListener(actionEvent -> {
            File file = Paths.get(textField.getText()).toFile();
            try (PrintWriter writer = new PrintWriter(file)) {
                writer.print(textField.getText());
            } catch (IOException e) {
                e.getLocalizedMessage();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
