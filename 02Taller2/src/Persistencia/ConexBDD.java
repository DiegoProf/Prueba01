package Persistencia;

import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexBDD{ // clase encargada de conectarse a la BDD

    public static final String URL = "jdbc:mysql://localhost:3306/01_Taller2"; // conexión con servidor: dirección, puerto y nombre de la base de datos
    public static final String USER = "root"; // nombre solicitado por la BDD para la conexión
    public static final String PASS = "123abc"; // contraseña solicitada por la BDD para la conexión
    public static final String DRIVER = "com.mysql.jdbc.Driver"; // driver utilizado en el programa

    // Constructor
    public ConexBDD(){
    }
    
    /// METODO PARA CONECTAR A LA BASE DE DATOS
    public static Connection conectar() { // método static: se puede invocar sin necesidad de instanciar un objeto
        Connection conexion = null;
        try {
            Class.forName(DRIVER);
            conexion = (Connection) DriverManager.getConnection(URL, USER, PASS); // se debe realizar un casteo a Connection
            System.out.println("Se ha conectado a la Base de Datos..."); // mensaje de éxito
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e); // mensaje de error
        }
        return conexion; // devuelve la conexión
    }

}
