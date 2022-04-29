package SubTelas.Func;

import Dao.UsuarioDao;
import Produto.Login;
import javax.swing.JOptionPane;

public class TelaCadFunc extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaCadFunc
     */
    public TelaCadFunc() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        bntSair = new javax.swing.JButton();
        cbxCargo = new javax.swing.JComboBox<>();
        pswSenha = new javax.swing.JPasswordField();
        cbPadrao = new javax.swing.JCheckBox();

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("Nome");

        lblSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSenha.setText("Senha");

        lblCargo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCargo.setText("Cargo");

        btnSair.setText("Salvar");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        bntSair.setText("Sair");
        bntSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSairActionPerformed(evt);
            }
        });

        cbxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Gerente", "Balconista", "Caixa" }));

        cbPadrao.setText("Padrão");
        cbPadrao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbPadraoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pswSenha))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPadrao))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntSair, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(pswSenha))
                    .addComponent(cbPadrao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCargo, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(cbxCargo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        //Variaves e Classes que vão ser utilizados
        UsuarioDao dao = new UsuarioDao();
        Login login = new Login();
        int resposta;
        
        //Passando os dados já tratados para um Molde
        login.setUsuario(txtNome.getText());      
        if(cbPadrao.isSelected()){
            login.setSenha(txtNome.getText());
        }else{
            login.setSenha(pswSenha.getText());
        }
        if(cbxCargo.getSelectedItem().toString().equalsIgnoreCase("selecione")){
            JOptionPane.showMessageDialog(null, "O Cargo não pode ser SELECIONE");
            return;
        }
        login.setCargo(cbxCargo.getSelectedItem().toString());
        
        //Inicinado a conexão com o banco de dados e salvando os dados OU não
        if(dao.conectar()){
            resposta = dao.salvar(login);
            
            if(resposta == 1){
                JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
                txtNome.setText("");
                pswSenha.setText("");
                cbPadrao.setSelected(false);
                cbxCargo.setSelectedItem("Selecione");
            }else if(resposta == 1062){
                JOptionPane.showMessageDialog(null, "Esse nome de Usuario já está em uso");
            }else{
                JOptionPane.showMessageDialog(null, "Usuario não pode ser cadastrado");
            }
            dao.desconectar();
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar ao banco de dados");
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void bntSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSairActionPerformed
        dispose();
    }//GEN-LAST:event_bntSairActionPerformed

    private void cbPadraoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbPadraoMouseClicked
        if(cbPadrao.isSelected()){
            JOptionPane.showMessageDialog(txtNome, "A senha padrão é o nome de usuario");
        }
    }//GEN-LAST:event_cbPadraoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntSair;
    private javax.swing.JButton btnSair;
    private javax.swing.JCheckBox cbPadrao;
    private javax.swing.JComboBox<String> cbxCargo;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPasswordField pswSenha;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
