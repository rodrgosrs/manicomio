import gui.CadastroPacienteGUI;
import gui.SystemM;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * @author Rodrigo
 */

public class Manicomio {

    public static void main(String[] args) {
        SystemM menuPrincipal = new SystemM();

        menuPrincipal.adicionarListenerCadastrarPaciente(e -> {
            try {
                CadastroPacienteGUI cadastro = new CadastroPacienteGUI();

                cadastro.setLocationRelativeTo(menuPrincipal);

                cadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                cadastro.setVisible(true);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(menuPrincipal,
                        "Erro ao abrir janela de cadastro:\n" + ex.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        menuPrincipal.adicionarListenerSair(e -> System.exit(0));

        menuPrincipal.setVisible(true);
    }
}