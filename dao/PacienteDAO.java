package dao;
import pessoas.Paciente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    
    public List<Paciente> findAll() throws SQLException {
    String sql = """
                SELECT p.idPaciente,
                       p.status,
                       p.idGrupoPaciente,
                       r.idRegistroPessoal,
                       r.nome,
                       r.cpf,
                       r.rg,
                       r.dataNascimento,
                       r.sexo,
                       r.telefone,
                       r.endereco
                FROM Paciente p
                JOIN RegistroPessoal r ON p.idRegistroPessoal = r.idRegistroPessoal
                """;

    List<Paciente> pacientes = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                pacientes.add(new Paciente(
                    rs.getInt("idPaciente"),
                    rs.getInt("idRegistroPessoal"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("rg"),
                    rs.getDate("dataNascimento"),
                    rs.getString("sexo"),
                    rs.getString("telefone"),
                    rs.getString("endereco"),
                    rs.getString("status"),
                    rs.getInt("idGrupoPaciente")
                ));
            }
        }
        return pacientes;
    }
}