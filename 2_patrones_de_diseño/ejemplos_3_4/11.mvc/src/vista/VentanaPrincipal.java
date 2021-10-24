package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import controlador.Coordinador;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Coordinador miCoordinador;
    private JTextArea areaIntroduccion;
    private JLabel labelTitulo, labelSeleccion;
    private JButton botonRegistrar, botonBuscar;
    public String textoIntroduccion = "";

    public VentanaPrincipal() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        botonRegistrar = new JButton();
        botonRegistrar.setBounds(100, 280, 120, 25);
        botonRegistrar.setText("Registrar");

        botonBuscar = new JButton();
        botonBuscar.setBounds(240, 280, 120, 25);
        botonBuscar.setText("Buscar");

        labelTitulo = new JLabel();
        labelTitulo.setText("PATRON MODELO VISTA CONTROLADOR");
        labelTitulo.setBounds(60, 40, 380, 30);
        labelTitulo.setFont(new java.awt.Font("Verdana", 1, 15));

        labelSeleccion = new JLabel();
        labelSeleccion.setText("Escoja que operacion desea realizar");
        labelSeleccion.setBounds(75, 240, 250, 25);

        textoIntroduccion = "Esta aplicacion presenta un ejemplo practico de patron " + "de diseño MCV.\n\n"
                + "La aplicacion permite registrar, actualizar, buscar y eliminar registros de una tabla Persona."
                + "tambien sin vinculados algunos conceptos de los Patrones Value Object y Data Access Object\n";

        areaIntroduccion = new JTextArea();
        areaIntroduccion.setBounds(50, 90, 380, 140);
        areaIntroduccion.setEditable(false);
        areaIntroduccion.setFont(new java.awt.Font("Verdana", 0, 14));
        areaIntroduccion.setLineWrap(true);
        areaIntroduccion.setText(textoIntroduccion);
        areaIntroduccion.setWrapStyleWord(true);
        areaIntroduccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED,
                null, null, null, new java.awt.Color(0, 0, 0)));

        botonRegistrar.addActionListener(this);
        botonBuscar.addActionListener(this);
        add(botonBuscar);
        add(botonRegistrar);
        add(labelSeleccion);
        add(labelTitulo);
        add(areaIntroduccion);

        setSize(480, 350);
        setTitle("Iplacex : Patrones de Diseño/MVC");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonRegistrar) {
            miCoordinador.mostrarVentanaRegistro();
        }
        if (e.getSource() == botonBuscar) {
            miCoordinador.mostrarVentanaConsulta();
        }
    }

}
