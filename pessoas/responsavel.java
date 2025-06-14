package manicomio.pessoas;

import java.util.Date;

/*
 * @author Rodrigo
 */

public class responsavel extends registroPessoal {
    private int idResponsavel;
    private String grauParentesco;
    
    public responsavel(int idRegistroPessoal,
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
    
}
