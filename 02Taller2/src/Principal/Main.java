
package Principal;

import Controlador.Control_Logica;
import Controlador.Control_RegistroIngreso;
import Persistencia.UsuarioDAO;
import Vista_RegistroIngreso.Panel1_Intro;
import Vista_RegistroIngreso.Panel2_Login;
import Vista_RegistroIngreso.Ventana;

/**
 *
 * @author Grupo B
 */
public class Main {

    public static void main(String args[]) {

        /// INSTANCIAR CLASES
        Control_RegistroIngreso control = new Control_RegistroIngreso();
        Ventana ventana = new Ventana();
        Panel1_Intro intro = new Panel1_Intro();
        Panel2_Login login = new Panel2_Login();
        Panel2_Login logProf = new Panel2_Login();
        Control_Logica controlLogica = new Control_Logica();
        UsuarioDAO opBDD = new UsuarioDAO();
        
        /// RELACIONAR CLASES CON LOS CONTROLADORES
        ventana.setControl(control);
        intro.setControl(control);
        login.setControl(control);
        logProf.setControl(control);
        controlLogica.setRegistroIngreso(control);
        
        controlLogica.setUsuarioDAO(opBDD);
        
        /// RELACIONAR CONTROLADORES CON LAS CLASES
        control.setVentana(ventana);
        control.setIntro(intro);
        control.setLogin(login);
        control.setControlLogica(controlLogica);
        
        opBDD.setControlLogica(controlLogica);
        
        /// CREAR VENTANA PRINCIPAL DESDE CONTROL
        control.crearVentana(); 
        ventana.setVisible(true);
        controlLogica.listarTodosLosMonos();
        
    }
}
