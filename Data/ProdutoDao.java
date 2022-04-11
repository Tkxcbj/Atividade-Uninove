package Data;

import Produto.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDao {
    Connection conn;
    PreparedStatement pst;
    
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
    
}
