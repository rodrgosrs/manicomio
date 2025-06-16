package manicomio.manicomio.clinica;
import java.util.Date;

/*
 * @author Rodrigo
 */

public class internacao {
    private int idInternacao;
    private int idPaciente;
    private Date dataEntrada;
    private Date dataAlta;
    private String motivo;

    public internacao(int idInternacao,
                      int idPaciente,
                      Date dataEntrada,
                      Date dataAlta,
                      String motivo) {
        this.idInternacao = idInternacao;
        this.idPaciente = idPaciente;
        this.dataEntrada = dataEntrada;
        this.dataAlta = dataAlta;
        this.motivo = motivo;
    }
    
    public int getIdInternacao() {
        return idInternacao;
    }
    public void setIdInternacao(int idInternacao) {
        this.idInternacao = idInternacao;
    }
    public int getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    public Date getDataEntrada() {
        return dataEntrada;
    }
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    public Date getDataAlta() {
        return dataAlta;
    }
    public void setDataAlta(Date dataAlta) {
        this.dataAlta = dataAlta;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}