package model;

import util.RutInvalidoException;

/**
 * En esta clase se representará el rut de la persona.
 * Se realiza validación del rut(que tenga el formato correcto)
 *
 * @author consu
 * @version 1.0
 * */
public class Rut {
    private String numero;

    /**
     * Constructor con parametros y validacion del rut.
     * El formato esperado es XXXXXXXX-Y (dígitos, guión, dígito o k/K).
     * @param numero    numero de rut de la persona
     * @throws RutInvalidoException si el formato del RUT es inválido
     */
    public Rut(String numero)throws RutInvalidoException{
        if(numero.matches("[0-9]+-[0-9kK]")){
            this.numero = numero;
        }else{
            throw new RutInvalidoException("Rut invalido: " + numero);
        }

    }

    //----------Getter-------
    /**
     * Obtiene el numero de rut de la persona
     *@return numero
     * */
    public String getNumero() {
        return numero;
    }


    /**
     * Retorna una descripción legible del RUT de la persona.
     * @return String con el rut del cliente formateados
     * */
    @Override
    public String toString(){
        return "Rut: " + numero;
    }
}
