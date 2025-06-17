import gui.CadastroPacienteGUI;
import gui.SystemM;
import javax.swing.JFrame;

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

            } catch (Exception ex) { }
        });

        menuPrincipal.adicionarListenerSair(e -> System.exit(0));

        menuPrincipal.setVisible(true);
    }
}