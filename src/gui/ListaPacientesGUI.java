package gui;

import dao.PacienteDAO;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
 * @author Rodrigo
 */

public class ListaPacientesGUI extends JFrame {
    private JTable tabelaPacientes;
    private PacienteDAO pacienteDAO;

    public ListaPacientesGUI() {
        super("Listagem de Pacientes");
        this.pacienteDAO = new PacienteDAO();
        
        initComponents();
        carregarPacientes();
        configurarJanela();
    }

    public void initComponents() {
        setLayout(new BorderLayout());

        tabelaPacientes = new JTable();
        tabelaPacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tabelaPacientes);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose());
        panelBotoes.add(btnFechar);
        
        add(panelBotoes, BorderLayout.SOUTH);
    }

    public void carregarPacientes() {
        try {
            List<Map<String, Object>> pacientes = pacienteDAO.listarTodosPacientes();

            // Todas as colunas detalhadas
            DefaultTableModel model = new DefaultTableModel(
                new Object[]{
                    "ID", "ID Registro", "Nome", "CPF", "RG", "Data Nasc.",
                    "Sexo", "Telefone", "Endereço", "Status", "Grupo"
                }, 0);

            for (Map<String, Object> p : pacientes) {
                model.addRow(new Object[]{
                    p.get("idPaciente"),
                    p.get("idRegistroPessoal"),
                    p.get("nome"),
                    p.get("cpf"),
                    p.get("rg"),
                    p.get("dataNascimento"),
                    p.get("sexo"),
                    p.get("telefone"),
                    p.get("endereco"),
                    p.get("status"),
                    p.get("idGrupoPaciente")
                });
            }

            tabelaPacientes.setModel(model);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                "Erro ao carregar pacientes: " + ex.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void configurarJanela() {
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
