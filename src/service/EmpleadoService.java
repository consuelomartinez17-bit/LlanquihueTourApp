package service;

import model.Direccion;
import model.Empleado;
import model.Rut;
import util.RutInvalidoException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;

/**
 * Servicio encargado de gestionar la colección de empleados (guías, operadores
 * y proveedores) vinculados a Llanquihue Tour. Permite cargar registros desde
 * un archivo externo, listarlos por consola y aplicar búsquedas o filtros
 * simples sobre la colección en memoria.
 *
 * @author consu
 * @version 1.0
 */
public class EmpleadoService {

    private ArrayList<Empleado> empleados;

    /**
     * Constructor sin parámetros.
     * Inicializa la colección de empleados vacía.
     */
    public EmpleadoService() {
        this.empleados = new ArrayList<>();
    }

    /**
     * Carga empleados desde un archivo de texto plano en formato CSV.
     * Cada línea debe tener el formato:
     * nombre,rut,telefono,numeroVivienda,calle,ciudad,region,cargo,jornada,turno
     * <p>
     * Cada línea se valida de forma independiente: si tiene formato incompleto,
     * un RUT inválido, un nombre vacío o un teléfono con caracteres no
     * numéricos, se informa por consola y se omite, sin detener la carga
     * del resto del archivo.
     *
     * @param rutaArchivo ruta del archivo .csv a leer
     */
    public void cargarDesdeArchivo(String rutaArchivo) {
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = lector.readLine()) != null) {
                numeroLinea++;
                if (linea.isBlank()) {
                    continue;
                }

                String[] datos = linea.split(",");
                if (datos.length < 9) {
                    System.out.println("Línea " + numeroLinea + " ignorada: formato incompleto.");
                    continue;
                }

                try {
                    String nombre = datos[0].trim();
                    Rut rut = new Rut(datos[1].trim());
                    String telefono = datos[2].trim();
                    Direccion direccion = new Direccion(
                            datos[3].trim(), datos[4].trim(), datos[5].trim(), datos[6].trim());
                    String cargo = datos[7].trim();
                    String jornada = datos[8].trim();
                    String turno = datos.length > 9 ? datos[9].trim() : "No especificado";

                    validarCamposBasicos(nombre, telefono, cargo);

                    Empleado empleado = new Empleado(nombre, rut, telefono, direccion, cargo, jornada, turno);
                    empleados.add(empleado);

                } catch (RutInvalidoException | IllegalArgumentException e) {
                    System.out.println("Línea " + numeroLinea + " ignorada: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Línea " + numeroLinea + " ignorada: dato inesperado (" + e.getMessage() + ").");
                }
            }

        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo '" + rutaArchivo + "': " + e.getMessage());
        }
    }

    /**
     * Valida los campos básicos de un empleado antes de crearlo: que el
     * nombre y el cargo no estén vacíos, y que el teléfono contenga solo
     * dígitos con una longitud razonable.
     *
     * @param nombre   nombre ya recortado (trim) leído del archivo
     * @param telefono teléfono ya recortado (trim) leído del archivo
     * @param cargo    cargo ya recortado (trim) leído del archivo
     * @throws IllegalArgumentException si algún campo no cumple el formato esperado
     */
    private void validarCamposBasicos(String nombre, String telefono, String cargo) {
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("el nombre no puede estar vacío");
        }
        if (cargo.isBlank()) {
            throw new IllegalArgumentException("el cargo no puede estar vacío");
        }
        if (!telefono.matches("[0-9]{6,15}")) {
            throw new IllegalArgumentException(
                    "el teléfono '" + telefono + "' no es válido (debe tener solo dígitos, entre 6 y 15)");
        }
    }

    /**
     * Agrega un empleado directamente a la colección.
     * @param empleado empleado a agregar
     */
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    /**
     * Muestra por consola todos los empleados almacenados en la colección,
     * numerados y separados visualmente para facilitar la lectura.
     */
    public void mostrarTodos() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        int contador = 1;
        for (Empleado empleado : empleados) {
            System.out.println();
            System.out.println("---------- Empleado #" + contador + " ----------");
            System.out.println(empleado);
            contador++;
        }
    }

    /**
     * Quita las tildes de un texto y lo pasa a minúsculas, para que las
     * búsquedas no dependan de que el usuario escriba los acentos correctos
     * (por ejemplo, que "Guia" encuentre "Guía").
     *
     * @param texto texto a normalizar
     * @return texto en minúsculas y sin tildes
     */
    private String normalizar(String texto) {
        String sinTildes = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}", "");
        return sinTildes.toLowerCase();
    }

    /**
     * Busca empleados cuyo nombre contenga el texto indicado, sin distinguir
     * mayúsculas/minúsculas ni tildes.
     *
     * @param texto texto a buscar dentro del nombre
     * @return colección con los empleados que coinciden
     */
    public ArrayList<Empleado> buscarPorNombre(String texto) {
        ArrayList<Empleado> resultado = new ArrayList<>();
        String textoNormalizado = normalizar(texto);
        for (Empleado empleado : empleados) {
            if (normalizar(empleado.getNombre()).contains(textoNormalizado)) {
                resultado.add(empleado);
            }
        }
        return resultado;
    }

    /**
     * Filtra empleados cuyo cargo contenga el texto indicado, sin distinguir
     * mayúsculas/minúsculas ni tildes. Útil para separar guías, operadores
     * y proveedores dentro de la misma colección, aunque no se escriba el
     * cargo completo.
     *
     * @param cargo texto a buscar dentro del cargo
     * @return colección con los empleados cuyo cargo coincide
     */
    public ArrayList<Empleado> buscarPorCargo(String cargo) {
        ArrayList<Empleado> resultado = new ArrayList<>();
        String cargoNormalizado = normalizar(cargo);
        for (Empleado empleado : empleados) {
            if (normalizar(empleado.getCargo()).contains(cargoNormalizado)) {
                resultado.add(empleado);
            }
        }
        return resultado;
    }

    /**
     * Obtiene la cantidad de empleados almacenados en la colección.
     * @return cantidad de empleados
     */
    public int getCantidad() {
        return empleados.size();
    }

    /**
     * Obtiene la colección completa de empleados.
     * @return ArrayList con los empleados cargados
     */
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
}