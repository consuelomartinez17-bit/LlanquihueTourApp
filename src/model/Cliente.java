package model;


/**
 * Esta clase representa a un cliente de la agencia Llanquihue Tour.
 * Contiene información como tipo de servicio, cantidad de pasajeros,
 * y también si es que requiere traductor.
 *
 * @author consu
 * @version 1.0
 */
public class Cliente extends Persona{

    private String tipoDeServicio;
    private int cantidadDePasajeros;
    private boolean necesitaTraductor;


    /**
     * Constructor con parámetros.
     * Se inicializa con datos establecidos
     *
     * @param nombre                         el nombre del cliente
     * @param rut                            el número de rut del cliente
     * @param numeroDeTelefono               el número de teléfono del cliente
     * @param direccion                      la dirección del cliente
     * @param tipoDeServicio                 el tipo de servicio que solicitó el cliente
     * @param cantidadDePasajeros            la cantidad de personas que visitaran el Tour.
     * @param necesitaTraductor              necesita/n traductor/es lo/s asistentes al Tour
     * */
    public Cliente(String nombre,Rut rut, String numeroDeTelefono, Direccion direccion, String tipoDeServicio, int cantidadDePasajeros, boolean necesitaTraductor){
        super(nombre, rut, numeroDeTelefono, direccion);
        this.tipoDeServicio = tipoDeServicio;
        this.cantidadDePasajeros = cantidadDePasajeros;
        this.necesitaTraductor = necesitaTraductor;
    }

    //----------------------
    //------Getters---------
    //----------------------

    /**
     * Obtiene el tipo de servicio solicitado por el cliente
     * @return tipoDeServicio
     * */
    public String getTipoDeServicio() {
        return tipoDeServicio;
    }

    /**
     * Obtiene la cantidad de pasajeros que solicitan el servicio
     * @return cantidadDePasajeros
     * */
    public int getCantidadDePasajeros() {
        return cantidadDePasajeros;
    }

    /**
     * Obtiene la respuesta si es que necesita traductor
     * @return necesitaTraductor
     * */
    public boolean isNecesitaTraductor() {
        return necesitaTraductor;
    }

    //----------------------
    //------Setters---------
    //----------------------

    /**
     * Establece el tipo de servicio que requiere el cliente
     * @param tipoDeServicio tipo de servicio a asignar
     * */
    public void setTipoDeServicio(String tipoDeServicio) {
        this.tipoDeServicio = tipoDeServicio;
    }

    /**
     * Establece la cantidad de pasajeros que requieren el servicio
     * @param cantidadDePasajeros la cantidad de personas que visitarán el tour.
     * */
    public void setCantidadDePasajeros(int cantidadDePasajeros) {
        this.cantidadDePasajeros = cantidadDePasajeros;
    }
    /**
     * Establece la necesidad de traductor del cliente
     * @param necesitaTraductor indica si los asistentes requieren traductor.
     * */
    public void setNecesitaTraductor(boolean necesitaTraductor) {
        this.necesitaTraductor = necesitaTraductor;
    }


    /**
     * Retorna una descripción legible del cliente de Llanquihue Tour.
     * @return String con los datos del cliente formateados
     */
    @Override
    public String toString(){
        return "=== Cliente ===" +
                "\nNombre: " + getNombre() +
                "\nNúmero de teléfono: " + getNumeroDeTelefono() +
                "\n" + getRut() +
                "\n--- Dirección ---" + getDireccion() +
                "\n--- Datos del servicio ---" +
                "\nTipo de servicio: " + tipoDeServicio +
                "\nCantidad de pasajeros: " + cantidadDePasajeros +
                "\nNecesita traductor: " + (necesitaTraductor ? "Sí" : "No");
    }
}

