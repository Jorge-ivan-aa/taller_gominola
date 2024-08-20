package co.edu.uniquindio.gominola.controller;

import co.edu.uniquindio.gominola.factory.ModelFactory;

public class MainController {

    private ModelFactory factory;

    public MainController(ModelFactory factory) {
        this.factory = ModelFactory.getIntance();
    }
}