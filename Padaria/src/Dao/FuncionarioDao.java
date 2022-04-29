/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import Produto.Funcionario;
import java.util.ArrayList;

public class FuncionarioDao {
    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    public boolean conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria", "root", "2270");
            return true;
        }catch(ClassNotFoundException | SQLException ex){
            return false;
        }
    }

    public ArrayList<Funcionario> selecionarTodos(){
        ArrayList lista = new ArrayList<Funcionario>();
        try{
            pst = conn.prepareStatement("SELECT usuario, cargo FROM newuser;");
            rs = pst.executeQuery();
            while(rs.next()){
                lista.add(rs.getString("usuario"));
                lista.add(rs.getString("cargo"));
            }
            return lista;
        }catch(SQLException ex){
            return null;
        }
    }

    public ArrayList<Funcionario> buscar(String nome){
        ArrayList lista = new ArrayList<Funcionario>();
        try{
            pst = conn.prepareStatement("SELECT * FROM newuser WHERE usuario LIKE ?;");
            pst.setString(1, nome + "%");
            rs = pst.executeQuery();
            while(rs.next()){
                lista.add(rs.getString("usuario"));
                lista.add(rs.getString("cargo"));
            }
            return lista;
        }catch(SQLException ex){
            System.err.println(ex);
            return null;
        }
    }
    
    public Funcionario selecionar(String nome){
        Funcionario funcionario = new Funcionario();
        try{
            pst = conn.prepareStatement("SELECT * FROM newuser WHERE usuario=?");
            pst.setString(1, nome);
            rs = pst.executeQuery();
            if(rs.next());
                funcionario.setNome(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setCargo(rs.getString("cargo"));
            return funcionario;
        }catch(SQLException ex){
            return null;
        }
    }

    public int editar(Funcionario funcionario, String nome){
        try{
            pst = conn.prepareStatement("UPDATE newuser SET usuario=?, cargo=? WHERE usuario=?;");
            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getCargo());
            pst.setString(3, nome);
            return pst.executeUpdate();
        }catch(SQLException ex){
            System.err.println(ex);
            return ex.getErrorCode();
        }
    }
    
    public int salvarSenha(String senha, String nome){
        try{
            pst = conn.prepareStatement("UPDATE newuser SET senha=? WHERE usuario=?");
            pst.setString(1, senha);
            pst.setString(2, nome);
            return pst.executeUpdate();
        }catch(SQLException ex){
            return ex.getErrorCode();
        }
    }
    
    public int excluir(String nome){
        try{
            pst = conn.prepareStatement("DELETE FROM newuser WHERE usuario=?");
            pst.setString(1, nome);
            return pst.executeUpdate();
        }catch(SQLException ex){
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
