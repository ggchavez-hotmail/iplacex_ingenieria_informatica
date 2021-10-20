package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Logica;
import modelo.vo.PersonaVo;
import controlador.Coordinador;

public class VentanaBuscar extends JFrame implements ActionListener {
    private Coordinador miCoordinador;
    private JLabel labelTitulo;
    private JTextField textCod, textNombre, textEdad, textTelefono, textProfesion;
    private JLabel cod, nombre, edad, telefono, profesion;
    private JButton botonGuardar, botonCancelar, botonBuscar, botonModificar, botonEliminar;

    public VentanaBuscar() {
        botonGuardar = new JButton();
        botonGuardar.setBounds(50, 220, 120, 25);
        botonGuardar.setText("Guardar");

        botonCancelar = new JButton();
        botonCancelar.setBounds(190, 250, 120, 25);
        botonCancelar.setText("Cancelar");

        botonBuscar = new JButton();
        botonBuscar.setBounds(170, 80, 120, 25);
        botonBuscar.setText("Ok");

        botonEliminar = new JButton();
        botonEliminar.setBounds(330, 220, 120, 25);
        botonEliminar.setText("Eliminar");

        botonModificar = new JButton();
        botonModificar.setBounds(190, 220, 120, 25);
        botonModificar.setText("Eliminar");

        labelTitulo = new JLabel();
        labelTitulo.setText("ADMINISTRAR PERSONAS");
        labelTitulo.setBounds(120, 20, 380, 30);
        labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

        cod = new JLabel();
        cod.setText("Codigo");
        cod.setBounds(20, 80, 80, 25);
        add(cod);

        nombre = new JLabel();
        nombre.setText("Nombre");
        nombre.setBounds(20, 120, 80, 25);
        add(nombre);

        telefono = new JLabel();
        telefono.setText("Telefono");
        telefono.setBounds(290, 160, 80, 25);
        add(telefono);

        profesion = new JLabel();
        profesion.setText("Profesion");
        profesion.setBounds(20, 160, 80, 25);
        add(profesion);

        edad = new JLabel();
        edad.setText("Edad");
        edad.setBounds(290, 120, 80, 25);
        add(edad);

        textCod = new JTextField();
        textCod.setBounds(80, 80, 80, 25);
        add(textCod);

        textNombre = new JTextField();
        textNombre.setBounds(80, 120, 190, 25);
        add(textNombre);

        textTelefono = new JTextField();
        textTelefono.setBounds(340, 160, 80, 25);
        add(textTelefono);

        textProfesion = new JTextField();
        textProfesion.setBounds(80, 160, 190, 25);
        add(textProfesion);

        textEdad = new JTextField();
        textEdad.setBounds(340, 120, 80, 25);
        add(textEdad);

        botonModificar.addActionListener(this);
        botonEliminar.addActionListener(this);
        botonBuscar.addActionListener(this);
        botonGuardar.addActionListener(this);
        botonCancelar.addActionListener(this);

        add(botonModificar);
        add(botonEliminar);
        add(botonBuscar);
        add(botonGuardar);
        add(botonCancelar);
    }

    public void limpiar() {
        textCod.setText("");
        textNombre.setText("");
        textEdad.setText("");
        textTelefono.setText("");
        textProfesion.setText("");
        habilita(true, false, false, false, false, true, false, true, true);
    }

    public void habilita(boolean codigo, boolean nombre, boolean edad, boolean telefono, boolean profesion,
            boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar) {
        textCod.setEditable(codigo);
        textNombre.setEditable(nombre);
        textEdad.setEditable(edad);
        textTelefono.setEditable(telefono);
        textProfesion.setEditable(profesion);
        botonBuscar.setEnabled(bBuscar);
        botonGuardar.setEnabled(bGuardar);
        botonModificar.setEnabled(bModificar);
        botonEliminar.setEnabled(bEliminar);
    }
}
