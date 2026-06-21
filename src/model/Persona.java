package model;



/**
 * Esta clase representa a una persona vinculada a la agencia Llanquihue Tour.
 * Contiene información básica como nombre, rut, teléfono y dirección.
 *
 * @author consu
 * @version 1.0
 */
public class Persona {

    private String nombre;
    private Rut rut;
    private String numeroDeTelefono;
    private Direccion direccion;

    /**
     * Constructor con parámetros
     * Inicializa con valores establecidos
     *
     * @param nombre              Nombre completo de la persona
     * @param rut                 Número de rut de la persona
     * @param numeroDeTelefono    Número de telefono de la persona
     * @param direccion           Dirección de la persona
     * */
    public Persona(String nombre, Rut rut, String numeroDeTelefono, Direccion direccion){
        this.nombre = nombre;
        this.rut = rut;
        this.numeroDeTelefono = numeroDeTelefono;
        this.direccion = direccion;
    }

    //----------------------
    //------Getters---------
    //----------------------


    /**
     * Obtiene el nombre de la persona
     * @return nombre
     * */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el número de Rut de la persona
     * @return rut
     */
    public Rut getRut() {
        return rut;
    }

    /**
     * Obtiene el número de teléfono de la persona
     * @return numeroDeTelefono
     * */
    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    /**
     * Obtiene la dirección de la persona
     * @return direccion
     * */
    public Direccion getDireccion() {
        return direccion;
    }

    //------------------------
    //-------Setters----------
    //------------------------

    /**
     * Establece el nombre de la persona
     * @param nombre nombre a asignar
     * */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el número de telefono de la persona
     * @param numeroDeTelefono número de telefono a asignar
     * */
    public void setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }

    /**
     *
     * Establece la dirección de la persona.
     * @param direccion dirección a asignar.
     * */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Retorna una descripción legible de las características de una persona
     * @return String con los datos de la persona
     * */
    @Override
    public String toString(){
        return "=== Persona ===" +
                "\nNombre: " + nombre +
                "\nNúmero de telefono: " + numeroDeTelefono +
                "\n" + rut +
                "\n--- Dirección --- " + direccion;

    }
}
