package dao;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import modelo.Tarefa;

/**
 *
 * @author tysonos
 */
public interface TarefaDAO {
    public int inserir(int codAssunto, Tarefa tarefa);
    public int apagar(int codigo) throws ClassNotFoundException, SQLException, SQLIntegrityConstraintViolationException;
    public int editar(Tarefa tarefa) throws Exception;
    public List<Tarefa> listar(int idAssunto);
    //public Tarefa listar(int codigo);
    
}
