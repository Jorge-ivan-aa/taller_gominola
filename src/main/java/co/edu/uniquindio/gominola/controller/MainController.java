package co.edu.uniquindio.gominola.controller;

import co.edu.uniquindio.gominola.factory.ModelFactory;
import co.edu.uniquindio.gominola.model.Acompanante;

public class MainController {

    private ModelFactory factory;

    public MainController(ModelFactory factory) {
        this.factory = ModelFactory.getIntance();
    }
}
