package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import Produto.Pendentes;
import Produto.Login;

public class PendentesDao {
    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    public boolean conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria", "root", "2270");
            return true;
        }catch(SQLException | ClassNotFoundException ex){
            return false;
        }
    }
    
    public ArrayList<Pendentes> pendentes(){
        ArrayList pendentes = new ArrayList<Pendentes>();
        try{
            pst = conn.prepareStatement("SELECT usuario FROM pendentes;");
            rs = pst.executeQuery();
            while(rs.next()){
                pendentes.add(rs.getString("usuario"));
            }
            return pendentes;
            
        }catch(SQLException ex){
            return null;
        }
    }
    
    public Pendentes verificar(String funcionario){
        Pendentes pendentes = new Pendentes();
        try{
            pst = conn.prepareStatement("SELECT * FROM pendentes WHERE usuario=?");
            pst.setString(1, funcionario);
            rs = pst.executeQuery();
            if(rs.next());
                pendentes.setUsuario(rs.getString("usuario"));
                pendentes.setSenha(rs.getString("senha"));
                pendentes.setCargo(rs.getString("cargo"));
                return pendentes;
        }catch(SQLException ex){
            return null;
        }
    }
    
    public int salvar(Pendentes pendentes){
        try{
            pst = conn.prepareStatement("INSERT INTO pendentes VALUES(?, ?, ?)");
            pst.setString(1, pendentes.getUsuario());
            pst.setString(2, pendentes.getSenha());
            pst.setString(3, pendentes.getCargo());
            return pst.executeUpdate();
        }catch(SQLException ex){
            return ex.getErrorCode();
        }
    }
    
    public int apagar(Login login){
        try{
            pst = conn.prepareStatement("DELETE FROM pendentes WHERE usuario=?");
            pst.setString(1, login.getUsuario());
            return pst.executeUpdate();
        }catch(SQLException ex){
            return ex.getErrorCode();
        }
    }
    
    
    public void desconectar(){
        try{
            conn.close();
            pst.close();
        }catch(SQLException ex){
        }
    }
}
