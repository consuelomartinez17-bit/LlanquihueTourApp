package model;

/**
 * En esta clase se definirá la excursión cultural.
 * Se definirá el lugar histórico a visitar en la excursión.
 *
 * @author consu
 * @version 1.0.
 * */

public class ExcursionCultural extends ServicioTuristico{

    private String lugarHistorico;


    /**
     * Constructor con parámetros.
     * Construye la excursión cultural.
     *
     * @param nombre              nombre de la excursión cultural
     * @param duracionHoras       duración de la excursión
     * @param lugarHistorico      lugar histórico a visitar en la excursión
     * */
    public ExcursionCultural(String nombre, double duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }


    /**
     * Obtiene el lugar histórico
     * @return lugarHistorico
     * */
    public String getLugarHistorico() {
        return lugarHistorico;
    }

    /**
     * Representa la excursión cultural como texto,
     * mostrando su nombre, duración y lugar histórico.
     *
     * @return una cadena con los datos del lugar histórico.
     */
    @Override
    public String toString() {
        return "[Excursión Cultural]\n" +
                super.toString() + "\n" +
                "Lugar histórico: " + lugarHistorico;
    }


}