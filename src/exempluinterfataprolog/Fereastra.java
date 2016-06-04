package exempluinterfataprolog;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fereastra extends javax.swing.JFrame {

    ConexiuneProlog conexiune;
    public Fereastra(String titlu) {
        super(titlu);
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupBtn = new javax.swing.ButtonGroup();
        tfParametru = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaDebug = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        tfInput = new javax.swing.JTextField();
        btIncarca = new javax.swing.JButton();
        btPorneste = new javax.swing.JButton();
        btConsulta = new javax.swing.JButton();
        btAuto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tfParametru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfParametruActionPerformed(evt);
            }
        });

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        textAreaDebug.setColumns(20);
        textAreaDebug.setRows(5);
        jScrollPane1.setViewportView(textAreaDebug);

        jButton1.setText("Salut");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btIncarca.setLabel("Incarca");
        btIncarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncarcaActionPerformed(evt);
            }
        });

        btPorneste.setText("Porneste");
        btPorneste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPornesteActionPerformed(evt);
            }
        });

        btConsulta.setText("Consulta");
        btConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultaActionPerformed(evt);
            }
        });

        btAuto.setText("Auto");
        btAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(tfParametru, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(okButton)
                        .addGap(27, 27, 27)
                        .addComponent(btAuto))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(103, 103, 103)
                .addComponent(jButton1)
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btIncarca, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(tfInput)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btPorneste, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfParametru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okButton)
                    .addComponent(jButton1)
                    .addComponent(tfInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAuto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btIncarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPorneste)
                    .addComponent(btConsulta))
                .addContainerGap(380, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tfInput.getAccessibleContext().setAccessibleName("");
        btIncarca.getAccessibleContext().setAccessibleName("btIncarca");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfParametruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfParametruActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfParametruActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String valoareParametru= "[" + tfParametru.getText() + "]";
        tfParametru.setText("");
        try {
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            PipedOutputStream pos= conexiune.expeditor.getPipedOutputStream();
            PrintStream ps = new PrintStream(pos);
            ps.println("salut.");
            ps.flush();
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btIncarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncarcaActionPerformed
        String input = tfInput.getText();
        tfInput.setText("");
        try {
//            String comanda = "comanda(incarca('F:/NgenH/Projects/Prolog/ExempluInterfataProlog/my_project/my_projectmy_rules.txt'))";
            String comanda = "comanda(incarca('C:/Users/AlexandruFlorian/Desktop/Sisteme expert/sisteme-expert/my_project'))";
            conexiune.expeditor.trimiteMesajSicstus(comanda);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btIncarcaActionPerformed

    private void btPornesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPornesteActionPerformed
        try {
            String comanda = "comanda(pornire)";
            conexiune.expeditor.trimiteMesajSicstus(comanda);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btPornesteActionPerformed

    private void btConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultaActionPerformed
        try {
            String comanda = "comanda(consulta)";
            conexiune.expeditor.trimiteMesajSicstus(comanda);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btConsultaActionPerformed

    
    
    private void btAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAutoActionPerformed
        String valoareParametru;
 
        try {
            valoareParametru = "[nu]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            
            valoareParametru = "[nimic]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            
            valoareParametru = "[nu]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            
            valoareParametru = "[nespecificat]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            
            valoareParametru = "[campie]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            
            
            valoareParametru = "[nu]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            
            
            valoareParametru = "[nu]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            
            valoareParametru = "[da]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            
            valoareParametru = "[alb]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            
            valoareParametru = "[oricare]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            
            valoareParametru = "[alta]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            
            valoareParametru = "[omnivor]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            
            valoareParametru = "[da]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            
            valoareParametru = "[vraji]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            
            valoareParametru = "[nu_foloseste]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAutoActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Fereastra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fereastra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fereastra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fereastra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fereastra("Verificare").setVisible(true);
            }
        });
    }

    public javax.swing.JTextArea getDebugTextArea(){
        return textAreaDebug;
    }
    
    
    public void setConexiune(ConexiuneProlog _conexiune){
        conexiune=_conexiune;
    }
    
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAuto;
    private javax.swing.JButton btConsulta;
    private javax.swing.JButton btIncarca;
    private javax.swing.JButton btPorneste;
    private javax.swing.ButtonGroup grupBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okButton;
    private javax.swing.JTextArea textAreaDebug;
    private javax.swing.JTextField tfInput;
    private javax.swing.JTextField tfParametru;
    // End of variables declaration//GEN-END:variables
}
