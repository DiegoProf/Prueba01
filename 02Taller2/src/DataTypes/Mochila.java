
package DataTypes;

/**
 *
 * @author Grupo B
 */
public class Mochila { // MOMENTÁNEAMENTE SIN USO
    
    private int id;
    private String [] comandos;
    private Carta [] cartas;
    
    
    /// GET & SET
    public String[] getComandos() {
        return comandos;
    }

    public void setComandos(String[] comandos) {
        this.comandos = comandos;
    }

    public Carta[] getCartas() {
        return cartas;
    }

    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
