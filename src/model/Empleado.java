package model;




/**
 * Esta clase representa a un empleado vinculado a la agencia Llanquihue Tour.
 * Contiene información básica como nombre, rut, teléfono y dirección.
 * Además de cargo, jornada y turno.
 *
 * @author consu
 * @version 1.0
 */
public class Empleado extends Persona{

    private String cargo;
    private String jornada;
    private String turno;


    /**
     * Constructor con parámetros.
     * Se inicializa con datos establecidos
     *
     * @param nombre             el nombre del empleado
     * @param rut                el número de rut del empleado
     * @param numeroDeTelefono   el número de teléfono del empleado
     * @param direccion          la dirección del empleado
     * @param cargo              el cargo de el empleado
     * @param jornada            la jornada del empleado
     * @param turno              el turno del empleado
     * */
    public Empleado(String nombre, Rut rut, String numeroDeTelefono, Direccion direccion, String cargo, String jornada, String turno){
        super(nombre, rut, numeroDeTelefono, direccion);
        this.cargo = cargo;
        this.jornada = jornada;
        this.turno = turno;
    }

    //----------------------
    //------Getters---------
    //----------------------

    /**
     * Obtiene el cargo de empleado
     * @return cargo
     * */
    public String getCargo() {
        return cargo;
    }

    /**
     * Obtiene la jornada de empleado
     * @return jornada
     * */
    public String getJornada() {
        return jornada;
    }

    /**
     * Obtiene el turno de empleado
     * @return turno
     * */
    public String getTurno() {
        return turno;
    }

    //----------------------
    //------Setters---------
    //----------------------

    /**
     * Establece el cargo del empleado
     * @param cargo cargo a asignar
     * */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Establece la jornada del empleado
     * @param jornada jornada a asignar
     * */
    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    /**
     * Establece el turno del empleado
     * @param turno turno a asignar
     * */
    public void setTurno(String turno) {
        this.turno = turno;
    }

    /**
     * Retorna una descripción legible del empleado vinculado a Llanquihue Tour.
     * @return String con los datos del empleado formateado
     * */
    @Override
    public String toString(){
        return "=== Empleado ===" +
                "\nNombre: " + getNombre() +
                "\nNúmero de teléfono: " + getNumeroDeTelefono() +
                "\n" + getRut() +
                "\n--- Dirección ---" + getDireccion() +
                "\n--- Datos laborales ---" +
                "\nCargo: " + cargo +
                "\nJornada: " + jornada +
                "\nTurno: " + turno;

    }
}
