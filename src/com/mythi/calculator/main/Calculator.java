package com.mythi.calculator.main;

import com.mythi.calculator.helpers.Checkers;
import com.mythi.calculator.utils.Operation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends Operation implements ActionListener, Checkers {

    JTextField txtNumber1, txtNumber2, txtResult;
    JButton addButton, subsButton, multipleButton, divideButton, clearButton;
    JLabel label1, label2, label3, errorLabel, emptyLabel;

    static int cache = 0;
    static int temp = 0;
    static String errorMessage = "";

    Calculator () {
        JFrame mainWindow = new JFrame("My Main Window");
        txtNumber1 = new JTextField();
        txtNumber2 = new JTextField();
        txtResult = new JTextField();
        addButton = new JButton("+");
        subsButton = new JButton("-");
        multipleButton = new JButton("*");
        divideButton = new JButton("/");
        clearButton = new JButton("Clear");
        label1 = new JLabel("Number 1: ");
        label2 = new JLabel("Number 2: ");
        label3 = new JLabel("Result");
        errorLabel = new JLabel(errorMessage);
        emptyLabel = new JLabel("EmptyLabel");

        txtNumber1.setBounds(50, 50, 200, 50);
        txtNumber2.setBounds(50, 125, 200, 50);
        txtResult.setBounds(50, 200, 200, 50);
        txtResult.setEditable(false);
        addButton.setBounds(300, 50, 50, 50);
        subsButton.setBounds(350, 50, 50, 50);
        multipleButton.setBounds(300, 100, 50, 50);
        divideButton.setBounds(350, 100, 50, 50);
        clearButton.setBounds(300, 150, 100, 50);

        addButton.addActionListener(this);
        subsButton.addActionListener(this);
        multipleButton.addActionListener(this);
        divideButton.addActionListener(this);
        clearButton.addActionListener(this);

        label1.setBounds(50, 20, 100, 30);
        label2.setBounds(50, 100, 100, 30);
        label3.setBounds(50, 175, 100, 30);
        errorLabel.setBounds(50, 260, 100, 30);

        mainWindow.add(addButton);
        mainWindow.add(subsButton);
        mainWindow.add(multipleButton);
        mainWindow.add(divideButton);
        mainWindow.add(clearButton);

        mainWindow.add(txtNumber1);
        mainWindow.add(txtNumber2);
        mainWindow.add(txtResult);

        mainWindow.add(label1);
        mainWindow.add(label2);
        mainWindow.add(label3);
        mainWindow.add(errorLabel);
        mainWindow.add(emptyLabel);

        mainWindow.setVisible(true);

        mainWindow.setLayout(null);
        mainWindow.setSize(475, 350);
    }

    @Override
    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkValues(ActionEvent e) {
        if (e.getSource()==addButton || e.getSource()==subsButton || e.getSource()==multipleButton || e.getSource()==divideButton) {
            if (!isInteger(txtNumber1.getText()) || !isInteger(txtNumber2.getText())) {
                errorMessage = "Values are must be an integer.";
                return false;
            } else if (txtNumber1.getText().length() == 0 || txtNumber2.getText().length() == 0) {
                errorMessage = "All values must be satisfied.";
                return false;
            }
        }
        errorMessage = "";
        return true;
    }

    public void actionPerformed(ActionEvent e) {
        String number1 = txtNumber1.getText();
        String number2 = txtNumber2.getText();

        int result = 0;

        if (checkValues(e) == true) {
            if (temp > 0) {
                number1 = String.valueOf(cache);
            }

            if (e.getSource()==addButton) {
                result = add(number1, number2);
                cache = result;
                temp++;
                System.out.println(errorMessage);
            } else if (e.getSource()==subsButton) {
                result = subtract(number1, number2);
                cache = result;
                temp++;
            } else if (e.getSource()==multipleButton) {
                result = multiple(number1, number2);
                cache = result;
                temp++;
            } else if (e.getSource()==divideButton) {
                result = divide(number1, number2);
                cache = result;
                temp++;
            } else if(e.getSource()==clearButton) {
                temp = 0;
                result = 0;
            }
        }

        cache = result;

        if (errorMessage.length() > 0) {
            txtResult.setText(errorMessage);
        } else {
            txtResult.setText(convertToString(result));
        }

    }

    public static void main(String[] args) {
        new Calculator();
    }

}