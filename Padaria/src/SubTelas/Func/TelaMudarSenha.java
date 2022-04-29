package SubTelas.Func;

import Dao.FuncionarioDao;
import javax.swing.JOptionPane;

public class TelaMudarSenha extends javax.swing.JInternalFrame {
    
    String usuario, senha;
    
    public TelaMudarSenha(String usuario, String senha) {
        initComponents();
        this.usuario = usuario;
        this.senha = senha;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSenhaAtual = new javax.swing.JLabel();
        lblSenhaNova = new javax.swing.JLabel();
        lblRepitaSenha = new javax.swing.JLabel();
        pswSenhaAtual = new javax.swing.JPasswordField();
        pswSenhaNova = new javax.swing.JPasswordField();
        pswRepitaSenha = new javax.swing.JPasswordField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setTitle("Alterar Senha");
        getContentPane().setLayout(null);

        lblSenhaAtual.setText("Senha Atual");
        getContentPane().add(lblSenhaAtual);
        lblSenhaAtual.setBounds(10, 10, 85, 30);

        lblSenhaNova.setText("Nova Senha");
        getContentPane().add(lblSenhaNova);
        lblSenhaNova.setBounds(10, 60, 85, 30);

        lblRepitaSenha.setText("Repita a Senha");
        getContentPane().add(lblRepitaSenha);
        lblRepitaSenha.setBounds(10, 110, 85, 30);
        getContentPane().add(pswSenhaAtual);
        pswSenhaAtual.setBounds(102, 10, 190, 30);
        getContentPane().add(pswSenhaNova);
        pswSenhaNova.setBounds(102, 60, 190, 30);
        getContentPane().add(pswRepitaSenha);
        pswRepitaSenha.setBounds(102, 110, 190, 30);

        btnSalvar.setText("Salvar Alteração");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(20, 170, 120, 30);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(170, 170, 120, 30);

        setBounds(0, 0, 410, 308);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(senha.equalsIgnoreCase(pswSenhaAtual.getText())){
            int resp = JOptionPane.showConfirmDialog(null, "Deseja mesmo alterar a senha?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if(resp == JOptionPane.YES_NO_OPTION){
                FuncionarioDao dao = new FuncionarioDao();
                int resposta;

                if(!pswSenhaNova.getText().equalsIgnoreCase(pswRepitaSenha.getText())){
                    JOptionPane.showMessageDialog(null, "As senha não são iguais");
                    pswRepitaSenha.requestFocus();
                    return;
                }           

                if(dao.conectar()){
                    resposta = dao.salvarSenha(pswSenhaNova.getText(), usuario);
                    if(resposta == 1){
                        JOptionPane.showMessageDialog(null, "Senha alterado com SUCESSO");
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Não foi possivel alterar a senha");
                    }
                    dao.desconectar();
                }else{
                    JOptionPane.showMessageDialog(null, "Não foi possivel conectar ao banco de dados");
                }
            }else{
                dispose();
            }
        }else{
            JOptionPane.showMessageDialog(null, "A sua senha atual não é essa");
            pswSenhaAtual.requestFocus();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblRepitaSenha;
    private javax.swing.JLabel lblSenhaAtual;
    private javax.swing.JLabel lblSenhaNova;
    private javax.swing.JPasswordField pswRepitaSenha;
    private javax.swing.JPasswordField pswSenhaAtual;
    private javax.swing.JPasswordField pswSenhaNova;
    // End of variables declaration//GEN-END:variables
}
