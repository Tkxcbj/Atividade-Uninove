package Dao;

import Produto.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import SubTelas.TelaAlterarProd;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ProdutoDao {
    
    TelaAlterarProd view;
    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    public boolean conectar(){
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria", "root", "");
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            return false;
        }
    }
    
    public int salvar(Produto produto){
        int resultado;
        try {
            pst = conn.prepareStatement("INSERT INTO produto VALUES(?, ?, ?, ?);");
            pst.setInt(1, produto.getCod());
            pst.setString(2, produto.getNome());
            pst.setString(3, produto.getCategoria());
            pst.setDouble(4, produto.getPreco());
            resultado = pst.executeUpdate();
            return resultado;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage() + " " + ex.getErrorCode());
            return ex.getErrorCode();
        }
    }
    
   public ArrayList<Produto> buscar(){
       ArrayList produto;
       produto = new ArrayList<Produto>();          
        try {
            pst = conn.prepareStatement("SELECT * FROM produto");
            rs = pst.executeQuery();
            if(rs.next()){
                produto.add(rs.getInt("cod"));
                produto.add(rs.getString("nome"));
                produto.add(rs.getDouble("preco"));  
            }
        } catch (SQLException ex) {
            return null;
        } 
        return produto;
    }
   
}
