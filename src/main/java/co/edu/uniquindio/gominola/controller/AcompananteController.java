package co.edu.uniquindio.gominola.controller;

import co.edu.uniquindio.gominola.factory.ModelFactory;
import co.edu.uniquindio.gominola.model.Acompanante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AcompananteController {
    private ModelFactory factory;
    private ObservableList<Acompanante> listaAcompananteObservable;

    public AcompananteController() {
        this.factory = ModelFactory.getIntance();
        this.listaAcompananteObservable = FXCollections.observableArrayList();
        this.sincronizarData();
    }

    public ObservableList<Acompanante> getListaProductoObservable() {
        return listaAcompananteObservable;
    }

    public void sincronizarData() {
        this.listaAcompananteObservable.addAll(this.factory.getGominola().getListaAcompante());
    }

}