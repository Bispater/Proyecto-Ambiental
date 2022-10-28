package Vistas;

import javax.swing.JButton;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainInterface extends Frame implements ActionListener{
    JButton Admin, User, Cerrar;
    public MainInterface(){

        //ADMIN
        Admin =new JButton("Administrador");
        Admin.setBounds(275,280,150,60);
        Admin.addActionListener(this);
        add(Admin);

        //USUARIO
        User = new JButton("Usuario Normal");
        User.setBounds(275,350,150,60);
        User.addActionListener(this);
        add(User);

        // BTN CERRAR
        Cerrar = new JButton("Cerrar");
        Cerrar.setBounds(15, 42, 100, 40);
        add(Cerrar);
        Cerrar.addActionListener(this);

        //LAYOUT PRINCIPAL
        setSize(700,700);
        setLayout(null);
        setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Admin){
                System.out.println("MOSTRANDO LOGIN DE ADMINISTRADOR");
                setVisible(false);
                AdminLogin h = new AdminLogin();
                h.vistaAdmin();
            }

            if(e.getSource() == User){
                System.out.println("MOSTRANDO LOGIN DE USUARIO");
                setVisible(false);
                UserInterface U = new UserInterface();
                U.VistaUser();
            }

            if(e.getSource() == Cerrar){
                System.out.println("\n¡INTERFAZ CERRADA!");
                setVisible(false);
                System.exit(0);
            }
        }
}
