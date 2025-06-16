package manicomio.pessoas;

import java.util.Date;

/*
 * @author 825131674
 */

public class Funcionario extends RegistroPessoal {
    private int idFuncionario;
    private String cargo;
    
    public Funcionario (int idRegistroPessoal,
                        String nome,
                        String cpf,
                        String rg,
                        Date dataNascimento,                    
                        String sexo,
                        String telefone,
                        String endereco,
                        int idFuncionario,
                        String cargo) {
        super(idRegistroPessoal,
              nome,
              cpf,
              rg,
              dataNascimento,
              sexo,
              telefone,
              endereco);
        this.idFuncionario = idFuncionario;
        this.cargo = cargo;
    }
    
    public int getIdFuncionario() {
        return idFuncionario;
    }
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
