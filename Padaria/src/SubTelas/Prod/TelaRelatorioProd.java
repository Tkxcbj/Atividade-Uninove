package SubTelas.Prod;

import Produto.Produto;
import Dao.ProdutoDao;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cleyt
 */
public class TelaRelatorioProd extends javax.swing.JInternalFrame {

    public TelaRelatorioProd() {
        initComponents();
        lblPesquisar.setVisible(false);
        txtPesquisar.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        lblTipo = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        lblPesquisar = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);
        getContentPane().setLayout(null);

        tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Categoria", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbProdutos);
        if (tbProdutos.getColumnModel().getColumnCount() > 0) {
            tbProdutos.getColumnModel().getColumn(0).setResizable(false);
            tbProdutos.getColumnModel().getColumn(1).setResizable(false);
            tbProdutos.getColumnModel().getColumn(2).setResizable(false);
            tbProdutos.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 122, 610, 330);

        lblTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTipo.setText("Tipo de Relatorio");
        getContentPane().add(lblTipo);
        lblTipo.setBounds(20, 30, 120, 30);

        cbxTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Geral", "Categoria", "Nome" }));
        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });
        cbxTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxTipoKeyPressed(evt);
            }
        });
        getContentPane().add(cbxTipo);
        cbxTipo.setBounds(140, 30, 120, 30);

        lblPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPesquisar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPesquisar.setText("Nome do produto");
        getContentPane().add(lblPesquisar);
        lblPesquisar.setBounds(310, 30, 120, 30);

        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyPressed(evt);
            }
        });
        getContentPane().add(txtPesquisar);
        txtPesquisar.setBounds(440, 30, 160, 30);

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(370, 70, 170, 29);

        setBounds(15, 25, 644, 491);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ArrayList<Produto> valores;
        
        ProdutoDao dao = new ProdutoDao();
        if(dao.conectar()){
            
            DefaultTableModel tableModel = (DefaultTableModel) tbProdutos.getModel();
            int pos = 0;
            valores = dao.buscarAvancada(cbxTipo.getSelectedItem().toString(), txtPesquisar.getText());
            if(valores.isEmpty()){
                JOptionPane.showMessageDialog(null, txtPesquisar.getText() + ", Não foi encotrado");
                return;
            }
            tableModel.setRowCount(0);
            while(true){
               try{
                    tableModel.addRow(new Object[]{
                    valores.get(pos++),
                    valores.get(pos++),
                    valores.get(pos++),
                    valores.get(pos++)
                    });
               }catch(IndexOutOfBoundsException ex){
                   break;
               }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed
        if(cbxTipo.getSelectedItem().toString().equalsIgnoreCase("Geral")){
            lblPesquisar.setVisible(false);
            txtPesquisar.setVisible(false);
        }else if(cbxTipo.getSelectedItem().toString().equalsIgnoreCase("Categoria")){
            lblPesquisar.setText("Categoria");
            lblPesquisar.setVisible(true);
            txtPesquisar.setVisible(true);
        }else if(cbxTipo.getSelectedItem().toString().equalsIgnoreCase("Nome")){
            lblPesquisar.setText("Nome do Produto");
            lblPesquisar.setVisible(true);
            txtPesquisar.setVisible(true);
        }
    }//GEN-LAST:event_cbxTipoActionPerformed

    private void cbxTipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxTipoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnBuscar.doClick();
        }
    }//GEN-LAST:event_cbxTipoKeyPressed

    private void txtPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnBuscar.doClick();
        }
    }//GEN-LAST:event_txtPesquisarKeyPressed


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTable tbProdutos;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
