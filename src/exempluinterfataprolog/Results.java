package exempluinterfataprolog;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

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
        
        BoxLayout layout = new BoxLayout(jResultsPanel, BoxLayout.Y_AXIS);
        
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
        final String[] parsed = result.split(" ");
        boolean bTooLow = false;
        if(Integer.valueOf(parsed[2]) < 50){ 
            bTooLow = true;
        }
            
        String displayedTex = 
                bTooLow ? "Rezultatul obtinut este prea mic pentru a fi afisat" :
                "Rezultatul este: " + parsed[1].substring(0, 1).toUpperCase() +
                parsed[1].substring(1) + " cu factor de certitudine: " + parsed[2];
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        element = new JPanel();
        element.setLayout(new BoxLayout(element, BoxLayout.X_AXIS));
        
        JLabel lbRes = new JLabel(displayedTex);
        lbRes.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
        lbRes.setVisible(true);
        element.add(lbRes);
        element.add(Box.createRigidArea(new Dimension(5,0)));

        
        if(!bTooLow){
            BufferedImage img = getResultImage(parsed[1]);
            Image aux = img.getScaledInstance(280, 280, Image.SCALE_SMOOTH);
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

            JButton btnDem = new JButton("Demonstratie pentru " + 
                    parsed[1].substring(0, 1).toUpperCase() + parsed[1].substring(1));
            btnDem.setName("btn" + parsed[1]);
            btnDem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ResultDemonstration rd = new ResultDemonstration(parsed[1]);
                    rd.setVisible(true);
                }
            });
            btnDem.setVisible(true);
            element.add(btnDem);
        }
        
        panel.add(element);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jResultsPanel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
