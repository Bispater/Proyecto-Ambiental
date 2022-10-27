package Vistas;
import javax.swing.*;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends Frame implements ActionListener {
    JButton volver;
    int ancho, alto;

    public void VistaUser(){
        ancho = 700;
        alto = 700;

        setSize(ancho,alto);
        setLayout(null);
        setVisible(true);

        volver = new JButton("Volver");
        volver.setBounds(12,42,100,40);
        add(volver);
        volver.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == volver){
            setVisible(false);
            new MainInterface();
        }
    }

}
