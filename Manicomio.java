package manicomio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * @author Rodrigo
 */

public class Manicomio {

    public static void main(String[] args) {
        JFrame window = new JFrame("Cadastro de Paciente");
        
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new FlowLayout());
        
        JLabel labelNome = new JLabel("Nome:");
        JTextField fieldNome = new JTextField(20);
        JLabel labelCPF = new JLabel("CPF:");
        JTextField fieldCPF = new JTextField(11);
        JButton botaoSalvar = new JButton("Salvar");
        
        window.add(labelNome);
        window.add(fieldNome);
        window.add(labelCPF);
        window.add(fieldCPF);
        window.add(botaoSalvar);
        
        window.setVisible(true);
    }
    
}