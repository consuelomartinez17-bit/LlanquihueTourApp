# LlanquihueTourApp

## Descripción

Aplicación de consola en Java desarrollada para Llanquihue Tour, agencia de turismo de la Región de Los Lagos. El sistema permite registrar y gestionar a las personas vinculadas a la operación de la agencia (guías, operadores y proveedores, modelados como `Empleado`) y a los clientes que solicitan servicios turísticos.

En esta entrega (Semana 5) el sistema fue ampliado para cargar empleados desde un archivo externo (`.csv`) hacia una colección dinámica (`ArrayList`), y permite recorrer, buscar por nombre y filtrar por cargo dichos registros desde un menú interactivo por consola.

## Paquetes y clases

- **app**
  - `Main`: clase principal, ejecuta el menú interactivo y orquesta la carga de datos.
- **model**
  - `Persona`: clase base con los atributos comunes (nombre, rut, teléfono, dirección).
  - `Empleado`: extiende `Persona`, representa a guías, operadores y proveedores.
  - `Cliente`: extiende `Persona`, representa a quienes solicitan un servicio turístico.
  - `Direccion`: representa la dirección de una persona (composición con `Persona`).
  - `Rut`: representa y valida el RUT de una persona (composición con `Persona`).
- **service**
  - `EmpleadoService`: gestiona la colección de empleados, su carga desde archivo, y las búsquedas/filtros.
- **util**
  - `RutInvalidoException`: excepción personalizada lanzada cuando el formato del RUT no es válido.

## Datos de entrada

El archivo `data/empleados.csv` contiene los registros de ejemplo que se cargan al iniciar el programa. Cada línea sigue el formato:

```
nombre,rut,telefono,numeroVivienda,calle,ciudad,region,cargo,jornada,turno
```

## Cómo ejecutar el programa

1. Clona o descarga este repositorio.
2. Abre el proyecto en IntelliJ IDEA.
3. Verifica que la carpeta `data/` esté ubicada en la raíz del proyecto (al mismo nivel que `src/`).
4. Ejecuta la clase `Main` (ubicada en el paquete `app`).
5. Usa el menú por consola para mostrar todos los empleados, buscar por nombre o filtrar por cargo.

## Autora

Consuelo — Desarrollo Orientado a Objetos I, Duoc UC.


## Semana 6: Jerarquía de Servicios Turísticos

### Objetivo de esta semana
Diseñar e implementar una jerarquía de clases con herencia simple para
representar los distintos servicios turísticos que ofrece la agencia
Llanquihue Tour (rutas gastronómicas, paseos lacustres y excursiones
culturales), aplicando atributos heredados, composición y sobreescritura
de métodos (`toString()`).

Esta funcionalidad es independiente de la entregada en Semana 5
(gestión de empleados y clientes) y no modifica las clases existentes.

### Clases creadas

* **model**
  * `ServicioTuristico`: clase base con los atributos comunes
    (nombre, duración en horas).
  * `RutaGastronomica`: extiende `ServicioTuristico`, agrega un listado
    de paradas gastronómicas.
  * `PaseoLacustre`: extiende `ServicioTuristico`, agrega el tipo de
    embarcación utilizada.
  * `ExcursionCultural`: extiende `ServicioTuristico`, agrega el lugar
    histórico a visitar.
* **data**
  * `GestorServicios`: crea las instancias de prueba de cada subclase
    y las reúne en una lista de tipo `ServicioTuristico`.
* **ui**
  * `Main`: ejecuta el programa, obtiene los servicios desde
    `GestorServicios` y los muestra por consola mediante polimorfismo.

### Cómo ejecutar Main (Semana 6)

1. Clona o descarga este repositorio.
2. Abre el proyecto en IntelliJ IDEA.
3. Ejecuta la clase `Main` ubicada en el paquete `ui`.
4. La consola mostrará el listado completo de servicios turísticos
   (rutas gastronómicas, paseos lacustres y excursiones culturales)
   con sus datos correspondientes.
