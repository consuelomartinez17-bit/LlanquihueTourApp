package app;

import model.Empleado;
import service.EmpleadoService;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal del programa. Carga empleados (guías, operadores y
 * proveedores) desde un archivo externo hacia una colección dinámica,
 * y permite recorrerla, buscarla y filtrarla mediante un menú interactivo
 * por consola.
 *
 * @author consu
 * @version 2.1
 */
public class Main {

    /**
     * Ruta por defecto del archivo de empleados. Se centraliza en una
     * constante (en vez de escribirla directo dentro de main) para que sea
     * fácil de mantener, y además se puede sobrescribir pasando una ruta
     * distinta como argumento al ejecutar el programa, sin tocar el código.
     */
    private static final String RUTA_ARCHIVO_POR_DEFECTO = "data/empleados.csv";

    public static void main(String[] args) {

        String rutaArchivo = (args.length > 0) ? args[0] : RUTA_ARCHIVO_POR_DEFECTO;

        EmpleadoService servicio = new EmpleadoService();
        servicio.cargarDesdeArchivo(rutaArchivo);

        Scanner scanner = new Scanner(System.in);

        System.out.println("════════════════════════════════════════");
        System.out.println(" LLANQUIHUE TOUR - SISTEMA DE GESTIÓN");
        System.out.println("════════════════════════════════════════");
        System.out.println("Se cargaron " + servicio.getCantidad() + " empleados desde el archivo.");

        int opcion = 0;

        do {
            System.out.println();
            System.out.println("════════════════════════════════════════");
            System.out.println("                MENÚ");
            System.out.println("════════════════════════════════════════");
            System.out.println("1. Mostrar todos los empleados");
            System.out.println("2. Buscar empleado por nombre");
            System.out.println("3. Filtrar empleados por cargo");
            System.out.println("4. Salir");
            System.out.println("════════════════════════════════════════");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println();
                    System.out.println("---- Listado completo de empleados ----");
                    servicio.mostrarTodos();
                    pausar(scanner);
                    break;

                case 2:
                    System.out.print("Ingrese nombre o parte del nombre a buscar: ");
                    String texto = scanner.nextLine();
                    ArrayList<Empleado> resultadoNombre = servicio.buscarPorNombre(texto);
                    System.out.println();
                    System.out.println("---- Resultados de la búsqueda ----");
                    mostrarResultados(resultadoNombre);
                    pausar(scanner);
                    break;

                case 3:
                    System.out.print("Ingrese el cargo a filtrar (ej: Guía turístico): ");
                    String cargo = scanner.nextLine();
                    ArrayList<Empleado> resultadoCargo = servicio.buscarPorCargo(cargo);
                    System.out.println();
                    System.out.println("---- Resultados del filtro ----");
                    mostrarResultados(resultadoCargo);
                    pausar(scanner);
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 4);

        scanner.close();
    }

    /**
     * Muestra por consola una colección de empleados resultante de una
     * búsqueda o filtro, numerados y separados visualmente, indicando
     * si no hubo coincidencias.
     *
     * @param resultados colección de empleados a mostrar
     */
    private static void mostrarResultados(ArrayList<Empleado> resultados) {
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron coincidencias.");
            return;
        }
        int contador = 1;
        for (Empleado empleado : resultados) {
            System.out.println();
            System.out.println("---------- Resultado #" + contador + " ----------");
            System.out.println(empleado);
            contador++;
        }
    }

    /**
     * Detiene la ejecución hasta que el usuario presione ENTER, para que
     * pueda leer con calma los resultados antes de que vuelva a aparecer
     * el menú.
     *
     * @param scanner el Scanner ya abierto que lee desde consola
     */
    private static void pausar(Scanner scanner) {
        System.out.println();
        System.out.print("Presione ENTER para volver al menú...");
        scanner.nextLine();
    }
}