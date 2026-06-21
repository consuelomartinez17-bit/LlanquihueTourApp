package model;


/**
 * Esta clase representa la dirección. Aqui se encontraran sus caracteristicas principales como lo son:
 * numero de vivienda, ya sea casa o departamento. Nombre de la calle, ciudad y región.
 *
 * @author consu
 * @version 1.0
 * */
public class Direccion {
    private String numeroDeVivienda;
    private String calle;
    private String ciudad;
    private String region;


    /**
     * Constructor vacio sin parametros
     * Inicializa la dirección con valores por defecto
     * */
    public Direccion(){
        this.numeroDeVivienda = "Sin número";
        this.calle = "Sin información";
        this.ciudad = "Sin información";
        this.region = "Sin información";
    }

    /**
     * Constructor con parametros
     *Inicializa la dirección con valores establecidos
     *
     * @param numeroDeVivienda     numero de vivienda de la dirección
     * @param calle                nombre de la calle de la dirección
     * @param ciudad               nombre de la ciudad de la dirección
     * @param region               nombre de la region de la dirección
     */
    public Direccion(String numeroDeVivienda, String calle, String ciudad, String region){
        this.numeroDeVivienda = numeroDeVivienda;
        this.calle = calle;
        this.ciudad = ciudad;
        this.region = region;
    }

    //------------------------
    //-------Getters----------
    //------------------------

    /**
     * Obtiene el numero de la vivienda de la dirección
     * @return numeroDeVivienda numero de la vivienda en la dirección
     * */
    public String getNumeroDeVivienda() {
        return numeroDeVivienda;
    }

    /**
     * Obtiene el nombre de la calle de la dirección
     * @return calle  calle de la dirección
     * */
    public String getCalle(){
        return calle;
    }

    /**
     * Obtiene el nombre de la ciudad de la dirección
     * @return ciudad  ciudad de la dirección
     * */
    public String getCiudad(){
        return ciudad;
    }
    /**
     * Obtiene el nombre de la región de la dirección
     * @return region  región de la dirección
     * */
    public String getRegion(){
        return region;
    }

    //------------------------
    //-------Setters----------
    //------------------------

    /**
     * Establece el numero de la vivienda de la dirección
     * @param numeroDeVivienda  número de vivienda a asignar en la dirección
     * */
    public void setNumeroDeVivienda(String numeroDeVivienda) {
        this.numeroDeVivienda = numeroDeVivienda;
    }

    /**
     * Establece el nombre de la calle de la dirección
     * @param calle  calle a asignar en la dirección
     * */
    public void setCalle(String calle) {
        this.calle = calle;
    }
    /**
     * Establece el nombre de la ciudad de la dirección
     * @param ciudad  ciudad a asignar en la dirección
     * */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    /**
     * Establece el nombre de la region de la dirección
     * @param region  region a asignar en la dirección
     * */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Retorna una descripción legible de la dirección.
     * @return String con los datos de la dirección formateados
     */
    @Override
    public String toString(){
        return  "\nNumero de vivienda: " + numeroDeVivienda +
                "\nCalle: " + calle +
                "\nCiudad: " + ciudad +
                "\nRegión: " + region;
    }

}
