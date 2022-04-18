package Dao;

import Produto.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDao {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    
    public boolean conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria", "root", "");
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex);
            return false;
        }
    }

    public boolean verificar(Login login){
        try {
            pstm = conn.prepareStatement("SELECT * FROM newuser WHERE usuario = ? and senha = ?;");
            pstm.setString(1, login.getUsuario());
            pstm.setString(2, login.getSenha());
            rs = pstm.executeQuery();
            if (rs.next()){
                login.setCargo(rs.getString("cargo"));
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }
    
    
    public int salvar(Login login){
        try {
            int status;
            pstm = conn.prepareStatement("INSERT INTO newuser VALUES(?, ?, ?);");
            pstm.setString(1, login.getUsuario());
            pstm.setString(2, login.getSenha());
            pstm.setString(3, login.getCargo());
            status = pstm.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return ex.getErrorCode();
        }
    }

    public void desconectar(){
        try{
            pstm.close();
            conn.close();
        }catch(SQLException ex){
        }
    }
}
