package Task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnalyzerGUI {
    private JTextField classNameInput;
    private JTextArea classDescriptionOutput;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AnalyzerGUI analyzerGUI = new AnalyzerGUI();
            analyzerGUI.createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Analyzer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel classNameLabel = new JLabel("Enter the full name of the class:");
        classNameInput = new JTextField();

        JLabel classDescriptionLabel = new JLabel("Class description:");
        classDescriptionOutput = new JTextArea();
        classDescriptionOutput.setEditable(false);
        classDescriptionOutput.setLineWrap(true);

        JButton analyzeButton = new JButton("Analyze");
        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analyzeClass();
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classNameInput.setText("");
                classDescriptionOutput.setText("");
            }
        });

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(classNameLabel, BorderLayout.NORTH);
        inputPanel.add(classNameInput, BorderLayout.CENTER);
        inputPanel.add(analyzeButton, BorderLayout.SOUTH);
        inputPanel.add(clearButton, BorderLayout.EAST);

        JScrollPane outputScrollPane = new JScrollPane(classDescriptionOutput);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(classDescriptionLabel, BorderLayout.CENTER);
        frame.add(outputScrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void analyzeClass() {
        String className = classNameInput.getText().trim();
        if (!className.isEmpty()) {
            try {
                String classDescription = Analyzer.getClassDescription(className);
                classDescriptionOutput.setText(classDescription);
            } catch (ClassNotFoundException e) {
                classDescriptionOutput.setText("\n" + "Class not found.");
            }
        } else {
            classDescriptionOutput.setText("Please enter a class name.");
        }
    }
}