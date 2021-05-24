
package Interface;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class LogIn extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
    public LogIn() {
        initComponents();
    }

    private JFrame goBack;

    /**
     * Creates new form LogIn
     *
     * @param v: previous frame
     */
    public LogIn(JFrame v) {
        initComponents();
        goBack = v;
        goBack.setVisible(false);
        this.setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        startClientButton = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        startServerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LogIn");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1000, 630));
        setMinimumSize(new java.awt.Dimension(1000, 630));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 630));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setMaximumSize(new java.awt.Dimension(1000, 630));
        backgroundPanel.setMinimumSize(new java.awt.Dimension(1000, 630));
        backgroundPanel.setPreferredSize(new java.awt.Dimension(1000, 630));

        logo.setBackground(new java.awt.Color(255, 255, 255));
        logo.setIcon(new javax.swing.ImageIcon(".\\src\\main\\java\\IconImages\\hospital.png")
        );
        logo.setFocusable(false);
        logo.setMaximumSize(new java.awt.Dimension(512, 480));
        logo.setMinimumSize(new java.awt.Dimension(512, 480));

        startClientButton.setBackground(new java.awt.Color(128, 29, 24));
        startClientButton.setFont(new java.awt.Font("Ubuntu Condensed", 0, 24)); // NOI18N
        startClientButton.setForeground(new java.awt.Color(255, 255, 255));
        startClientButton.setText("C L I E N T");
        startClientButton.setBorder(null);
        startClientButton.setBorderPainted(false);
        startClientButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startClientButton.setFocusPainted(false);
        startClientButton.setMargin(new java.awt.Insets(2, 1, 2, 1));
        startClientButton.setMaximumSize(new java.awt.Dimension(120, 35));
        startClientButton.setMinimumSize(new java.awt.Dimension(120, 35));
        startClientButton.setPreferredSize(new java.awt.Dimension(120, 35));
        startClientButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startClientButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                startClientButtonMouseExited(evt);
            }
        });
        startClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startClientButtonActionPerformed(evt);
            }
        });

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font("Linux Biolinum G", 0, 48)); // NOI18N
        title.setText("THREVAX HOSPITAL");
        title.setFocusable(false);
        title.setMaximumSize(new java.awt.Dimension(434, 40));
        title.setMinimumSize(new java.awt.Dimension(434, 40));
        title.setPreferredSize(new java.awt.Dimension(434, 40));

        startServerButton.setBackground(new java.awt.Color(128, 29, 24));
        startServerButton.setFont(new java.awt.Font("Ubuntu Condensed", 0, 24)); // NOI18N
        startServerButton.setForeground(new java.awt.Color(255, 255, 255));
        startServerButton.setText("S E R V E R");
        startServerButton.setBorder(null);
        startServerButton.setBorderPainted(false);
        startServerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startServerButton.setFocusPainted(false);
        startServerButton.setMargin(new java.awt.Insets(2, 1, 2, 1));
        startServerButton.setMaximumSize(new java.awt.Dimension(120, 35));
        startServerButton.setMinimumSize(new java.awt.Dimension(120, 35));
        startServerButton.setPreferredSize(new java.awt.Dimension(120, 35));
        startServerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startServerButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                startServerButtonMouseExited(evt);
            }
        });
        startServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startServerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                                .addComponent(startClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(startServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
                            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(244, 244, 244))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1014, 667));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ImageIcon icon = new ImageIcon("src/main/java/IconImages/virus.png");
        setIconImage(icon.getImage());
    }//GEN-LAST:event_formWindowActivated

    private void startClientButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startClientButtonMouseEntered
        startClientButton.setBackground(new Color(165, 63, 82));
        startClientButton.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_startClientButtonMouseEntered

    private void startClientButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startClientButtonMouseExited
        startClientButton.setBackground(new Color(128, 29, 24));
        startClientButton.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_startClientButtonMouseExited

    private void startClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startClientButtonActionPerformed
        HospitalClient hospitalClient = new HospitalClient(this);
    }//GEN-LAST:event_startClientButtonActionPerformed

    private void startServerButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startServerButtonMouseEntered
        startServerButton.setBackground(new Color(165, 63, 82));
        startServerButton.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_startServerButtonMouseEntered

    private void startServerButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startServerButtonMouseExited
        startServerButton.setBackground(new Color(128, 29, 24));
        startServerButton.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_startServerButtonMouseExited

    private void startServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startServerButtonActionPerformed
        HospitalServer hospitalServer = new HospitalServer(this);
    }//GEN-LAST:event_startServerButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLabel logo;
    private javax.swing.JButton startClientButton;
    private javax.swing.JButton startServerButton;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
