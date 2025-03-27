package dao;

public class DAOFactory {
    public static AssuntoDAO criarAssuntoDAO() {
        return new AssuntoDAOJDBC();
    }
    
    public static TarefaDAO criarTarefaDAO() {
        return new TarefaDAOJDBC();
    }
}
