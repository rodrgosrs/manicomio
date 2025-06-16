import java.awt.*;
import javax.swing.*;

/*
 * @author Rodrigo
 */

public class SystemM extends JFrame {
        private final JButton btnCadastrarPaciente;
        private final JButton btnListarPacientes;
        private final JButton btnCadastrarFuncionario;
        private final JButton btnListarFuncionarios;
        private final JButton btnInternarPaciente;
        private final JButton btnAltaPaciente;
        private final JButton btnCadastrarGrupo;
        private final JButton btnListarGrupos;
        private final JButton btnCadastrarAtividade;
        private final JButton btnAssociarAtividade;
        private final JButton btnCadastrarResponsavel;
        private final JButton btnCadastrarReferencia;
        private final JButton btnRelatoriosAtendimentos;
        private final JButton btnSair;
        
        public SystemM() {
            super("SGM – Sistema de Gerenciamento Manicomial");
        
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setSize(800, 600);
            setLocationRelativeTo(null);
            JPanel panelBotoes = new JPanel(new GridLayout(14, 1, 10, 10));
            panelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            JLabel label = new JLabel("Selecione uma Opção", JLabel.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            
            

            btnCadastrarPaciente = new JButton("Cadastrar Paciente");
            btnListarPacientes = new JButton("Listar Pacientes");
            btnCadastrarPaciente.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
            btnListarPacientes.setCursor(new Cursor(Cursor.HAND_CURSOR));

            btnCadastrarFuncionario = new JButton("Cadastrar Funcionário");
            btnListarFuncionarios = new JButton("Listar Funcionários");
            btnCadastrarFuncionario.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btnListarFuncionarios.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            btnInternarPaciente = new JButton("Internar Paciente");
            btnAltaPaciente = new JButton("Dar Alta ao Paciente");
            btnInternarPaciente.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btnAltaPaciente.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            btnCadastrarGrupo = new JButton("Cadastrar Grupo Terapêutico");
            btnListarGrupos = new JButton("Listar Grupos Terapêuticos");
            btnCadastrarGrupo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btnListarGrupos.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            btnCadastrarAtividade = new JButton("Cadastrar Atividade");
            btnAssociarAtividade = new JButton("Associar Atividade ao Grupo");
            btnCadastrarAtividade.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btnAssociarAtividade.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            btnCadastrarResponsavel = new JButton("Cadastrar Responsável Legal");
            btnCadastrarResponsavel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            btnCadastrarReferencia = new JButton("Cadastrar Profissional de Referência");
            btnCadastrarReferencia.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            btnRelatoriosAtendimentos = new JButton("Relatório de Atendimentos");
            btnRelatoriosAtendimentos.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            btnSair = new JButton("Sair");
            btnSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            panelBotoes.add(btnCadastrarPaciente);
            panelBotoes.add(btnListarPacientes);
            panelBotoes.add(btnCadastrarFuncionario);
            panelBotoes.add(btnListarFuncionarios);
            panelBotoes.add(btnInternarPaciente);
            panelBotoes.add(btnAltaPaciente);
            panelBotoes.add(btnCadastrarGrupo);
            panelBotoes.add(btnListarGrupos);
            panelBotoes.add(btnCadastrarAtividade);
            panelBotoes.add(btnAssociarAtividade);
            panelBotoes.add(btnCadastrarResponsavel);
            panelBotoes.add(btnCadastrarReferencia);
            panelBotoes.add(btnRelatoriosAtendimentos);
            panelBotoes.add(btnSair);

            add(label, BorderLayout.NORTH);
            add(new JScrollPane(panelBotoes), BorderLayout.CENTER);
    }
}