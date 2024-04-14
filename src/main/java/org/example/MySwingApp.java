package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MySwingApp {
    private JFrame frame;
    private JTextField salaryTextField;
    private JTextField expensesTextField;
    private JButton checkButton;
    private JLabel resultLabel;
    private DecisionTree decisionTree;

    public MySwingApp() {
        // Initialize the decision tree
        decisionTree = new DecisionTree();

        // Create and set up the window
        frame = new JFrame("Loan Eligibility Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Define new elements
        salaryTextField = new JTextField();
        expensesTextField = new JTextField();
        checkButton = new JButton("Check eligibility");
        resultLabel = new JLabel();

        // Define the panel to set the layout and add components
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Salary:"));
        panel.add(salaryTextField);
        panel.add(new JLabel("Expenses:"));
        panel.add(expensesTextField);
        panel.add(checkButton);
        panel.add(resultLabel);

        // Adding action listener for the button
        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int salary = Integer.parseInt(salaryTextField.getText());
                int expenses = Integer.parseInt(expensesTextField.getText());
                boolean shouldGiveLoan = decisionTree.shouldGiveLoan(salary, expenses);
                resultLabel.setText(shouldGiveLoan ? "Eligible for loan" : "Not eligible for loan");
            }
        });

        // Adding Panel to JFrame
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        // Display the window
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application’s GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MySwingApp();
            }
        });
    }
}
