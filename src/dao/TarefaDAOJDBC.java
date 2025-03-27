package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Tarefa;

/**
 *
 * @author tysonos
 */
public class TarefaDAOJDBC extends DAOGenerico implements TarefaDAO {

    @Override
    public int inserir(int codAssunto, Tarefa tarefa) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("INSERT INTO tarefa(assuntoId, titulo, descricao, prazoConclusao) ")
                .append("VALUES (?, ?, ?, ?)");

        String insert = sqlBuilder.toString();
        int linha = 0;
        try {
            linha = executarComando(insert, codAssunto, tarefa.getTitulo(),
                    tarefa.getDescricao(),
                    tarefa.getPrazoConclusao());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return linha;
    }

    @Override
    public int editar(Tarefa tarefa) throws Exception {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("UPDATE tarefa SET ")
                .append("titulo = ?, ")
                .append("descricao = ?, ")
                .append("prazoConclusao = ?,")
                .append("concluida = ? ")
                .append("WHERE id = ?");
        String update = sqlBuilder.toString();
        int linha = 0;
        try {
            linha = executarComando(update, tarefa.getTitulo(),
                                            tarefa.getDescricao(),
                                            tarefa.getPrazoConclusao(),
                                            tarefa.isConcluida(),
                                            tarefa.getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return linha;
    }

    @Override
    public int apagar(int codigo) throws ClassNotFoundException, SQLException, SQLIntegrityConstraintViolationException {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("DELETE FROM tarefa ")
                .append("WHERE id = ?");
        String delete = sqlBuilder.toString();
        int linha = 0;
        linha = executarComando(delete, codigo);
        return linha;
    }

    @Override
    public List<Tarefa> listar(int idAssunto) {
        ResultSet rset;
        String select = "SELECT * FROM tarefa where assuntoId=" + idAssunto;
        List<Tarefa> tarefas = new ArrayList<>();
        try {
            rset = executarConsulta(select);
            while (rset.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setId(rset.getInt("id"));
                tarefa.setAssunto(rset.getInt("assuntoId"));
                tarefa.setTitulo(rset.getString("titulo"));
                tarefa.setDescricao(rset.getString("descricao"));
                tarefa.setConcluida(rset.getBoolean("concluida"));
                tarefa.setDataCriacao(rset.getDate("dataCriacao"));
                tarefa.setPrazoConclusao(rset.getDate("prazoConclusao"));
                tarefas.add(tarefa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tarefas;
    }
    /*
    @Override
    public Assunto listar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     */
}
