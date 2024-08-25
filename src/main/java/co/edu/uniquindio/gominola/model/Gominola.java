package co.edu.uniquindio.gominola.model;

import java.util.ArrayList;

public class Gominola {

    private ArrayList<Cliente> listaCliente;
    private ArrayList<Acompanante> listaAcompanante;
    private ArrayList<Cita> listaCita;

    public Gominola() {
        listaCliente = new ArrayList<>();
        listaAcompanante = new ArrayList<>();
        listaCita = new ArrayList<>();
    }

    public void addCliente(Cliente cliente) {
        listaCliente.add(cliente);
    }

    public void rmCliente(int index) {
        listaCliente.remove(index);
    }

    public void addAcompanante(Acompanante acompanante) {
        listaAcompanante.add(acompanante);
    }

    public void rmAcompanante(int index) {
        listaAcompanante.remove(index);
    }

    public void addCita(Cita cita) {
        listaCita.add(cita);
    }

    public void rmCita(int index) {
        listaCita.remove(index);
    }

    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public ArrayList<Acompanante> getListaAcompanante() {
        return listaAcompanante;
    }

    public ArrayList<Cita> getListaCita() {
        return listaCita;
    }
}