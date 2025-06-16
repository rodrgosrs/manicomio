package manicomio.grupos;

/*
 * @author Rodrigo
 */

public class GrupoPaciente {
    private int idGrupoPaciente;
    private String nomeGrupo;
    private String descricao;

    public GrupoPaciente(int idGrupoPaciente,
    String nomeGrupo,
    String descricao) {
        this.idGrupoPaciente = idGrupoPaciente;
        this.nomeGrupo = nomeGrupo;
        this.descricao = descricao;
    }

    public int getIdGrupoPaciente() {
        return idGrupoPaciente;
    }
    public void setIdGrupoPaciente(int idGrupoPaciente) {
        this.idGrupoPaciente = idGrupoPaciente;
    }
    public String getNomeGrupo() {
        return nomeGrupo;
    }
    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
