package exempluinterfataprolog;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class ResultDemonstration extends javax.swing.JFrame {

    Dimension dim = null;

    public ResultDemonstration(String character) {
        initComponents();
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        Double width = dim.width / 1.5;
        Double height = dim.height / 1.5;
        this.setSize(width.intValue(), height.intValue());
        this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setTitle("Rezultate");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        jDemonstrationPanel.setLayout(new BoxLayout(jDemonstrationPanel, BoxLayout.Y_AXIS));
        
        readDemonstration(character);
    }
    
    void readDemonstration(String character){
         JTextPane text = new JTextPane();
        text.setMaximumSize(new Dimension(300, 300));
        
        String demonstration = "";
        String line;
        File file = new File(Fereastra.pathToMyProject + "log_witcher3/demonstratie_personaj=" + character + ".txt");
        
        try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            while ((line = br.readLine()) != null) {
                demonstration += line + "\n";
            }
        } catch (IOException ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        text.setText(demonstration);
        
        JScrollPane sp = new JScrollPane(text);
        jDemonstrationPanel.add(sp);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jDemonstrationPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDemonstrationPanelLayout = new javax.swing.GroupLayout(jDemonstrationPanel);
        jDemonstrationPanel.setLayout(jDemonstrationPanelLayout);
        jDemonstrationPanelLayout.setHorizontalGroup(
            jDemonstrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        jDemonstrationPanelLayout.setVerticalGroup(
            jDemonstrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jDemonstrationPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jDemonstrationPanel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
