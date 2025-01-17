/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author joaov
 */
public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, multButton, divButton, clearButton, enterButton;
    JPanel panel;
    Font myFont = new Font("SansSerif",Font.BOLD,30);
    int num1 = 0, num2 = 0, result = 0;
    char operator;
    
    
    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,500);
        frame.setLayout(null);
        
        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        
        addButton = new JButton("+");
        subButton = new JButton("-");
        multButton = new JButton("*");
        divButton = new JButton("÷");
        clearButton = new JButton("C");
        enterButton = new JButton("=");
        
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multButton;
        functionButtons[3] = divButton;
        functionButtons[4] = clearButton;
        functionButtons[5] = enterButton;
        
        for(int i = 0; i < 6; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            
        }
        
        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        
        clearButton.setBackground(Color.red);
        enterButton.setBackground(Color.gray);
        
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multButton);
        panel.add(clearButton);
        panel.add(numberButtons[0]);
        panel.add(enterButton);
        panel.add(divButton);
        
        frame.add(panel);
        frame.add(textfield);
        frame.setVisible(true);
        
    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        for(int i = 0; i<10; i++){
            if(e.getSource() == numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }    
        }
        if(e.getSource() == addButton){
            num1 = Integer.parseInt(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if(e.getSource() == subButton){
            num1 = Integer.parseInt(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(e.getSource() == multButton){
            num1 = Integer.parseInt(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Integer.parseInt(textfield.getText());
            operator = '÷';
            textfield.setText("");
        }
        if(e.getSource() == enterButton){
            num2 = Integer.parseInt(textfield.getText());
            
            switch(operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '÷':
                    result = num1 / num2;
                    break;
            }
        textfield.setText(String.valueOf(result));
        }
        if(e.getSource() == clearButton){
            textfield.setText("");
        }
    }
}