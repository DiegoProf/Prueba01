package Vista_RegistroIngreso;

import Controlador.Control_RegistroIngreso;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * @author Grupo B
 */
public class Panel1_Intro extends javax.swing.JPanel {

    Control_RegistroIngreso control = new Control_RegistroIngreso(); // el panel se relaciona con la clase control


    /// Contructor
    public Panel1_Intro() {

        initComponents(); // inicializar componentes

    }
    
    @Override /// Metodo para poner imagen de fondo
    public void paint(Graphics g) {
        Image imagen = new ImageIcon(getClass().getResource("/img/intro.png")).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }

    ////// SETTER
    public void setControl(Control_RegistroIngreso control) { // realacionar con la clase control
        this.control = control;
        btnComenzar.addActionListener(control); // configurar la clase control como oyente de los boton Comenzar
    }

    ////// GETTERS
    public JButton getBtnComenzar() {
        return btnComenzar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnComenzar = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(640, 480));
        setMinimumSize(new java.awt.Dimension(640, 480));
        setName("fondoPan"); // NOI18N

        btnComenzar.setBackground(new java.awt.Color(102, 102, 102));
        btnComenzar.setBorder(null);
        btnComenzar.setContentAreaFilled(false);
        btnComenzar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComenzar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnComenzarMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(btnComenzar, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(204, Short.MAX_VALUE)
                .addComponent(btnComenzar, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnComenzarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComenzarMouseEntered

    }//GEN-LAST:event_btnComenzarMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComenzar;
    // End of variables declaration//GEN-END:variables


}
