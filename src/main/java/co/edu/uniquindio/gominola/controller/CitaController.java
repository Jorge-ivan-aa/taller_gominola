package co.edu.uniquindio.gominola.controller;

import co.edu.uniquindio.gominola.factory.ModelFactory;
import co.edu.uniquindio.gominola.model.Acompanante;
import co.edu.uniquindio.gominola.model.Cita;
import co.edu.uniquindio.gominola.model.Cita;
import co.edu.uniquindio.gominola.model.Cliente;
import co.edu.uniquindio.gominola.view.CitaView;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class CitaController {
    private ModelFactory factory;
    private ObservableList<Cita> listaCitaObservable;

    public CitaController() {
        this.factory = ModelFactory.getIntance();
        this.sincronizarData();
    }

    public ObservableList<Cita> getListaCitaObservable() {
        return listaCitaObservable;
    }

    public void sincronizarData() {
        this.listaCitaObservable.addAll(this.factory.getGominola().getListaCita());
    }

    public void eliminarCita(String nombre){
        ArrayList<Cita> cita = factory.getGominola().getListaCita();
        for (int i = 0; i < cita.size(); i++){
            if (Objects.equals(cita.get(i).getAcompanante().getNombre(), nombre)){
                cita.remove(cita.get(i));
                this.listaCitaObservable.remove(cita.get(i));
            }
        }
    }

    public Cita consultarCita(String nombre){
        ArrayList<Cita> cita = this.factory.getGominola().getListaCita();
        for (Cita value : cita) {
            if (value.getAcompanante().getNombre().equals(nombre)){
                return value;
            }
        }
        return null;
    }

    public String crearCita(Acompanante acompanante, Cliente cliente, Date fecha, String hora, String lugar, int horas) {
        ArrayList<Cita> citas = factory.getGominola().getListaCita();
        for (Cita cita : citas) {
            if (Objects.equals(cita.getAcompanante().getNombre(), acompanante.getNombre())) {
                return "El citas ingresado ya se existe";
            }
        }
        Cita nuevoCita = new Cita(acompanante, cliente, fecha, hora, lugar, horas);
        this.factory.getGominola().addCita(nuevoCita);
        this.listaCitaObservable.add(nuevoCita);
        return "Cita registrado exitosamente";
    }

}