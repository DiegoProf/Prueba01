package Controlador;

import DataTypes.UsuarioDTO;
import Persistencia.ConexBDD;
import Persistencia.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * @author Grupo B
 */
public class Control_Logica {

    ////// ATRIBUTOS
    Control_RegistroIngreso registroIngreso; // permite acceder a las características del control de registro/ingreso
    ConexBDD conexion; // permite que esta clase se conecte a la BDD mediante
    UsuarioDAO usuarioDAO; // permite que esta clase acceda a las operaciones sobre la BDD
    UsuarioDTO usuarioDTO = new UsuarioDTO(); // permite que los atributos de usuario viajen entre las diferentes capas

//    ////// CREAR USUARIO
//    public void crearUsuario() { // inserta un nuevo profesor en la BDD
//        usuarioDTO = leerVentanaRegistro(); // recoge datos desde la ventana y los introduce en usuarioDTO
//        usuarioDAO.insertarUsuario(usuarioDTO); // inserta el nuevo usuario en la BDD
//    }
    ////// LOGIN
    public boolean login() throws SQLException {

        if (leerVentanaLogin() == null) { // Si hay algún error en la lectura de la ventana
            return false; // devuelve false

        } else { // Si la ventana es leída con éxito

            usuarioDTO = leerVentanaLogin(); // recoge datos desde la ventana y los introduce en usuarioDTO

            // se guardadn los datos consultados (usuario y contraseña) en usuarioConsultado
            UsuarioDTO usuarioConsultado = usuarioDAO.buscarPorNombre("registrousuario", usuarioDTO.getNombreUsuario());

            // Se comparan los resultados obtenidos en la consulta con los datos obtenidos desde la ventana
            // si el nombre introducido en la ventana != del nombre obtenido en la consulta
            if (!usuarioDTO.getNombreUsuario().equals(usuarioConsultado.getNombreUsuario())) {
                JOptionPane.showMessageDialog(null, "El usuario no está registrado!"); // mostrar mensaje de error
                registroIngreso.login.getTxtNombreUsuario().setText(""); // se borra el texto en la ventana
                registroIngreso.login.getPswContra1().setText(""); // se borra el texto en la ventana
                return false;
                // si coincide el nombre pero no la contraseña
            } else if (usuarioDTO.getNombreUsuario().equals(usuarioConsultado.getNombreUsuario())
                    && !usuarioDTO.getClave().equals(usuarioConsultado.getClave())) {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta!"); // mostrar error de contraseña
                registroIngreso.login.getPswContra1().setText(""); // se borra el texto en la ventana
                return false;
            } else {
                registroIngreso.login.getTxtNombreUsuario().setText(""); // se borra el texto en la ventana
                registroIngreso.login.getPswContra1().setText(""); // se borra el texto en la ventana
                return true; // si ambos datos coinciden devolver true
            }

        }
    }

//    ////// LEER VENTANA REGISTRO
//    public UsuarioDTO leerVentanaRegistro() { // obtener datos desde la ventana
//        UsuarioDTO u = new UsuarioDTO(); // usuarioDTO temporal para manipular datos dentro del método
//        u.setNombreUsuario(registroIngreso.login.getTxtNombreUsuario().getText()); // se guarda el nombre desde la ventana
//        u.setClave(registroIngreso.login.getPswContra1().getText()); // se guarda la contraseña desde la ventana
//        // Debe leer también el tipo de perfil (profesor o estudiante)
//        return u; // se devuelve el objeto temporal
//    }
    ////// LEER VENTANA LOGIN
    public UsuarioDTO leerVentanaLogin() { // obtener datos desde la ventana
        if ("".equals(registroIngreso.login.getTxtNombreUsuario().getText())) { // si no se ingresa ningún nombre
            JOptionPane.showMessageDialog(null, "Debe ingresar un usuario!");
            return null;
        } else {
            UsuarioDTO u = new UsuarioDTO(); // usuarioDTO temporal para manipular datos dentro del método
            u.setNombreUsuario(registroIngreso.login.getTxtNombreUsuario().getText()); // se guarda el nombre desde la ventana
            u.setClave(registroIngreso.login.getPswContra1().getText()); // se guarda la contraseña desde la ventana
            return u; // se devuelve el objeto temporal
        }
    }

    ////// LISTAR USUARIOS
    public void listarTodosLosMonos() {

        ArrayList<UsuarioDTO> usuarios = usuarioDAO.traerTabla("registrousuario");
//        for(int i=0; i<usuarios.size(); i++){
//            System.out.println(usuarios.get(i).getNombreUsuario()); 
//        }
    }

    ////// GETTERS & SETTERS
    public void setRegistroIngreso(Control_RegistroIngreso registroIngreso) {
        this.registroIngreso = registroIngreso;
    }

    public void setConexion(ConexBDD conexion) {
        this.conexion = conexion;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

//    public UsuarioDTO getUsuario() {
//        return usuarioDTO;
//    }
}
