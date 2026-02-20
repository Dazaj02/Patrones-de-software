package laboratorioT;

import java.util.ArrayList;
import java.util.List;

public class Experimento implements Cloneable {
    private String nombre;
    private double temperatura;
    private int tiempo;
    private List<String> instrumentos;

    public Experimento(String nombre, double temperatura, int tiempo, List<String> instrumentos) {
        this.nombre = nombre;
        this.temperatura = temperatura;
        this.tiempo = tiempo;
        this.instrumentos = instrumentos;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public List<String> getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(List<String> instrumentos) {
        this.instrumentos = instrumentos;
    }

    // PATRÓN PROTOTYPE: Implementación recursiva profunda
    @Override
    public Experimento clone() {
        try {
            Experimento clon = (Experimento) super.clone();
            clon.instrumentos = new ArrayList<>(this.instrumentos);
            return clon;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Experimento: " + nombre + "\n" +
                "Temperatura: " + temperatura + " °C\n" +
                "Tiempo: " + tiempo + " min\n" +
                "Instrumentos: " + instrumentos + "\n";
    }
}
