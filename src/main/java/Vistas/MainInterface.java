package Vistas;

import javax.swing.JButton;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainInterface extends Frame implements ActionListener{
    JButton Admin, User;
    MainInterface(){

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

    //LAYOUT PRINCIPAL
    setSize(700,700);
    setLayout(null);
    setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Admin){
            System.out.println("MOSTRANDO LOGIN DE ADMINISTRADOR");
            setVisible(false);
            AdminInterface h = new AdminInterface();
            h.vistaAdmin();
        }

        if(e.getSource() == User){
            System.out.println("MOSTRANDO LOGIN DE USUARIO");
            setVisible(false);
            UserInterface U = new UserInterface();
            U.VistaUser();
        }
    }

    public static void main(String[] args) {
        new MainInterface();
    }
}
