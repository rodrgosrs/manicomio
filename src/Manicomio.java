import javax.swing.SwingUtilities;

/*
 * @author Rodrigo
 */

public class Manicomio {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SystemM menu = new SystemM();
            menu.setVisible(true);
        });
    }
}