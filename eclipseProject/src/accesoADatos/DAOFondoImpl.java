package accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class DAOFondoImpl implements DAOFondo {

    @Override
    public VOFondo getFondoById(Integer id) {
        try {
            Connector conector = new Connector();
            Connection con = conector.getConnection();

            PreparedStatement pstmt = null;

            String sqlSelect = "SELECT * FROM Fondo " + " WHERE id = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setInt(1, id);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                VOFondo fondo = new VOFondo(res.getInt("id"), res.getString("titulo"), res.getDate("fecha_compra"));
                return fondo;
            }

        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public VOFondo getFondoByTitulo(String titulo) {
        try {
            Connector conector = new Connector();
            Connection con = conector.getConnection();

            PreparedStatement pstmt = null;

            String sqlSelect = "SELECT * FROM Fondo " + " WHERE titulo = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setString(1, titulo);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                VOFondo fondo = new VOFondo(res.getInt("id"), res.getString("titulo"), res.getDate("fecha_compra"));
                return fondo;
            }

        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<VOFondo> getFondosByFechas(Date desde, Date hasta) {
        try {
            Connector conector = new Connector();
            Connection con = conector.getConnection();

            PreparedStatement pstmt = null;

            String sqlSelect = "SELECT * FROM Fondo " + " WHERE fecha_compra between ? AND ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setDate(1, new java.sql.Date(desde.getTime()));
            pstmt.setDate(2, new java.sql.Date(hasta.getTime()));

            ResultSet res = pstmt.executeQuery();

            ArrayList<VOFondo> fondos = new ArrayList<>();
            VOFondo fondo;
            while (res.next()) {
                fondo = new VOFondo(res.getInt("id"), res.getString("titulo"), res.getDate("fecha_compra"));
                fondos.add(fondo);
            }
            return fondos;

        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public VOFondo getFondoByISBN(String ISBN) {
        try {

            Connector conector = new Connector();
            Connection con = conector.getConnection();

            PreparedStatement pstmt = null, pstmt2;

            String sqlSelect = "SELECT * FROM Libro " + " WHERE isbn = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setString(1, ISBN);

            String sqlSelectAutores = "SELECT * FROM Autores WHERE id = ?;";
            pstmt2 = con.prepareStatement(sqlSelectAutores);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {

                pstmt2.setInt(1, res.getInt("id"));
                ResultSet res2 = pstmt2.executeQuery();
                ArrayList<String> autores = new ArrayList<>();
                while (res2.next()) {
                    autores.add(res2.getString("autor"));
                }
                VOLibro libro = new VOLibro(res.getInt("id"), "null", null,
                        res.getString("isbn"), autores, res.getDate("ano_edicion"), res.getString("editorial"));
                con.close();
             
                VOFondo fondo = this.getFondoById(libro.getId());
                libro.setTitulo(fondo.getTitulo());
                libro.setFecha_compra(fondo.getFecha_compra());
                
                return fondo;

            }

        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<VOFondo> getFondos() {
        try {
            Connector conector = new Connector();
            Connection con = conector.getConnection();

            PreparedStatement pstmt = null;

            String sqlSelect = "SELECT * FROM Fondo;";

            pstmt = con.prepareStatement(sqlSelect);

            ResultSet res = pstmt.executeQuery();

            ArrayList<VOFondo> fondos = new ArrayList<>();
            VOFondo fondo;
            while (res.next()) {
                fondo = new VOFondo(res.getInt("id"), res.getString("titulo"), res.getDate("fecha_compra"));
                fondos.add(fondo);
            }
            return fondos;

        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<VOFondo> getFondosByAutor(String autor) {
        try {
            Connector conector = new Connector();
            Connection con = conector.getConnection();

            PreparedStatement pstmt = null;

            String sqlSelect = "select * from (select f.*, l.ano_edicion, l.editorial, l.isbn, a.autor from "
                    + "Fondo f inner join Libro l on f.id = l.id " + "inner join Autores a on a.id = l.id) "
                    + "as aux where aux.autor=?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setString(1, autor);

            ResultSet res = pstmt.executeQuery();

            ArrayList<VOFondo> fondos = new ArrayList<>();
            VOFondo fondo;
            ArrayList<String> autores = new ArrayList<>();
            autores.add(autor);
            while (res.next()) {
                fondo = new VOLibro(res.getInt("id"), res.getString("titulo"), res.getDate("fecha_compra"),
                        res.getString("isbn"), autores, res.getDate("ano_edicion"), res.getString("editorial"));
                fondos.add(fondo);
            }
            return fondos;

        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<VOFondo> getFondosByAnoEdicion(Date desde, Date hasta) {
        Connector conector = new Connector();
        Connection con = conector.getConnection();
        try {

            PreparedStatement pstmt = null, pstmt2 = null;

            String sqlSelect = "SELECT * FROM (select f.*, l.ano_edicion, l.editorial, l.isbn from "
                    + "Fondo f INNER JOIN Libro l ON f.id = l.id)" + "AS aux WHERE aux.ano_edicion between ? and ?;";

            String sqlSelect2 = "SELECT * FROM autores WHERE id = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setDate(1, new java.sql.Date(desde.getTime()));
            pstmt.setDate(2, new java.sql.Date(hasta.getTime()));

            pstmt2 = con.prepareStatement(sqlSelect2);

            con.setAutoCommit(false);
            ResultSet res = pstmt.executeQuery();

            ArrayList<VOFondo> fondos = new ArrayList<>();
            VOFondo fondo;
            ArrayList<String> autores;

            while (res.next()) {
                autores = new ArrayList<>();

                // Recoger los autores
                pstmt2.setInt(1, res.getInt("id"));
                ResultSet res2 = pstmt2.executeQuery();
                con.commit();
                while (res2.next()) {
                    autores.add(res2.getString("autor"));
                }

                fondo = new VOLibro(res.getInt("id"), res.getString("titulo"), res.getDate("fecha_compra"),
                        res.getString("isbn"), autores, res.getDate("ano_edicion"), res.getString("editorial"));

                fondos.add(fondo);
            }

            return fondos;

        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public ArrayList<VOFondo> getFondosByEditorial(String editorial) {
        Connector conector = new Connector();
        Connection con = conector.getConnection();
        try {

            PreparedStatement pstmt = null, pstmt2 = null;

            String sqlSelect = "SELECT * FROM (select f.*, l.ano_edicion, l.editorial, l.isbn from "
                    + "Fondo f INNER JOIN Libro l ON f.id = l.id)" + "AS aux WHERE aux.editorial = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setString(1, editorial);

            String sqlSelect2 = "SELECT * FROM autores WHERE id = ?;";

            pstmt2 = con.prepareStatement(sqlSelect2);

            con.setAutoCommit(false);
            ResultSet res = pstmt.executeQuery();

            ArrayList<VOFondo> fondos = new ArrayList<>();
            VOFondo fondo;
            ArrayList<String> autores;

            while (res.next()) {
                autores = new ArrayList<>();

                // Recoger los autores
                pstmt2.setInt(1, res.getInt("id"));
                ResultSet res2 = pstmt2.executeQuery();
                con.commit();
                while (res2.next()) {
                    autores.add(res2.getString("autor"));
                }

                fondo = new VOLibro(res.getInt("id"), res.getString("titulo"), res.getDate("fecha_compra"),
                        res.getString("isbn"), autores, res.getDate("ano_edicion"), res.getString("editorial"));

                fondos.add(fondo);
            }
            return fondos;

        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public ArrayList<VOFondo> getFondosByAutorYTitulo(String autor, String titulo) {
        try {
            Connector conector = new Connector();
            Connection con = conector.getConnection();

            PreparedStatement pstmt = null;

            String sqlSelect = "select * from (select f.*, l.ano_edicion, l.editorial, l.isbn, a.autor from "
                    + "Fondo f inner join Libro l on f.id = l.id " + "inner join Autores a on a.id = l.id) "
                    + "as aux where aux.autor=? and aux.titulo = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setString(1, autor);
            pstmt.setString(2, titulo);

            ResultSet res = pstmt.executeQuery();

            ArrayList<VOFondo> fondos = new ArrayList<>();
            VOFondo fondo;
            ArrayList<String> autores = new ArrayList<>();
            autores.add(autor);
            while (res.next()) {
                fondo = new VOLibro(res.getInt("id"), res.getString("titulo"), res.getDate("fecha_compra"),
                        res.getString("isbn"), autores, res.getDate("ano_edicion"), res.getString("editorial"));
                fondos.add(fondo);
            }
            return fondos;

        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<VOLibro> getLibros() {
        Connector conector = new Connector();
        Connection con = conector.getConnection();
        try {

            PreparedStatement pstmt = null, pstmt2 = null;

            String sqlSelect = "SELECT * FROM (select f.*, l.ano_edicion, l.editorial, l.isbn from "
                    + "Fondo f INNER JOIN Libro l ON f.id = l.id);";

            pstmt = con.prepareStatement(sqlSelect);

            String sqlSelect2 = "SELECT * FROM autores WHERE id = ?;";

            pstmt2 = con.prepareStatement(sqlSelect2);

            con.setAutoCommit(false);
            ResultSet res = pstmt.executeQuery();

            ArrayList<VOLibro> fondos = new ArrayList<>();
            VOLibro fondo;
            ArrayList<String> autores;

            while (res.next()) {
                autores = new ArrayList<>();

                // Recoger los autores
                pstmt2.setInt(1, res.getInt("id"));
                ResultSet res2 = pstmt2.executeQuery();
                con.commit();
                while (res2.next()) {
                    autores.add(res2.getString("autor"));
                }

                fondo = new VOLibro(res.getInt("id"), res.getString("titulo"), res.getDate("fecha_compra"),
                        res.getString("isbn"), autores, res.getDate("ano_edicion"), res.getString("editorial"));

                fondos.add(fondo);
            }
            return fondos;

        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Integer anadirFondo(VOFondo fondo) {
        Connector connector = new Connector();
        Connection con = connector.getConnection();
        try {

            PreparedStatement pstmt;

            String sqlInsert = "INSERT INTO Fondo "
                    + "(titulo, fecha_compra) "
                    + " VALUES ( ?, ?);";

            pstmt = con.prepareStatement(sqlInsert);
            pstmt.setString(1, fondo.getTitulo());
            pstmt.setDate(2, new java.sql.Date(fondo.getFecha_compra().getTime()));

            con.setAutoCommit(false);
            pstmt.executeUpdate();
            con.commit();
            return 0;
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
    public Integer anadirLibro(VOLibro libro) {
        Connector connector = new Connector();
        Connection con = connector.getConnection();
        try {

            PreparedStatement pstmt, pstmt2, pstmt3;

            String sqlInsert = "INSERT INTO Fondo "
                    + "(titulo, fecha_compra) "
                    + " VALUES ( ?, ?);";

            String sqlIntertLibro = "INSERT INTO Libro "
                    + "(id, isbn, ano_edicion, editorial) "
                    + "VALUES ( ?, ?, ?, ?);";

            String sqlInsertAutor = "INSERT INTO Autores "
                    + "(isbn, id, autor) "
                    + "VALUES (?, ?, ?);";

            pstmt = con.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, libro.getTitulo());
            pstmt.setDate(2, new java.sql.Date(libro.getFecha_compra().getTime()));

            pstmt2 = con.prepareStatement(sqlIntertLibro);
            pstmt3 = con.prepareStatement(sqlInsertAutor);

            con.setAutoCommit(false);
            pstmt.executeUpdate();
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                pstmt2.setInt(1, generatedKeys.getInt(1));
                pstmt2.setString(2, libro.getISBN());
                pstmt2.setDate(3, new java.sql.Date(libro.getAno_edicion().getTime()));
                pstmt2.setString(4, libro.getEditorial());

                pstmt2.executeUpdate();

                pstmt3.setString(1, libro.getISBN());
                pstmt3.setInt(2, generatedKeys.getInt(1));
                for (String autor : libro.getAutores()) {
                    pstmt3.setString(3, autor);
                    pstmt3.executeUpdate();
                }
            } else {
                con.rollback();
                return -1;
            }

            con.commit();
            return 0;
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
    public Integer modificarFondo(VOFondo fondo) {
        Connector connector = new Connector();
        Connection con = connector.getConnection();
        try {

            PreparedStatement pstmt, pstmt2;

            String sqlSelect
                    = "SELECT * FROM Fondo "
                    + " WHERE id = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setInt(1, fondo.getId());

            String sqlUpdate
                    = "UPDATE Fondo "
                    + "SET titulo = ?, "
                    + "fecha_compra = ? "
                    + "WHERE id = ?;";

            pstmt2 = con.prepareStatement(sqlUpdate);
            pstmt2.setString(1, fondo.getTitulo());
            pstmt2.setDate(2, new java.sql.Date(fondo.getFecha_compra().getTime()));
            pstmt2.setInt(3, fondo.getId());

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
    public Integer modificarLibro(VOLibro libro) {
        Connector connector = new Connector();
        Connection con = connector.getConnection();
        try {

            PreparedStatement pstmt, pstmt2, pstmt3, pstmt4, pstmt5;

            String sqlSelect
                    = "SELECT * FROM Fondo "
                    + " WHERE id = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setInt(1, libro.getId());

            String sqlUpdate
                    = "UPDATE Fondo "
                    + "SET titulo = ?, "
                    + "fecha_compra = ? "
                    + "WHERE id = ?;";

            pstmt2 = con.prepareStatement(sqlUpdate);
            pstmt2.setString(1, libro.getTitulo());
            pstmt2.setDate(2, new java.sql.Date(libro.getFecha_compra().getTime()));
            pstmt2.setInt(3, libro.getId());

            String sqlUpdateLibro
                    = "UDPATE Libro "
                    + "SET isbn = ?, "
                    + "ano_edicion = ?, "
                    + "editorial = ? "
                    + "WHERE id = ?;";

            pstmt3 = con.prepareStatement(sqlUpdateLibro);
            pstmt3.setString(1, libro.getISBN());
            pstmt3.setDate(2, new java.sql.Date(libro.getAno_edicion().getTime()));
            pstmt3.setString(3, libro.getEditorial());
            pstmt3.setInt(4, libro.getId());

            String sqlDeteleAutores = "DELETE FROM Autores WHERE id = ?;";
            pstmt4 = con.prepareStatement(sqlDeteleAutores);
            pstmt4.setInt(1, libro.getId());

            String sqlInsertAutor = "INSERT INTO Autores "
                    + "(isbn, id, autor) "
                    + "VALUES (?, ?, ?);";

            pstmt5 = con.prepareStatement(sqlInsertAutor);
            pstmt5.setString(1, libro.getISBN());
            pstmt5.setInt(2, libro.getId());

            con.setAutoCommit(false);
            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                pstmt2.executeUpdate();
                pstmt3.executeUpdate();
                pstmt4.executeUpdate();

                for (String autor : libro.getAutores()) {
                    pstmt5.setString(3, autor);
                    pstmt5.executeUpdate();
                }
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
    public Integer borrarFondo(VOFondo fondo) {
        Connector connector = new Connector();
        Connection con = connector.getConnection();
        try {

            PreparedStatement pstmt, pstmt2;

            String sqlSelect = "SELECT * FROM Fondo  WHERE id = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setInt(1, fondo.getId());

            String sqlUpdate = "DELETE FROM Fondo WHERE id = ?;";

            pstmt2 = con.prepareStatement(sqlUpdate);
            pstmt2.setInt(1, fondo.getId());

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
    public Integer borrarFondo(Integer id) {
        Connector connector = new Connector();
        Connection con = connector.getConnection();
        try {

            PreparedStatement pstmt, pstmt2;

            String sqlSelect = "SELECT * FROM Fondo  WHERE id = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setInt(1, id);

            String sqlUpdate = "DELETE FROM Fondo WHERE id = ?;";

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
    public Integer borrarFondo(String titulo) {
        Connector connector = new Connector();
        Connection con = connector.getConnection();
        try {

            PreparedStatement pstmt, pstmt2;

            String sqlSelect = "SELECT * FROM Fondo  WHERE titulo = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setString(1, titulo);

            String sqlUpdate = "DELETE FROM Fondo WHERE titulo = ?;";

            pstmt2 = con.prepareStatement(sqlUpdate);
            pstmt2.setString(1, titulo);

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
    public Integer borrarLibro(String ISBN) {
        Connector connector = new Connector();
        Connection con = connector.getConnection();
        try {

            PreparedStatement pstmt, pstmt2;

            String sqlSelect = "SELECT id FROM Libro  WHERE isbn = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setString(1, ISBN);

            String sqlUpdate = "DELETE FROM Fondo WHERE id = ?;";

            pstmt2 = con.prepareStatement(sqlUpdate);

            con.setAutoCommit(false);
            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                pstmt2.setInt(1, res.getInt("id"));
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
