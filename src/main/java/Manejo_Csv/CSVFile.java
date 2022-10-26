package Manejo_Csv;

import Usuarios.Admin;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CSVFile {

    private BufferedReader lector;
    private String linea;
    private String partes[] = null;

    public void leerArchivo(String nombreArchivo) {
        try {
            lector = new BufferedReader(new FileReader(nombreArchivo));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");
                imprimirLinea();
                System.out.println();
            }
            lector.close();
            linea = null;
            partes = null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void imprimirLinea() {
        for (int i = 0; i < partes.length; i++) {
            System.out.print(partes[i] + "  |  ");
        }
    }

    /*public ArrayList arrayText(String direccion, int cantL) { //Sin terminar OJO
        ArrayList<Admin> administradores = new ArrayList<>();
        administradores = null;
        try {
            lector = new BufferedReader(new FileReader(direccion));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");
                if(partes.length == cantL)
                {


                   int id = Integer.parseInt(partes[2])
                    Admin adminNuevo = new Admin(partes[0] , partes[1] , id , partes[3] );


                }

            }
            lector.close();
            linea = null;
            partes = null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return administradores ;
    }
*/
}