package dao;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import modelo.Assunto;
/**
 *
 * @author tysonos
 */
public interface AssuntoDAO {
    public int inserir(Assunto assunto);
    public int apagar(int codigo) throws ClassNotFoundException, SQLException, SQLIntegrityConstraintViolationException;
    public int editar(Assunto assunto);
    public List<Assunto> listar();
    public Assunto listar(int codigo);
}
