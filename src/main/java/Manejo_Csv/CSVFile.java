package Manejo_Csv;

import Usuarios.Admin;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVFile {

    private BufferedReader lector;
    private String linea;
    private String partes[] = null;

    public void writeCSV(String file, String[] header ){
        try {
            /*
            This function write into CSV file. Receive a string with name file, an index and a number that will be saved.
             */
            System.out.println(file);
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println(header[0] + ";" + header[1]);
            //System.out.println(header);
            printWriter.flush();
            printWriter.close();

            //JOptionPane.showMessageDialog(null, "File Saved");
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public void leerArchivo(String nombreArchivo) {
        try {
            lector = new BufferedReader(new FileReader(nombreArchivo));
            while ((linea = lector.readLine()) != null) {
                String str = linea;
                partes = str.split("[;]", 0);
                imprimirLinea(partes);
                System.out.println();
            }
            lector.close();
            linea = null;
            partes = null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void imprimirLinea(String partes[]) {
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