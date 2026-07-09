package data;

import model.Registrable;
import model.ServicioTuristico;
import model.RecursoAgencia;
import model.GuiaTuristico;
import model.Vehiculo;
import model.ColaboradorExterno;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona una colección genérica de entidades registrables del sistema
 * Llanquihue Tour, permitiendo agregar objetos de distintas jerarquías
 * (servicios turísticos y recursos de la agencia) y recorrerlas de forma
 * unificada mediante la interfaz Registrable, diferenciando su
 * comportamiento específico mediante instanceof.
 *
 * @author consu
 * @version 1.0
 */
public class GestorEntidades {

    private List<Registrable> entidades;

    /**
     * Constructor sin parámetros.
     * Inicializa la colección vacía de entidades registrables.
     */
    public GestorEntidades() {
        this.entidades = new ArrayList<>();
    }

    /**
     * Agrega una entidad registrable a la colección.
     * Si la entidad es nula, se rechaza y se informa por consola,
     * evitando que se agregue un elemento inválido a la lista.
     *
     * @param entidad entidad a agregar, debe implementar Registrable
     */
    public void agregarEntidad(Registrable entidad) {
        if (entidad == null) {
            System.out.println("No se puede agregar una entidad nula.");
            return;
        }
        entidades.add(entidad);
    }

    /**
     * Obtiene la cantidad de entidades registradas actualmente.
     * @return cantidad de entidades en la colección
     */
    public int getCantidad() {
        return entidades.size();
    }

    /**
     * Recorre la colección de entidades y muestra el resumen de cada una,
     * diferenciando el tipo específico mediante instanceof para aplicar
     * un encabezado distinto según la naturaleza de la entidad.
     *
     * Si la colección está vacía, se informa explícitamente en vez de
     * no mostrar nada, para que el usuario no confunda "vacío" con "error".
     */
    public void mostrarTodas() {
        if (entidades.isEmpty()) {
            System.out.println("No hay entidades registradas todavía.");
            return;
        }

        for (Registrable entidad : entidades) {
            if (entidad instanceof ServicioTuristico) {
                System.out.println("[Servicio Turístico]");
                entidad.mostrarResumen();

            } else if (entidad instanceof GuiaTuristico) {
                System.out.println("[Recurso - Guía]");
                entidad.mostrarResumen();

            } else if (entidad instanceof Vehiculo) {
                System.out.println("[Recurso - Vehículo]");
                entidad.mostrarResumen();

            } else if (entidad instanceof ColaboradorExterno) {
                System.out.println("[Recurso - Colaborador Externo]");
                entidad.mostrarResumen();

            } else {
                // Caso borde: cualquier Registrable futuro no contemplado
                // arriba igual se muestra, sin perderse silenciosamente.
                System.out.println("[Entidad no clasificada]");
                entidad.mostrarResumen();
            }
            System.out.println("----------------------------------------");
        }
    }

    /**
     * Carga un conjunto de entidades de ejemplo, combinando servicios
     * turísticos y recursos de la agencia, para poblar la colección
     * con datos de prueba.
     */
    public void cargarDatosDePrueba() {
        agregarEntidad(new GuiaTuristico("Pedro Alvarado", 1, "Español", 5));
        agregarEntidad(new Vehiculo("Sprinter Blanca", 2, "HTZR-21", 15));
    }

    /**
     * Obtiene la colección completa de entidades registradas.
     * @return lista de entidades registrables
     */
    public List<Registrable> getEntidades() {
        return entidades;
    }

    /**
     * Genera un resumen en formato de texto de todas las entidades
     * registradas, aplicando la misma diferenciación por instanceof
     * que mostrarTodas(), pero devolviendo el resultado como String
     * en vez de imprimirlo directamente, para poder mostrarlo en una
     * ventana gráfica con scroll.
     *
     * @return texto con el resumen completo de todas las entidades
     */
    public String generarResumenTexto() {
        StringBuilder resumen = new StringBuilder();

        if (entidades.isEmpty()) {
            return "No hay entidades registradas todavía.";
        }

        for (Registrable entidad : entidades) {
            String etiqueta;

            if (entidad instanceof ServicioTuristico) {
                etiqueta = "[Servicio Turístico]";
            } else if (entidad instanceof GuiaTuristico) {
                etiqueta = "[Recurso - Guía]";
            } else if (entidad instanceof Vehiculo) {
                etiqueta = "[Recurso - Vehículo]";
            } else if (entidad instanceof ColaboradorExterno) {
                etiqueta = "[Recurso - Colaborador Externo]";
            } else {
                etiqueta = "[Entidad no clasificada]";
            }

            resumen.append(etiqueta).append("\n");
            resumen.append(capturarResumen(entidad)).append("\n");
            resumen.append("----------------------------------------\n");
        }

        return resumen.toString();
    }

    /**
     * Captura la salida de mostrarResumen() de una entidad como texto,
     * redirigiendo temporalmente System.out, para poder reutilizar la
     * misma lógica de impresión tanto en consola como en la ventana
     * gráfica sin duplicar el mensaje en cada clase.
     *
     * @param entidad entidad de la cual capturar el resumen
     * @return el texto que mostrarResumen() habría impreso por consola
     */
    private String capturarResumen(Registrable entidad) {
        java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
        java.io.PrintStream original = System.out;
        System.setOut(new java.io.PrintStream(buffer));

        entidad.mostrarResumen();

        System.setOut(original);
        return buffer.toString().trim();
    }
}