package Persistencia;

import Controlador.Control_Logica;
import DataTypes.UsuarioDTO;
import com.mysql.jdbc.PreparedStatement;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioDAO { // DATA ACCESS OBJECT
    // objeto encargado de hablar con la BDD

    Control_Logica controlLogica = new Control_Logica(); // se relaciona con controlLogica

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// INSERTAR USUARIO
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean insertarUsuario(UsuarioDTO usuarioDTO) {

        try { // se ejecuta dentro de un try porque el método insertarUsuario involucra operaciones con BDD
            // (1) OBTENER LA CONEXION
            Connection conexion = ConexBDD.conectar(); // se realia la conexion y se guarda en un objeto Connection
            // (2) DEFINIR EL SQL A UTILIZAR
            String sql = "INSERT INTO registrousuario (NombreUsuario, Clave, TipoPerfil) VALUES (?, ?, ?)"; // String para completar sustituyendo los '?'
            // (3) DEFINIR EL OBJETO JDBC PARA OPERAR
            PreparedStatement pst = (PreparedStatement) conexion.prepareStatement(sql); // se prepara una pst con el String sql y se guarda
            pst.setString(1, usuarioDTO.getNombreUsuario()); // se sustituyen los '?' indicando en que columnas deben insertarse los datos
            pst.setString(2, usuarioDTO.getClave());
            pst.setString(3, usuarioDTO.getTipoPerfil());
            try {
                pst.executeUpdate(); // se ejecuta la sentencia
                JOptionPane.showMessageDialog(null, "Usuario ingresado con éxito!!!");
                return true;
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR EL USUARIO!!!");
            }
            // (4) EJECUTAR >>> INSERT, UPDATE y DELETE: executeUpdate() | ALTER, CREATE y DROP: execute() | SELECT: executeQuery() -> ResultSet                  
            int result = pst.executeUpdate(); // se guarda 1 o 0 según se haya ejecutado con éxito o no
            // (5) MANIPULAR LOS RESULTADOS
            if (result > 0) { // se evalúa si fue ejecutada con éxito para cerrar los objetos
                conexion.close(); // se cierra la conexion
                pst.close(); // se cierra la sentencia
                return true;
            }
            // (6) CERRAR OBJETOS JDBC UTILIZADOS
            conexion.close();
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            System.err.println(e);
        }
        return false;
    } // FIN INSERTAR USUARIO

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// BUSCAR POR NOMBRE
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public UsuarioDTO buscarPorNombre(String nombreTabla, String nombreUsuario) { // 

        UsuarioDTO u = new UsuarioDTO(); // usuario temporal para manejar los resultados de la consulta
        ResultSet result = null; // objeto ResultSet para almacenar los resultados de la consulta
        try {

            // (1) OBTENER LA CONEXION
            Connection conexion = ConexBDD.conectar(); // se realia la conexion y se guarda en un objeto Connection
            // (2) DEFINIR EL SQL A UTILIZAR
            String sql = "SELECT * FROM " + nombreTabla + " WHERE NombreUsuario = " + "\'" + nombreUsuario + "\'";
            // (3) DEFINIR EL OBJETO JDBC PARA OPERAR
            Statement st = (Statement) conexion.createStatement(); // se prepara una pst y se guarda
            // (4) EJECUTAR >>> INSERT, UPDATE y DELETE: executeUpdate() | ALTER, CREATE y DROP: execute() | SELECT: executeQuery() -> ResultSet                  
            try {
                result = st.executeQuery(sql); // se ejecuta la consulta y se almacena en result
                System.out.println("La consulta se ejecutó con éxito.");

                if (result.next()) { // si result no está vacío
                    u.setId(result.getInt(1)); // asigna los valores al usuario temporal indicando la columna de origen
                    u.setNombreUsuario(result.getString(2));
                    u.setClave(result.getString(3));
                    u.setTipoPerfil(result.getString(4));
                    u.setNivelJuego(result.getInt(5));
                }

            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "NO SE PUDO EJECUTAR LA CONSULTA!!!");
            }
            // (5) MANIPULAR LOS RESULTADOS
            if (result != null) { // si result no está vacío
                conexion.close(); // cerrar conexión
                st.close(); // cerrar sentencia
                result.close(); // cerrar ResultSet
                return u; // devolver usuario temporal
            }
            // (6) CERRAR OBJETOS JDBC UTILIZADOS (y si es posible, la conexión)
            conexion.close();
            st.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    } /// FIN BUSCAR POR NOMBRE

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// TRAER UNA TABLA
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<UsuarioDTO> traerTabla(String nombreTabla) { // 

        ArrayList<UsuarioDTO> listaUsuarios = new ArrayList<>(); // lista temporal de usuarios para manejar los resultados de la consulta
        UsuarioDTO u = new UsuarioDTO(); // usuario temporal
        ResultSet result = null; // objeto ResultSet para almacenar los resultados de la consulta

        try {

            // (1) OBTENER LA CONEXION
            Connection conexion = ConexBDD.conectar(); // se realia la conexion y se guarda en un objeto Connection
            // (2) DEFINIR EL SQL A UTILIZAR
            String sql = "SELECT * FROM " + nombreTabla;
            // (3) DEFINIR EL OBJETO JDBC PARA OPERAR
            Statement st = (Statement) conexion.createStatement(); // se prepara una pst y se guarda
            // (4) EJECUTAR >>> INSERT, UPDATE y DELETE: executeUpdate() | ALTER, CREATE y DROP: execute() | SELECT: executeQuery() -> ResultSet                  
            try {
                result = st.executeQuery(sql); // se ejecuta la consulta y se almacena en result
                System.out.println("La consulta se ejecutó con éxito.");

                
                Object fila;
                int cont=1;
                //ArrayList<UsuarioDTO> listaUsuarios = new ArrayList<>(); // lista temporal de usuarios para manejar los resultados de la consulta
                while (result.next()) { // mientras result no esté vacío
                    u.setId(result.getInt("id")); // asigna los valores al usuario temporal indicando la columna de origen
                    u.setNombreUsuario(result.getString("NombreUsuario"));
                    u.setClave(result.getString("Clave"));
                    u.setTipoPerfil(result.getString("TipoPerfil"));
                    u.setNivelJuego(result.getInt("NivelJuego"));
                        

                    
                    
//                    System.out.print(result.getInt(1));
//                    System.out.print(" - "+result.getString(2));
//                    System.out.print(" - "+result.getString(3));
//                    System.out.println(" - "+result.getString(4));
                    
                    listaUsuarios.add(u);
                    
                }

                for (int i = 0; i < listaUsuarios.size(); i++) {
                    System.out.print(listaUsuarios.get(i).getNombreUsuario());
                    System.out.print("-"+listaUsuarios.get(i).getClave());
                    System.out.println("-"+listaUsuarios.get(i).getTipoPerfil());
                }
                
                
                
                
                

            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "NO SE PUDO EJECUTAR LA CONSULTA!!!");
            }
            // (5) MANIPULAR LOS RESULTADOS
            if (result != null) { // si result no está vacío
                conexion.close(); // cerrar conexión
                st.close(); // cerrar sentencia
                result.close(); // cerrar ResultSet
                return listaUsuarios; // devolver lista temporal
            }
            // (6) CERRAR OBJETOS JDBC UTILIZADOS (y si es posible, la conexión)
            conexion.close();
            st.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    } /// FIN TRAER TABLA

    ////// SETTER
    public void setControlLogica(Control_Logica controlLogica) {
        this.controlLogica = controlLogica;
    }

}
