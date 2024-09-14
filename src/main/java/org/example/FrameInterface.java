package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;
    private JComboBox<String> optionComboBox;

    public Frame() {
        setTitle("Reconhecedor de Linguagens");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Digite a palavra:");
        inputField = new JTextField(20);
        JButton processButton = new JButton("Processar");

        inputPanel.add(label);
        inputPanel.add(inputField);
        inputPanel.add(processButton);

        add(inputPanel, BorderLayout.NORTH);

        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new FlowLayout());

        optionComboBox = new JComboBox<>(new String[]{"Autômato com Pilha", "Máquina de Turing"});
        optionPanel.add(optionComboBox);

        add(optionPanel, BorderLayout.CENTER);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(scrollPane, BorderLayout.SOUTH);

        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processInput();
            }
        });

        setLocationRelativeTo(null);
    }

    private void processInput() {
        String palavra = inputField.getText();
        if (palavra.equals("-")) {
            palavra = "";
        }

        String selectedOption = (String) optionComboBox.getSelectedItem();
        boolean accepted = false;

        if ("Autômato com Pilha".equals(selectedOption)) {
            AutomatoPilha automatoPilha = new AutomatoPilha(palavra);
            accepted = automatoPilha.process();
        } else if ("Máquina de Turing".equals(selectedOption)) {
            MaquinaTuring maquinaTuring = new MaquinaTuring(palavra);
            accepted = maquinaTuring.process();
        }

        outputArea.setText("Palavra '" + palavra + "' aceita? " + accepted);
    }
}
