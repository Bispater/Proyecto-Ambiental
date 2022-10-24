package Usuarios;

import Contenido.Noticias;
import Contenido.PuntoReciclaje;

import java.util.Scanner;
public class Usuario extends PersonaVirtual {
    private String Ciudad;

    Scanner entrada = new Scanner(System.in);
    //Constructor
    public Usuario(){
        super("","");
        this.Ciudad="";
    }

    //Getters & Setters
    public String getCiudad() {
        return this.Ciudad;
    }
    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }


    public boolean ValidarPersona() {
        int contFail = 0;
        int flag = 0 ;
        System.out.println("Inserte nombre");
        String nombre = entrada.nextLine();
        while(!nombre.matches("([a-zA-Z]*[ ']+[a-zA-Z]*)*"))
        {
            contFail++;
            if(contFail==5)
            {
                System.out.println("Creacion fallida");
                flag = 1 ;
                return false ;
            }
            System.out.println("El dato es incorrecto, debe escribir solo letras (nombre y apellido separados)");
            System.out.print("Inserte nombre de administrador: ");
            nombre = entrada.nextLine();
        }
        contFail = 0;

        System.out.println("Inserte rut");
        String rut = entrada.nextLine();
        while(!rut.matches("[0-9]*[-'][0-9]"))
        {
            contFail++;
            if(contFail ==5)
            {
                System.out.println("Creacion fallida");
                flag = 1 ;
                return false ;
            }
            System.out.println("Dato incorrecto, debe escribir numeros con guion y digito verificador");
            System.out.println("Inserte rut");
             rut = entrada.nextLine();
        }
        contFail = 0;
        System.out.println("Inserte ciudad donde vive");
        String ciudad = entrada.nextLine();
        while(!ciudad.matches("[A-Z][a-z]*") ) {
            contFail++;
            System.out.println("Formato incorrecto , ingrese con solo la primera letra mayuscula");
            if(contFail ==5)
            {

                System.out.println("Creacion fallida");
                flag = 1 ;
                return false ;
            }

            System.out.println("Inserte ciudad donde vive");
            ciudad = entrada.nextLine();
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



    //Comportamientos y metodos
    public void MenuUsuario(){
        int opcion;
        PuntoReciclaje ptoReciclaje = new PuntoReciclaje();
        Noticias noticias = new Noticias();
         if( !ValidarPersona()) return ;
        //Muestra de opciones del usuario
        System.out.println("ELIJA UNA OPCION:");
        System.out.println("1) Puntos de reciclaje cercanos\n2) Presentar noticias\n3) Consultar puntos de reciclaje por ciudad\n4) Presione 0 para salir");
        System.out.print("OPCION:");
        opcion = entrada.nextInt();
        try{
            switch (opcion){
                case 0 :
                    return;
                case 1 :
                    ptoReciclaje.PtoReciclajeCercano(this.Ciudad); //Busca puntosR de acuerdo a la ciudad ingresada
                    break;
                case 2 :
                    noticias.PresentarNoticia();
                    break;
                case 3 :
                    System.out.print("Ingrese la ciudad donde desea buscar: ");
                    String ciudad = entrada.nextLine();
                    while(!ciudad.matches("[A-Z][a-zA-Z]*")){
                        System.out.println("- Formato incorrecto. Ingrese solo letras, con la primera mayuscula\n");
                        System.out.print("Ingrese la ciudad donde desea buscar: ");
                        ciudad = entrada.nextLine();
                    }
                    ptoReciclaje.PtoReciclajeCercano(ciudad); //Busca puntosR de acuerdo a la ciudad ingresada
                    break;
                 default :
                     throw new Exception("No se puede ejecutar esa opcion ");


            }

        }catch(Exception e)
        {
         e.printStackTrace();

        }

    }
}
