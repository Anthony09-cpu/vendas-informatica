package interfacevendas;

import dao.ProdutoDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import beans.Produto;
import javax.swing.JOptionPane;

public class FormVendas extends javax.swing.JFrame {

    private void preencheTabela() {
        ProdutoDAO vendasDAO = new ProdutoDAO();
        String nome = txtProduto.getText();
        List<Produto> listaVendas = vendasDAO.getVendas(nome);
        DefaultTableModel tabelaVendas = (DefaultTableModel) tblVendas.getModel();
        tabelaVendas.setNumRows(0);
        for (Produto p : listaVendas) {
            Object[] obj = new Object[]{
                p.getId(),
                 p.getNome(),
                  p.getValor(),
                   p.getQtd()
            };
            tabelaVendas.addRow(obj);
        }
    }

    public FormVendas() {
        initComponents();
        preencheTabela();
        txtTotal.setText("0.00");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendas = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jspQuantidades = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        txtProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produtos Disponiveis");
        setMaximumSize(new java.awt.Dimension(919, 500));
        setMinimumSize(new java.awt.Dimension(919, 515));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tela de vendas");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(381, 11, 162, 29);

        tblVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome do Produto", "Valor do Produto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVendas);
        if (tblVendas.getColumnModel().getColumnCount() > 0) {
            tblVendas.getColumnModel().getColumn(0).setMinWidth(50);
            tblVendas.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblVendas.getColumnModel().getColumn(0).setMaxWidth(50);
            tblVendas.getColumnModel().getColumn(1).setMinWidth(250);
            tblVendas.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblVendas.getColumnModel().getColumn(1).setMaxWidth(250);
            tblVendas.getColumnModel().getColumn(2).setMinWidth(150);
            tblVendas.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblVendas.getColumnModel().getColumn(2).setMaxWidth(150);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 92, 421, 390);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 64, 919, 10);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Selecione o Produto");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(441, 95, 157, 22);

        jspQuantidades.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jspQuantidades);
        jspQuantidades.setBounds(547, 142, 51, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(441, 444, 40, 22);

        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtTotal);
        txtTotal.setBounds(485, 441, 137, 28);

        btnAdicionar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionar);
        btnAdicionar.setBounds(627, 141, 105, 31);

        txtProduto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtProduto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtProdutoCaretUpdate(evt);
            }
        });
        txtProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(txtProduto);
        txtProduto.setBounds(602, 92, 264, 28);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quantidade:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(441, 145, 96, 22);

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome do Produto", "Quantidade", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblProdutos);
        if (tblProdutos.getColumnModel().getColumnCount() > 0) {
            tblProdutos.getColumnModel().getColumn(0).setMinWidth(50);
            tblProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblProdutos.getColumnModel().getColumn(0).setMaxWidth(50);
            tblProdutos.getColumnModel().getColumn(2).setMinWidth(75);
            tblProdutos.getColumnModel().getColumn(2).setPreferredWidth(75);
            tblProdutos.getColumnModel().getColumn(2).setMaxWidth(75);
            tblProdutos.getColumnModel().getColumn(3).setMinWidth(75);
            tblProdutos.getColumnModel().getColumn(3).setPreferredWidth(75);
            tblProdutos.getColumnModel().getColumn(3).setMaxWidth(75);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(441, 183, 452, 216);

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(791, 440, 83, 31);

        btnComprar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnComprar.setText("Efetuar venda");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        getContentPane().add(btnComprar);
        btnComprar.setBounds(632, 440, 141, 31);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfacevendas/fundo-preto-abstrato-da-grade-digital.jpg"))); // NOI18N
        jLabel5.setMaximumSize(new java.awt.Dimension(919, 500));
        jLabel5.setMinimumSize(new java.awt.Dimension(919, 500));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 920, 480);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if (tblVendas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um produto!");
            return;
        } else {
            int id = (int) tblVendas.getValueAt(tblVendas.getSelectedRow(), 0);
            String nomeProduto = (String) tblVendas.getValueAt(tblVendas.getSelectedRow(), 1);
            double valorProduto = (double) tblVendas.getValueAt(tblVendas.getSelectedRow(), 2);
            int qtd = Integer.parseInt(jspQuantidades.getValue().toString());
            double total = Double.parseDouble(txtTotal.getText());
            if (qtd < 1) {
                JOptionPane.showMessageDialog(rootPane, "Quantidade invalida - " + ((int) jspQuantidades.getValue()));
                return;
            }
            DefaultTableModel tabelaSacola = (DefaultTableModel) tblProdutos.getModel();

            Object[] obj = new Object[]{
                id,
                nomeProduto,
                qtd,
                (qtd * valorProduto)
            };
            tabelaSacola.addRow(obj);
            txtTotal.setText(Double.toString(total + (qtd * valorProduto)));
            txtProduto.setText("");
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        DefaultTableModel tabela = (DefaultTableModel) tblProdutos.getModel();
        if (tblProdutos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha!");
        } else {
            String nome = (String) tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 1);
            if (JOptionPane.showConfirmDialog(rootPane, "Confirmar exclusão desse produto: " + nome) == 0) {
                double total = Double.parseDouble(txtTotal.getText());
                total -= (double) tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 3);
                txtTotal.setText(Double.toString(total));
                tabela.removeRow(tblProdutos.getSelectedRow());
                JOptionPane.showMessageDialog(rootPane, "Produto retirado da sacola!");
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        DefaultTableModel tabelaVenda = (DefaultTableModel) tblProdutos.getModel();
        int rowCount = tabelaVenda.getRowCount();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        for (int row = 0; row < rowCount; row++) {
            Produto produto = new Produto();
            System.out.println("ID: " + tblProdutos.getValueAt(row, 0));
            System.out.println("QTD: " + tblProdutos.getValueAt(row, 2));
            produto.setId((int) tblProdutos.getValueAt(row, 0));
            produto.setQtd((int) tblProdutos.getValueAt(row, 2));
            produtoDAO.diminuir(produto);
        }
        JOptionPane.showMessageDialog(rootPane, "Compra concluída!");

        txtProduto.setText("");
        txtTotal.setText("");
        jspQuantidades.setValue(0);
        tabelaVenda.setRowCount(0);

        int x = JOptionPane.showConfirmDialog(rootPane,"Deseja fazer mais alguma compra??");
        if(x == 0){//sim
            
        }else if(x == 1){//não
            dispose();
        }else if(x == 2){//cancelar
            dispose();
        }
    }//GEN-LAST:event_btnComprarActionPerformed

    private void txtProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoActionPerformed

    }//GEN-LAST:event_txtProdutoActionPerformed

    private void txtProdutoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtProdutoCaretUpdate
        preencheTabela();
    }//GEN-LAST:event_txtProdutoCaretUpdate

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jspQuantidades;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTable tblVendas;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
