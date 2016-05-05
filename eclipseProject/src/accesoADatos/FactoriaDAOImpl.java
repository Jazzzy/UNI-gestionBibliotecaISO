package accesoADatos;

public class FactoriaDAOImpl extends FactoriaDAO {

    @Override
    public DAOUsuario crearDAOUsuario() {
        return new DAOUsuarioImpl();
    }

    @Override
    public DAOFondo crearDAOFondo() {
        return new DAOFondoImpl();
    }

    @Override
    public DAOPrestamo crearDAOPrestamo() {
        return new DAOPrestamoImpl();
    }

}
