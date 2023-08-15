package io.github.luis01felipe.calculator;

import javax.swing.*;
import java.awt.event.*;

public class App extends JFrame implements ActionListener {
    JTextField screen = new JTextField("");
    JButton key0 = new JButton("0");
    JButton keyDot = new JButton("."); // Virgula/Ponto (.)
    JButton keyEqual = new JButton("="); // Igual (=)
    JButton keyMinus = new JButton("-"); // Menos (-)
    JButton key1 = new JButton("1");
    JButton key2 = new JButton("2");
    JButton key3 = new JButton("3");
    JButton keyPlus = new JButton("+"); // Mais (+)
    JButton key4 = new JButton("4");
    JButton key5 = new JButton("5");
    JButton key6 = new JButton("6");
    JButton keyDivide = new JButton("/"); // Divisão (/)
    JButton key7 = new JButton("7");
    JButton key8 = new JButton("8");
    JButton key9 = new JButton("9");
    JButton keyMultiply = new JButton("*"); // Vezes (*)
    JButton keyAC = new JButton("AC"); // Limpa a tela


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj instanceof JButton){
            JButton button = (JButton) obj;
            String buttonText = button.getText();
            switch (buttonText){
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    screen.setText(screen.getText() + buttonText);
                    break;
                case "AC":
                    screen.setText("");
                    break;
                case "/":
                case "*":
                case "-":
                case "+":
                    screen.setText(screen.getText() + buttonText);
                    break;
                case ".":
                    screen.setText(screen.getText() + ".");
                    break;
                case "=":
                    String equation = screen.getText();
                    double result = Calculation.calcularEquacao(equation);
                    String resultText = Double.toString(result);
                    screen.setText(resultText);
                    if(!obj.equals(keyEqual)){
                        screen.setText("");
                    }
                    break;
                // Add more cases as needed for other buttons
                default:
                    // Handle unexpected button case
                    break;
            }
        }

    }
    public App(){
        this.setTitle("Calculadora");
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true); // Impede o usuario de redimensionar
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Encerra o programa ao fechar a janela
        screen.setEditable(false);
        //
        this.setBounds(0, 0, 400, 500);
        screen.setBounds(0, 0, 300, 100);
        keyAC.setBounds(300, 0, 100, 100);

        key0.setBounds(0, 400, 100, 100);
        keyDot.setBounds(100, 400, 100, 100);
        keyMinus.setBounds(200, 400, 100, 100);
        keyEqual.setBounds(300, 400, 100, 100);

        key1.setBounds(0, 300, 100, 100);
        key2.setBounds(100, 300, 100, 100);
        key3.setBounds(200, 300, 100, 100);
        keyPlus.setBounds(300, 300, 100, 100);

        key4.setBounds(0, 200, 100, 100);
        key5.setBounds(100, 200, 100, 100);
        key6.setBounds(200, 200, 100, 100);
        keyDivide.setBounds(300, 200, 100, 100);

        key7.setBounds(0, 100, 100, 100);
        key8.setBounds(100, 100, 100, 100);
        key9.setBounds(200, 100, 100, 100);
        keyMultiply.setBounds(300, 100, 100, 100);

        //
        this.add(screen);
        this.add(key0);
        this.add(key1);
        this.add(key2);
        this.add(key3);
        this.add(key4);
        this.add(key5);
        this.add(key6);
        this.add(key7);
        this.add(key8);
        this.add(key9);
        this.add(keyAC);
        this.add(keyDivide);
        this.add(keyDot);
        this.add(keyEqual);
        this.add(keyMinus);
        this.add(keyMultiply);
        this.add(keyPlus);
        //
        key0.addActionListener(this);
        key1.addActionListener(this);
        key2.addActionListener(this);
        key3.addActionListener(this);
        key4.addActionListener(this);
        key5.addActionListener(this);
        key6.addActionListener(this);
        key7.addActionListener(this);
        key8.addActionListener(this);
        key9.addActionListener(this);
        keyAC.addActionListener(this);
        keyDivide.addActionListener(this);
        keyDot.addActionListener(this);
        keyEqual.addActionListener(this);
        keyMinus.addActionListener(this);
        keyMultiply.addActionListener(this);
        keyPlus.addActionListener(this);
    }
}
