package manicomio.pessoas;

import java.util.Date;

/*
 * @author Rodrigo
 */

public class registroPessoal {
    int idRegistroPessoal;
    private String nome;
    private String cpf;
    private String rg;
    private Date dataNascimento;
    private String sexo;
    private String telefone;
    private String endereco;
    
    public registroPessoal(int idRegistroPessoal,
                            String nome,
                            String cpf,
                            String rg,
                            Date dataNascimento,
                            String sexo,
                            String telefone,
                            String endereco){
        this.idRegistroPessoal = idRegistroPessoal;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    
    public int getIdRegistroPessoal() {
        return idRegistroPessoal;
    }
    public void setIdRegistroPessoal(int idRegistroPessoal) {
        this.idRegistroPessoal = idRegistroPessoal;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
}
