package exempluinterfataprolog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Fereastra extends javax.swing.JFrame {
    static Fereastra fereastra;
    static Results results;
    static DeCe dece;
    static int dialogResult = -1;
    static int dialogButton = JOptionPane.YES_NO_OPTION;
    static String pathToMyProject = "C:/Users/AlexandruFlorian/Desktop/Sisteme expert/sisteme-expert/my_project/";
    static boolean bHasAutoQuery = false;
    
    ConexiuneProlog conexiune;
    LinkedList<String> answers = new LinkedList<>();
    LinkedList<String> givenAnswers = new LinkedList<>();
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
        
        btnCloseProlog.setEnabled(false);
        
        bIncarca.setEnabled(true);
        bConsulta.setEnabled(false);
        bReset.setEnabled(false);
        btAuto.setEnabled(false);
        
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
        btAuto = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();

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

        btAuto.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        btAuto.setText("Auto Query");
        btAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAutoActionPerformed(evt);
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
                            .addComponent(btnCloseProlog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAuto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tfParametru, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(okButton)
                                .addGap(110, 110, 110)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panMeniu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfParametru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(panMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
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
        StringBuilder sb = new StringBuilder();
        String line = "";
        LinkedList<String> readAnswers = new LinkedList<>();
        final JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fc.setFileFilter(filter);
        
        fc.setMultiSelectionEnabled(true);
        fc.setCurrentDirectory(new File(pathToMyProject + "log_witcher3"));
 
        int retVal = fc.showOpenDialog(Fereastra.fereastra);
        if (retVal == JFileChooser.APPROVE_OPTION) {
            File[] selectedfiles = fc.getSelectedFiles();
            for (int i = 0; i < selectedfiles.length; i++) {
                sb.append(selectedfiles[i].getAbsolutePath());
            }
        }
        
        bHasAutoQuery = true;
        
        String path = sb.toString().replace("\\", "/");
        File file = new File(path);
        
        try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            while ((line = br.readLine()) != null) {
                    readAnswers.addFirst(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 0; i < readAnswers.size(); i++){
            if(i % 2 == 1)
                sendAnswer(readAnswers.get(i));    
            else
                jQuestion.setText(readAnswers.get(i));
        }
    }//GEN-LAST:event_btAutoActionPerformed

    private void btWhyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btWhyActionPerformed
        if(bHasAsked == true){
            JOptionPane.showMessageDialog(Fereastra.fereastra, "Ati intrebat deja o data!");
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
        StringBuilder sb = new StringBuilder();
        final JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fc.setFileFilter(filter);
        
        fc.setMultiSelectionEnabled(true);
        fc.setCurrentDirectory(new File(pathToMyProject));
 
        int retVal = fc.showOpenDialog(Fereastra.fereastra);
        if (retVal == JFileChooser.APPROVE_OPTION) {
            File[] selectedfiles = fc.getSelectedFiles();
            for (int i = 0; i < selectedfiles.length; i++) {
                sb.append(selectedfiles[i].getAbsolutePath());
            }
        }
        String path = sb.toString().replace("\\", "/");
        
        try {    
//            String comanda = "comanda(incarca('F:/NgenH/Projects/Prolog/ExempluInterfataProlog/my_project/my_projectmy_rules.txt'))";
            String comanda = "comanda(incarca('" + pathToMyProject + "', '" + path + "'))";
//	String comanda = "comanda(incarca('C:/Users/Izabela/Desktop/sistemeExeperProiect/sisteme-expert/my_project'))";
	conexiune.expeditor.trimiteMesajSicstus(comanda);
        bConsulta.setEnabled(true);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        bConsulta.setEnabled(false);
        btAuto.setEnabled(true);
    }//GEN-LAST:event_bConsultaActionPerformed

    private void bResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResetActionPerformed
        bIncarca.setEnabled(true);
        clearAll();
        init();
        resetConnection();
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
        Fereastra.dialogResult = -1;
        Fereastra.bHasAutoQuery = false;
        givenAnswers.clear();
        dialogButton = JOptionPane.YES_NO_OPTION;
        
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

    public void sendAnswer(String message, String question){
        jQuestion.setText(question);
        sendAnswer(message);
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
        answerGived.setText(answerGived.getText().replace("_", " "));
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
    
    public void disableAutoQuery() {
        btAuto.setEnabled(false);
    }
    
    public String getQuestion(){
        return jQuestion.getText();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
