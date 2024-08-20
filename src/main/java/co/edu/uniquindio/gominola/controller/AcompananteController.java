package co.edu.uniquindio.gominola.controller;

import co.edu.uniquindio.gominola.factory.ModelFactory;

public class AcompananteController {
    private ModelFactory factory;

    public AcompananteController(ModelFactory factory) {
        this.factory = ModelFactory.getIntance();
    }
}