package co.edu.uniquindio.gominola.factory;

import co.edu.uniquindio.gominola.model.Acompanante;
import co.edu.uniquindio.gominola.model.Cita;
import co.edu.uniquindio.gominola.model.Cliente;
import co.edu.uniquindio.gominola.model.Gominola;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class ModelFactory {
    private static ModelFactory instance;
    private Gominola gominola;

    private ModelFactory() {
        gominola = new Gominola();
        registrarAcompanantes(gominola);
        registrarClientes(gominola);
        registrarCitas(gominola);
    }

    public static ModelFactory getIntance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    public Gominola getGominola() {
        return gominola;
    }

    public static void registrarAcompanantes(Gominola gominola) {
        Acompanante acompanante1 = new Acompanante(
                "Lucía Fernández", "25", "M", "lucia.fernandez@example.com", "3123456789",
                "¡Hola, soy Lucía! Será un placer acompañarte.", 50000
        );
        Acompanante acompanante2 = new Acompanante(
                "Diego Martínez", "30", "L", "diego.martinez@example.com", "3012345678",
                "¡Hola! Soy Diego, listo para hacer de tu día algo especial.", 60000
        );
        Acompanante acompanante3 = new Acompanante(
                "Sofía Ramírez", "28", "S", "sofia.ramirez@example.com", "3201234567",
                "¡Hola! Soy Sofía, será un gusto acompañarte.", 55000
        );
        Acompanante acompanante4 = new Acompanante(
                "Javier López", "27", "XL", "javier.lopez@example.com", "3109876543",
                "¡Hola! Soy Javier, estoy aquí para ayudarte a disfrutar cada momento.", 65000
        );
        Acompanante acompanante5 = new Acompanante(
                "Camila Torres", "26", "M", "camila.torres@example.com", "3187654321",
                "¡Hola! Soy Camila, encantada de acompañarte en lo que necesites.", 52000
        );

        gominola.addAcompanante(acompanante1);
        gominola.addAcompanante(acompanante2);
        gominola.addAcompanante(acompanante3);
        gominola.addAcompanante(acompanante4);
        gominola.addAcompanante(acompanante5);

    }

    public static void registrarClientes(Gominola gominola) {
        Cliente cliente1 = new Cliente("Juan Pérez", "juan.perez@example.com", "3123456789");
        Cliente cliente2 = new Cliente("María Gómez", "maria.gomez@example.com", "3012345678");
        Cliente cliente3 = new Cliente("Carlos Rodríguez", "carlos.rodriguez@example.com", "3201234567");
        Cliente cliente4 = new Cliente("Ana Martínez", "ana.martinez@example.com", "3109876543");

        gominola.addCliente(cliente1);
        gominola.addCliente(cliente2);
        gominola.addCliente(cliente3);
        gominola.addCliente(cliente4);
    }

    public static void registrarCitas(Gominola gominola) {

        ArrayList<Acompanante> listaAcompanante = gominola.getListaAcompanante();
        ArrayList<Cliente> listaCliente = gominola.getListaCliente();


        Cita cita1 = new Cita(
                listaAcompanante.get(0), listaCliente.get(0), new Date(),
                "10:00 AM", "Café Central", 2
        );

        Cita cita2 = new Cita(
                listaAcompanante.get(1), listaCliente.get(1), new Date(),
                "02:00 PM", "Parque de la Vida", 3
        );

        Cita cita3 = new Cita(
                listaAcompanante.get(2), listaCliente.get(2), new Date(),
                "11:00 AM", "Restaurante El Rincón", 4
        );

        Cita cita4 = new Cita(
                listaAcompanante.get(3), listaCliente.get(3), new Date(),
                "05:00 PM", "Centro Comercial Portal del Quindío", 2
        );


        gominola.addCita(cita1);
        gominola.addCita(cita2);
        gominola.addCita(cita3);
        gominola.addCita(cita4);
    }

}