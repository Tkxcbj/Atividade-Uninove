/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SubTelas.Iniciar;

import Produto.Produto;
import Dao.ProdutoDao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaRegistro extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    double total;
    
    public TelaRegistro() {
        initComponents();
        tableModel = (DefaultTableModel) tbCompras.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCod = new javax.swing.JTextField();
        txtQuant = new javax.swing.JTextField();
        lblQuant = new javax.swing.JLabel();
        txtValorUni = new javax.swing.JTextField();
        lblValorUn = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        lblObs = new javax.swing.JLabel();
        lblCodProd = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        atxtDesc = new javax.swing.JTextArea();
        lblDados = new javax.swing.JLabel();
        lblNomeVendedor = new javax.swing.JLabel();
        lblNumeroCompra = new javax.swing.JLabel();
        lblDiaHora = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCompras = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        btnRemover = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblValorTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(txtCod);
        txtCod.setBounds(12, 41, 280, 45);

        txtQuant.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQuant.setText("1");
        getContentPane().add(txtQuant);
        txtQuant.setBounds(10, 112, 70, 40);

        lblQuant.setText("Quantidade");
        getContentPane().add(lblQuant);
        lblQuant.setBounds(10, 99, 70, 12);
        getContentPane().add(txtValorUni);
        txtValorUni.setBounds(90, 112, 80, 40);

        lblValorUn.setText("Valor unitario");
        getContentPane().add(lblValorUn);
        lblValorUn.setBounds(90, 100, 80, 12);
        getContentPane().add(txtValorTotal);
        txtValorTotal.setBounds(190, 112, 100, 40);

        lblObs.setText("Observação");
        getContentPane().add(lblObs);
        lblObs.setBounds(10, 220, 150, 16);

        lblCodProd.setText("COD - Produto ");
        getContentPane().add(lblCodProd);
        lblCodProd.setBounds(12, 20, 280, 20);

        btnAdd.setText("Adicionar (ENTER)");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(10, 170, 280, 40);

        atxtDesc.setColumns(20);
        atxtDesc.setRows(5);
        jScrollPane1.setViewportView(atxtDesc);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 240, 280, 130);

        lblDados.setText("Dados da compra");
        getContentPane().add(lblDados);
        lblDados.setBounds(360, 20, 230, 20);
        getContentPane().add(lblNomeVendedor);
        lblNomeVendedor.setBounds(560, 40, 140, 45);
        getContentPane().add(lblNumeroCompra);
        lblNumeroCompra.setBounds(360, 40, 80, 45);
        getContentPane().add(lblDiaHora);
        lblDiaHora.setBounds(450, 40, 100, 45);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(360, 40, 560, 10);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(920, 41, 3, 50);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(360, 90, 560, 10);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(360, 41, 3, 50);

        tbCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD", "Produto", "Quantidade", "valor UN", "valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbCompras);
        if (tbCompras.getColumnModel().getColumnCount() > 0) {
            tbCompras.getColumnModel().getColumn(0).setResizable(false);
            tbCompras.getColumnModel().getColumn(1).setResizable(false);
            tbCompras.getColumnModel().getColumn(2).setResizable(false);
            tbCompras.getColumnModel().getColumn(3).setResizable(false);
            tbCompras.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(360, 110, 560, 220);

        lblTotal.setText("SUBTOTAL                                                                                                              R$:");
        getContentPane().add(lblTotal);
        lblTotal.setBounds(360, 330, 450, 40);
        getContentPane().add(lblValor);
        lblValor.setBounds(820, 330, 100, 40);

        btnRemover.setText("Remover");
        getContentPane().add(btnRemover);
        btnRemover.setBounds(530, 480, 110, 40);

        btnFinalizar.setText("Finalizar");
        getContentPane().add(btnFinalizar);
        btnFinalizar.setBounds(770, 480, 110, 40);

        btnCancelar.setText("Cancelar");
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(650, 480, 110, 40);

        lblValorTotal.setText("Valor Total");
        getContentPane().add(lblValorTotal);
        lblValorTotal.setBounds(190, 100, 70, 12);

        setSize(new java.awt.Dimension(950, 569));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        ProdutoDao dao = new ProdutoDao();
        Produto produto = new Produto();
        
        
        if(dao.conectar()){
            produto = dao.buscar(Integer.parseInt(txtCod.getText()));
            double resutado = produto.getPreco() * Integer.parseInt(txtQuant.getText());
            total += resutado;
            if(produto != null){
                tableModel.addRow(new Object[]{
                    produto.getCod(),
                    produto.getNome(),
                    txtQuant.getText(),
                    produto.getPreco(),
                    resutado
                });
                lblValor.setText(String.valueOf(total));
            }else{
                JOptionPane.showMessageDialog(null, "Produto não cadastrado!");
            }
            dao.desconectar();
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar ao banco de dados");
        }
    }//GEN-LAST:event_btnAddActionPerformed
    
    
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(TelaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea atxtDesc;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblCodProd;
    private javax.swing.JLabel lblDados;
    private javax.swing.JLabel lblDiaHora;
    private javax.swing.JLabel lblNomeVendedor;
    private javax.swing.JLabel lblNumeroCompra;
    private javax.swing.JLabel lblObs;
    private javax.swing.JLabel lblQuant;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JLabel lblValorUn;
    private javax.swing.JTable tbCompras;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtQuant;
    private javax.swing.JTextField txtValorTotal;
    private javax.swing.JTextField txtValorUni;
    // End of variables declaration//GEN-END:variables
}
