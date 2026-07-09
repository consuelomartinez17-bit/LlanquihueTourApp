package model;

/**
 * Representa un vehículo utilizado por la agencia Llanquihue Tour
 * para el traslado de pasajeros durante los distintos servicios turísticos.
 *
 * @author consu
 * @version 1.0
 */
public class Vehiculo extends RecursoAgencia {

    private String patente;
    private int capacidadPasajeros;

    /**
     * Constructor con parámetro.
     * Construye un vehículo con sus datos particulares.
     *
     * @param nombre             nombre o modelo identificatorio del vehículo
     * @param id                 identificador único del vehículo
     * @param patente            patente del vehículo
     * @param capacidadPasajeros cantidad máxima de pasajeros que puede transportar
     */
    public Vehiculo(String nombre, int id, String patente, int capacidadPasajeros) {
        super(nombre, id);
        this.patente = patente;
        this.capacidadPasajeros = capacidadPasajeros;
    }

    /**
     * Obtiene la patente del vehículo.
     * @return patente
     */
    public String getPatente() {
        return patente;
    }

    /**
     * Obtiene la capacidad de pasajeros del vehículo.
     * @return capacidadPasajeros
     */
    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    /**
     * Muestra un resumen del vehículo, incluyendo nombre, patente
     * y capacidad de pasajeros.
     */
    @Override
    public void mostrarResumen() {
        System.out.println("Vehículo: " + nombre + " | Patente: " + patente
                + " | Capacidad: " + capacidadPasajeros + " pasajeros");
    }
}
