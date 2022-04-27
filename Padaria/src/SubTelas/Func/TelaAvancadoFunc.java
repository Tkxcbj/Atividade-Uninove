/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SubTelas.Func;

import Dao.FuncionarioDao;
import Produto.Funcionario;
import SubTelas.Prod.TelaAvancado;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class TelaAvancadoFunc extends javax.swing.JFrame {

    JButton btn;
    
    public TelaAvancadoFunc() {
        initComponents();
        btnExcluir.setEnabled(false);
    }

    public TelaAvancadoFunc(String nome, JButton btn){
        initComponents();
        mostra(nome);
        this.btn = btn;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        lblSenha = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnRedefinirSenha = new javax.swing.JButton();
        pswSenha = new javax.swing.JPasswordField();
        cbxCargo = new javax.swing.JComboBox<>();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Opções Avançadas");
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(null);

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUsuario.setText("Usuario");
        getContentPane().add(lblUsuario);
        lblUsuario.setBounds(20, 10, 66, 40);
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(90, 10, 240, 40);

        btnSalvar.setText("Salvar");
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(240, 170, 80, 40);

        lblSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSenha.setText("Senha");
        getContentPane().add(lblSenha);
        lblSenha.setBounds(20, 60, 66, 40);

        lblCargo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCargo.setText("Cargo");
        getContentPane().add(lblCargo);
        lblCargo.setBounds(20, 110, 66, 40);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(60, 170, 80, 40);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(150, 170, 80, 40);

        btnRedefinirSenha.setText("Redefinir Senha");
        getContentPane().add(btnRedefinirSenha);
        btnRedefinirSenha.setBounds(120, 220, 140, 40);
        getContentPane().add(pswSenha);
        pswSenha.setBounds(90, 60, 240, 40);

        cbxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Gerente", "Balconista", "Caixa" }));
        getContentPane().add(cbxCargo);
        cbxCargo.setBounds(90, 110, 240, 40);

        setSize(new java.awt.Dimension(412, 320));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        mostra(txtUsuario.getText());
        btnExcluir.setEnabled(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o usuario?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if(resp == JOptionPane.YES_NO_OPTION){
            FuncionarioDao dao = new FuncionarioDao();
            if(dao.conectar()){
                resp  = dao.excluir(txtUsuario.getText());
                if(resp == 1){
                    JOptionPane.showMessageDialog(null, "Usuario excluido com sucesso");
                    this.btn.doClick();
                }else{
                    JOptionPane.showMessageDialog(null, "Não foi possivel excluir o usuario", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                dao.desconectar();
            }else{
                JOptionPane.showMessageDialog(null, "não foi possivel conectar ao banco de dados");
            }
        }else{
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void mostra(String nome){
        FuncionarioDao dao = new FuncionarioDao();
        Funcionario funcionario;
        
        if(dao.conectar()){
            funcionario = dao.selecionar(nome);
            if(funcionario != null){
                txtUsuario.setText(funcionario.getNome());
                pswSenha.setText(funcionario.getSenha());
                cbxCargo.setSelectedItem(funcionario.getCargo());
                pswSenha.setEditable(false);
            }else{
                JOptionPane.showMessageDialog(null, "Usuario não encontrado!");
                btnExcluir.setEnabled(false);
            }
            dao.desconectar();
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar ao banco de dados");
        }
    }
    
    public static void avancado(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAvancadoFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAvancadoFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAvancadoFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAvancadoFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAvancadoFunc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnRedefinirSenha;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxCargo;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField pswSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
