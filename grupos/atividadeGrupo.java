package manicomio.grupos;

/*
 * @author Rodrigo
 */

public class atividadeGrupo {
    private int idAtividadeGrupo;
    private int idGrupoPaciente;
    
    public atividadeGrupo(int idAtividadeGrupo,
                          int idGrupoPaciente) {
        this.idAtividadeGrupo = idAtividadeGrupo;
        this.idGrupoPaciente = idGrupoPaciente;
    }
    
    public int getIdAtividadeGrupo() {
        return idAtividadeGrupo;
    }
    public void setIdAtividadeGrupo(int idAtividadeGrupo) {
        this.idAtividadeGrupo = idAtividadeGrupo;
    }
    public int getIdGrupoPaciente() {
        return idGrupoPaciente;
    }
    public void setIdGrupoPaciente(int idGrupoPaciente) {
        this.idGrupoPaciente = idGrupoPaciente;
    }
}
