package model;

/**
 * Bicicleta tradicional (sin motor).
 * Atributos PROPIOS: cantidad de cambios, tipo de freno y si lleva canasto.
 * NO tiene motor ni bateria.
 */
public class BicicletaTradicional extends Bicicleta {

    private int cantidadCambios;   // 1 = sin cambios (piñon fijo)
    private String tipoFreno;      // "Zapata", "V-Brake" o "Disco"
    private boolean tieneCanasto;

    public BicicletaTradicional() {
    }

    public BicicletaTradicional(String codigo, String marca, String modelo, int aro, String color,
                                int cantidadCambios, String tipoFreno, boolean tieneCanasto) {
        super(codigo, marca, modelo, aro, color);
        this.cantidadCambios = cantidadCambios;
        this.tipoFreno = tipoFreno;
        this.tieneCanasto = tieneCanasto;
    }

    @Override
    public String getTipo() {
        return "Tradicional";
    }

    @Override
    public double calcularCostoMantencion() {
        double costo = 10000 + (cantidadCambios * 500);
        if ("Disco".equals(tipoFreno)) {
            costo += 8000;   // los frenos de disco cuestan mas de mantener
        } else {
            costo += 3000;
        }
        return costo;
    }

    /** Metodo EXCLUSIVO de la tradicional: la electrica no lo tiene. */
    public String revisarCambios() {
        if (cantidadCambios <= 1) {
            return "Bicicleta de piñon fijo: no hay cambios que calibrar.";
        }
        return "Se calibraran los " + cantidadCambios + " cambios y se lubricara la cadena.";
    }

    public int getCantidadCambios() {
        return cantidadCambios;
    }

    public void setCantidadCambios(int cantidadCambios) {
        this.cantidadCambios = cantidadCambios;
    }

    public String getTipoFreno() {
        return tipoFreno;
    }

    public void setTipoFreno(String tipoFreno) {
        this.tipoFreno = tipoFreno;
    }

    public boolean isTieneCanasto() {
        return tieneCanasto;
    }

    public void setTieneCanasto(boolean tieneCanasto) {
        this.tieneCanasto = tieneCanasto;
    }
}
