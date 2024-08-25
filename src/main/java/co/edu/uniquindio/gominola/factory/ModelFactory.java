package co.edu.uniquindio.gominola.factory;

import co.edu.uniquindio.gominola.model.Gominola;

public class ModelFactory {
    private static ModelFactory instance;
    private Gominola gominola;

    private ModelFactory() {
        gominola = new Gominola();
    }

    public static ModelFactory getIntance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    public Gominola getGominola() {
        return gominola;
    }
}