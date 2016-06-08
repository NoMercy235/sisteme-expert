package exempluinterfataprolog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Fereastra extends javax.swing.JFrame {
    static Fereastra fereastra;
    static Results results;
    
    ConexiuneProlog conexiune;
    LinkedList<String> answers = new LinkedList<>();
    LinkedList<JToggleButton> toggles = new LinkedList<>();
    LinkedList<JLabel> labels = new LinkedList<>();
    
    int fc = 100;
    boolean customFc = false;
    
    public Fereastra(String titlu) {
        super(titlu);
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(dim);
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setTitle("Witcher 3");
        Incarca.setEnabled(true);
        Consulta.setEnabled(true);
        Reset.setEnabled(true);
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
       // panMeniu.setOpaque(false);
        UIManager.put("ToggleButton.select", Color.YELLOW);
        
        panIntrebSiRasp.setVisible(false);
        intrebareSiRaspunsDat.setVisible(false);
        panCertitudine.setVisible(false);
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

        jFileChooser1 = new javax.swing.JFileChooser();
        tfParametru = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaDebug = new javax.swing.JTextArea();
        btAuto = new javax.swing.JButton();
        panMain = new javax.swing.JPanel();
        lbFcAux = new javax.swing.JLabel();
        jQuestion = new javax.swing.JLabel();
        panCertitudine = new javax.swing.JPanel();
        btnMinus = new javax.swing.JButton();
        lbFc = new javax.swing.JLabel();
        btnPlus = new javax.swing.JButton();
        panAns = new javax.swing.JPanel();
        btWhy = new javax.swing.JButton();
        answersScroll = new javax.swing.JScrollPane();
        panAnswersPanel = new javax.swing.JPanel();
        intrebareSiRaspunsDat = new javax.swing.JScrollPane();
        panIntrebSiRasp = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        Meniu = new javax.swing.JMenu();
        Incarca = new javax.swing.JMenuItem();
        Consulta = new javax.swing.JMenuItem();
        Reset = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1049, 479));

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        textAreaDebug.setColumns(20);
        textAreaDebug.setRows(5);
        jScrollPane1.setViewportView(textAreaDebug);

        btAuto.setText("Auto");
        btAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAutoActionPerformed(evt);
            }
        });

        lbFcAux.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        lbFcAux.setForeground(new java.awt.Color(153, 0, 0));
        lbFcAux.setText("Factor de certitudine:");

        jQuestion.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jQuestion.setForeground(new java.awt.Color(153, 0, 0));
        jQuestion.setText("Intrebare");

        panCertitudine.setLayout(new javax.swing.BoxLayout(panCertitudine, javax.swing.BoxLayout.LINE_AXIS));

        btnMinus.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        btnMinus.setForeground(new java.awt.Color(153, 0, 0));
        btnMinus.setText("-");
        btnMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinusActionPerformed(evt);
            }
        });
        panCertitudine.add(btnMinus);

        lbFc.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        lbFc.setForeground(new java.awt.Color(153, 0, 0));
        lbFc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFc.setText("100");
        panCertitudine.add(lbFc);

        btnPlus.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        btnPlus.setForeground(new java.awt.Color(153, 0, 0));
        btnPlus.setText("+");
        btnPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusActionPerformed(evt);
            }
        });
        panCertitudine.add(btnPlus);

        btWhy.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        btWhy.setForeground(new java.awt.Color(153, 0, 0));
        btWhy.setText("De ce vrei sa stii?");
        btWhy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btWhyActionPerformed(evt);
            }
        });

        answersScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout panAnswersPanelLayout = new javax.swing.GroupLayout(panAnswersPanel);
        panAnswersPanel.setLayout(panAnswersPanelLayout);
        panAnswersPanelLayout.setHorizontalGroup(
            panAnswersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 257, Short.MAX_VALUE)
        );
        panAnswersPanelLayout.setVerticalGroup(
            panAnswersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );

        answersScroll.setViewportView(panAnswersPanel);

        intrebareSiRaspunsDat.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout panIntrebSiRaspLayout = new javax.swing.GroupLayout(panIntrebSiRasp);
        panIntrebSiRasp.setLayout(panIntrebSiRaspLayout);
        panIntrebSiRaspLayout.setHorizontalGroup(
            panIntrebSiRaspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );
        panIntrebSiRaspLayout.setVerticalGroup(
            panIntrebSiRaspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        intrebareSiRaspunsDat.setViewportView(panIntrebSiRasp);

        javax.swing.GroupLayout panAnsLayout = new javax.swing.GroupLayout(panAns);
        panAns.setLayout(panAnsLayout);
        panAnsLayout.setHorizontalGroup(
            panAnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAnsLayout.createSequentialGroup()
                .addGroup(panAnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panAnsLayout.createSequentialGroup()
                        .addComponent(answersScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btWhy, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                    .addComponent(intrebareSiRaspunsDat, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        panAnsLayout.setVerticalGroup(
            panAnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAnsLayout.createSequentialGroup()
                .addGroup(panAnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(answersScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panAnsLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(btWhy)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(intrebareSiRaspunsDat, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panMainLayout = new javax.swing.GroupLayout(panMain);
        panMain.setLayout(panMainLayout);
        panMainLayout.setHorizontalGroup(
            panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addComponent(panCertitudine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addComponent(lbFcAux)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(panMainLayout.createSequentialGroup()
                .addComponent(panAns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panMainLayout.setVerticalGroup(
            panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbFcAux)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panCertitudine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Meniu.setText("Meniu");
        Meniu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeniuActionPerformed(evt);
            }
        });

        Incarca.setText("Incarca");
        Incarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IncarcaActionPerformed(evt);
            }
        });
        Meniu.add(Incarca);

        Consulta.setText("Consulta");
        Consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaActionPerformed(evt);
            }
        });
        Meniu.add(Consulta);

        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });
        Meniu.add(Reset);

        menuBar.add(Meniu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(panMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfParametru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okButton)
                    .addComponent(btAuto))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String valoareParametru= "[" + tfParametru.getText() + "]";
        tfParametru.setText("");
        try {
            conexiune.expeditor.trimiteMesajSicstus(valoareParametru);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_okButtonActionPerformed

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

    private void MeniuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeniuActionPerformed
        try {    
//            String comanda = "comanda(incarca('F:/NgenH/Projects/Prolog/ExempluInterfataProlog/my_project/my_projectmy_rules.txt'))";
//            String comanda = "comanda(incarca('C:/Users/Izabela/Desktop/prologProiect/sisteme-expert/my_project'))";
            String comanda = "comanda(incarca('C:/Users/AlexandruFlorian/Desktop/Sisteme expert/sisteme-expert/my_project'))";
            conexiune.expeditor.trimiteMesajSicstus(comanda);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MeniuActionPerformed

    private void ConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaActionPerformed
       
        try {
            String comanda = "comanda(consulta)";
            conexiune.expeditor.trimiteMesajSicstus(comanda);
            panAns.setOpaque(false);
            panAnswersPanel.setOpaque(false);
            answersScroll.setOpaque(false);
            panMain.setOpaque(false);
            intrebareSiRaspunsDat.setVisible(true);
            panIntrebSiRasp.setVisible(true);
            panIntrebSiRasp.setOpaque(false);
            intrebareSiRaspunsDat.setOpaque(false);
            panCertitudine.setOpaque(false);
            panCertitudine.setVisible(true);
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
        Consulta.setEnabled(false);
    }//GEN-LAST:event_ConsultaActionPerformed

    private void IncarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IncarcaActionPerformed
        try {    
//            String comanda = "comanda(incarca('F:/NgenH/Projects/Prolog/ExempluInterfataProlog/my_project/my_projectmy_rules.txt'))";
            String comanda = "comanda(incarca('C:/Users/AlexandruFlorian/Desktop/Sisteme expert/sisteme-expert/my_project'))";
            conexiune.expeditor.trimiteMesajSicstus(comanda);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
        Incarca.setEnabled(false);
    }//GEN-LAST:event_IncarcaActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
       Incarca.setEnabled(true);
       Consulta.setEnabled(true);
       String comanda = "comanda(iesire('C:/Users/Izabela/Desktop/prologProiect/sisteme-expert/my_project'))";
    }//GEN-LAST:event_ResetActionPerformed

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
        
        BoxLayout layout = new BoxLayout(panAnswersPanel, BoxLayout.Y_AXIS);
        panAnswersPanel.setLayout(layout);
        panAnswersPanel.setMinimumSize(
                new Dimension(
                    panAnswersPanel.getSize().width,
                    panAnswersPanel.getSize().height
                )
        );
        panAnswersPanel.setMaximumSize(
                new Dimension(
                    panAnswersPanel.getSize().width,
                    panAnswersPanel.getSize().height
                )
        );
        panAnswersPanel.setBackground(new Color(0, 0, 0, 0));
        
        
        BoxLayout layout2 = new BoxLayout(panIntrebSiRasp, BoxLayout.Y_AXIS);
        panIntrebSiRasp.setLayout(layout2);
        
        ButtonGroup jbtGroup = new ButtonGroup();
        for(int i = 0; i < answers.size(); i++){
            if(!answers.get(i).equals("")){
                final JToggleButton toggle = new JToggleButton();
                toggle.setVisible(true);
                toggle.setText(answers.get(i));
                toggle.setName("tog" + answers.get(i));
                toggle.setSize(maxWidth, 5);
                SwingUtilities.updateComponentTreeUI(toggle);
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
                         
                            JLabel lastQuestion = new JLabel();
                            JLabel answerGived = new JLabel();
                            JSeparator sepIntrSiRasp = new JSeparator();
                            
                            lastQuestion.setText(jQuestion.getText());
                            lastQuestion.setVisible(true);
                            answerGived.setVisible(true);
                            labels.push(answerGived);
                            
                            answerGived.setText(message.substring(1, message.length()-1));
                            answerGived.setName("l" + toggles.get(i).getText());
                            
                            panIntrebSiRasp.add(lastQuestion);
                            panIntrebSiRasp.add(answerGived);
                            panIntrebSiRasp.add(sepIntrSiRasp);
                            intrebareSiRaspunsDat.scrollRectToVisible(sepIntrSiRasp.getVisibleRect());
                            
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
        panAnswersPanel.revalidate();
        panAnswersPanel.repaint();
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Consulta;
    private javax.swing.JMenuItem Incarca;
    private javax.swing.JMenu Meniu;
    private javax.swing.JMenuItem Reset;
    private javax.swing.JScrollPane answersScroll;
    private javax.swing.JButton btAuto;
    private javax.swing.JButton btWhy;
    private javax.swing.JButton btnMinus;
    private javax.swing.JButton btnPlus;
    private javax.swing.JScrollPane intrebareSiRaspunsDat;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jQuestion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbFc;
    private javax.swing.JLabel lbFcAux;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel panAns;
    private javax.swing.JPanel panAnswersPanel;
    private javax.swing.JPanel panCertitudine;
    private javax.swing.JPanel panIntrebSiRasp;
    private javax.swing.JPanel panMain;
    private javax.swing.JTextArea textAreaDebug;
    private javax.swing.JTextField tfParametru;
    // End of variables declaration//GEN-END:variables
}
