package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import Produto.Registro;

public class RegistroDao {
    
    Connection conn;
    PreparedStatement pst;
    ResultSet st;
    
    public boolean conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria", "root", "2270");
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            return false;
        }
    }

    public int adcionarProd(Registro resgistro){
        try{
            pst = conn.prepareStatement("INSERT INTO venda VALUES(?, ?")
        }catch(SQLException ex){
            System.err.println(ex);
            return ex.getErrorCode();
        }
    }
    
    
    public void desconectar(){
        try{
            pst.close();
            conn.close();
        }catch(SQLException ex){
        }
    }
}
