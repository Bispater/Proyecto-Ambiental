package Usuarios;
import Contenido.Noticias;
import Contenido.PuntoReciclaje;
import Manejo_Csv.CSVFile;
import Manejo_Csv.CSVManage;

import java.util.Scanner;
import java.util.ArrayList;


public class Admin extends PersonaVirtual {
    private String Contrasenia;
    Scanner entrada = new Scanner(System.in);
    private int id ;
    ArrayList <Admin> administradores = new ArrayList<>();



    // Constructores
    public Admin() {
        super("admin","00000000-0");
        this.Contrasenia = "admin";
        this.id=1;
    }
    public Admin(String nombre , int id , String contrasenia) {
        super(nombre,""); //Solicitar rut al admin
        this.Contrasenia = contrasenia;
        this.id=id;

    }

    // Geters y setters
    public String getContrasenia() {
        return this.Contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.Contrasenia = contrasenia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Comportamientos
    public Admin CrearAdmin() {
        Admin NuevoAdmin;
        String Contrasenia, nombre = "", Rut = "";
        int ID=0;
        CrearPersona();

        System.out.print("Ingrese su contraseña:");
        Contrasenia = entrada.next();
        while(!Contrasenia.matches("([a-zA-Z]*+[0-9]*+)*")){
            System.out.println("Formato incorrecto, debe recibir al menos una letra y un numero");
            System.out.print("Ingrese contraseña:");
            Contrasenia = entrada.next();
        }

        NuevoAdmin = new Admin(nombre,ID,Contrasenia);
        return NuevoAdmin;
    }
    public boolean ValidarContrasenia(String contrasenia){
        int contFail=0;
        while(!contrasenia.matches("([a-zA-Z]*+[0-9]*+)*")){ //Revisar
            contFail++;
            System.out.println("El dato es incorrecto, debe recibir al menos una letra y numero");
            if(contFail==5)
            {
                System.out.println("Acceso denegado - intente nuevamente");
                return false;
            }
            System.out.print("Ingrese contraseña: ");
            contrasenia = entrada.next();

        }

        return true;
    }

    public void CrearPersona()
    {
        int id , contFail=0;
        int flag=0;
        String Nombre , Rut;
        //Valdiacion de formato de datos
        System.out.print("Inserte nombre natural:");
        Nombre = entrada.nextLine();
        while(!Nombre.matches("([a-zA-Z]*[ ']+[a-zA-Z]*)*")){
            contFail++;
            if(contFail==5)
            {
                System.out.println("Creacion fallida");
                flag = 1 ;
                return;
            }
            System.out.println("El dato es incorrecto, debe escribir solo letras (nombre y apellido separados)");
            System.out.print("Inserte nombre de administrador: ");
            Nombre = entrada.nextLine();
        }
            if(flag!= 1 )this.setNombre(Nombre);
        do{
            flag=0 ;
            contFail=0;
            System.out.print("Ingrese ID:");
            id = entrada.nextInt();

            //Valdiacion de formato de datos
            if(id>0 && Validarid( id )){
                flag = 1;   //Formato del ID correcto
            }
            else {
                System.out.println("Formato del identificador incorrecto, debe escribir solo numeros");
                contFail++;
                if(contFail == 5)
                {
                   System.out.println("Creacion fallida");
                    return;
                }
            }
        }while(flag==0);
        if(flag == 1 )
        {
            this.id = id ;
        }
        System.out.print("Inserte su Rut:");
        contFail=0;
        flag=0 ;
        Rut = entrada.nextLine();
        while(!Rut.matches("[0-9]*[-'][0-9]")){
            contFail++;
            if(contFail ==5)
            {
                System.out.println("Creacion fallida");
                flag = 1 ;
                return;
            }
            System.out.println("Dato incorrecto, debe escribir numeros con guion y digito verificador");
            System.out.print("Inserte su Rut:");
            Rut = entrada.nextLine();
        }
        if(flag != 1)
        {
            setRut(Rut);
        }
    }
    public boolean ValidarPersona(){
      System.out.println("Inserte id");
        int idnew = entrada.nextInt();
      System.out.println("Inserte contraseña");
       String contra = entrada.next();

        if(!Validarid( idnew) && ValidarContrasenia(contra )){
            return true;
        }
        System.out.println("Acceso denegado - intente nuevamente");
        return false;
    }

    public void CambiarContrasenia(){
        int Id,flag=0;
        String contra;

        do{
            System.out.print("Ingrese ID:");
            Id = entrada.nextInt();
            //Valdiacion de formato de datos
            if(Id>0){
                flag = 1;   //Formato del ID correcto
            }
            else {
                System.out.println("Formato del identificador incorrecto, debe escribir solo numeros");
            }
        }while(flag==0);

        if(ValidarContrasenia(getContrasenia())){
            //CAMBIO DE CONTRASEÑA
            System.out.print("Ingrese nueva contraseña: ");
            contra = entrada.next();
            while(!contra.matches("([a-zA-Z]*+[0-9]*+)*")){
                System.out.println("El dato es incorrecto, debe recibir al menos una letra y numero");
                System.out.print("Ingrese nueva contraseña: ");
                contra = entrada.next();
            }
            setContrasenia(contra);
            System.out.println("¡Su contraseña se actualizo con exito!");
        }
        else{
            System.out.println("Error al cambiar la contraseña :(");
        }
    }

    public void MenuAdministrador() {

        //Lectura Texto Admins
        /*
        CSVFile archivoAdmins = new CSVFile();
        archivoAdmins.leerArchivo("src/main/resources/csvadmins.csv");
        CSVManage ob = new CSVManage();
        String[] header = { "Nombre", "Rut" , "id" , "Contraseña"};
        ob.writeCSV("src/main/resources/csvadmins.csv", header);
        */
        Noticias NoticiaNueva = new Noticias();
        PuntoReciclaje ptoNuevo = new PuntoReciclaje();
        Admin newAdmin = new Admin("Fabian", 4, "123");
        administradores.add(newAdmin);

        if (ValidarPersona()) {

            do {
                System.out.println("================MENU ADMINISTRADOR====================");
                System.out.println("ELIJA UNA OPCION:");
                System.out.println("0) Presione 0 para salir");
                System.out.println("1) Mostrar puntos de reciclaje\n2) Agregar administrador\n3) Agregar punto de reciclaje\n4) Agregar noticia");
                System.out.println("5) Eliminar punto de reciclaje\n6) Eliminar noticia\n7) Cambiar contraseña\n8) Actualizar punto de reciclaje");
                System.out.print("OPCION:");
                int opcion = entrada.nextInt();
                try{
                    switch (opcion) {
                        case 0:
                            return;
                        case 1:
                            ptoNuevo.MostrarPtoReciclaje();
                            break;
                        case 2:
                            administradores.add(CrearAdmin());
                            System.out.println("Se agrego exitosamente...");
                            break;
                        case 3:
                            if (ptoNuevo.CrearPuntoReciclaje()) {
                                System.out.println("Se agrego exitosamente...");
                            }
                            break;
                        case 4:
                            if (NoticiaNueva.CrearNoticia()) {
                                System.out.println("Se agrego exitosamente...");
                            }
                            break;
                        case 5:
                            if (ptoNuevo.EliminarPtoReciclaje()) {
                                System.out.println("Se elimino el punto de reciclaje exitosamente...");
                            } else {
                                System.out.println("Punto de reciclaje inexistente, intente nuevamente...");
                            }
                            break;
                        case 6:
                            if (NoticiaNueva.EliminarNoticia()) {
                                System.out.println("Se elimino la noticia exitosamente...");
                            } else {
                                System.out.println("Noticia inexistente, intente nuevamente...");
                            }
                            break;
                        case 7:
                            System.out.println("===============================================");
                            System.out.println("--------Identificador de administrador---------");
                            CambiarContrasenia();
                            break;
                        case 8:
                            ptoNuevo.ActualizarPtoReciclaje();
                            break;
                        default:
                            throw new Exception("No se puede ejecutar esa opcion ");

                    }

                }catch (Exception e)
                {
                    e.printStackTrace();
                    return;
                }

            } while (true);
        }
        System.out.println("--------------");
        System.out.println("Menu Cerrado");
    }
    public  boolean Validarid( int id)
    {
        if(id <0 ) return false ;
        for(int i =0 ; i<administradores.size() ; i ++)
        {
            if(administradores.get(i).getId() == id) return false ;
        }
        return true ;
    }
}