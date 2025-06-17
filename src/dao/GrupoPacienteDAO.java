package dao;

import grupos.GrupoPaciente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Rodrigo
 */

public class GrupoPacienteDAO {
    
    public List<GrupoPaciente> findAll() throws SQLException {
        String sql = """
                    SELECT idGrupoPaciente,
                    nomeGrupo, descricao 
                    FROM GrupoPaciente
                """;
        List<GrupoPaciente> grupos = new ArrayList<>();
        
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            
            while (rs.next()) {
                grupos.add(new GrupoPaciente(
                    rs.getInt("idGrupoPaciente"),
                    rs.getString("nomeGrupo"),
                    rs.getString("descricao")
                ));
            }
        }
        return grupos;
    }
}