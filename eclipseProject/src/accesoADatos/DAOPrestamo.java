package accesoADatos;

import java.util.ArrayList;
import java.util.Date;

public interface DAOPrestamo {

    VOPrestamo getPrestamoById(Integer id);

    ArrayList<VOPrestamo> getPrestamos();

    ArrayList<VOPrestamo> getPrestamosByUsuario(Integer id_usuario);

    ArrayList<VOPrestamo> getPrestamosByFondo(Integer id_fondo);

    ArrayList<VOPrestamo> getPrestamosPendientes();

    ArrayList<VOPrestamo> getPrestamosPendientesDeUsuario(Integer id_usuario);

    ArrayList<VOPrestamo> getPrestamosByFecha(Date desde, Date hasta);

    ArrayList<VOPrestamo> getPrestamosByFechaYUsuario(Date desde, Date hasta, Integer id_usuario);

    Integer anadirPrestamo(VOPrestamo prestamo);

    Integer modificarPrestamo(VOPrestamo prestamo);

    Integer borrarPrestamo(Integer id_prestamo);

}
