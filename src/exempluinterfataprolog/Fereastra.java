package exempluinterfataprolog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

public class Fereastra extends javax.swing.JFrame {
    static Fereastra fereastra;
    static Results results;
    
    ConexiuneProlog conexiune;
    LinkedList<String> answers = new LinkedList<>();
    LinkedList<JToggleButton> toggles = new LinkedList<>();
    
    int fc = 100;
    boolean customFc = false;
    
    public Fereastra(String titlu) {
        super(titlu);
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(dim);
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setTitle("Witcher 3");
        UIManager.put("ToggleButton.select", Color.YELLOW);
        
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(this.getClass().getResource("/images/bg2.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setSize(dim);
        picLabel.setOpaque(true);
        picLabel.setLayout(null);
        this.add(picLabel);

        panMain.setOpaque(false);
        panAnswersPanel.setOpaque(false);
        answersScroll.setOpaque(false);
 
        answersScroll.setVisible(false);
        jQuestion.setVisible(false);
        btWhy.setVisible(false);
        btnPlus.setVisible(false);
        btnMinus.setVisible(false);
        lbFc.setVisible(false);
        lbFcAux.setVisible(false);
        
        fereastra = this;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfParametru = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaDebug = new javax.swing.JTextArea();
        tfInput = new javax.swing.JTextField();
        btIncarca = new javax.swing.JButton();
        btPorneste = new javax.swing.JButton();
        btConsulta = new javax.swing.JButton();
        btAuto = new javax.swing.JButton();
        panMain = new javax.swing.JPanel();
        answersScroll = new javax.swing.JScrollPane();
        panAnswersPanel = new javax.swing.JPanel();
        jQuestion = new javax.swing.JLabel();
        btWhy = new javax.swing.JButton();
        lbFcAux = new javax.swing.JLabel();
        btnPlus = new javax.swing.JButton();
        lbFc = new javax.swing.JLabel();
        btnMinus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1049, 479));

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

        btIncarca.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        btIncarca.setForeground(new java.awt.Color(153, 0, 0));
        btIncarca.setLabel("Incarca");
        btIncarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncarcaActionPerformed(evt);
            }
        });

        btPorneste.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        btPorneste.setForeground(new java.awt.Color(153, 0, 0));
        btPorneste.setText("Porneste");
        btPorneste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPornesteActionPerformed(evt);
            }
        });

        btConsulta.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        btConsulta.setForeground(new java.awt.Color(153, 0, 0));
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

        javax.swing.GroupLayout panAnswersPanelLayout = new javax.swing.GroupLayout(panAnswersPanel);
        panAnswersPanel.setLayout(panAnswersPanelLayout);
        panAnswersPanelLayout.setHorizontalGroup(
            panAnswersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        panAnswersPanelLayout.setVerticalGroup(
            panAnswersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
        );

        answersScroll.setViewportView(panAnswersPanel);

        jQuestion.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jQuestion.setForeground(new java.awt.Color(153, 0, 0));
        jQuestion.setText("Intrebare");

        btWhy.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        btWhy.setForeground(new java.awt.Color(153, 0, 0));
        btWhy.setText("De ce vrei sa stii?");
        btWhy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btWhyActionPerformed(evt);
            }
        });

        lbFcAux.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        lbFcAux.setForeground(new java.awt.Color(153, 0, 0));
        lbFcAux.setText("Factor de certitudine:");

        btnPlus.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        btnPlus.setForeground(new java.awt.Color(153, 0, 0));
        btnPlus.setText("+");
        btnPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusActionPerformed(evt);
            }
        });

        lbFc.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        lbFc.setForeground(new java.awt.Color(153, 0, 0));
        lbFc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFc.setText("100");

        btnMinus.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        btnMinus.setForeground(new java.awt.Color(153, 0, 0));
        btnMinus.setText("-");
        btnMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panMainLayout = new javax.swing.GroupLayout(panMain);
        panMain.setLayout(panMainLayout);
        panMainLayout.setHorizontalGroup(
            panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMainLayout.createSequentialGroup()
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbFcAux)
                            .addComponent(jQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(answersScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btWhy))
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbFc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panMainLayout.setVerticalGroup(
            panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMainLayout.createSequentialGroup()
                .addComponent(jQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lbFcAux)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbFc)
                        .addComponent(btnMinus))
                    .addComponent(btnPlus, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(answersScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btWhy))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(panMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btIncarca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btPorneste, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btConsulta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addComponent(tfInput, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfParametru, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAuto))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btIncarca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPorneste, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(panMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfParametru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okButton)
                    .addComponent(btAuto))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            answersScroll.setVisible(true);
            jQuestion.setVisible(true);
            btWhy.setVisible(true);
            btnPlus.setVisible(true);
            btnMinus.setVisible(true);
            lbFc.setVisible(true);
            lbFcAux.setVisible(true);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btConsultaActionPerformed

    
    
    private void btAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAutoActionPerformed
        String valoareParametru;
 
        try {
            valoareParametru = "[medie]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            valoareParametru = "[alba]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            valoareParametru = "[nu]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            valoareParametru = "[roscat]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            valoareParametru = "[nu_conteaza]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            valoareParametru = "[nu]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);   
            
            valoareParametru = "[nu_conteaza]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            valoareParametru = "[nu_conteaza]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            valoareParametru = "[nu]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            valoareParametru = "[nu]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            valoareParametru = "[nu]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            valoareParametru = "[nu_conteaza]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            valoareParametru = "[nu]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            valoareParametru = "[nu_conteaza]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
            valoareParametru = "[nu_conteaza]";
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAutoActionPerformed

    private void btWhyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btWhyActionPerformed
        try {
            String comanda = "[de_ce]";
            conexiune.expeditor.trimiteMesajSicstus(comanda);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btWhyActionPerformed

    private void btnPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlusActionPerformed
        fc += 10;
        if(fc > 100) fc = 100;
        if(!customFc) customFc = true;
        lbFc.setText(String.valueOf(fc));
    }//GEN-LAST:event_btnPlusActionPerformed

    private void btnMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinusActionPerformed
        fc -= 10;
        if(fc < 0) fc = 0;
        if(!customFc) customFc = true;
        lbFc.setText(String.valueOf(fc));
    }//GEN-LAST:event_btnMinusActionPerformed

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
    
    public void setQuestion(String question){
        jQuestion.setText(question);
    }
    
    public void generateAnswers(){
        int maxWidth = 0;
        
        for(int i = 0; i < answers.size(); i++){
            if(answers.get(i).length() * 3 > maxWidth) maxWidth = answers.get(i).length() * 3;
        }
        
        GridLayout layout = new GridLayout(answers.size(), 0, 10, 10);
        panAnswersPanel.setLayout(layout);
        
        ButtonGroup jbtGroup = new ButtonGroup();
        for(int i = 0; i < answers.size(); i++){
            if(!answers.get(i).equals("")){
                JToggleButton toggle = new JToggleButton();
                toggle.setVisible(true);
                toggle.setText(answers.get(i));
                toggle.setName("tog" + answers.get(i));
                toggle.setSize(maxWidth, 5);
                
                toggles.push(toggle);
                jbtGroup.add(toggle);
                panAnswersPanel.add(toggle);
            }
        }
        
        JButton btnSend = new JButton("Am raspuns la intrebare");
        btnSend.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    boolean hasSent = false;
                    String message = "";
                    for(int i = 0; i < toggles.size(); i++){
                        if(toggles.get(i).isSelected()){
                            message = "[" + toggles.get(i).getText();
                            message += customFc ? ",fc," + fc + ".0" : "";
                            message += "]";
                            hasSent = true;
                        }
                    }
                    
                    if(!hasSent){
                        JOptionPane.showMessageDialog(fereastra, "Va rugam sa selectati un raspuns!");
                    }
                    if(hasSent){
                        answers.clear();
                        toggles.clear();
                        panAnswersPanel.removeAll();
                        panAnswersPanel.revalidate();
                        panAnswersPanel.repaint();
                        conexiune.expeditor.trimiteMesajSicstus(message);
                        
                        customFc = false;
                        fc = 100;
                        lbFc.setText(String.valueOf(fc));
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnSend.setVisible(true);
        panAnswersPanel.add(btnSend);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane answersScroll;
    private javax.swing.JButton btAuto;
    private javax.swing.JButton btConsulta;
    private javax.swing.JButton btIncarca;
    private javax.swing.JButton btPorneste;
    private javax.swing.JButton btWhy;
    private javax.swing.JButton btnMinus;
    private javax.swing.JButton btnPlus;
    private javax.swing.JLabel jQuestion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbFc;
    private javax.swing.JLabel lbFcAux;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel panAnswersPanel;
    private javax.swing.JPanel panMain;
    private javax.swing.JTextArea textAreaDebug;
    private javax.swing.JTextField tfInput;
    private javax.swing.JTextField tfParametru;
    // End of variables declaration//GEN-END:variables
}
