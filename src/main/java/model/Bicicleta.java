package model;

/**
 * SUPER CLASE del taller. Contiene lo que tienen EN COMUN
 * todas las bicicletas, sin importar si son tradicionales o electricas.
 *
 * Es abstracta: no tiene sentido crear una "bicicleta generica",
 * siempre sera de un tipo concreto (hija).
 */
public abstract class Bicicleta {

    private String codigo;   // identificador unico (como la matricula del estudiante)
    private String marca;
    private String modelo;
    private int aro;         // 20, 26, 27, 29 ...
    private String color;

    public Bicicleta() {
    }

    public Bicicleta(String codigo, String marca, String modelo, int aro, String color) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.aro = aro;
        this.color = color;
    }

    /* ---------- Metodos que CADA HIJA debe implementar a su manera ---------- */

    /** Devuelve "Tradicional" o "Eléctrica". Sirve para mostrar el tipo en la tabla. */
    public abstract String getTipo();

    /** El costo de la mantencion depende del tipo de bicicleta. */
    public abstract double calcularCostoMantencion();

    /* ---------- Getters y setters ---------- */

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAro() {
        return aro;
    }

    public void setAro(int aro) {
        this.aro = aro;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
