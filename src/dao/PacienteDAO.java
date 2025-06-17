package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pessoas.Paciente;

/*
 * @author Rodrigo
 */

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
                        rs.getInt("idGrupoPaciente")));
            }
        }
        return pacientes;
    }

    public void save(Paciente paciente) throws SQLException {
        String sqlRegistro = """
                INSERT INTO registropessoal (
                    nome, cpf, rg, dataNascimento,
                    sexo, telefone, endereco
                )
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        String sqlPaciente = """
                INSERT INTO paciente (
                    status, idGrupoPaciente, idRegistroPessoal
                )
                """;

        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);

            try (PreparedStatement psRegistro = conn.prepareStatement(
                    sqlRegistro, Statement.RETURN_GENERATED_KEYS)) {

                psRegistro.setString(1, paciente.getNome());
                psRegistro.setString(2, paciente.getCpf());
                psRegistro.setString(3, paciente.getRg());
                psRegistro.setDate(4, new java.sql.Date(paciente.getDataNascimento().getTime()));
                psRegistro.setString(5, paciente.getSexo());
                psRegistro.setString(6, paciente.getTelefone());
                psRegistro.setString(7, paciente.getEndereco());

                psRegistro.executeUpdate();

                try (ResultSet generatedKeys = psRegistro.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        paciente.setIdRegistroPessoal(generatedKeys.getInt(1));
                    }
                }
            }

            try (PreparedStatement psPaciente = conn.prepareStatement(
                    sqlPaciente, Statement.RETURN_GENERATED_KEYS)) {

                psPaciente.setString(1, paciente.getStatus());
                psPaciente.setInt(2, paciente.getIdGrupoPaciente());
                psPaciente.setInt(3, paciente.getIdRegistroPessoal());

                psPaciente.executeUpdate();

                try (ResultSet generatedKeys = psPaciente.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        paciente.setIdPaciente(generatedKeys.getInt(1));
                    }
                }
            }

            conn.commit();

        } catch (SQLException e) {
            if (conn != null)
                conn.rollback();
            throw e;
        } finally {
            if (conn != null)
                conn.setAutoCommit(true);
        }
    }

    public void update(Paciente paciente) throws SQLException {
        String sqlRegistro = """
                UPDATE RegistroPessoal 
                SET nome = ?, 
                    cpf = ?,
                    rg = ?,
                    dataNascimento = ?,
                    sexo = ?,
                    telefone = ?,
                    endereco = ?
                WHERE idRegistroPessoal = ?
                """;

        String sqlPaciente = """
                UPDATE Paciente 
                SET status = ?,
                    idGrupoPaciente = ?
                WHERE idPaciente = ?
                """;
    
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);
    
            try (PreparedStatement psRegistro = conn.prepareStatement(sqlRegistro)) {
                psRegistro.setString(1, paciente.getNome());
                psRegistro.setString(2, paciente.getCpf());
                psRegistro.setString(3, paciente.getRg());
                psRegistro.setDate(4, new java.sql.Date(paciente.getDataNascimento().getTime()));
                psRegistro.setString(5, paciente.getSexo());
                psRegistro.setString(6, paciente.getTelefone());
                psRegistro.setString(7, paciente.getEndereco());
                psRegistro.setInt(8, paciente.getIdRegistroPessoal());
            }
    
            try (PreparedStatement psPaciente = conn.prepareStatement(sqlPaciente)) {
                psPaciente.setString(1, paciente.getStatus());
                psPaciente.setInt(2, paciente.getIdGrupoPaciente());
                psPaciente.setInt(3, paciente.getIdPaciente());
            }
    
            conn.commit();
            
        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
            }
        }
    }

    public void delete(int idPaciente) throws SQLException {
        String sql = "DELETE FROM paciente WHERE idPaciente = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idPaciente);
        }
    }
}