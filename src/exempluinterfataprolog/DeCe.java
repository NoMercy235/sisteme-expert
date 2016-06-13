package exempluinterfataprolog;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DeCe extends javax.swing.JFrame {

      Dimension dim = null;

    public DeCe() {
        initComponents();
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(dim.width / 4, dim.height / 4);
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setTitle("Rezultate");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setTitle("De ce vrei sa stii?");
        
        jWhyPanel.setLayout(new BoxLayout(jWhyPanel, BoxLayout.Y_AXIS));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jWhyPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout jWhyPanelLayout = new javax.swing.GroupLayout(jWhyPanel);
        jWhyPanel.setLayout(jWhyPanelLayout);
        jWhyPanelLayout.setHorizontalGroup(
            jWhyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        jWhyPanelLayout.setVerticalGroup(
            jWhyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jWhyPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void addWhy(String why){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JPanel element = new JPanel();
        element.setLayout(new BoxLayout(element, BoxLayout.X_AXIS));
        
        JLabel lbRes = new JLabel(why);
        lbRes.setVisible(true);
        element.add(lbRes);
        
        panel.add(element);

        element.setVisible(true);
        panel.setVisible(true);
        jWhyPanel.add(panel);
        jWhyPanel.revalidate();
        jWhyPanel.repaint();    
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jWhyPanel;
    // End of variables declaration//GEN-END:variables
}
