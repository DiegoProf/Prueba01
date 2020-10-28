package Controlador;

import Vista_RegistroIngreso.Panel1_Intro;
import Vista_RegistroIngreso.Panel2_Login;
import Vista_RegistroIngreso.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * @author Grupo B
 */
public class Control_RegistroIngreso implements ActionListener {

    /// VENTANA Y PANELES (elementos con los que la calse está relacionada)
    Ventana ventana;
    Panel1_Intro intro;
    Panel2_Login login;
    Control_Logica controlLogica;

    @Override
    public void actionPerformed(ActionEvent evento) { // establece esta clase como oyente de otros objetos

        ////// COMENZAR
        if (evento.getSource() == intro.getBtnComenzar()) { // si el evento proviene del botón Comenzar del panel Intro
            intro.setVisible(false); // ocultar el panel Intro
            cambiarPanel(login); // mostrar el panel logGen
        }

        ////// ACEPTAR LOGIN
        if (evento.getSource() == login.getBtnAceptar()) { // si el vento proviene del botón Aceptar del panel logProf
            try { // se ejecuta dentro de un try porque el método login involucra operaciones con BDD
                if (controlLogica.login()) { // si el método login se ejecuta con éxito
                    login.setVisible(false); // ocultar el panel logProf
                    JOptionPane.showMessageDialog(null, "LOGIN CORRECTO!!!"); // mostrar mensaje
                    cambiarPanel(intro); // mostrar el panel Intro
                }
            } catch (SQLException ex) { // si no se pueden ejecutar las operaciones sobre la BDD
                Logger.getLogger(Control_RegistroIngreso.class.getName()).log(Level.SEVERE, null, ex); // muestra error
            }
        } /// FIN LOGIN

    }

    /// CREAR VENTANA
    public void crearVentana() { // crea la ventana inicial
        ventana.contenedorFondo.add(intro); // carga la imagen de fondo en el panel contenedorFondo
        ventana.setVisible(true); // hace la ventan visible
        ventana.pack(); // carga los componentes dela ventana
    }

    /// CAMBIAR PANEL
    public void cambiarPanel(JPanel panel) { // cambia todo el contenido de la ventana
        ventana.contenedorFondo.removeAll(); // elimina el panel actual
        ventana.contenedorFondo.add(panel); // carga el nuevo panel
        panel.setVisible(true); // hace el panel visible
    }

    ////// SETTERS
    public void setVentana(Ventana ventana) {
        this.ventana = ventana;
    }

    public void setIntro(Panel1_Intro intro) {
        this.intro = intro;
    }

    public void setControlLogica(Control_Logica controlLogica) {
        this.controlLogica = controlLogica;
    }

    public void setLogin(Panel2_Login login) {
        this.login = login;
    }

}
