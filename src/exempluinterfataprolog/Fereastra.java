package exempluinterfataprolog;

import static exempluinterfataprolog.ExempluInterfataProlog.PORT;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
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
    static DeCe dece;
    
    ConexiuneProlog conexiune;
    LinkedList<String> answers = new LinkedList<>();
    LinkedList<JToggleButton> toggles = new LinkedList<>();
    LinkedList<JLabel> labels = new LinkedList<>();
    
    int fc = 100;
    boolean customFc = false;
    boolean bHasAsked = false;
    
    public Fereastra(String titlu) {
        super(titlu);
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(dim);
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        Incarca.setEnabled(true);
        Consulta.setEnabled(false);
        Reset.setEnabled(false);
        btnCloseProlog.setEnabled(false);
        
        bIncarca.setEnabled(true);
        bConsulta.setEnabled(false);
        bReset.setEnabled(false);
        
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
        
        clearAll();
        
//        fereastra = this;
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
        jQuestion = new javax.swing.JLabel();
        lbFcAux = new javax.swing.JLabel();
        panCertitudine = new javax.swing.JPanel();
        btnMinus = new javax.swing.JButton();
        lbFc = new javax.swing.JLabel();
        btnPlus = new javax.swing.JButton();
        panAns = new javax.swing.JPanel();
        answersScroll = new javax.swing.JScrollPane();
        panAnswersPanel = new javax.swing.JPanel();
        intrebareSiRaspunsDat = new javax.swing.JScrollPane();
        panIntrebSiRasp = new javax.swing.JPanel();
        btWhy = new javax.swing.JButton();
        panMeniu = new javax.swing.JPanel();
        bIncarca = new javax.swing.JButton();
        bConsulta = new javax.swing.JButton();
        bReset = new javax.swing.JButton();
        btnCloseProlog = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        Meniu = new javax.swing.JMenu();
        Incarca = new javax.swing.JMenuItem();
        Consulta = new javax.swing.JMenuItem();
        Reset = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jQuestion.setFont(new java.awt.Font("Monotype Corsiva", 1, 48)); // NOI18N
        jQuestion.setForeground(new java.awt.Color(153, 0, 0));
        jQuestion.setText("Intrebare");

        lbFcAux.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        lbFcAux.setForeground(new java.awt.Color(153, 0, 0));
        lbFcAux.setText("Factor de certitudine:");

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

        answersScroll.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        answersScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout panAnswersPanelLayout = new javax.swing.GroupLayout(panAnswersPanel);
        panAnswersPanel.setLayout(panAnswersPanelLayout);
        panAnswersPanelLayout.setHorizontalGroup(
            panAnswersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );
        panAnswersPanelLayout.setVerticalGroup(
            panAnswersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );

        answersScroll.setViewportView(panAnswersPanel);

        intrebareSiRaspunsDat.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panIntrebSiRasp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panIntrebSiRaspLayout = new javax.swing.GroupLayout(panIntrebSiRasp);
        panIntrebSiRasp.setLayout(panIntrebSiRaspLayout);
        panIntrebSiRaspLayout.setHorizontalGroup(
            panIntrebSiRaspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 823, Short.MAX_VALUE)
        );
        panIntrebSiRaspLayout.setVerticalGroup(
            panIntrebSiRaspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
        );

        intrebareSiRaspunsDat.setViewportView(panIntrebSiRasp);

        javax.swing.GroupLayout panAnsLayout = new javax.swing.GroupLayout(panAns);
        panAns.setLayout(panAnsLayout);
        panAnsLayout.setHorizontalGroup(
            panAnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(answersScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(intrebareSiRaspunsDat, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panAnsLayout.setVerticalGroup(
            panAnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAnsLayout.createSequentialGroup()
                .addComponent(answersScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(intrebareSiRaspunsDat, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btWhy.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        btWhy.setForeground(new java.awt.Color(153, 0, 0));
        btWhy.setText("De ce vrei sa stii?");
        btWhy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btWhyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panMainLayout = new javax.swing.GroupLayout(panMain);
        panMain.setLayout(panMainLayout);
        panMainLayout.setHorizontalGroup(
            panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMainLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addComponent(lbFcAux, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panCertitudine, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panAns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btWhy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panMainLayout.setVerticalGroup(
            panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(panCertitudine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addComponent(jQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbFcAux, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(btWhy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        bIncarca.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        bIncarca.setText("Incarca");
        bIncarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIncarcaActionPerformed(evt);
            }
        });

        bConsulta.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        bConsulta.setText("Consulta");
        bConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultaActionPerformed(evt);
            }
        });

        bReset.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        bReset.setText("Reset");
        bReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bResetActionPerformed(evt);
            }
        });

        btnCloseProlog.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        btnCloseProlog.setText("Close Prolog");
        btnCloseProlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClosePrologActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panMeniuLayout = new javax.swing.GroupLayout(panMeniu);
        panMeniu.setLayout(panMeniuLayout);
        panMeniuLayout.setHorizontalGroup(
            panMeniuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMeniuLayout.createSequentialGroup()
                .addGroup(panMeniuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panMeniuLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(bIncarca, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panMeniuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panMeniuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(btnCloseProlog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        panMeniuLayout.setVerticalGroup(
            panMeniuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMeniuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bIncarca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bReset, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCloseProlog, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        Meniu.setText("Meniu");
        Meniu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Meniu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeniuActionPerformed(evt);
            }
        });

        Incarca.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Incarca.setText("Incarca");
        Incarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IncarcaActionPerformed(evt);
            }
        });
        Meniu.add(Incarca);

        Consulta.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Consulta.setText("Consulta");
        Consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaActionPerformed(evt);
            }
        });
        Meniu.add(Consulta);

        Reset.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
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
                .addGap(144, 144, 144)
                .addComponent(panMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panMeniu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tfParametru, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(okButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btAuto)
                                .addGap(45, 45, 45))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panMeniu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfParametru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okButton)
                            .addComponent(btAuto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(panMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
 
        valoareParametru = "[medie]";
        sendAnswer(valoareParametru);

        valoareParametru = "[alba]";
        sendAnswer(valoareParametru);

        valoareParametru = "[nu]";
        sendAnswer(valoareParametru);

        valoareParametru = "[roscat]";
        sendAnswer(valoareParametru);

        valoareParametru = "[nu_conteaza]";
        sendAnswer(valoareParametru);

        valoareParametru = "[nu]";
        sendAnswer(valoareParametru);   

        valoareParametru = "[nu_conteaza]";
        sendAnswer(valoareParametru);

        valoareParametru = "[nu_conteaza]";
        sendAnswer(valoareParametru);

        valoareParametru = "[nu]";
        sendAnswer(valoareParametru);

        valoareParametru = "[nu]";
        sendAnswer(valoareParametru);

        valoareParametru = "[nu]";
        sendAnswer(valoareParametru);

        valoareParametru = "[nu_conteaza]";
        sendAnswer(valoareParametru);

        valoareParametru = "[nu]";
        sendAnswer(valoareParametru);

        valoareParametru = "[nu_conteaza]";
        sendAnswer(valoareParametru);

        valoareParametru = "[nu_conteaza]";
        sendAnswer(valoareParametru);
    }//GEN-LAST:event_btAutoActionPerformed

    private void MeniuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeniuActionPerformed
        try {    
//            String comanda = "comanda(incarca('F:/NgenH/Projects/Prolog/ExempluInterfataProlog/my_project/my_projectmy_rules.txt'))";
//            String comanda = "comanda(incarca('C:/Users/Izabela/Desktop/sistemeExeperProiect/sisteme-expert/my_project'))";
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
            
            init();
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
        Consulta.setEnabled(false);
        bConsulta.setEnabled(false);
    }//GEN-LAST:event_ConsultaActionPerformed

    private void IncarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IncarcaActionPerformed
        try {    
//            String comanda = "comanda(incarca('F:/NgenH/Projects/Prolog/ExempluInterfataProlog/my_project/my_projectmy_rules.txt'))";
            String comanda = "comanda(incarca('C:/Users/AlexandruFlorian/Desktop/Sisteme expert/sisteme-expert/my_project'))";
//	String comanda = "comanda(incarca('C:/Users/Izabela/Desktop/sistemeExeperProiect/sisteme-expert/my_project'))";
	conexiune.expeditor.trimiteMesajSicstus(comanda);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
        Incarca.setEnabled(false);
        bIncarca.setEnabled(false);
    }//GEN-LAST:event_IncarcaActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
       Incarca.setEnabled(true);
       Consulta.setEnabled(true);
       bIncarca.setEnabled(true);
       bConsulta.setEnabled(true);
       String comanda = "comanda(reinitiaza)";
       try {
            conexiune.expeditor.trimiteMesajSicstus(comanda);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ResetActionPerformed

    private void btWhyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btWhyActionPerformed
        if(bHasAsked == true){
            JOptionPane.showMessageDialog(Fereastra.fereastra, "Ati intrebat deja o data! PA!");
            return;
        }
        try {
            String comanda = "[de_ce]";
            bHasAsked = true;
            conexiune.expeditor.trimiteMesajSicstus(comanda);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btWhyActionPerformed

    private void bIncarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIncarcaActionPerformed
         try {    
//            String comanda = "comanda(incarca('F:/NgenH/Projects/Prolog/ExempluInterfataProlog/my_project/my_projectmy_rules.txt'))";
            String comanda = "comanda(incarca('C:/Users/AlexandruFlorian/Desktop/Sisteme expert/sisteme-expert/my_project'))";
//	String comanda = "comanda(incarca('C:/Users/Izabela/Desktop/sistemeExeperProiect/sisteme-expert/my_project'))";
	conexiune.expeditor.trimiteMesajSicstus(comanda);
        bConsulta.setEnabled(true);
        Consulta.setEnabled(true);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
        Incarca.setEnabled(false);
        bIncarca.setEnabled(false);
    }//GEN-LAST:event_bIncarcaActionPerformed

    private void bConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultaActionPerformed
        try {
            String comanda = "comanda(consulta)";
            conexiune.expeditor.trimiteMesajSicstus(comanda);
            
            init();
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
        Consulta.setEnabled(false);
        bConsulta.setEnabled(false);
    }//GEN-LAST:event_bConsultaActionPerformed

    private void bResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResetActionPerformed
       Incarca.setEnabled(true);
       bIncarca.setEnabled(true);
       String comanda = "comanda(reinitiaza)";
        try {
            conexiune.expeditor.trimiteMesajSicstus(comanda);
            clearAll();
            init();
            resetConnection();
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bResetActionPerformed

    private void btnMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinusActionPerformed
        fc -= 10;
        if(fc < 0) fc = 0;
        if(!customFc) customFc = true;
        lbFc.setText(String.valueOf(fc));
    }//GEN-LAST:event_btnMinusActionPerformed

    private void btnPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlusActionPerformed
        fc += 10;
        if(fc > 100) fc = 100;
        if(!customFc) customFc = true;
        lbFc.setText(String.valueOf(fc));
    }//GEN-LAST:event_btnPlusActionPerformed

    private void btnClosePrologActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClosePrologActionPerformed
        bReset.setEnabled(true);
        btnCloseProlog.setEnabled(false);
        
        try {
            conexiune.opresteProlog();
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
        String closeProlog = "taskkill /f /im \"spwin.exe\"";
        Runtime rtime= Runtime.getRuntime();
        try {
            rtime.exec(closeProlog);
        } catch (IOException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnClosePrologActionPerformed

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
    
    public void resetConnection(){
        try {
            try {
                ExempluInterfataProlog.PORT ++;
                conexiune = new ConexiuneProlog(ExempluInterfataProlog.PORT, fereastra);
            } catch (IOException ex) {
                Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setConexiune(ConexiuneProlog _conexiune){
        conexiune=_conexiune;
    }
    
    public void setQuestion(String question){
        jQuestion.setText(question);
    }
    
    public void clearAll(){
        answers.clear();
        panAnswersPanel.removeAll();
        panAnswersPanel.revalidate();
        panAnswersPanel.repaint();
        panIntrebSiRasp.removeAll();
        panIntrebSiRasp.revalidate();
        panIntrebSiRasp.repaint();
        
        textAreaDebug.setVisible(false);
        btAuto.setVisible(true);
        okButton.setVisible(false);
        tfParametru.setVisible(false);
        jScrollPane1.setVisible(false);
        
        panMeniu.setVisible(true);
        panMeniu.setOpaque(false);
        
        panMain.setOpaque(false);
        
        jQuestion.setVisible(false);
        lbFcAux.setVisible(false);

        panCertitudine.setOpaque(false);
        panCertitudine.setVisible(false);
            
        btnPlus.setVisible(false);
        btnMinus.setVisible(false);
        lbFc.setVisible(false);
            
        panAns.setVisible(false);
        panAns.setOpaque(false);
            
        btWhy.setVisible(false);
            
        answersScroll.setVisible(false);
        answersScroll.setOpaque(false);
        panAnswersPanel.setOpaque(false);
        panAnswersPanel.setVisible(false);

        intrebareSiRaspunsDat.setVisible(false);
        intrebareSiRaspunsDat.setOpaque(false);
        panIntrebSiRasp.setVisible(false);
        panIntrebSiRasp.setOpaque(false);
   
    }
    
    public void init(){
        bReset.setEnabled(false);
        panMain.setOpaque(false);
        jQuestion.setVisible(true);
        lbFcAux.setVisible(true);

        panCertitudine.setOpaque(false);
        panCertitudine.setVisible(true);

        btnPlus.setVisible(true);
        btnMinus.setVisible(true);
        lbFc.setVisible(true);

        panAns.setVisible(true);
        panAns.setOpaque(false);

        btWhy.setVisible(true);

        answersScroll.setVisible(true);
        answersScroll.setOpaque(false);
        panAnswersPanel.setOpaque(false);
        panAnswersPanel.setBackground(Color.BLUE);
        panAnswersPanel.setVisible(true);

        intrebareSiRaspunsDat.setVisible(true);
        intrebareSiRaspunsDat.setOpaque(false);
        panIntrebSiRasp.setVisible(true);
        panIntrebSiRasp.setOpaque(false);
    }
    
    public void activateReset(){
        btnCloseProlog.setEnabled(true);
    }
    
    public void deactivateReset(){
        btnCloseProlog.setEnabled(false);
    }
    
    public void generateAnswers(){
        bHasAsked = false;
 
        int maxWidth = 0;
        
        for(int i = 0; i < answers.size(); i++){
            if(answers.get(i).length() * 3 > maxWidth) maxWidth = answers.get(i).length() * 3;
        }
        
        BoxLayout layout = new BoxLayout(panAnswersPanel, BoxLayout.Y_AXIS);
        panAnswersPanel.setLayout(layout);
        panAnswersPanel.setSize(panAnswersPanel.getPreferredSize());
        panAnswersPanel.setBackground(new Color(0, 0, 0, 0));
        
        BoxLayout layout2 = new BoxLayout(panIntrebSiRasp, BoxLayout.Y_AXIS);
        panIntrebSiRasp.setLayout(layout2);
        
        ButtonGroup jbtGroup = new ButtonGroup();
        
        JButton btnSend = new JButton("Am raspuns la intrebare");
        btnSend.setFont(new Font("Monotype Corsiva", Font.BOLD, 36));
        for(int i = 0; i < answers.size(); i++){
            if(!answers.get(i).equals("")){
                final JToggleButton toggle = new JToggleButton();
                toggle.setVisible(true);
                toggle.setText(answers.get(i));
                
                toggle.setName("tog" + answers.get(i));
                toggle.setSize(100, 5);
                toggle.setFont(new Font("Monotype Corsiva", Font.BOLD, 36));
                
                SwingUtilities.updateComponentTreeUI(toggle);
                toggles.push(toggle);
                jbtGroup.add(toggle);
                
                panAnswersPanel.add(toggle);
            }
        }
        
        
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
                            lastQuestion.setFont(new Font("Monotype Corsiva", Font.BOLD, 36));
                            lastQuestion.setVisible(true);
                            answerGived.setVisible(true);
                            intrebareSiRaspunsDat.getViewport().setViewPosition(new Point(0, i +1000));
                            labels.push(answerGived);
                            
                            answerGived.setText(message.substring(1, message.length()-1));
                            answerGived.setName("l" + toggles.get(i).getText());
                            answerGived.setFont(new Font("Monotype Corsiva", Font.BOLD, 36));
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
                        conexiune.expeditor.trimiteMesajSicstus(message);
                        
                        customFc = false;
                        fc = 100;
                        lbFc.setText(String.valueOf(fc));
                    }
                    panAnswersPanel.revalidate();
                    panAnswersPanel.repaint();
                } catch (Exception ex) {
                    Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnSend.setVisible(true);
        panAnswersPanel.add(btnSend);
        panAnswersPanel.revalidate();
        panAnswersPanel.repaint();
        this.repaint();
    }

    
    public void sendAnswer(String message){

        JLabel lastQuestion = new JLabel();
        JLabel answerGived = new JLabel();
        JSeparator sepIntrSiRasp = new JSeparator();

        lastQuestion.setText(jQuestion.getText());
        lastQuestion.setFont(new Font("Monotype Corsiva", Font.BOLD, 36));
        lastQuestion.setVisible(true);
        answerGived.setVisible(true);
        intrebareSiRaspunsDat.getViewport().setViewPosition(new Point(0, 10000));
        labels.push(answerGived); 

        answerGived.setText(message.substring(1, message.length()-1));
        answerGived.setName("l" + message);
        answerGived.setFont(new Font("Monotype Corsiva", Font.BOLD, 36));
        panIntrebSiRasp.add(lastQuestion);
        panIntrebSiRasp.add(answerGived);
        panIntrebSiRasp.add(sepIntrSiRasp);
        intrebareSiRaspunsDat.scrollRectToVisible(sepIntrSiRasp.getVisibleRect());

        try {
            conexiune.expeditor.trimiteMesajSicstus(message);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }

        customFc = false;
        fc = 100;
        lbFc.setText(String.valueOf(fc));
        
        panAnswersPanel.revalidate();
        panAnswersPanel.repaint();
    }
    
    public void clearAnswers(){
        answers.clear();
        toggles.clear();
        panAnswersPanel.removeAll();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Consulta;
    private javax.swing.JMenuItem Incarca;
    private javax.swing.JMenu Meniu;
    private javax.swing.JMenuItem Reset;
    private javax.swing.JScrollPane answersScroll;
    private javax.swing.JButton bConsulta;
    private javax.swing.JButton bIncarca;
    private javax.swing.JButton bReset;
    private javax.swing.JButton btAuto;
    private javax.swing.JButton btWhy;
    private javax.swing.JButton btnCloseProlog;
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
    private javax.swing.JPanel panMeniu;
    private javax.swing.JTextArea textAreaDebug;
    private javax.swing.JTextField tfParametru;
    // End of variables declaration//GEN-END:variables
}
