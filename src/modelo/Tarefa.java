package modelo;

import java.util.Date;

/**
 *
 * @author tysonos
 */

public class Tarefa {
    private int id;
    private int idAssunto;
    private String titulo;
    private String descricao;
    private boolean concluida;
    private Date dataCriacao;
    private Date prazoConclusao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAssunto() {
        return idAssunto;
    }

    public void setAssunto(int codAssunto) {
        this.idAssunto = codAssunto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getPrazoConclusao() {
        return prazoConclusao;
    }

    public void setPrazoConclusao(Date prazoConclusao) {
        this.prazoConclusao = prazoConclusao;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "id=" + id + ", idAssunto=" + idAssunto + ", titulo=" + titulo + ", descricao=" + descricao + ", concluida=" + concluida + ", dataCriacao=" + dataCriacao + ", prazoConclusao=" + prazoConclusao + '}';
    }
    
}
