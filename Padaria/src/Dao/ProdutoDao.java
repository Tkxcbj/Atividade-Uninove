package Dao;

import Produto.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDao {
    
    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    Produto produto;
    
    public boolean conectar(){
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria", "root", "2270");
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
    
    public int editar(Produto produto){
        try{
            pst = conn.prepareStatement("UPDATE produto SET nome=?, categoria=?, preco=? WHERE codigo=?;");
            pst.setString(1, produto.getNome());
            pst.setString(2, produto.getCategoria());
            pst.setDouble(3, produto.getPreco());
            pst.setInt(4, produto.getCod());
            int resultado = pst.executeUpdate();
            return resultado;
        }catch(SQLException ex){
            return ex.getErrorCode();
        }
    }
    
    public Produto buscar(int valor){
        Produto jtProd = new Produto();         
         try {
             pst = conn.prepareStatement("SELECT * FROM produto WHERE codigo=?;");
             pst.setInt(1, valor);
             rs = pst.executeQuery();            
             if(rs.next());
                    jtProd.setCod(rs.getInt("codigo"));
                    jtProd.setNome(rs.getString("nome"));
                    jtProd.setCategoria(rs.getString("categoria"));
                    jtProd.setPreco(rs.getDouble("preco"));  
                    return jtProd;
         } catch (SQLException ex) {
             return null;
         } 
    }
    
    public ArrayList<Produto> buscar(String nome){
        ArrayList lista = new ArrayList<Produto>();
        try{
            pst = conn.prepareStatement("SELECT * FROM produto WHERE nome=?;");
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while(rs.next()){
                lista.add(rs.getInt("codigo"));
                lista.add(rs.getString("nome"));
                lista.add(rs.getString("categoria"));
                lista.add(rs.getDouble("preco"));
            }
            return lista;
        }catch(SQLException ex){
            return null;
        }
    }
    
    public ArrayList<Produto> selecionarTudo(){
        ArrayList lista = new ArrayList<Produto>();
        try {
             pst = conn.prepareStatement("SELECT * FROM produto;");
             rs = pst.executeQuery();            
             while(rs.next()){         
                    lista.add(rs.getInt("codigo"));
                    lista.add(rs.getString("nome"));
                    lista.add(rs.getString("categoria"));
                    lista.add(rs.getDouble("preco"));
             }
                    return lista;
        } catch (SQLException ex) {
             return null;
         } 
    }
    
    public int excluir(int cod){
        int resp;
        try{
            pst = conn.prepareStatement("DELETE FROM produto WHERE codigo=?;");
            pst.setInt(1, cod);
            resp = pst.executeUpdate();
            return resp;
        }catch(SQLException ex){
            return ex.getErrorCode();
        }
    }
   
    
    public void desconectar(){
        try {
            pst.close();
            conn.close();
        } catch (SQLException ex) {          
        }       
    }
}
