package manicomio.clinica;
import java.util.Date;

/*
 * @author Rodrigo
 */

public class Atendimento {
    private int idAtendimento;
    private int idPaciente;
    private int idFuncionario;
    private Date dataHora;
    private String observacao;
    
    public Atendimento(int idAtendimento,
                       int idPaciente,
                       int idFuncionario,
                       Date dataHora,
                       String observacao) {
        this.idAtendimento = idAtendimento;
        this.idPaciente = idPaciente;
        this.idFuncionario = idFuncionario;
        this.dataHora = dataHora;
        this.observacao = observacao;
    }
    
    
    public int getIdAtendimento() {
        return idAtendimento;
    }
    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }
    public int getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    public int getIdFuncionario() {
        return idFuncionario;
    }
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    public Date getDataHora() {
        return dataHora;
    }
    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}