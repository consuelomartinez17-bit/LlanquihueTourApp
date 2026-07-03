package ui;

import data.GestorServicios;
import model.ServicioTuristico;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        GestorServicios gestor = new GestorServicios();
        List<ServicioTuristico> servicios = gestor.crearServicios();

        System.out.println("========================================");
        System.out.println("  LLANQUIHUE TOUR - Servicios Turísticos");
        System.out.println("========================================\n");

        for (ServicioTuristico servicio : servicios) {
            servicio.mostrarInformacion();
            System.out.println("----------------------------------------");
        }

    }
}