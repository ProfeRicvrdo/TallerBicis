package model;

import java.util.ArrayList;

/**
 * Clase GESTORA (equivalente a "Escuela" del CRUD de estudiantes).
 * La lista guarda objetos de tipo Bicicleta, pero dentro hay
 * BicicletaTradicional y BicicletaElectrica mezcladas (POLIMORFISMO).
 */
public class Taller {

    private ArrayList<Bicicleta> listaBicicletas;

    public Taller() {
        this.listaBicicletas = new ArrayList<>();
    }

    /** @return true si se agrego, false si ya existia una bicicleta con ese codigo */
    public boolean agregarBicicleta(Bicicleta nueva) {
        for (Bicicleta b : listaBicicletas) {
            if (b.getCodigo().equals(nueva.getCodigo())) {
                return false;
            }
        }
        listaBicicletas.add(nueva);
        return true;
    }

    public void eliminarBicicleta(Bicicleta eliminar) {
        listaBicicletas.remove(eliminar);
    }

    /**
     * Reemplaza la bicicleta que tenga el mismo codigo por la que llega actualizada.
     * @return true si la encontro y la reemplazo
     */
    public boolean actualizarBicicleta(Bicicleta actualizada) {
        for (int i = 0; i < listaBicicletas.size(); i++) {
            if (listaBicicletas.get(i).getCodigo().equals(actualizada.getCodigo())) {
                listaBicicletas.set(i, actualizada);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Bicicleta> getListaBicicletas() {
        return listaBicicletas;
    }

    /** Datos de ejemplo para no partir con la tabla vacia al probar. */
    public void cargarDatosDePrueba() {
        agregarBicicleta(new BicicletaTradicional("T-001", "Trek", "Marlin 5", 29, "Rojo", 21, "Disco", false));
        agregarBicicleta(new BicicletaTradicional("T-002", "Oxford", "City", 26, "Azul", 1, "Zapata", true));
        agregarBicicleta(new BicicletaElectrica("E-001", "Specialized", "Turbo Vado", 28, "Negro", 250, 500));
        agregarBicicleta(new BicicletaElectrica("E-002", "Giant", "Explore E+", 27, "Gris", 500, 700));
    }
}
