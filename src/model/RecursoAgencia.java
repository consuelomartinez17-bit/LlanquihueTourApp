package model;

/**
 * Clase base abstracta para los recursos operativos de la agencia
 * (guías, vehículos, colaboradores externos) que no forman parte
 * de la jerarquía de servicios turísticos, pero que igualmente
 * deben poder gestionarse de forma unificada mediante Registrable.
 *
 * @author consu
 * @version 1.0
 */
public abstract class RecursoAgencia implements Registrable {

    protected String nombre;
    protected int id;

    /**
     * Constructor con parámetro.
     * Construye un recurso de la agencia con sus datos básicos comunes.
     *
     * @param nombre nombre identificatorio del recurso
     * @param id     identificador numérico único del recurso
     */
    public RecursoAgencia(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    /**
     * Obtiene el nombre del recurso.
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el identificador único del recurso.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Muestra un resumen del recurso. Cada subclase debe personalizar
     * este mensaje según el tipo específico de recurso que representa.
     */
    @Override
    public abstract void mostrarResumen();
}