package manicomio.pessoas;

import java.util.Date;

/*
 * @author Rodrigo
 */

public class paciente extends registroPessoal {
    private int idPaciente;
    private String status;
    private int idGrupoPaciente;
    
    public paciente(int idRegistroPessoal,
                    String nome,
                    String cpf,
                    String rg,
                    Date dataNascimento,                    
                    String sexo,
                    String telefone,
                    String endereco,
                    int idPaciente,
                    String status,
                    int idGrupoPaciente) {
        super(idRegistroPessoal,
                nome,
                cpf,
                rg,
                dataNascimento,
                sexo,
                telefone,
                endereco);
        this.idPaciente = idPaciente;
        this.status = status;
        this.idGrupoPaciente = idGrupoPaciente;
    }
    
    public int getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getIdGrupoPaciente() {
        return idGrupoPaciente;
    }
    public void setIdGrupoPaciente(int idGrupoPaciente) {
        this.idGrupoPaciente = idGrupoPaciente;
    }
    
}
