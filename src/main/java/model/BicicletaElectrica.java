package model;

/**
 * Bicicleta electrica (con motor y bateria).
 * Atributos PROPIOS: potencia del motor (W) y capacidad de la bateria (Wh).
 * NO tiene cantidad de cambios, tipo de freno ni canasto.
 */
public class BicicletaElectrica extends Bicicleta {

    private int potenciaMotorW;       // ej: 250, 500, 750
    private int capacidadBateriaWh;   // ej: 400, 500, 700

    public BicicletaElectrica() {
    }

    public BicicletaElectrica(String codigo, String marca, String modelo, int aro, String color,
                              int potenciaMotorW, int capacidadBateriaWh) {
        super(codigo, marca, modelo, aro, color);
        this.potenciaMotorW = potenciaMotorW;
        this.capacidadBateriaWh = capacidadBateriaWh;
    }

    @Override
    public String getTipo() {
        return "Eléctrica";
    }

    @Override
    public double calcularCostoMantencion() {
        return 25000 + (potenciaMotorW * 15) + (capacidadBateriaWh * 10);
    }

    /** Metodo EXCLUSIVO de la electrica: la tradicional no lo tiene. */
    public double calcularAutonomiaKm() {
        // aproximacion: una bici electrica consume ~15 Wh por kilometro
        return capacidadBateriaWh / 15.0;
    }

    /** Metodo EXCLUSIVO de la electrica. */
    public String diagnosticarBateria() {
        String nivel;
        if (capacidadBateriaWh >= 600) {
            nivel = "alta capacidad";
        } else if (capacidadBateriaWh >= 400) {
            nivel = "capacidad media";
        } else {
            nivel = "baja capacidad";
        }
        return String.format("Bateria de %s (%d Wh). Autonomia estimada: %.1f km.",
                nivel, capacidadBateriaWh, calcularAutonomiaKm());
    }

    public int getPotenciaMotorW() {
        return potenciaMotorW;
    }

    public void setPotenciaMotorW(int potenciaMotorW) {
        this.potenciaMotorW = potenciaMotorW;
    }

    public int getCapacidadBateriaWh() {
        return capacidadBateriaWh;
    }

    public void setCapacidadBateriaWh(int capacidadBateriaWh) {
        this.capacidadBateriaWh = capacidadBateriaWh;
    }
}
