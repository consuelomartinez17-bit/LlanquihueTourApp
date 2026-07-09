package model;

/**
 * Representa a un colaborador externo que presta servicios
 * a la agencia Llanquihue Tour sin ser parte directa de su personal.
 *
 * @author consu
 * @version 1.0
 */
public class ColaboradorExterno extends RecursoAgencia {

    private String empresa;
    private String servicioPrestado;

    /**
     * Constructor con parámetro.
     * Construye un colaborador externo con sus datos particulares.
     *
     * @param nombre           nombre del colaborador externo
     * @param id               identificador único del colaborador
     * @param empresa          empresa a la que pertenece el colaborador
     * @param servicioPrestado descripción del servicio que presta a la agencia
     */
    public ColaboradorExterno(String nombre, int id, String empresa, String servicioPrestado) {
        super(nombre, id);
        this.empresa = empresa;
        this.servicioPrestado = servicioPrestado;
    }

    /**
     * Obtiene la empresa a la que pertenece el colaborador.
     * @return empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Obtiene el servicio prestado por el colaborador.
     * @return servicioPrestado
     */
    public String getServicioPrestado() {
        return servicioPrestado;
    }

    /**
     * Muestra un resumen del colaborador externo, incluyendo nombre,
     * empresa y servicio prestado.
     */
    @Override
    public void mostrarResumen() {
        System.out.println("Colaborador externo: " + nombre + " | Empresa: " + empresa
                + " | Servicio: " + servicioPrestado);
    }
}
