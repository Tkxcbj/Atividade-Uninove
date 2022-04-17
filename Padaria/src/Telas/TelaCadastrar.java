
package Telas;

import Produto.Pendentes;
import Dao.PendentesDao;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


public class TelaCadastrar extends javax.swing.JFrame {

    PendentesDao dao = new PendentesDao();
    
    public TelaCadastrar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblSenhaII = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        txtSenhaII = new javax.swing.JTextField();
        cbxCargo = new javax.swing.JComboBox<>();
        btnRequisitar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lblSenha.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        lblSenha.setText("Senha");
        getContentPane().add(lblSenha);
        lblSenha.setBounds(10, 90, 73, 41);

        lblSenhaII.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        lblSenhaII.setText("Repita a senha");
        getContentPane().add(lblSenhaII);
        lblSenhaII.setBounds(10, 140, 110, 41);

        lblCargo.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        lblCargo.setText("Cargo");
        getContentPane().add(lblCargo);
        lblCargo.setBounds(10, 190, 73, 41);

        lblUsuario.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        lblUsuario.setText("Usuário");
        getContentPane().add(lblUsuario);
        lblUsuario.setBounds(10, 40, 73, 41);
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(120, 40, 250, 40);
        getContentPane().add(txtSenha);
        txtSenha.setBounds(120, 90, 250, 40);

        txtSenhaII.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaIIKeyPressed(evt);
            }
        });
        getContentPane().add(txtSenhaII);
        txtSenhaII.setBounds(120, 140, 250, 40);

        cbxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Gerente", "Vendedor", "Caixa" }));
        cbxCargo.setEnabled(false);
        getContentPane().add(cbxCargo);
        cbxCargo.setBounds(120, 190, 250, 40);

        btnRequisitar.setText("Requisitar");
        btnRequisitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequisitarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRequisitar);
        btnRequisitar.setBounds(20, 260, 90, 40);

        setSize(new java.awt.Dimension(423, 359));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRequisitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequisitarActionPerformed
        boolean status;
        int salvar;
        Pendentes login = new Pendentes();
        
        login.setUsuario(txtUsuario.getText());
        login.setSenha(txtSenha.getText());
        login.setCargo("Selecione");
        if(!login.getSenha().equals(txtSenhaII.getText())){
            JOptionPane.showMessageDialog(null, "As senhas devem ser iguais", "Erro", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        status = dao.conectar();
        if(status){
            salvar = dao.salvar(login);
            if(salvar == 1){
                JOptionPane.showMessageDialog(null, "Requisição feita com sucesso, espere pela aprovação do gerente");
                dispose();
            } else if(salvar == 1062){
                JOptionPane.showMessageDialog(null, "O usuario já foi cadastrado, espere pela aprovação do gerente");
            } else{
                JOptionPane.showMessageDialog(null, "Não foi possivel cadastra esse usuario!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        dao.desconectar();       
    }//GEN-LAST:event_btnRequisitarActionPerformed

    private void txtSenhaIIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaIIKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnRequisitar.doClick();
        }
    }//GEN-LAST:event_txtSenhaIIKeyPressed

    public static void telaCad(String args[]) {
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
            java.util.logging.Logger.getLogger(TelaCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastrar().setVisible(true);
            }
        });
    }

    public void limpar(){
        txtUsuario.setText("");
        txtSenha.setText("");
        txtSenhaII.setText("");
        cbxCargo.setSelectedItem("Selecione");
        txtUsuario.requestFocus();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRequisitar;
    private javax.swing.JComboBox<String> cbxCargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSenhaII;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtSenhaII;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
