package co.edu.uniquindio.gominola.controller;

import co.edu.uniquindio.gominola.factory.ModelFactory;
import co.edu.uniquindio.gominola.model.Acompanante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

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

    public void eliminarAcompanante(String nombre){
        ArrayList<Acompanante> acompanantes = factory.getGominola().getListaAcompanante();
        for (int i = 0; i < acompanantes.size(); i++){
            if (Objects.equals(acompanantes.get(i).getNombre(), nombre)){
                acompanantes.remove(acompanantes.get(i));
                this.listaAcompananteObservable.remove(acompanantes.get(i));
            }
        }
    }

    public Acompanante consultarAcompanante(String correo){
        ArrayList<Acompanante> acompanantes = this.factory.getGominola().getListaAcompanante();
        for (Acompanante value : acompanantes) {
            if (value.getNombre().equals(correo)){
                return value;
            }
        }
        return null;
    }

    public String crearAcompanante(String nombre, String edad, String talla, String correo, String telefono, String saludo, int valorHora) {
        ArrayList<Acompanante> acompanantes = factory.getGominola().getListaAcompanante();
        for (Acompanante acompanante : acompanantes) {
            if (Objects.equals(acompanante.getNombre(), nombre)) {
                return "El acompañante ingresado ya se existe";
            }
        }
        Acompanante nuevoAcompanante = new Acompanante(nombre, edad, talla, correo, telefono, saludo, valorHora);
        this.factory.getGominola().addAcompanante(nuevoAcompanante);
        this.listaAcompananteObservable.add(nuevoAcompanante);
        return "Acompañante registrado exitosamente";
    }


    public void actualizarAcompanante(String nombre, String edad, String talla, String correo, String telefono, String saludo, int valorHora){
        ArrayList<Acompanante> acompanantes = factory.getGominola().getListaAcompanante();
        for (int i = 0; i < acompanantes.size(); i++){
            if (Objects.equals(acompanantes.get(i).getNombre(), nombre)){
                Acompanante nuevoAcompanante = new Acompanante(nombre, edad, talla, correo, telefono, saludo, valorHora);
                acompanantes.remove(acompanantes.get(i));
                acompanantes.add(nuevoAcompanante);
                this.listaAcompananteObservable.remove(acompanantes.get(i));
                this.listaAcompananteObservable.add(nuevoAcompanante);
            }
        }
    }

}