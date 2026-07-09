package model;


import java.util.List;
/**
 * En esta clase se definirá la ruta gastronómica que entrega Llanquihue Tour.
 * Mediante una lista donde se guardaran las paradas.
 *
 * @author consu
 * @version 1.0.
 * */

public class RutaGastronomica extends ServicioTuristico implements Registrable{

    private List<String> paradas;


    /**
     * Constructor con parametro.
     * Construye la ruta gastronómica, con sus distintas paradas.
     * @param nombre              nombre de la ruta gastronómica
     * @param duracionHoras       duracion de la ruta gastronómica
     * @param paradas             listado con los nombres de cada parada de la ruta
     *
     * */
    public RutaGastronomica(String nombre, double duracionHoras, List<String> paradas) {
        super(nombre, duracionHoras);
        this.paradas = paradas;
    }


    /**
     * Obtiene la cantidad de paradas de la ruta gastronómica.
     * @return numeroDeParadas
     * */
    public int getNumeroDeParadas() {
        return paradas.size();
    }

    /**
     * Obtiene el listado de paradas de la ruta gastronómica.
     * @return paradas
     * */
    public List<String> getParadas() {
        return paradas;
    }


    /**
     * Muestra un resumen de la ruta gastronómica.
     */

    @Override
    public void mostrarResumen() {
        System.out.println("Ruta gastronómica: " + nombre);
    }

    /**
     * Muestra la información completa de la ruta gastronómica,
     * incluyendo nombre, duración, número de paradas y lista de paradas.
     */
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Número de paradas: " + getNumeroDeParadas());
        System.out.println("Paradas: " + paradas);
    }

    /**
     * Muestra los datos de la ruta gastronómica con sus respectivas paradas.
     * @return String con los datos de la ruta gastronómica.
     * */
    @Override
    public String toString() {
        return "[Ruta Gastronómica]\n" +
                super.toString() + "\n" +
                "Número de paradas: " + getNumeroDeParadas() + "\n" +
                "Paradas: " + paradas;
    }

}