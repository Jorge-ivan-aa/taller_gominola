package co.edu.uniquindio.gominola.controller;

import co.edu.uniquindio.gominola.factory.ModelFactory;
import co.edu.uniquindio.gominola.model.Acompanante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;
import java.util.SimpleTimeZone;

public class AcompananteController {
    private ModelFactory factory;
    private ObservableList<Acompanante> listaAcompananteObservable;

    public AcompananteController() {
        this.factory = ModelFactory.getIntance();
        this.listaAcompananteObservable = FXCollections.observableArrayList();
        this.sincronizarData();
    }

    public ObservableList<Acompanante> getListaAcompananteObservable() {
        return listaAcompananteObservable;
    }

    public void sincronizarData() {
        this.listaAcompananteObservable.addAll(this.factory.getGominola().getListaAcompanante());
    }


    public Acompanante consultarAcompanante(String nombre){
        ArrayList<Acompanante> acompanantes = this.factory.getGominola().getListaAcompanante();
        for (Acompanante value : acompanantes) {
            if (value.getNombre().equals(nombre)){
                return value;
            }
        }
        return null;
    }


    public String eliminarAcompanante(String nombre) {

        if (this.consultarAcompanante(nombre) == null) {
            return "El acompañante ingresado no existe";
        } else {
            int index = -1;
            ArrayList<Acompanante> acompanantes = factory.getGominola().getListaAcompanante();
            for (int i = 0; i < acompanantes.size(); i++) {
                if (Objects.equals(acompanantes.get(i).getNombre(), nombre)) {
                    index = i;
                }
            }

            if (index != -1) {
                this.listaAcompananteObservable.remove(index);
                acompanantes.remove(acompanantes.get(index));
            }

            return "El acompañante fue eliminado correctamente";
        }
    }


    public String crearAcompanante(String nombre, String edad, String talla, String correo, String telefono, String saludo, int valorHora) {
        ArrayList<Acompanante> acompanantes = factory.getGominola().getListaAcompanante();

        if (this.consultarAcompanante(nombre) != null) {
            return "El acompañante ingresado ya existe";
        } else {
            Acompanante nuevoAcompanante = new Acompanante(nombre, edad, talla, correo, telefono, saludo, valorHora);
            this.factory.getGominola().addAcompanante(nuevoAcompanante);
            this.listaAcompananteObservable.add(nuevoAcompanante);
            return "Acompañante registrado exitosamente";
        }
    }


    public String actualizarAcompanante(String nombre, String edad, String talla, String correo, String telefono, String saludo, int valorHora) {
        ArrayList<Acompanante> acompanantes = factory.getGominola().getListaAcompanante();

        if (this.consultarAcompanante(nombre) == null) {
            return "El acompañante ingresado no existe";

        } else {
            int index = -1;
            for (int i = 0; i < acompanantes.size(); i++) {
                if (Objects.equals(acompanantes.get(i).getNombre(), nombre)) {
                    index = i;

                }

            }

            if (index != -1) {
                Acompanante nuevoAcompanante = new Acompanante(nombre, edad, talla, correo, telefono, saludo, valorHora);
                acompanantes.remove(index);
                acompanantes.add(nuevoAcompanante);
                this.listaAcompananteObservable.remove(index);
                this.listaAcompananteObservable.add(nuevoAcompanante);
            }


            return "El acompañante ingresado fue actualizado";
        }
    }
}