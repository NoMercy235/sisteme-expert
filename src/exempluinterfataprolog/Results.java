package exempluinterfataprolog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;

public class Results extends javax.swing.JFrame {

    Dimension dim = null;
    
    public Results() {
        initComponents();
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(dim.width, dim.height);
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
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
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JPanel element = new JPanel();
        element.setLayout(new BoxLayout(element, BoxLayout.X_AXIS));
        
        String[] parsed = result.split(" ");
        String displayedTex = "Rezultatul este: " + parsed[1] +
                " cu factor de certitudine: " + parsed[2];
        
        JLabel lbRes = new JLabel(displayedTex);
        lbRes.setVisible(true);
        element.add(lbRes);
        
        BufferedImage img = getResultImage(parsed[1]);
        Image aux = img.getScaledInstance(200, 280, Image.SCALE_SMOOTH);
        if(img != null){
            System.out.println("/images/" + parsed[1] + ".png");
            JLabel picLabel = new JLabel(new ImageIcon(aux));
            picLabel.setSize(dim);
            picLabel.setOpaque(true);
            picLabel.setLayout(null);
            picLabel.setSize(200, 200);
            element.add(picLabel);
         
            element.revalidate();
            element.repaint();
        }
       
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
