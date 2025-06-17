import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * @author Rodrigo
 */

public class SystemM extends JFrame {
    private final JButton[] botoes;
    private final String[] textosBotoes = {
        "Cadastrar Paciente",
        "Listar Pacientes",
        "Cadastrar Funcionário",
        "Listar Funcionários",
        "Internar Paciente",
        "Dar Alta ao Paciente",
        "Cadastrar Grupo Terapêutico",
        "Listar Grupos Terapêuticos",
        "Cadastrar Atividade",
        "Associar Atividade ao Grupo",
        "Cadastrar Responsável Legal",
        "Cadastrar Profissional de Referência",
        "Relatório de Atendimentos",
        "Sair"
    };
    
    public SystemM() {
        super("SGM – Sistema de Gerenciamento Manicomial");
        configurarJanela();
        botoes = criarBotoes();
        adicionarComponentes();
        tema();
    }
    
    private void configurarJanela() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
    }
    
    private JButton[] criarBotoes() {
        JButton[] botoes = new JButton[textosBotoes.length];
        for (int i = 0; i < textosBotoes.length; i++) {
            botoes[i] = new JButton(textosBotoes[i]);
            botoes[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            botoes[i].setPreferredSize(new Dimension(250, 40));
        }
        return botoes;
    }
    
    private void adicionarComponentes() {
        JPanel panelBotoes = new JPanel(new GridLayout(0, 1, 10, 10));
        panelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelBotoes.setDoubleBuffered(true);

        for (JButton botao : botoes) {
            panelBotoes.add(botao);
        }
        
        JLabel label = new JLabel("Selecione uma Opção", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        
        add(label, BorderLayout.NORTH);
        add(new JScrollPane(panelBotoes), BorderLayout.CENTER);
        JScrollPane scrollPane = new JScrollPane(panelBotoes);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    public void adicionarListenerCadastrarPaciente(ActionListener listener) {
        botoes[0].addActionListener(listener);
    }
    public void adicionarListenerListarPacientes(ActionListener listener) {
        botoes[1].addActionListener(listener);
    }
    public void adicionarListenerCadastrarFuncionario(ActionListener listener) {
        botoes[2].addActionListener(listener);
    }
    public void adicionarListenerListarFuncionarios(ActionListener listener) {
        botoes[3].addActionListener(listener);
    }
    public void adicionarListenerInternarPaciente(ActionListener listener) {
        botoes[4].addActionListener(listener);
    }
    public void adicionarListenerDarAltaAoPaciente(ActionListener listener) {
        botoes[5].addActionListener(listener);
    }
    public void adicionarListenerCadastrarGrupoTerapeutico(ActionListener listener) {
        botoes[6].addActionListener(listener);
    }
    public void adicionarListenerListarGruposTerapeuticos(ActionListener listener) {
        botoes[7].addActionListener(listener);
    }
    public void adicionarListenerCadastrarAtividade(ActionListener listener) {
        botoes[8].addActionListener(listener);
    }
    public void adicionarListenerAssociarAtividadeAoGrupo(ActionListener listener) {
        botoes[9].addActionListener(listener);
    }
    public void adicionarListenerCadastrarResponsavelLegal(ActionListener listener) {
        botoes[10].addActionListener(listener);
    }
    public void adicionarListenerCadastrarProfissionalDeReferencia(ActionListener listener) {
        botoes[11].addActionListener(listener);
    }
    public void adicionarListenerRelatorioDeAtendimentos(ActionListener listener) {
        botoes[12].addActionListener(listener);
    }
    public void adicionarListenerSair(ActionListener listener) {
        botoes[13].addActionListener(listener);
    }
    
    public void tema() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}