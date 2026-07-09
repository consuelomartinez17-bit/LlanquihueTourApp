package model;

/**
 * Representa a un guía turístico contratado por la agencia
 * Llanquihue Tour para acompañar los distintos servicios ofrecidos.
 *
 * @author consu
 * @version 1.0
 */
public class GuiaTuristico extends RecursoAgencia {

    private String idioma;
    private int aniosExperiencia;

    /**
     * Constructor con parámetro.
     * Construye un guía turístico con sus datos particulares.
     *
     * @param nombre           nombre del guía turístico
     * @param id               identificador único del guía
     * @param idioma           idioma principal en que atiende el guía
     * @param aniosExperiencia años de experiencia como guía turístico
     */
    public GuiaTuristico(String nombre, int id, String idioma, int aniosExperiencia) {
        super(nombre, id);
        this.idioma = idioma;
        this.aniosExperiencia = aniosExperiencia;
    }

    /**
     * Obtiene el idioma principal del guía.
     * @return idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * Obtiene los años de experiencia del guía.
     * @return aniosExperiencia
     */
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    /**
     * Muestra un resumen del guía turístico, incluyendo nombre,
     * idioma y años de experiencia.
     */
    @Override
    public void mostrarResumen() {
        System.out.println("Guía turístico: " + nombre + " | Idioma: " + idioma
                + " | Experiencia: " + aniosExperiencia + " años");
    }
}