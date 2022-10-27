package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdministrador extends Frame implements ActionListener {

    int ancho, alto, anchoLabel, centrar;

    //CRUD PUNTOS RECICLAJE
    JButton agregarPuntosReciclaje, mostrarPuntosReciclaje, actualizarPuntoReciclaje, eliminarPuntoReciclaje;
    //CRUD NOTICIAS
    JButton agregarNoticia, mostrarNoticias, eliminarNoticia;
    //FUNCIONES ADMINISTRADOR
    JButton agregarAdmin, cambiarContrasenia, cerrarSesion;
    public void menuPrincipal () {

        //CONFIGURACIÓN PANTALLA
        ancho = 700;
        alto = 700;
        anchoLabel = 500;
        centrar = (ancho / 2) - (anchoLabel / 2);
        setSize(ancho,alto);
        setLayout(null);
        setVisible(true);
        JFrame frame = new JFrame();
        frame.setSize(100, 100);

        // BOTONES DE OPCIONES ADMINISTRADOR
        // BTN CERRAR SESIÓN
        cerrarSesion = new JButton("Cerrar Sesión");
        cerrarSesion.setBounds(580, 40, 100, 40);
        add(cerrarSesion);
        cerrarSesion.addActionListener(this);

        // PUNTOS DE RECICLAJE
        agregarPuntosReciclaje = new JButton("Agregar Puntos de Reciclaje");
        agregarPuntosReciclaje.setBounds(centrar,140, anchoLabel,40);
        add(agregarPuntosReciclaje);
        agregarPuntosReciclaje.addActionListener(this);

        mostrarPuntosReciclaje = new JButton("Mostrar Puntos de Reciclaje");
        mostrarPuntosReciclaje.setBounds(centrar,190, anchoLabel,40);
        add(mostrarPuntosReciclaje);
        mostrarPuntosReciclaje.addActionListener(this);

        actualizarPuntoReciclaje = new JButton("Actualizar Puntos de Reciclaje");
        actualizarPuntoReciclaje.setBounds(centrar,240, anchoLabel,40);
        add(actualizarPuntoReciclaje);
        actualizarPuntoReciclaje.addActionListener(this);

        eliminarPuntoReciclaje = new JButton("Eliminar Puntos de Reciclaje");
        eliminarPuntoReciclaje.setBounds(centrar,290, anchoLabel,40);
        add(eliminarPuntoReciclaje);
        eliminarPuntoReciclaje.addActionListener(this);

        // NOTICIAS
        agregarNoticia = new JButton("Agregar Noticias");
        agregarNoticia.setBounds(centrar,340, anchoLabel,40);
        add(agregarNoticia);
        agregarNoticia.addActionListener(this);

        mostrarNoticias = new JButton("Mostrar Noticias");
        mostrarNoticias.setBounds(centrar,390, anchoLabel,40);
        add(mostrarNoticias);
        mostrarNoticias.addActionListener(this);

        eliminarNoticia = new JButton("Eliminar Noticia");
        eliminarNoticia.setBounds(centrar,440, anchoLabel,40);
        add(eliminarNoticia);
        eliminarNoticia.addActionListener(this);

        // FUNCIONES ADMINISTRADOR
        agregarAdmin = new JButton("Agregar Administrador");
        agregarAdmin.setBounds(centrar,490, anchoLabel,40);
        add(agregarAdmin);
        agregarAdmin.addActionListener(this);

        cambiarContrasenia = new JButton("Cambiar Contraseña");
        cambiarContrasenia.setBounds(centrar,540, anchoLabel,40);
        add(cambiarContrasenia);
        cambiarContrasenia.addActionListener(this);


    }
/*
    case cerrarSesion:
    setVisible(false);
    new LabelExample();
 */

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cerrarSesion){
            new MainInterface();
        }
        if(e.getSource() == agregarPuntosReciclaje){
            AgregarPuntoReciclaje f = new AgregarPuntoReciclaje();
            f.agregarPunto();
        }

        JFrame frame = new JFrame();
        frame.setSize(100, 100);
    }
}


