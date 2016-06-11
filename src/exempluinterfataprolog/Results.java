package exempluinterfataprolog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

public class Results extends javax.swing.JFrame {

    Dimension dim = null;
    JPanel element;
    
    public Results() {
        initComponents();
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(dim.width, dim.height);
        this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setTitle("Rezultate");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        jResultsPanel.setLayout(new BoxLayout(jResultsPanel, BoxLayout.Y_AXIS));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jResultsPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jResultsPanelLayout = new javax.swing.GroupLayout(jResultsPanel);
        jResultsPanel.setLayout(jResultsPanelLayout);
        jResultsPanelLayout.setHorizontalGroup(
            jResultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jResultsPanelLayout.setVerticalGroup(
            jResultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jResultsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addResult(String result){
        String[] parsed = result.split(" ");
        if(Integer.valueOf(parsed[2]) < 50) return;
            
        String displayedTex = "Rezultatul este: " + parsed[1] +
                " cu factor de certitudine: " + parsed[2];
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        element = new JPanel();
        element.setLayout(new BoxLayout(element, BoxLayout.X_AXIS));
        
        JLabel lbRes = new JLabel(displayedTex);
        lbRes.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
        lbRes.setVisible(true);
        element.add(lbRes);
        
        BufferedImage img = getResultImage(parsed[1]);
        Image aux = img.getScaledInstance(200, 280, Image.SCALE_SMOOTH);
        if(img != null){
            JLabel picLabel = new JLabel(new ImageIcon(aux));
            picLabel.setSize(dim);
            picLabel.setOpaque(true);
            picLabel.setLayout(null);
            picLabel.setSize(200, 200);
            element.add(picLabel);
         
            element.revalidate();
            element.repaint();
        }
       
        readFile(parsed[1]);
        panel.add(element);
//       jResultsPanel.add(jScrollPane1);
//       jResultsPanel.add(picLabel);
        JSeparator sepPictures = new JSeparator();
        sepPictures.setForeground(java.awt.Color.blue);
        panel.add(sepPictures);

        element.setVisible(true);
        panel.setVisible(true);
        jResultsPanel.add(panel);
        jResultsPanel.revalidate();
        jResultsPanel.repaint();
    }
    
    private BufferedImage  getResultImage(String charName){
        BufferedImage  img = null;
        
        try {
            img = ImageIO.read(this.getClass().getResource("/images/" + charName + ".png"));
        } catch (IOException ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return img;
    }
    
    
    public void readFile(String name){
        JTextPane text = new JTextPane();
        text.setMaximumSize(new Dimension(300, 300));
//        text.setPreferredSize(new Dimension(300, 300));

        
        String demonstration = "";
        String line;
        File file = new File("C:/Users/AlexandruFlorian/Desktop/Sisteme expert/sisteme-expert/my_project/log_witcher3/demonstratie_personaj=" + name + ".txt");
        
        try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            while ((line = br.readLine()) != null) {
                demonstration += line + "\n";
            }
        } catch (IOException ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        text.setText(demonstration);
        
        JScrollPane sp = new JScrollPane(text);
        element.add(sp);
    }
    
    
    
    
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
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Results().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jResultsPanel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
