package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import dao.PacienteDAO;
import dao.GrupoPacienteDAO;
import pessoas.Paciente;
import java.sql.SQLException;
import java.util.List;
import javax.swing.text.MaskFormatter;

/*
 * @author Rodrigo
 */

public class CadastroPacienteGUI extends JFrame {
    private final JTextField txtNome;
    private final JFormattedTextField txtCpf;
    private final JTextField txtRg;
    private final JFormattedTextField txtDataNascimento;
    private final JComboBox<String> cbSexo;
    private final JFormattedTextField txtTelefone;
    private final JTextField txtEndereco;
    private final JComboBox<String> cbStatus;
    private final JComboBox<GrupoPaciente> cbGrupoPaciente;
    private final PacienteDAO pacienteDAO;
    private final GrupoPacienteDAO grupoPacienteDAO;

    public CadastroPacienteGUI() {
        super("Cadastro de Paciente");
        this.pacienteDAO = new PacienteDAO();
        this.grupoPacienteDAO = new GrupoPacienteDAO();
        
        setSize(700, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        try {
            MaskFormatter cpfFormatter = new MaskFormatter("###.###.###-##");
            MaskFormatter telFormatter = new MaskFormatter("(##) # ####-####");
            MaskFormatter dateFormatter = new MaskFormatter("##/##/####");
            
            txtNome = new JTextField();
            txtCpf = new JFormattedTextField(cpfFormatter);
            txtRg = new JTextField();
            txtDataNascimento = new JFormattedTextField(dateFormatter);
            txtTelefone = new JFormattedTextField(telFormatter);
            txtEndereco = new JTextField();
            
            cbSexo = new JComboBox<>(new String[]{"M", "F"});
            cbSexo.setRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    String descricao = "";
                    switch(value.toString()) {
                        case "M": descricao = "Masculino"; break;
                        case "F": descricao = "Feminino"; break;
                    }
                    return super.getListCellRendererComponent(list, descricao, index, isSelected, cellHasFocus);
                }
            });
            
            cbStatus = new JComboBox<>(new String[]{"ATIVO", "INATIVO", "INTERNADO", "ALTA"});
            
            cbGrupoPaciente = new JComboBox<>();
            carregarGruposPaciente();
            
        } catch (ParseException e) {
            throw new RuntimeException("Erro ao criar máscaras de formatação", e);
        }
        
        formPanel.add(new JLabel("Nome Completo:"));
        formPanel.add(txtNome);
        formPanel.add(new JLabel("CPF:"));
        formPanel.add(txtCpf);
        formPanel.add(new JLabel("RG:"));
        formPanel.add(txtRg);
        formPanel.add(new JLabel("Data de Nascimento:"));
        formPanel.add(txtDataNascimento);
        formPanel.add(new JLabel("Sexo:"));
        formPanel.add(cbSexo);
        formPanel.add(new JLabel("Telefone:"));
        formPanel.add(txtTelefone);
        formPanel.add(new JLabel("Endereço:"));
        formPanel.add(txtEndereco);
        formPanel.add(new JLabel("Status:"));
        formPanel.add(cbStatus);
        formPanel.add(new JLabel("Grupo Terapêutico:"));
        formPanel.add(cbGrupoPaciente);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnSalvar = criarBotao("Salvar", new Color(46, 125, 50));
        JButton btnCancelar = criarBotao("Cancelar", new Color(211, 47, 47));
        
        buttonPanel.add(btnSalvar);
        buttonPanel.add(btnCancelar);
        
        add(new JLabel("CADASTRO DE PACIENTE", JLabel.CENTER) {{
            setFont(new Font("Arial", Font.BOLD, 18));
            setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        }}, BorderLayout.NORTH);
        
        add(new JScrollPane(formPanel), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        btnSalvar.addActionListener(e -> salvarPaciente());
        btnCancelar.addActionListener(e -> dispose());
    }
    
    private JButton criarBotao(String texto, Color corFundo) {
        JButton botao = new JButton(texto);
        botao.setBackground(corFundo);
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setPreferredSize(new Dimension(120, 40));
        return botao;
    }
    
    private void carregarGruposPaciente() {
        try {
            List<GrupoPaciente> grupos = grupoPacienteDAO.findAll();
            cbGrupoPaciente.removeAllItems();
            grupos.forEach(cbGrupoPaciente::addItem);
            cbGrupoPaciente.setSelectedIndex(-1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar grupos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void salvarPaciente() {
        try {
            if (txtNome.getText().trim().isEmpty() || txtCpf.getText().replaceAll("[^0-9]", "").length() != 11) {
                JOptionPane.showMessageDialog(this, "Nome e CPF válido são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNascimento = sdf.parse(txtDataNascimento.getText());
            
            Paciente paciente = new Paciente(
                0,
                0,
                txtNome.getText().trim(),
                txtCpf.getText().replaceAll("[^0-9]", ""),
                txtRg.getText().trim(),
                new java.sql.Date(dataNascimento.getTime()),
                cbSexo.getSelectedItem().toString(),
                txtTelefone.getText().replaceAll("[^0-9]", ""),
                txtEndereco.getText().trim(),
                cbStatus.getSelectedItem().toString(),
                cbGrupoPaciente.getItemAt(cbGrupoPaciente.getSelectedIndex()).getIdGrupoPaciente()
            );
            
            pacienteDAO.save(paciente);
            
            JOptionPane.showMessageDialog(this, "Paciente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
            
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Data de nascimento inválida! Use o formato dd/mm/aaaa", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar paciente:\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro inesperado:\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limparCampos() {
        txtNome.setText("");
        txtCpf.setText("");
        txtRg.setText("");
        txtDataNascimento.setText("");
        cbSexo.setSelectedIndex(0);
        txtTelefone.setText("");
        txtEndereco.setText("");
        cbStatus.setSelectedIndex(0);
        cbGrupoPaciente.setSelectedIndex(-1);
        txtNome.requestFocus();
    }

    //
    class GrupoPaciente {
        private int idGrupoPaciente;
        private String nomeGrupo;
        
        public GrupoPaciente(int id, String nome) {
            this.idGrupoPaciente = id;
            this.nomeGrupo = nome;
        }
        public int getIdGrupoPaciente() {
            return idGrupoPaciente;
        }
        @Override
        public String toString() {
            return nomeGrupo;
        }
    }
}