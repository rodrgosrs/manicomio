package manicomio.pessoas;

import java.util.Date;

/*
 * @author Rodrigo
 */

public class Responsavel extends RegistroPessoal {
    private int idResponsavel;
    private String grauParentesco;
    private int idPaciente;
    
    public Responsavel(int idRegistroPessoal,
                       String nome,
                       String cpf,
                       String rg,
                       Date dataNascimento,                    
                       String sexo,
                       String telefone,
                       String endereco,
                       int idResponsavel,
                       String grauParentesco) {
        super(idRegistroPessoal,
              nome,
              cpf,
              rg,
              dataNascimento,
              sexo,
              telefone,
              endereco);
        this.idResponsavel = idResponsavel;
        this.grauParentesco = grauParentesco;
        this.idPaciente = idPaciente;
    }
    
    public int getIdResponsavel() {
        return idResponsavel;
    }
    public void setIdResponsavel(int idResponsavel){
        this.idResponsavel = idResponsavel;
    }
    public String getGrauParentesco() {
        return grauParentesco;
    }
    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }
    public int getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
}
