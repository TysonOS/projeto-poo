/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


/**
 *
 * @author tysonos
 */

/*
 id INT auto_increment PRIMARY KEY,
    titulo VARCHAR(60),
    descricao VARCHAR(255),
    dataCriacao timestamp default current_timestamp
*/

import java.util.Date;

public class Assunto {
    private int id;
    private String titulo;
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    private Date dataCriacao;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\n\nAssunto{" + "id=" + id + ", \ntitulo=" + titulo + ", \ndescricao=" + descricao + ", \ndataCriacao=" + dataCriacao + '}';
    }

   
    
    
    
}
