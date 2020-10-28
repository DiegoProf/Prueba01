package DataTypes;

/**
 * @author Grupo B
 */
public class Usuario { // MOMENTÁNEAMENTE SIN USO

    private int id;
    private String nombreUsuario;
    private String clave;
    private String tipoPerfil;
    private int nivelJuego;

    /// GET & SET

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
