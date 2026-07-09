package ui;

/**
 * Clase principal del sistema Llanquihue Tour (módulo vigente).
 * Su única responsabilidad es iniciar la aplicación delegando
 * el control del menú a MenuGestion, evitando concentrar la
 * lógica de interacción directamente en main().
 *
 * @author consu
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        MenuGestion menu = new MenuGestion();
        menu.iniciar();
    }
}