package accesoADatos;

import java.util.ArrayList;
import java.util.Date;

public class InterfazAccesoADatosImpl implements InterfazAccesoADatos {

    private static DAOUsuario dao_usuario;
    private static DAOPrestamo dao_prestamo;
    private static DAOFondo dao_fondo;

    public InterfazAccesoADatosImpl() {
        FactoriaDAO fd = FactoriaDAO.newFactoria();
        dao_usuario = fd.crearDAOUsuario();
        dao_prestamo = fd.crearDAOPrestamo();
        dao_fondo = fd.crearDAOFondo();
    }

    @Override
    public VOUsuario getUsuarioById(Integer id) {
        return dao_usuario.getUsuarioById(id);
    }

    @Override
    public VOUsuario getUsuarioByEmail(String email) {
        return dao_usuario.getUsuarioByEmail(email);
    }

    @Override
    public VOUsuario getUsuarioByDNI(String DNI) {
        return dao_usuario.getUsuarioByDNI(DNI);
    }

    @Override
    public ArrayList<VOUsuario> getUsuarios() {
        return dao_usuario.getUsuarios();
    }

    @Override
    public Integer anadirUsuario(VOUsuario usuario) {
        return dao_usuario.anadirUsuario(usuario);
    }

    @Override
    public Integer borrarUsuario(VOUsuario usuario) {
        return dao_usuario.borrarUsuario(usuario);
    }

    @Override
    public Integer borrarUsuarioById(Integer id) {
        return dao_usuario.borrarUsuarioById(id);
    }

    @Override
    public Integer borrarUsuarioByDNI(String DNI) {
        return dao_usuario.borrarUsuarioByDNI(DNI);
    }

    @Override
    public Integer modificarUsuario(VOUsuario usuario) {
        return dao_usuario.modificarUsuario(usuario);
    }

    @Override
    public VOFondo getFondoById(Integer id) {
        return dao_fondo.getFondoById(id);
    }

    @Override
    public VOFondo getFondoByTitulo(String titulo) {
        return dao_fondo.getFondoByTitulo(titulo);
    }

    @Override
    public ArrayList<VOFondo> getFondosByFechas(Date desde, Date hasta) {
        return dao_fondo.getFondosByFechas(desde, hasta);
    }

    @Override
    public VOFondo getFondoByISBN(String ISBN) {
        return dao_fondo.getFondoByISBN(ISBN);
    }

    @Override
    public ArrayList<VOFondo> getFondos() {
        return dao_fondo.getFondos();
    }

    @Override
    public ArrayList<VOFondo> getFondosByAutor(String autor) {
        return dao_fondo.getFondosByAutor(autor);
    }

    @Override
    public ArrayList<VOFondo> getFondosByAnoEdicion(Date desde, Date hasta) {
        return dao_fondo.getFondosByAnoEdicion(desde, hasta);
    }

    @Override
    public ArrayList<VOFondo> getFondosByEditorial(String editorial) {
        return dao_fondo.getFondosByEditorial(editorial);
    }

    @Override
    public ArrayList<VOFondo> getFondosByAutorYTitulo(String autor, String titulo) {
        return dao_fondo.getFondosByAutorYTitulo(autor, titulo);
    }

    @Override
    public ArrayList<VOLibro> getLibros() {
        return dao_fondo.getLibros();
    }

    @Override
    public Integer anadirFondo(VOFondo fondo) {
        return dao_fondo.anadirFondo(fondo);
    }

    @Override
    public Integer anadirLibro(VOLibro libro) {
        return dao_fondo.anadirLibro(libro);
    }

    @Override
    public Integer modificarFondo(VOFondo fondo) {
        return dao_fondo.modificarFondo(fondo);
    }

    @Override
    public Integer modificarLibro(VOLibro libro) {
        return dao_fondo.modificarLibro(libro);
    }

    @Override
    public Integer borrarFondo(VOFondo fondo) {
        return dao_fondo.borrarFondo(fondo);
    }

    @Override
    public Integer borrarFondo(Integer id) {
        return dao_fondo.borrarFondo(id);
    }

    @Override
    public Integer borrarFondo(String titulo) {
        return dao_fondo.borrarFondo(titulo);
    }

    @Override
    public Integer borrarLibro(String ISBN) {
        return dao_fondo.borrarLibro(ISBN);
    }

    @Override
    public VOPrestamo getPrestamoById(Integer id) {
        return dao_prestamo.getPrestamoById(id);
    }

    @Override
    public ArrayList<VOPrestamo> getPrestamos() {
        return dao_prestamo.getPrestamos();
    }

    @Override
    public ArrayList<VOPrestamo> getPrestamosByUsuario(Integer id_usuario) {
        return dao_prestamo.getPrestamosByUsuario(id_usuario);
    }

    @Override
    public ArrayList<VOPrestamo> getPrestamosByFondo(Integer id_fondo) {
        return dao_prestamo.getPrestamosByFondo(id_fondo);
    }

    @Override
    public ArrayList<VOPrestamo> getPrestamosPendientes() {
        return dao_prestamo.getPrestamosPendientes();
    }

    @Override
    public ArrayList<VOPrestamo> getPrestamosPendientesDeUsuario(Integer id_usuario) {
        return dao_prestamo.getPrestamosPendientesDeUsuario(id_usuario);
    }

    @Override
    public ArrayList<VOPrestamo> getPrestamosByFecha(Date desde, Date hasta) {
        return dao_prestamo.getPrestamosByFecha(desde, hasta);
    }

    @Override
    public ArrayList<VOPrestamo> getPrestamosByFechaYUsuario(Date desde, Date hasta, Integer id_usuario) {
        return dao_prestamo.getPrestamosByFechaYUsuario(desde, hasta, id_usuario);
    }

    @Override
    public Integer anadirPrestamo(VOPrestamo prestamo) {
        return dao_prestamo.anadirPrestamo(prestamo);
    }

    @Override
    public Integer modificarPrestamo(VOPrestamo prestamo) {
        return dao_prestamo.modificarPrestamo(prestamo);
    }

    @Override
    public Integer borrarPrestamo(Integer id_prestamo) {
        return dao_prestamo.borrarPrestamo(id_prestamo);
    }

}
