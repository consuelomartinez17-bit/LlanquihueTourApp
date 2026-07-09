package ui;

import data.GestorEntidades;
import data.GestorServicios;
import model.*;

import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Controla el menú interactivo del sistema mediante JOptionPane,
 * permitiendo cargar servicios turísticos, ingresar nuevos recursos
 * de la agencia (guías y vehículos) y visualizar el resumen de
 * todas las entidades registradas.
 *
 * @author consu
 * @version 1.0
 */
public class MenuGestion {

    private GestorEntidades gestorEntidades;
    private GestorServicios gestorServicios;

    /**
     * Constructor sin parámetros.
     * Inicializa los gestores de entidades y servicios turísticos.
     */
    public MenuGestion() {
        this.gestorEntidades = new GestorEntidades();
        this.gestorServicios = new GestorServicios();
    }

    /**
     * Inicia el ciclo del menú principal, mostrando las opciones
     * disponibles hasta que el usuario decida salir.
     */
    public void iniciar() {


        int opcion;
        do {
            String seleccion = JOptionPane.showInputDialog(null,
                    "=== LLANQUIHUE TOUR - Gestión de Entidades ===\n\n" +
                            "1. Ingresar Guía Turístico\n" +
                            "2. Ingresar Vehículo\n" +
                            "3. Ingresar Colaborador Externo\n" +
                            "4. Mostrar resumen de todas las entidades\n" +
                            "5. Salir\n\n" +
                            "Seleccione una opción:");

            // Caso borde: el usuario cierra el diálogo o presiona Cancelar
            if (seleccion == null) {
                break;
            }

            opcion = parsearOpcion(seleccion);

            switch (opcion) {
                case 1:
                    ingresarGuiaTuristico();
                    break;
                case 2:
                    ingresarVehiculo();
                    break;
                case 3:
                    ingresarColaboradorExterno();
                    break;
                case 4:
                    mostrarResumenGeneral();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 5);
    }

    /**
     * Convierte el texto ingresado por el usuario en un número de opción,
     * devolviendo un valor inválido (-1) si el texto no es numérico,
     * en vez de dejar que la excepción interrumpa el programa.
     *
     * @param texto texto ingresado por el usuario en el diálogo
     * @return número de opción, o -1 si el texto no era válido
     */
    private int parsearOpcion(String texto) {
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Carga los servicios turísticos de prueba en el gestor de entidades,
     * integrándolos junto a los recursos de la agencia en una misma
     * colección de tipo Registrable.
     */
    private void cargarServiciosIniciales() {
        List<ServicioTuristico> servicios = gestorServicios.crearServicios();
        for (ServicioTuristico servicio : servicios) {
            gestorEntidades.agregarEntidad(servicio);
        }
        gestorEntidades.cargarDatosDePrueba();
    }

    /**
     * Solicita al usuario los datos de un nuevo guía turístico mediante
     * cuadros de diálogo, valida que los campos numéricos sean correctos,
     * y lo agrega a la colección de entidades.
     */
    private void ingresarGuiaTuristico() {
        String nombre = JOptionPane.showInputDialog("Nombre del guía turístico:");
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío. Operación cancelada.");
            return;
        }

        String idioma = JOptionPane.showInputDialog("Idioma principal del guía:");
        if (idioma == null) {
            return;
        }

        String textoAnios = JOptionPane.showInputDialog("Años de experiencia:");
        if (textoAnios == null) {
            return;
        }

        int anios;
        try {
            anios = Integer.parseInt(textoAnios.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Los años de experiencia deben ser un número. Operación cancelada.");
            return;
        }

        int id = gestorEntidades.getCantidad() + 1;
        GuiaTuristico guia = new GuiaTuristico(nombre, id, idioma, anios);
        gestorEntidades.agregarEntidad(guia);

        JOptionPane.showMessageDialog(null, "Guía turístico agregado correctamente.");
    }

    /**
     * Solicita al usuario los datos de un nuevo vehículo mediante
     * cuadros de diálogo, valida que los campos numéricos sean correctos,
     * y lo agrega a la colección de entidades.
     */
    private void ingresarVehiculo() {
        String nombre = JOptionPane.showInputDialog("Nombre o modelo del vehículo:");
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío. Operación cancelada.");
            return;
        }

        String patente = JOptionPane.showInputDialog("Patente del vehículo:");
        if (patente == null) {
            return;
        }

        String textoCapacidad = JOptionPane.showInputDialog("Capacidad de pasajeros:");
        if (textoCapacidad == null) {
            return;
        }

        int capacidad;
        try {
            capacidad = Integer.parseInt(textoCapacidad.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La capacidad debe ser un número. Operación cancelada.");
            return;
        }

        int id = gestorEntidades.getCantidad() + 1;
        Vehiculo vehiculo = new Vehiculo(nombre, id, patente, capacidad);
        gestorEntidades.agregarEntidad(vehiculo);

        JOptionPane.showMessageDialog(null, "Vehículo agregado correctamente.");
    }

    /**
     * Solicita al usuario los datos de un nuevo colaborador externo mediante
     * cuadros de diálogo, valida que los campos no queden vacíos,
     * y lo agrega a la colección de entidades.
     */
    private void ingresarColaboradorExterno() {
        String nombre = JOptionPane.showInputDialog("Nombre del colaborador externo:");
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío. Operación cancelada.");
            return;
        }

        String empresa = JOptionPane.showInputDialog("Empresa a la que pertenece:");
        if (empresa == null || empresa.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La empresa no puede estar vacía. Operación cancelada.");
            return;
        }

        String servicioPrestado = JOptionPane.showInputDialog("Servicio que presta a la agencia:");
        if (servicioPrestado == null || servicioPrestado.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El servicio prestado no puede estar vacío. Operación cancelada.");
            return;
        }

        int id = gestorEntidades.getCantidad() + 1;
        ColaboradorExterno colaborador = new ColaboradorExterno(nombre, id, empresa, servicioPrestado);
        gestorEntidades.agregarEntidad(colaborador);

        JOptionPane.showMessageDialog(null, "Colaborador externo agregado correctamente.");
    }

    /**
     * Muestra por consola y por cuadro de diálogo el resumen de todas
     * las entidades registradas, delegando el recorrido y diferenciación
     * de tipos al GestorEntidades.
     */
    private void mostrarResumenGeneral() {
        gestorEntidades.mostrarTodas(); // salida por consola, sigue igual

        String resumenTexto = gestorEntidades.generarResumenTexto();

        JTextArea areaTexto = new JTextArea(resumenTexto);
        areaTexto.setEditable(false);
        areaTexto.setFont(new java.awt.Font("Consolas", java.awt.Font.PLAIN, 13));
        areaTexto.setCaretPosition(0); // asegura que el scroll parta desde arriba

        JScrollPane panelScroll = new JScrollPane(areaTexto);
        panelScroll.setPreferredSize(new java.awt.Dimension(550, 400));

        JOptionPane.showMessageDialog(null, panelScroll,
                "Resumen de Entidades - Llanquihue Tour",
                JOptionPane.PLAIN_MESSAGE);
    }
}