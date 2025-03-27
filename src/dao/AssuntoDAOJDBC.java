package dao;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import modelo.Assunto;
/**
 *
 * @author tysonos
 */
public class AssuntoDAOJDBC extends DAOGenerico implements AssuntoDAO {
    
    @Override
    public int inserir(Assunto assunto) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("INSERT INTO assunto(titulo, descricao, dataCriacao) ")
                .append("VALUES (?, ?, ?)");
     
        String insert = sqlBuilder.toString();
        int linha = 0;
        try {  
            linha = executarComando(insert, assunto.getTitulo(), 
                                                        assunto.getDescricao(), 
                                                        assunto.getDataCriacao());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return linha;
    }

    @Override
    public int editar(Assunto assunto) {
      StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("UPDATE assunto SET ")
                .append("titulo = ?, ")
                .append("descricao = ? ")
                .append("WHERE id = ?");
        String update = sqlBuilder.toString();
        int linha = 0;
        try {
            linha = executarComando(update, assunto.getTitulo(), assunto.getDescricao(), assunto.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return linha; 
    }

    @Override
    public int apagar(int codigo) throws ClassNotFoundException, SQLException, SQLIntegrityConstraintViolationException {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("DELETE FROM assunto ")
                .append("WHERE id = ?");
        String delete = sqlBuilder.toString();
        int linha = 0;        
        linha = executarComando(delete, codigo);
        return linha;
    }

    @Override
    public List<Assunto> listar() {
        ResultSet rset;
        String select = "SELECT * FROM assunto";
        List<Assunto> assuntos = new ArrayList<>();
        try {        
            rset = executarConsulta(select);
            while (rset.next()) {
                Assunto assunto = new Assunto();
                assunto.setId(rset.getInt("id"));
                assunto.setTitulo(rset.getString("titulo"));
                assunto.setDescricao(rset.getString("descricao"));
                assunto.setDataCriacao(rset.getDate("dataCriacao"));
                assuntos.add(assunto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return assuntos;
    }

    @Override
    public Assunto listar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
