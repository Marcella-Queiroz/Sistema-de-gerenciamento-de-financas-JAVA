/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.Dar_Baixa;

import com.mycompany.dao.DaoDespesas;
import com.mycompany.despesas.CadDespesas;
import com.mycompany.modelo.ModDespesas;
import com.mycompany.utilidades.DadosTemporarios;
import com.mycompany.utilidades.Formularios;
import com.mycompany.utilidades.MyFormatter;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marcella.1963
 */
public class Dar_Baixa extends javax.swing.JFrame {

    /**
     * Creates new form Dar_Baixa
     */
    public Dar_Baixa() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodosBaixa();
        
        
    }
    
    public void listarTodosBaixa(){
    try{
        DefaultTableModel defaultTableModel = (DefaultTableModel) TableDar_Baixa.getModel();
        
        TableDar_Baixa.setModel(defaultTableModel);
        
        DaoDespesas daoDespesas = new DaoDespesas();
        
        ResultSet resultSet = daoDespesas.listarTodosBaixa();
        
        defaultTableModel.setRowCount(0);
        
        while(resultSet.next()){
            String id = resultSet.getString(1);
            String categoria_id = resultSet.getString(2);
            String nome = resultSet.getString(3);
            Double valor = resultSet.getDouble(4);
            String vencimento = resultSet.getString(5);
            String pagamento = resultSet.getString(6);
            
            String dataFormatada = "";
            String dataFormatada2 = "";
            try{
                dataFormatada = MyFormatter.formatDate(vencimento, "yyyy-MM-dd", "dd/MM/yyyy");
                dataFormatada2 = MyFormatter.formatDate(pagamento, "yyyy-MM-dd", "dd/MM/yyyy");
            }catch(Exception e){}
                
                defaultTableModel.addRow(new Object[]{id, categoria_id, nome, valor, dataFormatada, dataFormatada2});
            }
        
    }catch(Exception e ){
        System.out.println(e.getMessage());
    
        }
    }
    
    
    public void listarPorId(int pID){
    try{
        DefaultTableModel defaultTableModel = (DefaultTableModel) TableDar_Baixa.getModel();
        
        TableDar_Baixa.setModel(defaultTableModel);
        
        DaoDespesas daoDespesas = new DaoDespesas();
        
        ResultSet resultSet = daoDespesas.listarPorId(pID);
        
        defaultTableModel.setRowCount(0);
        
        while(resultSet.next()){
            String id = resultSet.getString(1);
            String categoria_id = resultSet.getString(2);
            String nome = resultSet.getString(3);
            Double valor = resultSet.getDouble(4);
            String vencimento = resultSet.getString(5);
            String pagamento = resultSet.getString(6);
            
            String dataFormatada = "";
            String dataFormatada2 = "";
            try{
                dataFormatada = MyFormatter.formatDate(vencimento, "yyyy-MM-dd", "dd/MM/yyyy");
                dataFormatada2 = MyFormatter.formatDate(pagamento, "yyyy-MM-dd", "dd/MM/yyyy");
            }catch(Exception e){}
                
                defaultTableModel.addRow(new Object[]{id, categoria_id, nome, valor, dataFormatada, dataFormatada2});
            }
        
    }catch(Exception e ){
        System.out.println(e.getMessage());
    
        }
    }
    public void listarPorNome(String pNome){
        try{
        DefaultTableModel defaultTableModel = (DefaultTableModel)TableDar_Baixa.getModel();
        
        TableDar_Baixa.setModel(defaultTableModel);
        
            DaoDespesas daoDespesas = new DaoDespesas();
            
            ResultSet resultSet = daoDespesas.ListarPorNome(pNome);
            
            defaultTableModel.setRowCount(0);
            while(resultSet.next()){
                String id = resultSet.getString(1);
                String categoria_id = resultSet.getString(2);
                String nome = resultSet.getNString(3);
                Double valor = resultSet.getDouble(4);
                String vencimento = resultSet.getString(5);
                String pagamento = resultSet.getString(6);
               String dataFormatada = "";
            String dataFormatada2 = "";
            try{
                dataFormatada = MyFormatter.formatDate(vencimento, "yyyy-MM-dd", "dd/MM/yyyy");
                dataFormatada2 = MyFormatter.formatDate(pagamento, "yyyy-MM-dd", "dd/MM/yyyy");
            }catch(Exception e){}
                
                defaultTableModel.addRow(new Object[]{id, categoria_id, nome, valor, dataFormatada, dataFormatada2});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableDar_Baixa = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dar Baixa");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        TableDar_Baixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Categoria", "Nome", "Valor", "Vencimento", "Pagamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableDar_Baixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDar_BaixaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableDar_Baixa);

        jButton1.setText("Buscar");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Id", "Nome", " " }));

        jButton2.setText("Salvar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.Dar_Baixa = null;
    }//GEN-LAST:event_formWindowClosed

    private void TableDar_BaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDar_BaixaMouseClicked
       if(evt.getClickCount() == 2){
           ModDespesas modDespesas = new ModDespesas();
           
            modDespesas.setId(Integer.parseInt(String.valueOf(TableDar_Baixa.getValueAt(TableDar_Baixa.getSelectedRow(), 0))));
            modDespesas.setCategoriaId(Integer.parseInt(String.valueOf(TableDar_Baixa.getValueAt(TableDar_Baixa.getSelectedRow(), 1))));
            modDespesas.setNome(String.valueOf(TableDar_Baixa.getValueAt(TableDar_Baixa.getSelectedRow(), 2)));
            modDespesas.setValor(Float.parseFloat(String.valueOf(TableDar_Baixa.getValueAt(TableDar_Baixa.getSelectedRow(), 3))));
           
            DadosTemporarios.tempObject = (ModDespesas) modDespesas;
            
            if(Formularios.cadDespesas == null){
                Formularios.cadDespesas = new CadDespesas();
                
            ((CadDespesas)Formularios.cadDespesas).existeDadosTemporarios();
                Formularios.cadDespesas.setVisible(true);
                Formularios.cadDespesas.setExtendedState(JFrame.NORMAL);
            }
       }
    }//GEN-LAST:event_TableDar_BaixaMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Dar_Baixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dar_Baixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dar_Baixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dar_Baixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dar_Baixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableDar_Baixa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
