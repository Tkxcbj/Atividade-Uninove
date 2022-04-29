
package SubTelas.Prod;

import Commun.TextPrompt;
import Dao.ProdutoDao;
import Produto.Produto;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author cleyt
 */
public class TelaAlterarProd extends javax.swing.JInternalFrame {
    
    public TelaAlterarProd() {
        initComponents();
        prencherTabela();
        TextPrompt tx = new TextPrompt("Pesquisar", txtPesquisar);
    }
    
   /* public void atualizarTabela(){
        ProdutoDao dao = new ProdutoDao();
        dao.conectar();
        ArrayList<Produto> produtos = dao.buscar();
        prencherTabela(produtos);
        
    }*/
    
    private void prencherTabela() {
        //Prenchendno a tabela assim que inicia
        ProdutoDao dao = new ProdutoDao();
        ArrayList<Produto> prod;
        DefaultTableModel tableModel = (DefaultTableModel) jtProd.getModel();
        int valor = 0;

        boolean status = dao.conectar();
        if(status){
            prod = dao.selecionarTudo();  
            while(true){
                try{
                    tableModel.addRow(new Object[] {
                        prod.get(valor++),
                        prod.get(valor++),
                        prod.get(valor++),
                        prod.get(valor++)
                        });

                }catch(IndexOutOfBoundsException ex){
                    break;
                }
            }
            dao.desconectar();
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar ao banco de dados");
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtProd = new javax.swing.JTable();
        txtPesquisar = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnAtualizar = new javax.swing.JButton();
        btnAvancado = new javax.swing.JButton();

        setClosable(true);
        getContentPane().setLayout(null);

        jtProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Produto", "Categoria", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProd.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProd);
        if (jtProd.getColumnModel().getColumnCount() > 0) {
            jtProd.getColumnModel().getColumn(0).setResizable(false);
            jtProd.getColumnModel().getColumn(0).setPreferredWidth(50);
            jtProd.getColumnModel().getColumn(1).setResizable(false);
            jtProd.getColumnModel().getColumn(1).setPreferredWidth(280);
            jtProd.getColumnModel().getColumn(2).setResizable(false);
            jtProd.getColumnModel().getColumn(2).setPreferredWidth(170);
            jtProd.getColumnModel().getColumn(3).setResizable(false);
            jtProd.getColumnModel().getColumn(3).setPreferredWidth(117);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 76, 623, 355);

        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyPressed(evt);
            }
        });
        getContentPane().add(txtPesquisar);
        txtPesquisar.setBounds(12, 13, 432, 40);

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar);
        btnPesquisar.setBounds(451, 13, 90, 40);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 62, 620, 10);

        btnAtualizar.setText("Atualizar");
        btnAtualizar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnAtualizar.setMargin(new java.awt.Insets(2, 1, 2, 0));
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar);
        btnAtualizar.setBounds(550, 40, 70, 20);

        btnAvancado.setText("Avançado");
        btnAvancado.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnAvancado.setMargin(new java.awt.Insets(2, 1, 2, 0));
        btnAvancado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAvancado);
        btnAvancado.setBounds(550, 10, 70, 20);

        setBounds(0, 0, 639, 461);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) jtProd.getModel();
        int l = 0;
        
        while(l < tableModel.getRowCount()){
            tableModel.removeRow(l);
        }
        prencherTabela();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        ProdutoDao dao = new ProdutoDao();
        ArrayList<Produto> lista;
        DefaultTableModel tableModel = (DefaultTableModel) jtProd.getModel();
        
        if(txtPesquisar.getText().equalsIgnoreCase("")){
            btnAtualizar.doClick();
        }else{
            boolean status = dao.conectar();
            int pos = 0, linha = 0;
            
            if(status){
                lista = dao.buscar(txtPesquisar.getText());
                while(linha < tableModel.getRowCount()){
                    tableModel.removeRow(linha);
                }
                while(true){
                    try{
                        tableModel.addRow(new Object[] {
                            lista.get(pos++),
                            lista.get(pos++),
                            lista.get(pos++),
                            lista.get(pos++),
                        });
                    }catch(IndexOutOfBoundsException ex){
                        break;
                    }
                }
            }
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnAvancadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancadoActionPerformed
        TelaAvancado avacado = new TelaAvancado(btnAtualizar);
        avacado.setVisible(true);
    }//GEN-LAST:event_btnAvancadoActionPerformed

    private void txtPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnPesquisar.doClick();
        }
    }//GEN-LAST:event_txtPesquisarKeyPressed

    private void jtProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdMouseClicked
        if(evt.getClickCount() == 2){
            DefaultTableModel tableModel = (DefaultTableModel) jtProd.getModel();
            TelaAvancado avancado = new TelaAvancado(btnAtualizar, Integer.parseInt(jtProd.getValueAt(jtProd.getSelectedRow(), 0).toString()));
            avancado.setVisible(true);
        }
    }//GEN-LAST:event_jtProdMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnAvancado;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtProd;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
