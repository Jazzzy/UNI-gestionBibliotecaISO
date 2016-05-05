package accesoADatos;

import java.util.ArrayList;
import java.util.Date;

public interface DAOFondo {

    VOFondo getFondoById(Integer id);

    VOFondo getFondoByTitulo(String titulo);

    ArrayList<VOFondo> getFondosByFechas(Date desde, Date hasta);

    VOFondo getFondoByISBN(String ISBN);

    ArrayList<VOFondo> getFondos();

    ArrayList<VOFondo> getFondosByAutor(String autor);

    ArrayList<VOFondo> getFondosByAnoEdicion(Date desde, Date hasta);

    ArrayList<VOFondo> getFondosByEditorial(String editorial);

    ArrayList<VOFondo> getFondosByAutorYTitulo(String autor, String titulo);

    ArrayList<VOLibro> getLibros();

    Integer anadirFondo(VOFondo fondo);

    Integer anadirLibro(VOLibro libro);

    Integer modificarFondo(VOFondo fondo);

    Integer modificarLibro(VOLibro libro);

    Integer borrarFondo(VOFondo fondo);

    Integer borrarFondo(Integer id);

    Integer borrarFondo(String titulo);

    Integer borrarLibro(String ISBN);

}
