package model;

/**
 * En esta clase se definirá el paseo Lacustre.
 * Se definirá el tipo de embarcación que se usará para realizar el paseo.
 *
 * @author consu
 * @version 1.0.
 * */
public class PaseoLacustre extends ServicioTuristico implements Registrable {

    private String tipoEmbarcacion;

    /**
     * Constructor con parámetros.
     * Construye el paseo lacustre con sus distintos atributos.
     *
     * @param nombre               nombre del paseo lacustre.
     * @param duracionHoras        duración que se le asignara al paseo lacustre
     * @param tipoEmbarcacion      tipo de embarcación que se usará en el paseo
     * */

    public PaseoLacustre(String nombre, double duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    /**
     * Obtiene el tipo de embarcación
     * @return tipoEmbarcacion
     * */

    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }



    /**
     * Muestra un resumen del paseo lacustre.
     * */
    @Override
    public void mostrarResumen() {
        System.out.println("Paseo lacustre: " + nombre);
    }


    /**
     * Muestra la información completa del paseo lacustre,
     * incluyendo nombre, duración, tipo de embarcación.
     */
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tipo de embarcación: " + getTipoEmbarcacion());
    }

    /**
     * Representa el paseo lacustre como texto,
     * mostrando su nombre, duración y tipo de embarcación.
     *
     * @return una cadena con los datos del paseo lacustre.
     */
    @Override
    public String toString() {
        return "[Paseo Lacustre]\n" +
                super.toString() + "\n" +
                "Tipo de embarcación: " + tipoEmbarcacion;
    }
}
