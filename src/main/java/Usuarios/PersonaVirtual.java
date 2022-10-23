package Usuarios;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonaVirtual { //Clase padre - superClase
    private String Nombre;

    private String Rut;

    Scanner entrada = new Scanner(System.in);

    public PersonaVirtual (String nombre, String run){
        this.Nombre = nombre;
        this.Rut = run;
    }

    public String getNombre() {
        return Nombre;
    }



    public String getRut() {
        return Rut;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }


    public void setRut(String rut) {
        this.Rut = rut;
    }

    public boolean ValidarPersona(){

        int contFail=0;

        //-----------VALIDACION DE FORMATOS-------------//

        while(!Nombre.matches("([a-zA-Z]*[ ']+[a-zA-Z]*)*")){
            contFail++;
            if(contFail==5) return false;
            System.out.println("El dato es incorrecto, debe escribir solo letras (nombre y apellido separados)");
            System.out.print("Inserte nombre de administrador: ");
            Nombre = entrada.nextLine();
        }
        contFail=0 ;
        System.out.print("Inserte su Rut:");
        Rut = entrada.nextLine();
        while(!Rut.matches("[0-9]*[-'][0-9]")){
            contFail++;
            if(contFail==5) return false;
            System.out.println("Dato incorrecto, debe escribir numeros con guion y digito verificador");
            System.out.print("Inserte su Rut:");
            Rut = entrada.nextLine();
        }

    return true ;
    }

    public void CrearPersona() {
        int id, contFail = 0;
        int flag = 0;
        String Nombre, Rut;
        //Valdiacion de formato de datos
        System.out.print("Inserte nombre natural:");
        Nombre = entrada.nextLine();
        while (!Nombre.matches("([a-zA-Z]*[ ']+[a-zA-Z]*)*")) {
            contFail++;
            if (contFail == 5) {
                System.out.println("Creacion fallida");
                flag = 1;
                return;
            }
            System.out.println("El dato es incorrecto, debe escribir solo letras (nombre y apellido separados)");
            System.out.print("Inserte nombre de administrador: ");
            Nombre = entrada.nextLine();
        }
        if (flag != 1) this.setNombre(Nombre);

        System.out.print("Inserte su Rut:");
        contFail = 0;
        flag = 0;
        Rut = entrada.nextLine();
        while (!Rut.matches("[0-9]*[-'][0-9]")) {
            contFail++;
            if (contFail == 5) {
                System.out.println("Creacion fallida");
                flag = 1;
                return;
            }
            System.out.println("Dato incorrecto, debe escribir numeros con guion y digito verificador");
            System.out.print("Inserte su Rut:");
            Rut = entrada.nextLine();
        }
        if (flag != 1) {
            setRut(Rut);
        }
    }
}
