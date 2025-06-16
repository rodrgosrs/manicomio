package grupos;
import java.util.Date;

/*
 * @author Rodrigo
 */

public class Atividade {
    private int idAtividade;
    private String nomeAtividade;
    private String descricao;
    private Date dataHora;
    
    public Atividade(int idAtividade,
                     String nomeAtividade,
                     String descricao,
                     Date dataHora) {
        this.idAtividade = idAtividade;
        this.nomeAtividade = nomeAtividade;
        this.descricao = descricao;
        this.dataHora = dataHora;
    }
    
    public int getIdAtividade() {
        return idAtividade;
    }
    public void setIdAtividade(int idAtividade) {
        this.idAtividade = idAtividade;
    }
    public String getNomeAtividade() {
        return nomeAtividade;
    }
    public void setNomeAtividade(String nomeAtividade) {
        this.nomeAtividade = nomeAtividade;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Date getDataHora() {
        return dataHora;
    }
    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
}