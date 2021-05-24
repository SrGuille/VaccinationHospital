
package Interface;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class HospitalServer extends Hospital {

    private JFrame goBack;

    /**
     * Creates new form HospitalServer
     *
     * @param v: previous frame
     *
     */
    public HospitalServer(JFrame v) {
        super(v);
        removeDeskButtons();
    }

    private ImageIcon plainButton = super.generateImage(".\\src\\main\\java\\IconImages\\emptydesk.png", 40, 40);
    /**
     *
     * Apparently is easier to remove them, but actually no; peace was never an
     * option 
     *
     */
    public void removeDeskButtons() {
        for (int i = 0; i < 10; i++) {
            //super.buttonDesks[i].setVisible(false);
            for (ActionListener al : super.buttonDesks[i].getActionListeners()) {
                super.buttonDesks[i].removeActionListener(al);
            }
            super.buttonDesks[i].setIcon(plainButton);
            super.buttonDesks[i].setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
