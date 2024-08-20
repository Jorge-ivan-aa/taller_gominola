package co.edu.uniquindio.gominola.model;

import co.edu.uniquindio.gominola.view.AcompananteView;

import java.util.ArrayList;

public class Gominola {

    private ArrayList<Cliente> listaCliente;
    private ArrayList<Acompanante> listaAcompante;
    private ArrayList<Cita> listaCita;

    public Gominola() {
        listaCliente = new ArrayList<>();
        listaAcompante = new ArrayList<>();
        listaCita = new ArrayList<>();
    }

    public void addCliente(Cliente cliente) {
        listaCliente.add(cliente);
    }

    public void rmCliente(int index) {
        listaCliente.remove(index);
    }

    public void addAcompanante(Acompanante acompanante) {
        listaAcompante.add(acompanante);
    }

    public void rmAcompanante(int index) {
        listaAcompante.remove(index);
    }

    public void addCita(Cita cita) {
        listaCita.add(cita);
    }

    public void rmCita(int index) {
        listaCita.remove(index);
    }
}