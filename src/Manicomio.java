import dao.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;

/*
 * @author Rodrigo
 */

public class Manicomio {

    public static void main(String[] args) {
        // new SystemM().setVisible(true);
        testarConexao();
    }
    
    public static void testarConexao() {
        System.out.println("=== TESTE DE CONEXÃO ===");
        
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("✅ Conexão bem-sucedida!");
            System.out.println("URL: " + conn.getMetaData().getURL());
            System.out.println("Driver: " + conn.getMetaData().getDriverName());
            System.out.println("Versão: " + conn.getMetaData().getDriverVersion());
        } catch (SQLException e) {
            System.err.println("❌ ERRO NA CONEXÃO:");
            System.err.println("Código de erro: " + e.getErrorCode());
            System.err.println("Estado SQL: " + e.getSQLState());
            System.err.println("Mensagem: " + e.getMessage());
            e.printStackTrace();
        }
    }
}