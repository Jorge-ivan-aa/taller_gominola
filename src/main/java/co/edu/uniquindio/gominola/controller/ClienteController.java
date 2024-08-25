package co.edu.uniquindio.gominola.controller;

import co.edu.uniquindio.gominola.factory.ModelFactory;
import co.edu.uniquindio.gominola.model.Cliente;
import co.edu.uniquindio.gominola.model.Cliente;
import co.edu.uniquindio.gominola.model.Cliente;
import co.edu.uniquindio.gominola.model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class ClienteController {
    private ModelFactory factory;
    private ObservableList<Cliente> listaClienteObservable;

    public ClienteController() {
        this.factory = ModelFactory.getIntance();
        this.listaClienteObservable =  FXCollections.observableArrayList();
        this.sincronizarData();
    }

    public ObservableList<Cliente> getListaClienteObservable() {
        return listaClienteObservable;
    }

    public void sincronizarData() {
        this.listaClienteObservable.addAll(this.factory.getGominola().getListaCliente());
    }

    public void eliminarCliente(String nombre){
        ArrayList<Cliente> Cliente = factory.getGominola().getListaCliente();
        for (int i = 0; i < Cliente.size(); i++){
            if (Objects.equals(Cliente.get(i).getNombre(), nombre)){
                Cliente.remove(Cliente.get(i));
                this.listaClienteObservable.remove(Cliente.get(i));
            }
        }
    }

    public Cliente consultarCliente(String nombre){
        ArrayList<Cliente> Cliente = this.factory.getGominola().getListaCliente();
        for (Cliente value : Cliente) {
            if (value.getNombre().equals(nombre)){
                return value;
            }
        }
        return null;
    }

    public String crearCliente(String nombre, String correo, String telefono) {
        ArrayList<Cliente> Clientes = factory.getGominola().getListaCliente();
        for (Cliente Cliente : Clientes) {
            if (Objects.equals(Cliente.getNombre(), nombre)) {
                return "El Clientes ingresado ya se existe";
            }
        }
        Cliente nuevoCliente = new Cliente(nombre, correo, telefono);
        this.factory.getGominola().addCliente(nuevoCliente);
        this.listaClienteObservable.add(nuevoCliente);
        return "Cliente registrado exitosamente";
    }
    public void actualizarCliente(String nombre, String correo, String telefono){
        ArrayList<Cliente> Clientes = factory.getGominola().getListaCliente();
        for (int i = 0; i < Clientes.size(); i++){
            if (Objects.equals(Clientes.get(i).getNombre(), nombre)){
                Cliente nuevoCliente = new Cliente(nombre, correo, telefono);
                Clientes.remove(Clientes.get(i));
                Clientes.add(nuevoCliente);
                this.listaClienteObservable.remove(Clientes.get(i));
                this.listaClienteObservable.add(nuevoCliente);
            }
        }
    }
    
}