package model;

/**
 * En esta clase se definirá el servicio turístico que entrega Llanquihue Tour.
 * Con su nombre y tiempo de duración del tour.
 *
 * @author consu
 * @version 1.0.
 * */

public class ServicioTuristico {

    protected String nombre;
    protected double duracionHoras;

    /**
     * Constructor con parámetros
     * Construye el servicio turístico.
     *
     * @param nombre           nombre del servicio turístico
     * @param duracionHoras    cantidad de horas que dura el servicio
     * */
    public ServicioTuristico(String nombre, double duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    //-------------------------------------
    //-----------Getters-------------------
    //-------------------------------------

    /**
     * Obtiene el nombre del servicio turístico
     * @return nombre
     * */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la duración del servicio turístico
     * @return duracionHoras
     * */
    public double getDuracionHoras() {
        return duracionHoras;
    }

    /**
     * Muestra la información del servicio turístico por consola.
     * Las subclases deben sobrescribir este método para mostrar
     * su información específica.
     * */
    public void mostrarInformacion() {
        System.out.println("Servicio Turístico" +
                "\nNombre: " + nombre +
                "\nDuración: " + duracionHoras + " hrs");
    }


    /**
     * Muestra los datos del servicio turístico con su duración.
     * @return String con los datos del servicio turístico.
     * */
    @Override
    public String toString() {
        return "Servicio Turístico" +
                "\nNombre: " + nombre +
                "\nDuración: " + duracionHoras + " hrs";
    }
}