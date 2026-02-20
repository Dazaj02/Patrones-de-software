package laboratorioT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JTextField txtNombre;
    private JTextField txtTemperatura;
    private JTextField txtTiempo;
    private JTextField txtInstrumentos;
    private JTextArea txtResultados;
    private JButton btnCrear;
    private JButton btnClonar;

    private Experimento experimentoActual;

    public MainFrame() {
        setTitle("Configuración de Experimentos de Laboratorio");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JPanel panelDatos = new JPanel(new GridLayout(5, 2, 5, 5));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelDatos.add(new JLabel("Nombre del experimento:"));
        txtNombre = new JTextField();
        panelDatos.add(txtNombre);

        panelDatos.add(new JLabel("Temperatura (°C):"));
        txtTemperatura = new JTextField();
        panelDatos.add(txtTemperatura);

        panelDatos.add(new JLabel("Tiempo (min):"));
        txtTiempo = new JTextField();
        panelDatos.add(txtTiempo);

        panelDatos.add(new JLabel("Instrumentos (separados por coma):"));
        txtInstrumentos = new JTextField();
        panelDatos.add(txtInstrumentos);

        JPanel panelBotones = new JPanel(new FlowLayout());
        btnCrear = new JButton("Crear Experimento (Builder)");
        btnClonar = new JButton("Clonar Experimento (Prototype)");
        btnClonar.setEnabled(false);

        panelBotones.add(btnCrear);
        panelBotones.add(btnClonar);

        txtResultados = new JTextArea();
        txtResultados.setEditable(false);
        JScrollPane scrollResultados = new JScrollPane(txtResultados);

        add(panelDatos, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(scrollResultados, BorderLayout.SOUTH);

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearExperimento();
            }
        });

        btnClonar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clonarExperimento();
            }
        });
    }

    private void crearExperimento() {
        try {
            String nombre = txtNombre.getText();
            double temperatura = Double.parseDouble(txtTemperatura.getText());
            int tiempo = Integer.parseInt(txtTiempo.getText());

            // Permite al usuario ingresar los instrumentos a través de la interfaz gráfica
            // separados por comas
            String[] instrumentosArray = txtInstrumentos.getText().split(",");

            ExperimentoBuilder builder = new ExperimentoBuilder()
                    .setNombre(nombre)
                    .setTemperatura(temperatura)
                    .setTiempo(tiempo);

            for (String inst : instrumentosArray) {
                String trimInst = inst.trim();
                // Verificamos que no agregue strings vacíos
                if (!trimInst.isEmpty()) {
                    builder.agregarInstrumento(trimInst);
                }
            }

            experimentoActual = builder.build();

            // Mensaje que refleja la estructura del objeto creado
            txtResultados.setText("--- EXPERIMENTO CREADO ORIGINAL ---\n" + experimentoActual.toString());

            btnClonar.setEnabled(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese números válidos en Temperatura y Tiempo.",
                    "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clonarExperimento() {
        if (experimentoActual != null) {
            Experimento experimentoClonado = experimentoActual.clone();

            // Le añadimos un sufijo para distinguir fácilmente al clon del original
            experimentoClonado.setNombre(experimentoClonado.getNombre() + " (Copia Clonada)");

            txtResultados.append("\n--- EXPERIMENTO CLONADO EXITOSAMENTE ---\n" + experimentoClonado.toString());
            txtResultados.append("(Nota: El clon es totalmente independiente gracias a la Clonación Profunda)\n");
        }
    }
}
