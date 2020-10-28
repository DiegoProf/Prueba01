package DataTypes;

/**
 * @author Grupo B
 */
public class UsuarioDTO { // DATA TRANSFER OBJECT
                          // Objeto utilizado para transferir datos entre clases

    /// Atributos
    private int id;
    private String nombreUsuario;
    private String clave;
    private String tipoPerfil;
    private int nivelJuego;

    
    /// GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(String tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public int getNivelJuego() {
        return nivelJuego;
    }

    public void setNivelJuego(int nivelJuego) {
        this.nivelJuego = nivelJuego;
    }
    

}
