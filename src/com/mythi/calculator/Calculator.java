package com.mythi.calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JTextField txtNumber1, txtNumber2, txtResult;
    JButton addButton, subsButton, multButton, divideButton, clearButton;
    JLabel label1, label2, label3;

    static int cache = 0;
    static int temp = 0;

    Calculator () {
        JFrame mainWindow = new JFrame("My Main Window");
        txtNumber1 = new JTextField();
        txtNumber2 = new JTextField();
        txtResult = new JTextField();
        addButton = new JButton("+");
        subsButton = new JButton("-");
        multButton = new JButton("*");
        divideButton = new JButton("/");
        clearButton = new JButton("Clear");
        label1 = new JLabel("Number 1: ");
        label2 = new JLabel("Number 2: ");
        label3 = new JLabel("Result");

        txtNumber1.setBounds(50, 50, 150, 20);
        txtNumber2.setBounds(50, 100, 150, 20);
        txtResult.setBounds(50, 150, 150, 20);
        txtResult.setEditable(false);
        addButton.setBounds(50, 200, 95, 30);
        subsButton.setBounds(150, 200, 95, 30);
        multButton.setBounds(250, 200, 95, 30);
        divideButton.setBounds(350, 200, 95, 30);
        clearButton.setBounds(450, 200, 95, 30);

        addButton.addActionListener(this);
        subsButton.addActionListener(this);
        multButton.addActionListener(this);
        divideButton.addActionListener(this);
        clearButton.addActionListener(this);

        label1.setBounds(50, 20, 100, 30);
        label2.setBounds(50, 70, 100, 30);
        label3.setBounds(50, 120, 100, 30);

        mainWindow.add(addButton);
        addButton.setVisible(true);
        mainWindow.add(subsButton);
        subsButton.setVisible(true);
        mainWindow.add(multButton);
        multButton.setVisible(true);
        mainWindow.add(divideButton);
        divideButton.setVisible(true);
        mainWindow.add(clearButton);
        clearButton.setVisible(true);

        mainWindow.add(txtNumber1);
        txtNumber1.setVisible(true);
        mainWindow.add(txtNumber2);
        txtNumber2.setVisible(true);
        mainWindow.add(txtResult);
        txtResult.setVisible(true);

        mainWindow.add(label1);
        label1.setVisible(true);
        mainWindow.add(label2);
        label2.setVisible(true);
        mainWindow.add(label3);
        label3.setVisible(true);

        mainWindow.setVisible(true);

        mainWindow.setLayout(null);
        mainWindow.setSize(640, 480);
    }

    public static int convertToNumber(String text) {
        int num = Integer.parseInt(text);

        return num;
    }

    public static String convertToString(int number) {
        String convertedInt = String.valueOf(number);
        return convertedInt;
    }

    public static int add(String num1, String num2) {
        int a = convertToNumber(num1);
        int b = convertToNumber(num2);

        return a + b;
    }

    public static int substract(String num1, String num2) {
        int a = convertToNumber(num1);
        int b = convertToNumber(num2);

        return a - b;
    }

    public static int multiple(String num1, String num2) {
        int a = convertToNumber(num1);
        int b = convertToNumber(num2);

        return a * b;
    }

    public static int divide(String num1, String num2) {
        int a = convertToNumber(num1);
        int b = convertToNumber(num2);

        return a / b;
    }

    public void actionPerformed(ActionEvent e) {

        String number1 = txtNumber1.getText();
        String number2 = txtNumber2.getText();

        int result = 0;

        if (temp > 0) {
            number1 = String.valueOf(cache);
        }

        if (e.getSource()==addButton) {
            result = add(number1, number2);
            cache = result;
            temp++;
        } else if (e.getSource()==subsButton) {
            result = substract(number1, number2);
            cache = result;
            temp++;
        } else if (e.getSource()==multButton) {
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

        cache = result;
        txtResult.setText(convertToString(result));
    }

    public static void main(String[] args) {
        new Calculator();
    }

}