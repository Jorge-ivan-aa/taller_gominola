package co.edu.uniquindio.gominola.controller;

import co.edu.uniquindio.gominola.factory.ModelFactory;
import co.edu.uniquindio.gominola.view.CitaView;

public class CitaController {
    private ModelFactory factory;

    public CitaController(ModelFactory factory) {
        this.factory = ModelFactory.getIntance();
    }
}