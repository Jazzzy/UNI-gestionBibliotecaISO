package testiso;

import accesoADatos.InterfazAccesoADatosImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        InterfazAccesoADatosImpl interfaz = new InterfazAccesoADatosImpl();

        System.out.println(" === PRUEBAS DE ACCESO A USUARIOS === ");

        System.out.println("1. Añadir 5 usuarios");

        try {

            VOUsuario bruno = new VOUsuario(0, "Bruno", "11112222A", false, sdf.parse("06-11-1995"), "Calle falsa 123", "+34987654321", "bruno@putimail.com");

            interfaz.anadirUsuario(bruno);
            interfaz.anadirUsuario(new VOUsuario(0, "Jaime", "22223333B", true, sdf.parse("07-07-1995"), "Calle falsa 124", "+34123456789", "jaime@putimail.com"));
            interfaz.anadirUsuario(new VOUsuario(0, "Ruben", "33334444C", true, sdf.parse("08-08-1995"), "Calle falsa 125", "+34456123789", "ruben@putimail.com"));
            interfaz.anadirUsuario(new VOUsuario(0, "Pablo", "44445555D", true, sdf.parse("09-09-1995"), "Calle falsa 126", "+34123789456", "pablo@putimail.com"));
            interfaz.anadirUsuario(new VOUsuario(0, "Manel", "55556666E", true, sdf.parse("10-10-1995"), "Calle falsa 127", "+34789123456", "manel@putimail.com"));

            System.out.println("2. Recuperar usuarios por filtro");

            printVOUserData(interfaz.getUsuarioByDNI("11112222A"));
            printVOUserData(interfaz.getUsuarioByEmail("jaime@putimail.com"));
            printVOUserData(interfaz.getUsuarioById(1));

            System.out.println("3. Recuperar todos los usuarios");
            printUsers(interfaz.getUsuarios());

            System.out.println("4. Borrar usuarios por filtros");
            interfaz.borrarUsuarioByDNI("22223333B");
            interfaz.borrarUsuarioById(2);
            interfaz.borrarUsuario(bruno);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("5. Recuperar todos los usuarios");
        printUsers(interfaz.getUsuarios());

        System.out.println(" === PRUEBAS DE ACCESO A FONDOS === ");

        try {

            System.out.println("1. Añadir 5 usuarios");

            ArrayList<String> autores = new ArrayList<>();
            autores.add("Pepe");
            VOLibro vol;
            vol = new VOLibro(0, "Libro1", sdf.parse("07-07-1995"), "987-7-78-789989-9", autores, sdf.parse("01-01-1990"), "Anaya");
            interfaz.anadirLibro(vol);

            autores = new ArrayList<>();
            autores.add("Juan");
            vol = new VOLibro(0, "Libro2", sdf.parse("07-07-1995"), "987-7-78-789981-9", autores, sdf.parse("01-01-1990"), "Anaya");
            interfaz.anadirLibro(vol);

            autores = new ArrayList<>();
            autores.add("Juan");
            autores.add("Pepe");
            vol = new VOLibro(0, "Libro3", sdf.parse("07-07-1995"), "987-7-78-789981-9", autores, sdf.parse("01-01-1991"), "Anaya");
            interfaz.anadirLibro(vol);

            autores = new ArrayList<>();
            autores.add("Juan");
            autores.add("Pepe");
            vol = new VOLibro(0, "Libro4", sdf.parse("07-09-1995"), "987-1-78-789981-9", autores, sdf.parse("01-01-1992"), "Anaya");
            interfaz.anadirLibro(vol);

            System.out.println("2. Recuperar por filtro");

            printVOBook(interfaz.getFondoByISBN("987-1-78-789981-9"));
            printVOBook(interfaz.getFondoById(1));
            printVOBook(interfaz.getFondoByTitulo("Libro3"));
            printFondos(interfaz.getFondosByAutor("Juan"));
            printFondos(interfaz.getFondosByAnoEdicion(sdf.parse("01-01-1991"), sdf.parse("02-01-1992")));
            printFondos(interfaz.getFondosByAutorYTitulo("Juan", "Pepe"));
            printFondos(interfaz.getFondosByFechas(sdf.parse("06-07-1995"), sdf.parse("08-07-1995")));

            System.out.println("3. Recuperar todos");

            printFondos(interfaz.getFondos());

            System.out.println("4. Borrar Fondos");

            interfaz.borrarFondo(5);
            interfaz.borrarFondo(vol);
            interfaz.borrarFondo("Libro3");

            System.out.println("5. Recuperar todos");

            printFondos(interfaz.getFondos());

        } catch (ParseException ex) {
            Logger.getLogger(TestISO.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(" === PRUEBAS DE PRESTAMOS === ");

        try {
            System.out.println("1. Registrar 4 prestamos");
            System.out.println("BRUNO: " + interfaz.getUsuarioByEmail("bruno@putimail.com").getId());
            interfaz.anadirPrestamo(new VOPrestamo(0, sdf.parse("02-02-2016"), null, interfaz.getUsuarioByEmail("bruno@putimail.com"), interfaz.getFondoByISBN("987-1-78-789981-9")));
            interfaz.anadirPrestamo(new VOPrestamo(0, sdf.parse("03-02-2016"), null, interfaz.getUsuarioByEmail("ruben@putimail.com"), interfaz.getFondoByISBN("987-1-78-789981-9")));
            interfaz.anadirPrestamo(new VOPrestamo(0, sdf.parse("04-02-2016"), null, interfaz.getUsuarioByEmail("pablo@putimail.com"), interfaz.getFondoByISBN("987-1-78-789981-9")));
            interfaz.anadirPrestamo(new VOPrestamo(0, sdf.parse("01-02-2016"), null, interfaz.getUsuarioByEmail("bruno@putimail.com"), interfaz.getFondoByISBN("987-1-78-789981-9")));

            System.out.println("2. Recuperar prestamos");
            printPrestamos(interfaz.getPrestamos());

            System.out.println("3. Recuperar por filtros");
            printPrestamos(interfaz.getPrestamosByFondo(interfaz.getFondoByISBN("987-1-78-789981-9").getId()));
            printPrestamos(interfaz.getPrestamosByUsuario(interfaz.getUsuarioByEmail("bruno@putimail.com").getId()));

            System.out.println("4. Borrar Prestamos");
            ArrayList<VOPrestamo> prestamos = interfaz.getPrestamosPendientes();
            if (prestamos.size() > 0) {
                interfaz.borrarPrestamo(prestamos.get(0).getId());
            }

            System.out.println("5. Recuperar todos");
            printPrestamos(interfaz.getPrestamos());

        } catch (ParseException ex) {
            Logger.getLogger(TestISO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void printUsers(ArrayList<VOUsuario> listOfUsers) {
        for (VOUsuario vou : listOfUsers) {
            printVOUserData(vou);
        }
    }

    public static void printVOUserData(VOUsuario vou) {

        System.out.println("ID: " + vou.getId());
        System.out.println("\t\tNombre: " + vou.getNombre());
        System.out.println("\t\tDNI: " + vou.getDni());
        System.out.println("\t\tSexo (true: male, false: female): " + vou.isSexo());
        System.out.println("\t\tBirth Date: " + vou.getFecha_nacimiento());
        System.out.println("\t\tAdress: " + vou.getDireccion());
        System.out.println("\t\tPhone: " + vou.getTelefono());
        System.out.println("\t\te-mail: " + vou.getEmail());
    }

    public static void printFondos(ArrayList<VOFondo> books) {
        for (VOFondo vou : books) {

            printVOBook(vou);

        }
    }

    public static void printVOBook(VOFondo vou) {

        if (vou instanceof VOLibro) {
            VOLibro aux = (VOLibro) vou;
            System.out.println("ID: " + aux.getId());
            System.out.println("\t\tISBN: " + aux.getISBN());
            System.out.println("\t\tTITULO: " + aux.getTitulo());
            System.out.println("\t\tEditorial: " + aux.getEditorial());
            System.out.println("\t\tAno edicion: " + aux.getAno_edicion());
            System.out.println("\t\tAutores: " + aux.getAutores().toString());
            System.out.println("\t\tFecha compra: " + aux.getFecha_compra());
        } else {
            System.out.println("ID: " + vou.getId());
            System.out.println("\t\tTITULO: " + vou.getTitulo());
            System.out.println("\t\tFecha compra: " + vou.getFecha_compra());

        }
    }

    public static void printVOPrestamo(VOPrestamo vop) {
        System.out.println("ID: " + vop.getId());
        System.out.println("\t\tFecha Inicio: " + vop.getFecha_inicio());
        System.out.println("\t\tFecha Fin: " + vop.getFecha_fin());

        System.out.println("Usuario: ");
        printVOUserData(vop.getUsuario());
        System.out.println("Fondo: ");
        printVOBook(vop.getFondo());

    }

    public static void printPrestamos(ArrayList<VOPrestamo> alvop) {
        for (VOPrestamo vop : alvop) {
            printVOPrestamo(vop);
        }
    }

}
