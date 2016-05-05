package accesoADatos;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUsuarioImpl implements DAOUsuario {

    @Override
    public VOUsuario getUsuarioById(Integer id) {
        try {
            Connector conector = new Connector();
            Connection con = conector.getConnection();

            PreparedStatement pstmt = null;

            String sqlSelect = "SELECT * FROM Usuario " + " WHERE id = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setInt(1, id);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                VOUsuario usuario = new VOUsuario(id, res.getString("nombre"), res.getString("dni"),
                        res.getBoolean("sexo"), res.getDate("fecha_nacimiento"), res.getString("direccion"),
                        res.getString("telefono"), res.getString("email"));
                return usuario;
            }

        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public VOUsuario getUsuarioByEmail(String email) {
        try {
            Connector conector = new Connector();
            Connection con = conector.getConnection();

            PreparedStatement pstmt = null;

            String sqlSelect = "SELECT * FROM Usuario " + " WHERE email = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setString(1, email);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                VOUsuario usuario = new VOUsuario(res.getInt("id"), res.getString("nombre"), res.getString("dni"),
                        res.getBoolean("sexo"), res.getDate("fecha_nacimiento"), res.getString("direccion"),
                        res.getString("telefono"), res.getString("email"));
                return usuario;
            }

        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public VOUsuario getUsuarioByDNI(String DNI) {
        try {
            Connector conector = new Connector();
            Connection con = conector.getConnection();

            PreparedStatement pstmt = null;

            String sqlSelect = "SELECT * FROM Usuario " + " WHERE dni = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setString(1, DNI);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                VOUsuario usuario = new VOUsuario(res.getInt("id"), res.getString("nombre"), res.getString("dni"),
                        res.getBoolean("sexo"), res.getDate("fecha_nacimiento"), res.getString("direccion"),
                        res.getString("telefono"), res.getString("email"));
                return usuario;
            }

        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<VOUsuario> getUsuarios() {
        try {
            Connector connector = new Connector();
            Connection con = connector.getConnection();
            PreparedStatement pstmt = null;

            String sqlSelect = "SELECT * FROM Usuario;";

            pstmt = con.prepareStatement(sqlSelect);

            ResultSet res = pstmt.executeQuery();

            ArrayList<VOUsuario> resultado = new ArrayList<>();

            while (res.next()) {
                VOUsuario usuario = new VOUsuario(res.getInt("id"), res.getString("nombre"), res.getString("dni"),
                        res.getBoolean("sexo"), res.getDate("fecha_nacimiento"), res.getString("direccion"),
                        res.getString("telefono"), res.getString("email"));
                resultado.add(usuario);
            }

            return resultado;

        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer anadirUsuario(VOUsuario usuario) {
        Connector connector = new Connector();
        Connection con = connector.getConnection();
        try {

            PreparedStatement pstmt, pstmt2;

            String sqlSelect = "SELECT * FROM Usuario " + " WHERE nombre = ? OR email = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getEmail());

            String sqlInsert = "INSERT INTO Usuario "
                    + "(nombre, dni, sexo, fecha_nacimiento, direccion, telefono, email) "
                    + " VALUES ( ?, ?, ?, ?, ?, ?, ?);";

            pstmt2 = con.prepareStatement(sqlInsert);
            pstmt2.setString(1, usuario.getNombre());
            pstmt2.setString(2, usuario.getDni());
            pstmt2.setBoolean(3, usuario.isSexo());
            pstmt2.setDate(4, new java.sql.Date(usuario.getFecha_nacimiento().getTime()));
            pstmt2.setString(5, usuario.getDireccion());
            pstmt2.setString(6, usuario.getTelefono());
            pstmt2.setString(7, usuario.getEmail());

            con.setAutoCommit(false);
            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                con.rollback();
                return -1;
            } else {
                pstmt2.executeUpdate();
                con.commit();
                return 0;
            }

        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return -1;
        } catch (NullPointerException e) {
            System.out.println("Faltan argumentos");
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return -1;
        }

    }

    @Override
    public Integer borrarUsuario(VOUsuario usuario) {
        Connector connector = new Connector();
        Connection con = connector.getConnection();
        try {

            PreparedStatement pstmt, pstmt2;

            String sqlSelect = "SELECT * FROM Usuario " + " WHERE id = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setInt(1, usuario.getId());

            String sqlUpdate = "DELETE FROM Usuario " + "WHERE id = ?;";

            pstmt2 = con.prepareStatement(sqlUpdate);
            pstmt2.setInt(1, usuario.getId());

            con.setAutoCommit(false);
            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                pstmt2.executeUpdate();
                con.commit();
                return 0;
            } else {
                con.rollback();
                return -1;
            }

        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return -1;
        } catch (NullPointerException e) {
            System.out.println("Faltan argumentos");
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return -1;
        }

    }

    @Override
    public Integer borrarUsuarioById(Integer id) {
        Connector connector = new Connector();
        Connection con = connector.getConnection();
        try {

            PreparedStatement pstmt, pstmt2;

            String sqlSelect = "SELECT * FROM Usuario " + " WHERE id = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setInt(1, id);

            String sqlUpdate = "DELETE FROM Usuario " + "WHERE id = ?;";

            pstmt2 = con.prepareStatement(sqlUpdate);
            pstmt2.setInt(1, id);

            con.setAutoCommit(false);
            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                pstmt2.executeUpdate();
                con.commit();
                return 0;
            } else {
                con.rollback();
                return -1;
            }

        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return -1;
        } catch (NullPointerException e) {
            System.out.println("Faltan argumentos");
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return -1;
        }
    }

    @Override
    public Integer borrarUsuarioByDNI(String DNI) {
        Connector connector = new Connector();
        Connection con = connector.getConnection();
        try {

            PreparedStatement pstmt, pstmt2;

            String sqlSelect = "SELECT * FROM Usuario " + " WHERE dni = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setString(1, DNI);

            String sqlUpdate = "DELETE FROM Usuario " + "WHERE dni = ?;";

            pstmt2 = con.prepareStatement(sqlUpdate);
            pstmt2.setString(1, DNI);

            con.setAutoCommit(false);
            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                pstmt2.executeUpdate();
                con.commit();
                return 0;
            } else {
                con.rollback();
                return -1;
            }

        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return -1;
        } catch (NullPointerException e) {
            System.out.println("Faltan argumentos");
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return -1;
        }

    }

    @Override
    public Integer modificarUsuario(VOUsuario usuario) {
        Connector connector = new Connector();
        Connection con = connector.getConnection();
        try {

            PreparedStatement pstmt, pstmt2;

            String sqlSelect
                    = "SELECT * FROM Usuario "
                    + " WHERE id = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setInt(1, usuario.getId());

            String sqlUpdate
                    = "UPDATE Usuario "
                    + "SET nombre = ?, "
                    + "dni = ?, "
                    + "sexo = ?, "
                    + "fecha_nacimiento = ?, "
                    + "direccion = ? ,"
                    + "telefono = ? ,"
                    + "email = ? "
                    + "WHERE id = ?;";

            pstmt2 = con.prepareStatement(sqlUpdate);
            pstmt2.setString(1, usuario.getNombre());
            pstmt2.setString(2, usuario.getDni());
            pstmt2.setBoolean(3, usuario.isSexo());
            pstmt2.setDate(4, new java.sql.Date(usuario.getFecha_nacimiento().getTime()));
            pstmt2.setString(5, usuario.getDireccion());
            pstmt2.setString(6, usuario.getTelefono());
            pstmt2.setString(7, usuario.getEmail());
            pstmt2.setInt(8, usuario.getId());

            con.setAutoCommit(false);
            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                pstmt2.executeUpdate();
                con.commit();
                return 0;
            } else {
                con.rollback();
                return -1;
            }

        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return -1;
        } catch (NullPointerException e) {
            System.out.println("Faltan argumentos");
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return -1;
        }

    }

}
