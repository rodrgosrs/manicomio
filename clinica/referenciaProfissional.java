package manicomio.clinica;

/*
 * @author Rodrigo
 */

public class referenciaProfissional {
    private int idReferencia;
    private int idFuncionario;
    private int idPaciente;
    
    public referenciaProfissional(int idReferencia,
                                  int idFuncionario,
                                  int idPaciente) {
        this.idReferencia = idReferencia;
        this.idFuncionario = idFuncionario;
        this.idPaciente = idPaciente;
    }

    public int getIdReferencia() {
        return idReferencia;
    }
    public void setIdReferencia(int idReferencia) {
        this.idReferencia = idReferencia;
    }
    public int getIdFuncionario() {
        return idFuncionario;
    }
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    public int getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
}