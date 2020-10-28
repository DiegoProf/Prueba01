package Vista_RegistroIngreso;

import Controlador.Control_RegistroIngreso;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * @author Grupo B
 */
public class Panel2_Login extends javax.swing.JPanel {

    Control_RegistroIngreso control = new Control_RegistroIngreso();

    public Panel2_Login() {

        initComponents();

    }

    @Override
    public void paint(Graphics g) {
        Image imagen = new ImageIcon(getClass().getResource("/img/login.png")).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }

    public void setControl(Control_RegistroIngreso control) {
        this.control = control;
        btnAceptar.addActionListener(control);
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public JPasswordField getPswContra1() {
        return pswContra1;
    }

    public JTextField getTxtNombreUsuario() {
        return txtNombreUsuario;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pswContra1 = new javax.swing.JPasswordField();
        txtNombreUsuario = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(640, 480));
        setMinimumSize(new java.awt.Dimension(640, 480));
        setName("fondoPan"); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pswContra1.setForeground(new java.awt.Color(255, 255, 255));
        pswContra1.setBorder(null);
        pswContra1.setCaretColor(new java.awt.Color(255, 255, 255));
        pswContra1.setMinimumSize(new java.awt.Dimension(14, 20));
        pswContra1.setOpaque(false);
        pswContra1.setPreferredSize(new java.awt.Dimension(14, 20));
        pswContra1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pswContra1ActionPerformed(evt);
            }
        });
        add(pswContra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 412, 170, 29));

        txtNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreUsuario.setBorder(null);
        txtNombreUsuario.setCaretColor(new java.awt.Color(255, 255, 255));
        txtNombreUsuario.setOpaque(false);
        add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 170, 29));

        btnAceptar.setBackground(new java.awt.Color(204, 204, 204));
        btnAceptar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("INGRESAR");
        btnAceptar.setBorder(null);
        btnAceptar.setBorderPainted(false);
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.setOpaque(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 395, 110, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void pswContra1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pswContra1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pswContra1ActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JPasswordField pswContra1;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables


}
