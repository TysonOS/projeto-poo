package dao;

import java.sql.*;

public class DAOGenerico {
    public static Connection getConexao() throws SQLException, ClassNotFoundException {
        String USUARIO = "root";
        String SENHA = "123456";
        String URL_BANCO = "jdbc:mysql://localhost:3306/study_tracker";
        //Faz com que a classe seja carregada pela JVM
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(URL_BANCO, USUARIO, SENHA);
    }
    
     public static int executarComando(String query, Object... params) throws SQLException, ClassNotFoundException {
        PreparedStatement sql = (PreparedStatement)  getConexao().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        for (int i = 0; i < params.length; i++) {
            sql.setObject(i+1,params[i]);
        }
        int result = sql.executeUpdate();
        ResultSet rs = sql.getGeneratedKeys();
        if(rs.next()){  //retorna a chave primaria adicionada
            result = rs.getInt(1);
        }
        sql.close();
        return result;
     }
     
     public static ResultSet executarConsulta(String query, Object... params) throws SQLException, ClassNotFoundException {
        PreparedStatement sql = (PreparedStatement)  getConexao().prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            sql.setObject(i+1,params[i]);
        }
        return sql.executeQuery();
    }
}
