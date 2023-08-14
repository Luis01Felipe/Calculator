import javax.swing.*;
import java.awt.event.*;

public class Screen0 extends JFrame implements ActionListener {
    JLabel title = new JLabel("Bem vindo a minha calculadora :)");
    JButton btnEnter = new JButton("Entrar");
    JButton btnExit = new JButton("Sair");

    public Screen0() {
        this.setTitle("Calculadora");
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 400, 400);

        title.setBounds(100, 0, 200, 100);
        btnEnter.setBounds(100, 100, 100, 100);
        btnExit.setBounds(200, 100, 100, 100); // Ajuste nas coordenadas

        this.add(title);
        this.add(btnEnter);
        this.add(btnExit);

        btnEnter.addActionListener(this);
        btnExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj.equals(btnEnter)) {
            App calculadora = new App();
            dispose();
        } else if (obj.equals(btnExit)) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Screen0());
    }
}
