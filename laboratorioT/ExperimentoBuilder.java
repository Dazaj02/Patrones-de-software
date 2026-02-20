package laboratorioT;

import java.util.ArrayList;
import java.util.List;

// PATRÓN BUILDER
public class ExperimentoBuilder {
    private String nombre;
    private double temperatura;
    private int tiempo;
    private List<String> instrumentos;

    public ExperimentoBuilder() {
        this.instrumentos = new ArrayList<>();
    }

    public ExperimentoBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ExperimentoBuilder setTemperatura(double temperatura) {
        this.temperatura = temperatura;
        return this;
    }

    public ExperimentoBuilder setTiempo(int tiempo) {
        this.tiempo = tiempo;
        return this;
    }

    public ExperimentoBuilder agregarInstrumento(String instrumento) {
        this.instrumentos.add(instrumento);
        return this;
    }

    public Experimento build() {
        return new Experimento(nombre, temperatura, tiempo, instrumentos);
    }
}
