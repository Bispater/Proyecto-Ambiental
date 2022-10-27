package Vistas;

import Contenido.PuntoReciclaje;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarPuntoReciclaje extends Frame implements ActionListener {

    JTextField direccion, tipoReciclaje, ciudad, capacidad;
    JLabel text, direccion1, tipoReciclaje1, ciudad1, capacidad1;;
    JButton volver, aceptar;
    int centrar;
    int ancho, alto, anchoLabel;


    public void agregarPunto(){
        //CONFIGURACIÓN PANTALLA
        ancho = 700;
        alto = 700;
        anchoLabel = 400;
        centrar = (ancho / 2) - (anchoLabel / 2);
        setSize(ancho,alto);
        setLayout(null);
        setVisible(true);

        // BTN VOLVER
        volver = new JButton("Volver");
        volver.setBounds(15, 42, 100, 40);
        add(volver);
        volver.addActionListener(this);

        //TEXTO BIENVENIDA
        text = new JLabel("Agregar puntos de reciclaje: ");
        text.setBounds(centrar,70, 400,20);
        add(text);

        //INPUT Direccion
        direccion1 = new JLabel("Dirección:");
        direccion1.setBounds(centrar+3,110, 400,20);
        add(direccion1);
        direccion=new JTextField();
        direccion.setBounds(centrar,130, 400,40);
        add(direccion);


        //INPUT TIPO RECICLAJE
        tipoReciclaje1 = new JLabel("Tipo Reciclaje:");
        tipoReciclaje1.setBounds(centrar+3,180, 400,20);
        add(tipoReciclaje1);
        tipoReciclaje=new JTextField();
        tipoReciclaje.setBounds(centrar,200, 400,40);
        add(tipoReciclaje);

        //INPUT CIUDAD
        ciudad1 = new JLabel("Ciudad donde se encuentra:");
        ciudad1.setBounds(centrar+3,250, 400,20);
        add(ciudad1);
        ciudad=new JTextField();
        ciudad.setBounds(centrar,270, 400,40);
        add(ciudad);

        //INPUT CAPACIDAD KILOGRAMOS
        capacidad1 = new JLabel("Capacidad:");
        capacidad1.setBounds(centrar+3,320, 400,20);
        add(capacidad1);
        capacidad=new JTextField();
        capacidad.setBounds(centrar,340, 400,40);
        add(capacidad);

        //ACEPTAR
        aceptar = new JButton("Crear");
        aceptar.setBounds(centrar,400, 400,40);
        add(aceptar);
        aceptar.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aceptar){
            JFrame frame = new JFrame();
            frame.setSize(100, 100);
            PuntoReciclaje puntos = new PuntoReciclaje();
            JOptionPane.showMessageDialog(frame, "Punto creado con exito!");
            setVisible(false);
            new AdminInterface();
        }
    }
}



