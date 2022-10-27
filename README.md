# Proyecto-Ambiental

Integrantes : 
  - Byron Cortés Gajardo
  - Fabián Molina Torrealba
  - Felipe Gallardo Estay
  
Relaciones entre clases :
 
CLASE MAIN:
	- Lectura y carga de datos desde un CSV usando las clases CsvFile y CsvManage.
	- Creación del MENU principal la cual instancia objetos de la clase Admin y la clase Usuario, para dirigirse a los menús de cada uno de los mencionados. 

CLASE CSVFILE & CSVMANAGE:
	- Leen y escriben desde/hacia un CSV -> Las colecciones (ArrayList) de Administradores, Noticias y Puntos de reciclaje que han sido registrados.

CLASE USUARIOS
	- Clase hija de la clase padre -> <PersonaVirtual>.
	- Muestran y consultan -> Puntos de reciclaje que se encuentran guardados en la coleccion de la clase <PuntoReciclaje>, especificamente los 
    encontrados en la ciudad que registra el usuario o los de la ciudad que quiera buscar, haciendo llamados a metodos/comportamientos de la 
    clase <PuntoReciclaje>.
	- Presenta -> Noticias que se encuentran guardados en la colección de la clase <Noticias> usando funciones o métodos de esta.

CLASE ADMIN
	- Contiene una coleccion (ArrayList) de tipo Admin para almacenar todos los objetos tipo Admin que se crean y se quieren registrar
	- Clase hija de la clase padre -> <PersonaVirtual>.
	- Muestra, crea y modifica -> Cualquier punto de reciclaje que se encuentra o sea registrado en la coleccion de la clase <PuntoReciclaje> usando 
    funciones o metodos de esta.
	- Crea y elimina -> Cualquier noticia que se encuentra registrado en la coleccion de la clase <Noticias> haciendo llamados y usando funciones o 
    metodos de esta.
	- Crea -> Administradores nuevos que son almacenados en la colección de la misma clase Admin. Al ser registrados pide la validación de la función
    "Crearpersona" de la clase padre <PersonaVirtual>. Además usando funciones o métodos de la clase Admin.

CLASE NOTICIAS
	- Contiene una colección (ArrayList) de tipo Noticia para almacenar todos los objetos tipo Noticia que se crean y se quieren registrar
	- Maneja métodos para crear y presentar las noticias para cualquier clase que las invoque.

CLASE PUNTORECICLAJE
	- Contiene una coleccion (ArrayList) de tipo PuntoReciclaje para almacenar todos los objetos tipo PuntoReciclaje que se crean y se quieren registrar
	- Maneja sobreescritura de métodos para crear y mostrar los puntos de reciclaje que sean solicitados a través de sus métodos.
 
