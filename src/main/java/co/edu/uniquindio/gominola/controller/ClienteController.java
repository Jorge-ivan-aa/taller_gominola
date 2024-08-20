package co.edu.uniquindio.gominola.controller;

import co.edu.uniquindio.gominola.factory.ModelFactory;
import co.edu.uniquindio.gominola.model.Cliente;

public class ClienteController {
    private ModelFactory factory;

    public ClienteController(ModelFactory factory) {
        this.factory = ModelFactory.getIntance();
    }
}