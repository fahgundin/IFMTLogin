package javax;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class TextFieldFrame extends JFrame {

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPasswordField passwordField;
    private JButton textButton;
    private JLabel imageLabel;
    

    public TextFieldFrame() {

        super("Registre o Usuário");
        setLayout(new FlowLayout());
        
        ImageIcon imageIcon = new ImageIcon("ifmt.png");
        imageLabel = new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        add(imageLabel, BorderLayout.SOUTH);
        
        JPanel fieldsPanel = new JPanel(new FlowLayout());

        textField1 = new JTextField(10);
        add(textField1);

        textField2 = new JTextField(5);
        add(textField2);

        passwordField = new JPasswordField("password");
        add(passwordField);

        textField3 = new JTextField("Registre seu Email, Usuário e Senha.");
        textField3.setEditable(false);
        add(textField3);
        
        add(fieldsPanel, BorderLayout.CENTER);

        textButton = new JButton("Registrar");
        add(textButton);
        
        
      

        TextFieldHandler handler = new TextFieldHandler();
        textField1.addActionListener(handler);
        textField2.addActionListener(handler);
        textField3.addActionListener(handler);
        passwordField.addActionListener(handler);
        textButton.addActionListener(handler);

    }

    private class TextFieldHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String string = "";

            if (event.getSource() == textField1)
                string = String.format("Email: %s", event.getActionCommand());
            else if (event.getSource() == textField2)
                string = String.format("Usuário: %s", event.getActionCommand());
            else if (event.getSource() == textField3)
                string = String.format("textfield3: %s", event.getActionCommand());
            else if (event.getSource() == passwordField)
                string = String.format("Senha do Usuário: %s", event.getActionCommand());
            else if (event.getSource() == textButton) {
                
                registrarUsuario();
                return; 
            }

            JOptionPane.showMessageDialog(null, string);
        }

        private void registrarUsuario() {
            String nome = textField1.getText();
            String sobrenome = textField2.getText();
            String senha = passwordField.getText();

            if (!nome.isEmpty() && !sobrenome.isEmpty()) {
                String mensagem = String.format("Olá %s \n Seu Email é: %s \n Sua Senha é: %s", sobrenome, nome, senha);
                JOptionPane.showMessageDialog(null, mensagem);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, preencha os campos Email e Usuário para se registrar.");
            }
        }
    }

    public static void main(String[] args) {
        TextFieldFrame textFieldFrame = new TextFieldFrame();
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFieldFrame.setSize(600, 400);
        textFieldFrame.setVisible(true);
        
        
    }
}
