package co.edu.uniquindio.gominola.controller;

import co.edu.uniquindio.gominola.factory.ModelFactory;
import co.edu.uniquindio.gominola.model.Cliente;
import javafx.collections.ObservableList;

public class ClienteController {
    private ModelFactory factory;
    private ObservableList<Cliente> listaClienteObservable;

    public ClienteController(ModelFactory factory) {
        this.factory = ModelFactory.getIntance();
        this.sincronizarData();
    }

    public ObservableList<Cliente> getListaProductoObservable() {
        return listaClienteObservable;
    }

    public void sincronizarData() {
        this.listaClienteObservable.addAll(this.factory.getGominola().getListaCliente());
    }

}