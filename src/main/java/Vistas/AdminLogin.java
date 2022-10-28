package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin extends Frame implements ActionListener {

    JTextField user, password;
    JLabel text, input1, input2;
    JButton aceptar, volver;
    int centrar;
    int ancho, alto, anchoLabel;
    public void vistaAdmin(){

        //CONFIGURACIÓN PANTALLA
        ancho = 700;
        alto = 700;
        setSize(ancho,alto);
        setLayout(null);
        setVisible(true);

        //PROPIEDAD PARA CENTRAR HORIZONTAL
        anchoLabel = 300;
        centrar = (ancho / 2) - (anchoLabel / 2);

        // BTN VOLVER
        volver = new JButton("Volver");
        volver.setBounds(15, 42, 100, 40);
        add(volver);
        volver.addActionListener(this);

        //TEXTO BIENVENIDA
        text = new JLabel("Bienvenida, ingresa los datos para iniciar sesión : ");
        text.setBounds(centrar,200, 400,20);
        add(text);

        //INPUT USUARIO
        input1 = new JLabel("Usuario:");
        input1.setBounds(centrar+3,270, 400,20);
        add(input1);
        user=new JTextField();
        user.setBounds(centrar,290, 400,40);
        add(user);

        //INPUT CONTRASEÑA
        input2 = new JLabel("Contraseña:");
        input2.setBounds(centrar+3,330, 400,20);
        add(input2);
        password=new JTextField();
        password.setBounds(centrar,350, 400,40);
        add(password);

        //BOTÓN DE ACEPTAR
        aceptar = new JButton("Ingresar");
        aceptar.setBounds(centrar,410, 400,40);
        add(aceptar);
        aceptar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == volver){
            setVisible(false);
            new MainInterface();
        }
        if (e.getSource() == aceptar){
            validarIngreso();
        }
    }

    public void validarIngreso(){
        System.out.println("VALIDANDO INGRESO ...");
        if ((this.user.getText().equals("user"))&&(this.password.getText().equals("admin"))){
            System.out.println("VALIDACIÓN EXITOSA");
            setVisible(false);
            JFrame frame = new JFrame();
            frame.setSize(100, 100);
            MenuAdministrador h = new MenuAdministrador();
            h.menuPrincipal();
            JOptionPane.showMessageDialog(frame, "¡Ingreso Exitoso!");
        }else {
            System.out.println("VALIDACIÓN FALLIDA ...");
            JFrame frame = new JFrame();
            frame.setSize(100, 100);
            JOptionPane.showMessageDialog(frame, "Uno o más datos son incorrectos");
        }
    }


}
