package editor;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextEditor extends JFrame{
    JTextArea textArea;
    JTextField textField;
    JButton sButton, lButton;
    JScrollPane scroll;

    public TextEditor() {
        setSize(500, 500);
        setTitle("Text Editor");
        textArea = new JTextArea();
        textArea.setSize(300,300);
        textField = new JTextField();
        textField.setSize(100, 30);
        sButton = new JButton("Save");
        lButton = new JButton("Load");
        scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JPanel input = new JPanel(new FlowLayout(FlowLayout.CENTER));
        input.add(textField);
        input.add(sButton);
        input.add(lButton);

        textArea.setName("TextArea");
        textField.setName("FilenameField");
        sButton.setName("SaveButton");
        lButton.setName("LoadButton");
        scroll.setName("ScrollPane");


        add(textField, BorderLayout.NORTH);
        add(input, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        lButton.addActionListener(actionEvent -> {
            try {
                textArea.setText(new String(Files.readAllBytes(Path.of(textField.getText()))));
            } catch (IOException e) {
                textArea.setText(null);
                e.printStackTrace();
            }
        });

        sButton.addActionListener(actionEvent -> {
            try (Writer writer = new FileWriter(new File(textField.getText()))) {
                writer.write(textArea.getText());
            } catch (IOException e) {
                textArea.setText(null);
                e.printStackTrace();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
