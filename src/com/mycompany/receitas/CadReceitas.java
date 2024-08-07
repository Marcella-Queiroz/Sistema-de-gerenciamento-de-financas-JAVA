package com.mycompany.receitas;

import com.mycompany.categoria.CadCategoria;
import com.mycompany.categoria.ListCategoria;
import com.mycompany.dao.DaoTipo_Categoria;
import com.mycompany.dao.DaoReceitas;
import com.mycompany.utilidades.Formularios;
import com.mycompany.utilidades.DadosTemporarios;
import com.mycompany.utilidades.Constantes;
import com.mycompany.modelo.ModReceitas;
import com.mycompany.utilidades.MyFormatter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class CadReceitas extends javax.swing.JFrame {

    public CadReceitas() {
        initComponents();
        
        if(!existeDadosTemporarios()){
            DaoReceitas daoReceitas = new DaoReceitas();
            
            int id = daoReceitas.buscarProximoId();
            if(id>=0)
                jtfIdReceitas.setText(String.valueOf(id));
            
            btnSalvar2.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir2.setVisible(false);
            jtfIdReceitas.setText(String.valueOf(daoReceitas.buscarProximoId()));
            
        }else{
            btnSalvar2.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir2.setVisible(true);
        }   
        DaoReceitas daoReceitas = new DaoReceitas();
        
        jtfIdReceitas.setEnabled(false);
        
        try{
            ResultSet resultSet = new DaoTipo_Categoria().listarTodosPorIdCategoria(1);
        
            while(resultSet.next()){
                JcbCategoria.addItem(resultSet.getString("Nome"));
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        jtfIdCategoria.setVisible(false);
        
        setLocationRelativeTo(null);
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

        public void inserir() {
        DaoReceitas daoReceitas = new DaoReceitas();

        int categoriaId = Integer.parseInt(jtfIdCategoria.getText());
        String receitas = jtfReceita.getText();
        Double valor = Double.valueOf(jtfValor.getText());
        String Data_de_Lancamento = jtfDtLançamento.getText();

        
            // Converta a data de lançamento para o formato do banco de dados (YYYY-MM-DD)
            String dataFormatada = MyFormatter.formatDate(Data_de_Lancamento, "dd/MM/yyyy", "yyyy-MM-dd");

            // Resto do seu código para inserir a receita...
            if (daoReceitas.inserir(categoriaId, receitas, valor, dataFormatada)) {
                JOptionPane.showMessageDialog(null, "Novo tipo de receita cadastrado! ");
                jtfReceita.setText("");
                jtfValor.setText("");
                jtfDtLançamento.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar a receita ");
            }

    }
        
    private void alterar(){        
        DaoReceitas daoReceitas = new DaoReceitas();

        String dataFormatada = MyFormatter.formatDate(jtfDtLançamento.getText(), "dd/MM/yyyy", "yyyy-MM-dd");

        if (daoReceitas.alterar(Integer.parseInt(jtfIdReceitas.getText()),Integer.parseInt(jtfIdCategoria.getText()), jtfReceita.getText(), Double.parseDouble(jtfValor.getText()), dataFormatada)){
            JOptionPane.showMessageDialog(null, " Alterado com sucesso! ");

            jtfIdReceitas.setText("");
            jtfReceita.setText("");  
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar a receita! ");
        }

        ((ListReceitas)Formularios.listReceitas).listarTodos();

        dispose();
    }
    private void excluir(){
        DaoReceitas daoReceitas = new DaoReceitas();         
        if (daoReceitas.excluir(Integer.parseInt(jtfIdReceitas.getText()))){
            JOptionPane.showMessageDialog(null, "Receita " + jtfReceita.getText() + " excluída com sucesso! ");
            
            jtfIdReceitas.setText("");
            jtfReceita.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a receita ! ");
        }
        
        ((ListReceitas) Formularios.listReceitas).listarTodos();
        
        dispose();
        
    }

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
        btnSalvar2 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        btnExcluir2 = new javax.swing.JButton();
        jtfLabelDtLancamento = new javax.swing.JLabel();
        jtfIdCategoria = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de receitas");
        setPreferredSize(new java.awt.Dimension(500, 500));
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

        JcbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcbCategoriaItemStateChanged(evt);
            }
        });
        JcbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcbCategoriaActionPerformed(evt);
            }
        });

        jtfLabelCategoria.setText("Categoria");

        btnSalvar2.setText("Salvar");
        btnSalvar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvar2ActionPerformed(evt);
            }
        });

        btnExcluir2.setText("Excluir");
        btnExcluir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluir2ActionPerformed(evt);
            }
        });

        jtfLabelDtLancamento.setText("Data de Lançamento");

        jtfIdCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIdCategoriaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("Editar categoria");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfLabelDespesa)
                            .addComponent(jtfLabelValor)
                            .addComponent(jtfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfLabelDtLancamento)
                            .addComponent(jtfDtLançamento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(444, 444, 444))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSalvar2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnExcluir2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtfLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfIdReceitas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtfLabelCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                            .addComponent(JcbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator4)
                            .addComponent(jSeparator3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
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
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar2)
                    .addComponent(btnExcluir2))
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

    private void btnSalvar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvar2ActionPerformed
       DaoReceitas daoReceitas = new DaoReceitas();
       if(btnSalvar2.getText() == Constantes.BTN_SALVAR_TEXT){
            inserir();
            
          jtfIdReceitas.setText(String.valueOf(daoReceitas.buscarProximoId()));
          jtfReceita.setText("");            
        }else if (btnSalvar2.getText() == Constantes.BTN_ALTERAR_TEXT){
             alterar();
            ((ListReceitas) Formularios.listReceitas).listarTodos();
           dispose();
        }
    
    }//GEN-LAST:event_btnSalvar2ActionPerformed

    private void btnExcluir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluir2ActionPerformed
        int escolha =
                JOptionPane.showConfirmDialog(null,
                        "Deseja realmente excluir a receita " + jtfReceita.getText() + "?");
        if (escolha == JOptionPane.YES_NO_OPTION)
            excluir();
    }//GEN-LAST:event_btnExcluir2ActionPerformed

    private void jtfIdCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIdCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIdCategoriaActionPerformed

    private void JcbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcbCategoriaItemStateChanged
        try{
            DaoTipo_Categoria daoCategoria = new DaoTipo_Categoria();



            ResultSet resultSet = daoCategoria.listarPorNome(JcbCategoria.getSelectedItem().toString());

            resultSet.next();
            

        
            jtfIdCategoria.setText(String.valueOf(resultSet.getInt("id")));
        }catch(SQLException e){}
    }//GEN-LAST:event_JcbCategoriaItemStateChanged

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if (Formularios.listCategoria == null)
        Formularios.listCategoria = new ListCategoria();
        
        Formularios.listCategoria.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadReceitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JcbCategoria;
    private javax.swing.JButton btnExcluir2;
    private javax.swing.JButton btnSalvar2;
    private javax.swing.JLabel jLabel1;
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
