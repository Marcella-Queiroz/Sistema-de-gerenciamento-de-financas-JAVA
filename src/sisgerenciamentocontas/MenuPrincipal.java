package sisgerenciamentocontas;

import com.mycompany.despesas.CadDespesas;
import com.mycompany.despesas.ListDespesas;
import com.mycompany.metas.CadMetas;
import com.mycompany.metas.ListMetas;
import com.mycompany.receitas.CadReceitas;
import com.mycompany.receitas.ListReceitas;
import com.mycompany.tipoCategoria.CadTipoCategoria;
import com.mycompany.utilidades.BancoDeDadosMySql;
import com.mycompany.utilidades.Formularios;
import javax.swing.JOptionPane;
import com.mycompany.tipoCategoria.ListTipoCategoria;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
        
        if(!BancoDeDadosMySql.conectar()){
            JOptionPane.showMessageDialog(null, "Não foi possível se conectar ao banco de dados. O sistema será finalizado.");
            System.exit(0);   
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxCadastrar = new javax.swing.JComboBox<>();
        jComboBoxListar = new javax.swing.JComboBox<>();
        jComboBoxDarBaixa = new javax.swing.JComboBox<>();
        Metas = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setBackground(new java.awt.Color(80, 82, 84));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Gerenciamento de Contas");

        jSeparator1.setBackground(new java.awt.Color(80, 82, 84));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("---IMAGEM---");
        jLabel2.setBorder(new javax.swing.border.MatteBorder(null));

        jComboBoxCadastrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cadastrar", "Receitas", "Despesas", "Metas", "Tipo de Categoria" }));
        jComboBoxCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCadastrarActionPerformed(evt);
            }
        });

        jComboBoxListar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Listar", "Receitas", "Despesas", "Tipo Categoria", "Metas" }));
        jComboBoxListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxListarActionPerformed(evt);
            }
        });

        jComboBoxDarBaixa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dar Baixa", "Despesas" }));
        jComboBoxDarBaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDarBaixaActionPerformed(evt);
            }
        });

        Metas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Metas", " ", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jComboBoxCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Metas, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxListar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxDarBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jComboBoxCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jComboBoxListar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Metas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxDarBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxDarBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDarBaixaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDarBaixaActionPerformed

    private void jComboBoxCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCadastrarActionPerformed
        switch (jComboBoxCadastrar.getSelectedIndex()) {
            case 1:
                if (Formularios.cadReceitas == null)
                    Formularios.cadReceitas = new CadReceitas();

                Formularios.cadReceitas.setVisible(true);
                
                break;
            case 2:
                if (Formularios.cadDespesas == null)
                    Formularios.cadDespesas = new CadDespesas();

                Formularios.cadDespesas.setVisible(true);
                
                break;
            case 3:
                if (Formularios.cadMetas == null)
                    Formularios.cadMetas = new CadMetas();

                Formularios.cadMetas.setVisible(true);
                
                break;
            case 4:
                if (Formularios.cadTipoCategoria == null)
                    Formularios.cadTipoCategoria = new CadTipoCategoria();

                Formularios.cadTipoCategoria.setVisible(true);
                
                break;   
        }
    }//GEN-LAST:event_jComboBoxCadastrarActionPerformed

    private void jComboBoxListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxListarActionPerformed
        switch (jComboBoxListar.getSelectedIndex()) {
            case 1:
                if (Formularios.listReceitas == null)
                    Formularios.listReceitas = new ListReceitas();
                
                Formularios.listReceitas.setVisible(true);
                
                break;                
            case 2:
                if (Formularios.listDespesas == null)
                    Formularios.listDespesas = new ListDespesas();
                
                Formularios.listDespesas.setVisible(true);
                
                break;
                
            case 3:
                if (Formularios.listTipoCategoria == null)
                    Formularios.listTipoCategoria = new ListTipoCategoria();

                Formularios.listTipoCategoria.setVisible(true);
                
                break;
            case 4:
                if (Formularios.listMetas == null)
                    Formularios.listMetas = new ListMetas();

                Formularios.listMetas.setVisible(true);
        }
    }//GEN-LAST:event_jComboBoxListarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Metas;
    private javax.swing.JComboBox<String> jComboBoxCadastrar;
    private javax.swing.JComboBox<String> jComboBoxDarBaixa;
    private javax.swing.JComboBox<String> jComboBoxListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
