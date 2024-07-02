/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.receitas;

import com.mycompany.dao.DaoReceitas;
import com.mycompany.utilidades.Formularios;
import com.mycompany.utilidades.DadosTemporarios;
import com.mycompany.utilidades.Constantes;
import com.mycompany.dao.DaoCategoria;
import com.mycompany.modelo.ModReceitas;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author marcella.1963
 */
public class CadReceitas extends javax.swing.JFrame {

    public CadReceitas() {
        initComponents();
        
        if(!existeDadosTemporarios()){
            DaoReceitas daoReceitas = new DaoReceitas();
            
            int id = daoReceitas.buscarProximoId();
            if(id>=0)
                jtfIdReceitas.setText(String.valueOf(id));
            
            btnSalvar.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
            jtfIdReceitas.setText(String.valueOf(daoReceitas.buscarProximoId()));
            
        }else{
            btnSalvar.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }   
        DaoReceitas daoReceitas = new DaoReceitas();
        
        jtfIdReceitas.setEnabled(false);
        
        try{
            ResultSet resultSet = new DaoReceitas().ListarTodos();
        
            while(resultSet.next()){
                JcbCategoria.addItem(resultSet.getString("Nome"));
                
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        jtfIdReceitas.setVisible(false);
    }
    public Boolean existeDadosTemporarios(){
        if (DadosTemporarios.tempObject instanceof ModReceitas){
        int id =((ModReceitas)DadosTemporarios.tempObject).getId();
        String nome = ((ModReceitas)DadosTemporarios.tempObject).getNome();
        double valor = ((ModReceitas) DadosTemporarios.tempObject).getValor();
        String data_de_lançamento = ((ModReceitas) DadosTemporarios.tempObject).getDataDeLançamento();
        
        
        jtfIdReceitas.setText(String.valueOf(id));
        jtfReceita.setText(nome);
        jtfValor.setText(String.valueOf(valor));
        jtfDtLançamento.setText(data_de_lançamento);
        
        
        DadosTemporarios.tempObject = null;
        return true;
        
        }else
            return false;
    }
    private void inserir(){
        DaoReceitas daoReceitas = new DaoReceitas();

        int categoriaId = Integer.parseInt(jtfIdCategoria.getText());
        String receitas =jtfReceita.getText();
        Double valor = Double.valueOf(jtfValor.getText());
        String Data_de_Lançamento = jtfDtLançamento.getText();
        

        if (daoReceitas.inserir(categoriaId,receitas , valor, Data_de_Lançamento)){
            JOptionPane.showMessageDialog(null, "Novo tipo de depesa cadastrado! ");

            jtfIdCategoria.setText(String.valueOf(daoReceitas.buscarProximoId()));
            jtfReceita.setText("");

        }else{
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar a despesa");
          }
    
    }    
    private void alterar(){
            DaoReceitas daoReceitas = new DaoReceitas();
            
            if (daoReceitas.alterar(Integer.parseInt(jtfIdReceitas.getText()),Integer.parseInt(jtfIdCategoria.getText()), jtfReceita.getText(), Double.parseDouble(jtfValor.getText()), jtfDtLançamento.getText())){
                JOptionPane.showMessageDialog(null, " Alterado com sucesso! ");
                
                jtfIdReceitas.setText("");
                jtfReceita.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir a despesa! ");
        }
            ((ListReceitas)Formularios.listReceitas).listarTodos();
            
            dispose();
    }
    private void excluir(){
        DaoReceitas daoReceitas = new DaoReceitas();         
        if (daoReceitas.excluir(Integer.parseInt(jtfIdReceitas.getText()))){
            JOptionPane.showMessageDialog(null, "Despesa" + jtfReceita.getText() + " excluída com sucesso!");
            
            jtfIdReceitas.setText("");
            jtfReceita.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a !");
        }
        
        ((ListReceitas) Formularios.listDespesas).listarTodos();
        
        dispose();
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfIdReceitas = new javax.swing.JTextField();
        jtfLabelID = new javax.swing.JLabel();
        jtfLabelDespesa = new javax.swing.JLabel();
        jtfLabelValor = new javax.swing.JLabel();
        JcbCategoria = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        jtfReceita = new javax.swing.JTextField();
        jtfLabelCategoria = new javax.swing.JLabel();
        jtfDtLançamento = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jtfValor = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        btnSalvar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        btnExcluir = new javax.swing.JButton();
        jtfLabelDtLancamento = new javax.swing.JLabel();
        jtfIdCategoria = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jtfIdReceitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIdReceitasActionPerformed(evt);
            }
        });

        jtfLabelID.setText("ID");

        jtfLabelDespesa.setText("Receita");

        jtfLabelValor.setText("Valor");

        JcbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcbCategoriaActionPerformed(evt);
            }
        });

        jtfLabelCategoria.setText("Categoria");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");

        jtfLabelDtLancamento.setText("Data de Lançamento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator3)
                    .addComponent(jtfReceita)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfIdReceitas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfLabelCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                    .addComponent(JcbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfLabelDespesa)
                            .addComponent(jtfLabelValor)
                            .addComponent(jtfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfLabelDtLancamento)
                            .addComponent(jtfDtLançamento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 600, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtfLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfIdReceitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfLabelCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfLabelDespesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfLabelValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfLabelDtLancamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDtLançamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JcbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JcbCategoriaActionPerformed

    private void jtfIdReceitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIdReceitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIdReceitasActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.cadReceitas = null;
    }//GEN-LAST:event_formWindowClosed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
      // DaoReceitas daoReceitas = new DaoReceitas();
        
       // if(btnSalvar.getText() == Constantes.BTN_SALVAR_TEXT){
           // inserir();
            
          //jtfIdReceitas.setText(String.valueOf(daoReceitas.buscarProximoId());
         //  jtfReceita.setText("");            
      //  }else if (btnSalvar.getText() == Constantes.BTN_ALTERAR_TEXT){
           //  alterar();
            //((ListReceitas) Formularios.listReceitas).listarTodos();
           //dispose();
       // }
    //}                                         
    }//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(CadReceitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadReceitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadReceitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadReceitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadReceitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JcbCategoria;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JFormattedTextField jtfDtLançamento;
    private javax.swing.JTextField jtfIdCategoria;
    private javax.swing.JTextField jtfIdReceitas;
    private javax.swing.JLabel jtfLabelCategoria;
    private javax.swing.JLabel jtfLabelDespesa;
    private javax.swing.JLabel jtfLabelDtLancamento;
    private javax.swing.JLabel jtfLabelID;
    private javax.swing.JLabel jtfLabelValor;
    private javax.swing.JTextField jtfReceita;
    private javax.swing.JTextField jtfValor;
    // End of variables declaration//GEN-END:variables
}
