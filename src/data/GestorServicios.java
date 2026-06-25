package data;

import model.ServicioTuristico;
import model.RutaGastronomica;
import model.PaseoLacustre;
import model.ExcursionCultural;
import java.util.List;
import java.util.ArrayList;


/**
 * Esta clase gestiona la creación de los servicios turísticos
 * que ofrece la agencia Llanquihue Tour.
 *
 * @author consu
 * @version 1.0.
 * */
public class GestorServicios {

    /**
     * Crea las instancias de prueba de cada subclase de ServicioTuristico
     * (rutas gastronómicas, paseos lacustres y excursiones culturales)
     * y las reúne en una sola lista.
     *
     * @return una lista con todos los servicios turísticos creados
     * */

    public List<ServicioTuristico> crearServicios() {
        List<ServicioTuristico> servicios = new ArrayList<>();

        RutaGastronomica rutaDeSaboresAlemanes = new RutaGastronomica("Ruta de Sabores Alemanes", 4, List.of("Casa del Arte Diego Rivera", "Cervecería Ciplac", "Kuchen Café"));
        RutaGastronomica rutaDelSalmonPatagonico = new RutaGastronomica("Ruta del Salmón Patagónico", 3.5, List.of("Mercado de Puerto Montt", "Restaurante Costanera"));
        PaseoLacustre travesiaLagoLlanquihue = new PaseoLacustre("Travesía Lago Llanquihue", 2.5, "Catamarán");
        PaseoLacustre navegacionLagoTodoslosSantos = new PaseoLacustre("Navegación Lago Todos los Santos", 3, "Lancha");
        ExcursionCultural huellasColonialesDeFrutillar = new ExcursionCultural("Huellas Coloniales de Frutillar", 5, "Teatro del Lago");
        ExcursionCultural patrimonioDePuertoOctay = new ExcursionCultural("Patrimonio de Puerto Octay", 4, "Museo El Colono");

        servicios.add(rutaDeSaboresAlemanes);
        servicios.add(rutaDelSalmonPatagonico);
        servicios.add(travesiaLagoLlanquihue);
        servicios.add(navegacionLagoTodoslosSantos);
        servicios.add(huellasColonialesDeFrutillar);
        servicios.add(patrimonioDePuertoOctay);



        return servicios;
    }
}