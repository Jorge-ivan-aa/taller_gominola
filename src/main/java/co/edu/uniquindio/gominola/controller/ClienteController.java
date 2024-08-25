package co.edu.uniquindio.gominola.controller;

import co.edu.uniquindio.gominola.factory.ModelFactory;
import co.edu.uniquindio.gominola.model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

public class ClienteController {
    private ModelFactory factory;
    private ObservableList<Cliente> listaClienteObservable;

    public ClienteController() {
        this.factory = ModelFactory.getIntance();
        this.listaClienteObservable = FXCollections.observableArrayList();
        this.sincronizarData();
    }

    public ObservableList<Cliente> getListaClienteObservable() {
        return listaClienteObservable;
    }

    public void sincronizarData() {
        this.listaClienteObservable.addAll(this.factory.getGominola().getListaCliente());
    }

    public String eliminarCliente(String nombre) {

        if (this.consultarCliente(nombre) == null) {
            return "El cliente ingresado no existe";
        } else {
            int index = -1;
            ArrayList<Cliente> Clientes = factory.getGominola().getListaCliente();
            for (int i = 0; i < Clientes.size(); i++) {
                if (Objects.equals(Clientes.get(i).getNombre(), nombre)) {
                    index = i;
                }
            }
            if (index != -1) {
                this.listaClienteObservable.remove(Clientes.get(index));
                Clientes.remove(Clientes.get(index));
            }
            return "El cliente fue eliminado correctamente";
        }
    }

    public Cliente consultarCliente(String nombre) {
        ArrayList<Cliente> Clientes = this.factory.getGominola().getListaCliente();
        for (Cliente value : Clientes) {
            if (value.getNombre().equals(nombre)) {
                return value;
            }
        }
        return null;
    }

    public String crearCliente(String nombre, String correo, String telefono) {
        ArrayList<Cliente> Clientes = factory.getGominola().getListaCliente();

        if (this.consultarCliente(nombre) != null) {
            return "El cliente ingresado ya existe";
        } else {
            Cliente nuevoCliente = new Cliente(nombre, correo, telefono);
            this.factory.getGominola().addCliente(nuevoCliente);
            this.listaClienteObservable.add(nuevoCliente);
            return "Cliente registrado exitosamente";
        }
    }

    public String actualizarCliente(String nombre, String correo, String telefono) {
        ArrayList<Cliente> Clientes = factory.getGominola().getListaCliente();

        if (this.consultarCliente(nombre) == null) {
            return "El cliente ingresado no existe";

        } else {
            for (int i = 0; i < Clientes.size(); i++) {
                if (Objects.equals(Clientes.get(i).getNombre(), nombre)) {
                    Cliente nuevoCliente = new Cliente(nombre, correo, telefono);
                    Clientes.remove(Clientes.get(i));
                    Clientes.add(nuevoCliente);
                    this.listaClienteObservable.remove(Clientes.get(i));
                    this.listaClienteObservable.add(nuevoCliente);
                }
            }
            return "El cliente fue actualizado correctamente";

        }
    }

}