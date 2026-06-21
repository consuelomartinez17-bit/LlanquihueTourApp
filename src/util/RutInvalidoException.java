package util;

/**
 * Excepción personalizada para RUT inválidos
 * @author consu
 * @version 1.0
 * */
public class RutInvalidoException extends Exception{

    /**
     * Constructor con el mensaje de error.
     * @param mensaje descripción del error ocurrido
     */
    public RutInvalidoException(String mensaje){
        super(mensaje);
    }
}