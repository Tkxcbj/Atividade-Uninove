
package SubTelas.ProdTelas;

import Commun.TextPrompt;
import Dao.ProdutoDao;
import Produto.Produto;
import java.util.ArrayList;
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
    
public void prencherTabela() {
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
        getContentPane().add(txtPesquisar);
        txtPesquisar.setBounds(12, 13, 432, 40);

        btnPesquisar.setText("Pesquisar");
        getContentPane().add(btnPesquisar);
        btnPesquisar.setBounds(451, 13, 90, 40);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 62, 620, 10);

        setBounds(0, 0, 639, 461);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtProd;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
