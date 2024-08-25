package co.edu.uniquindio.gominola.controller;

import co.edu.uniquindio.gominola.factory.ModelFactory;
import co.edu.uniquindio.gominola.model.Cita;
import co.edu.uniquindio.gominola.view.CitaView;
import javafx.collections.ObservableList;

public class CitaController {
    private ModelFactory factory;
    private ObservableList<Cita> listaCitaObservable;


    public CitaController(ModelFactory factory) {
        this.factory = ModelFactory.getIntance();
        this.sincronizarData();
    }


    public ObservableList<Cita> getListaProductoObservable() {
        return listaCitaObservable;
    }

    public void sincronizarData() {
        this.listaCitaObservable.addAll(this.factory.getGominola().getListaCita());
    }
}
