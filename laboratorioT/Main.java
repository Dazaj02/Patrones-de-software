package laboratorioT;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            }
        });
    }
}

/*
 * =========================================================================
 * 🎓 EXPLICACIÓN DE LOS PATRONES DE DISEÑO EN EL PROYECTO:
 * =========================================================================
 * 
 * 1. Patrón Builder (Constructor):
 * - ¿Cómo funciona?: Se utiliza la clase `ExperimentoBuilder` para crear o
 * ensamblar instancias de `Experimento` paso a paso.
 * - Ventaja en el proyecto: Evita un constructor con demasiados parámetros
 * (anti-patrón "telescoping constructor"). Permite que configuremos los
 * atributos
 * (como temperatura o tiempo) de forma muy legible, encadenando métodos
 * como `.setNombre().setTemperatura()...`.
 * - Ubicación: Se aplica en `MainFrame.java`, dentro del método
 * `crearExperimento()`,
 * donde usamos el Builder para construir el objeto final llamando a `.build()`.
 * 
 * 2. Patrón Prototype (Prototipo):
 * - ¿Cómo funciona?: Se implementa la interfaz `Cloneable` en la clase base
 * (`Experimento`) y se sobrescribe el método `clone()`.
 * - Clonación Profunda implementada: En lugar de hacer una copia superficial
 * (donde compartirían la misma lista de instrumentos y se modificarían a la
 * vez),
 * nuestro método `clone()` crea una **fresca y nueva lista** (`new ArrayList`)
 * para asegurar la independencia del clon.
 * - Ventaja en el proyecto: Permite duplicar las configuraciones de los
 * experimentos sin tener que volver a ingresar todos los datos nuevamente
 * y sin llamar repetidamente al Builder.
 * - Ubicación: Se aplica en `MainFrame.java`, en el método
 * `clonarExperimento()`,
 * donde llamamos simplemente a `experimentoActual.clone()`.
 * =========================================================================
 */
