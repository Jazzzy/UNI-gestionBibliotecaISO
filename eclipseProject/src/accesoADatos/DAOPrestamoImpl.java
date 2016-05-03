package accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

public class DAOPrestamoImpl implements DAOPrestamo{

	@Override
	public VOPrestamo getPrestamoById(Integer id) {
		try {
			Connector conector = new Connector();
			Connection con = conector.getConnection();

			PreparedStatement pstmt = null, pstmt2, pstmt3;

			String sqlSelect = "SELECT * FROM Prestamo " + " WHERE id = ?;";

			pstmt = con.prepareStatement(sqlSelect);
			pstmt.setInt(1, id);
			
			String sqlSelectUsuario = "SELECT * FROM Usuario WHERE id = ?;";

			pstmt2 = con.prepareStatement(sqlSelectUsuario);
			
			
			String sqlSelectFondo = "SELECT * FROM Fondo " + " WHERE id = ?;";

			pstmt3 = con.prepareStatement(sqlSelectFondo);
			

			
			
			
			ResultSet res = pstmt.executeQuery();

			if (res.next()) {
				
				
				pstmt2.setInt(1, res.getInt("id_usuario"));
				pstmt3.setInt(1, res.getInt("id_fondo"));
				
				
				ResultSet res2 = pstmt2.executeQuery();

				VOUsuario usuario;
				VOFondo fondo;
				if (res2.next()) {
					usuario = new VOUsuario(id, res.getString("nombre"), res.getString("dni"),
							res.getBoolean("sexo"), res.getDate("fecha_nacimiento"), res.getString("direccion"),
							res.getString("telefono"), res.getString("email"));

				}else{
					return null;
				}
				
				ResultSet res3 = pstmt3.executeQuery();

				if (res3.next()) {
					fondo = new VOFondo(res.getInt("id"), res.getString("titulo"), res.getDate("fecha_compra"));
				}else{
					return null;
				}
				
				VOPrestamo prestamo = new VOPrestamo(res.getInt("id"), res.getDate("fecha_inicio"), res.getDate("fecha_fin"), usuario, fondo);
				return prestamo;
			}

		} catch (

		SQLException e) {
			System.out.println("Error en la consulta");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<VOPrestamo> getPrestamos() {
		try {
			Connector conector = new Connector();
			Connection con = conector.getConnection();

			PreparedStatement pstmt = null, pstmt2, pstmt3;

			String sqlSelect = "SELECT * FROM Prestamo;";

			pstmt = con.prepareStatement(sqlSelect);
			
			String sqlSelectUsuario = "SELECT * FROM Usuario WHERE id = ?;";

			pstmt2 = con.prepareStatement(sqlSelectUsuario);
			
			
			String sqlSelectFondo = "SELECT * FROM Fondo " + " WHERE id = ?;";

			pstmt3 = con.prepareStatement(sqlSelectFondo);
			

			ArrayList<VOPrestamo> prestamos = new ArrayList<>();
			
			
			ResultSet res = pstmt.executeQuery();
			VOPrestamo prestamo;
			VOUsuario usuario;
			VOFondo fondo;

			while (res.next()) {
				
				
				pstmt2.setInt(1, res.getInt("id_usuario"));
				pstmt3.setInt(1, res.getInt("id_fondo"));
				
				
				ResultSet res2 = pstmt2.executeQuery();

				
				if (res2.next()) {
					usuario = new VOUsuario(res.getInt("id"), res.getString("nombre"), res.getString("dni"),
							res.getBoolean("sexo"), res.getDate("fecha_nacimiento"), res.getString("direccion"),
							res.getString("telefono"), res.getString("email"));

				}else{
					return null;
				}
				
				ResultSet res3 = pstmt3.executeQuery();

				if (res3.next()) {
					fondo = new VOFondo(res.getInt("id"), res.getString("titulo"), res.getDate("fecha_compra"));
				}else{
					return null;
				}
				
				prestamo = new VOPrestamo(res.getInt("id"), res.getDate("fecha_inicio"), res.getDate("fecha_fin"), usuario, fondo);
				prestamos.add(prestamo);
			}
			return prestamos;

		} catch (

		SQLException e) {
			System.out.println("Error en la consulta");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<VOPrestamo> getPrestamosByUsuario(Integer id_usuario) {
		try {
			Connector conector = new Connector();
			Connection con = conector.getConnection();

			PreparedStatement pstmt = null, pstmt2, pstmt3;

			String sqlSelect = "SELECT * FROM Prestamo WHERE id_usuario = ?;";

			pstmt = con.prepareStatement(sqlSelect);
			pstmt.setInt(1, id_usuario);
			
			String sqlSelectUsuario = "SELECT * FROM Usuario WHERE id = ?;";

			pstmt2 = con.prepareStatement(sqlSelectUsuario);
			
			
			String sqlSelectFondo = "SELECT * FROM Fondo " + " WHERE id = ?;";

			pstmt3 = con.prepareStatement(sqlSelectFondo);
			

			ArrayList<VOPrestamo> prestamos = new ArrayList<>();
			
			
			ResultSet res = pstmt.executeQuery();
			VOPrestamo prestamo;
			VOUsuario usuario;
			VOFondo fondo;

			while (res.next()) {
				
				
				pstmt2.setInt(1, res.getInt("id_usuario"));
				pstmt3.setInt(1, res.getInt("id_fondo"));
				
				
				ResultSet res2 = pstmt2.executeQuery();

				
				if (res2.next()) {
					usuario = new VOUsuario(res.getInt("id"), res.getString("nombre"), res.getString("dni"),
							res.getBoolean("sexo"), res.getDate("fecha_nacimiento"), res.getString("direccion"),
							res.getString("telefono"), res.getString("email"));

				}else{
					return null;
				}
				
				ResultSet res3 = pstmt3.executeQuery();

				if (res3.next()) {
					fondo = new VOFondo(res.getInt("id"), res.getString("titulo"), res.getDate("fecha_compra"));
				}else{
					return null;
				}
				
				prestamo = new VOPrestamo(res.getInt("id"), res.getDate("fecha_inicio"), res.getDate("fecha_fin"), usuario, fondo);
				prestamos.add(prestamo);
			}
			return prestamos;

		} catch (

		SQLException e) {
			System.out.println("Error en la consulta");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<VOPrestamo> getPrestamosByFondo(Integer id_fondo) {
		try {
			Connector conector = new Connector();
			Connection con = conector.getConnection();

			PreparedStatement pstmt = null, pstmt2, pstmt3;

			String sqlSelect = "SELECT * FROM Prestamo WHERE id_fondo = ?;";

			pstmt = con.prepareStatement(sqlSelect);
			pstmt.setInt(1, id_fondo);
			
			String sqlSelectUsuario = "SELECT * FROM Usuario WHERE id = ?;";

			pstmt2 = con.prepareStatement(sqlSelectUsuario);
			
			
			String sqlSelectFondo = "SELECT * FROM Fondo " + " WHERE id = ?;";

			pstmt3 = con.prepareStatement(sqlSelectFondo);
			

			ArrayList<VOPrestamo> prestamos = new ArrayList<>();
			
			
			ResultSet res = pstmt.executeQuery();
			VOPrestamo prestamo;
			VOUsuario usuario;
			VOFondo fondo;

			while (res.next()) {
				
				
				pstmt2.setInt(1, res.getInt("id_usuario"));
				pstmt3.setInt(1, res.getInt("id_fondo"));
				
				
				ResultSet res2 = pstmt2.executeQuery();

				
				if (res2.next()) {
					usuario = new VOUsuario(res.getInt("id"), res.getString("nombre"), res.getString("dni"),
							res.getBoolean("sexo"), res.getDate("fecha_nacimiento"), res.getString("direccion"),
							res.getString("telefono"), res.getString("email"));

				}else{
					return null;
				}
				
				ResultSet res3 = pstmt3.executeQuery();

				if (res3.next()) {
					fondo = new VOFondo(res.getInt("id"), res.getString("titulo"), res.getDate("fecha_compra"));
				}else{
					return null;
				}
				
				prestamo = new VOPrestamo(res.getInt("id"), res.getDate("fecha_inicio"), res.getDate("fecha_fin"), usuario, fondo);
				prestamos.add(prestamo);
			}
			return prestamos;

		} catch (

		SQLException e) {
			System.out.println("Error en la consulta");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<VOPrestamo> getPrestamosPendientes() {
		try {
			Connector conector = new Connector();
			Connection con = conector.getConnection();

			PreparedStatement pstmt = null, pstmt2, pstmt3;

			String sqlSelect = "SELECT * FROM Prestamo WHERE fecha_fin = NULL;";

			pstmt = con.prepareStatement(sqlSelect);
			
			String sqlSelectUsuario = "SELECT * FROM Usuario WHERE id = ?;";

			pstmt2 = con.prepareStatement(sqlSelectUsuario);
			
			
			String sqlSelectFondo = "SELECT * FROM Fondo " + " WHERE id = ?;";

			pstmt3 = con.prepareStatement(sqlSelectFondo);
			

			ArrayList<VOPrestamo> prestamos = new ArrayList<>();
			
			
			ResultSet res = pstmt.executeQuery();
			VOPrestamo prestamo;
			VOUsuario usuario;
			VOFondo fondo;

			while (res.next()) {
				
				
				pstmt2.setInt(1, res.getInt("id_usuario"));
				pstmt3.setInt(1, res.getInt("id_fondo"));
				
				
				ResultSet res2 = pstmt2.executeQuery();

				
				if (res2.next()) {
					usuario = new VOUsuario(res.getInt("id"), res.getString("nombre"), res.getString("dni"),
							res.getBoolean("sexo"), res.getDate("fecha_nacimiento"), res.getString("direccion"),
							res.getString("telefono"), res.getString("email"));

				}else{
					return null;
				}
				
				ResultSet res3 = pstmt3.executeQuery();

				if (res3.next()) {
					fondo = new VOFondo(res.getInt("id"), res.getString("titulo"), res.getDate("fecha_compra"));
				}else{
					return null;
				}
				
				prestamo = new VOPrestamo(res.getInt("id"), res.getDate("fecha_inicio"), res.getDate("fecha_fin"), usuario, fondo);
				prestamos.add(prestamo);
			}
			return prestamos;

		} catch (

		SQLException e) {
			System.out.println("Error en la consulta");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<VOPrestamo> getPrestamosPendientesDeUsuario(Integer id_usuario) {
		try {
			Connector conector = new Connector();
			Connection con = conector.getConnection();

			PreparedStatement pstmt = null, pstmt2, pstmt3;

			String sqlSelect = "SELECT * FROM Prestamo WHERE fecha_fin = NULL AND id_usuario = ?;";

			pstmt = con.prepareStatement(sqlSelect);
			pstmt.setInt(1, id_usuario);
			
			String sqlSelectUsuario = "SELECT * FROM Usuario WHERE id = ?;";

			pstmt2 = con.prepareStatement(sqlSelectUsuario);
			
			
			String sqlSelectFondo = "SELECT * FROM Fondo " + " WHERE id = ?;";

			pstmt3 = con.prepareStatement(sqlSelectFondo);
			

			ArrayList<VOPrestamo> prestamos = new ArrayList<>();
			
			
			ResultSet res = pstmt.executeQuery();
			VOPrestamo prestamo;
			VOUsuario usuario;
			VOFondo fondo;

			while (res.next()) {
				
				
				pstmt2.setInt(1, res.getInt("id_usuario"));
				pstmt3.setInt(1, res.getInt("id_fondo"));
				
				
				ResultSet res2 = pstmt2.executeQuery();

				
				if (res2.next()) {
					usuario = new VOUsuario(res.getInt("id"), res.getString("nombre"), res.getString("dni"),
							res.getBoolean("sexo"), res.getDate("fecha_nacimiento"), res.getString("direccion"),
							res.getString("telefono"), res.getString("email"));

				}else{
					return null;
				}
				
				ResultSet res3 = pstmt3.executeQuery();

				if (res3.next()) {
					fondo = new VOFondo(res.getInt("id"), res.getString("titulo"), res.getDate("fecha_compra"));
				}else{
					return null;
				}
				
				prestamo = new VOPrestamo(res.getInt("id"), res.getDate("fecha_inicio"), res.getDate("fecha_fin"), usuario, fondo);
				prestamos.add(prestamo);
			}
			return prestamos;

		} catch (

		SQLException e) {
			System.out.println("Error en la consulta");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<VOPrestamo> getPrestamosByFecha(Date desde, Date hasta) {
		try {
			Connector conector = new Connector();
			Connection con = conector.getConnection();

			PreparedStatement pstmt = null, pstmt2, pstmt3;

			String sqlSelect = "SELECT * FROM Prestamo WHERE fecha_inicio >= ? AND fecha_fin <= ?;";

			pstmt = con.prepareStatement(sqlSelect);
			pstmt.setDate(1, new java.sql.Date(desde.getTime()));
			pstmt.setDate(2, new java.sql.Date(hasta.getTime()));
			
			String sqlSelectUsuario = "SELECT * FROM Usuario WHERE id = ?;";

			pstmt2 = con.prepareStatement(sqlSelectUsuario);
			
			
			String sqlSelectFondo = "SELECT * FROM Fondo " + " WHERE id = ?;";

			pstmt3 = con.prepareStatement(sqlSelectFondo);
			

			ArrayList<VOPrestamo> prestamos = new ArrayList<>();
			
			
			ResultSet res = pstmt.executeQuery();
			VOPrestamo prestamo;
			VOUsuario usuario;
			VOFondo fondo;

			while (res.next()) {
				
				
				pstmt2.setInt(1, res.getInt("id_usuario"));
				pstmt3.setInt(1, res.getInt("id_fondo"));
				
				
				ResultSet res2 = pstmt2.executeQuery();

				
				if (res2.next()) {
					usuario = new VOUsuario(res.getInt("id"), res.getString("nombre"), res.getString("dni"),
							res.getBoolean("sexo"), res.getDate("fecha_nacimiento"), res.getString("direccion"),
							res.getString("telefono"), res.getString("email"));

				}else{
					return null;
				}
				
				ResultSet res3 = pstmt3.executeQuery();

				if (res3.next()) {
					fondo = new VOFondo(res.getInt("id"), res.getString("titulo"), res.getDate("fecha_compra"));
				}else{
					return null;
				}
				
				prestamo = new VOPrestamo(res.getInt("id"), res.getDate("fecha_inicio"), res.getDate("fecha_fin"), usuario, fondo);
				prestamos.add(prestamo);
			}
			return prestamos;

		} catch (

		SQLException e) {
			System.out.println("Error en la consulta");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<VOPrestamo> getPrestamosByFechaYUsuario(Date desde, Date hasta, Integer id_usuario) {
		try {
			Connector conector = new Connector();
			Connection con = conector.getConnection();

			PreparedStatement pstmt = null, pstmt2, pstmt3;

			String sqlSelect = "SELECT * FROM Prestamo WHERE fecha_inicio >= ? AND fecha_fin <= ? AND id_usuario = ?;";

			pstmt = con.prepareStatement(sqlSelect);
			pstmt.setDate(1, new java.sql.Date(desde.getTime()));
			pstmt.setDate(2, new java.sql.Date(hasta.getTime()));
			pstmt.setInt(3, id_usuario);
			
			String sqlSelectUsuario = "SELECT * FROM Usuario WHERE id = ?;";

			pstmt2 = con.prepareStatement(sqlSelectUsuario);
			
			
			String sqlSelectFondo = "SELECT * FROM Fondo " + " WHERE id = ?;";

			pstmt3 = con.prepareStatement(sqlSelectFondo);
			

			ArrayList<VOPrestamo> prestamos = new ArrayList<>();
			
			
			ResultSet res = pstmt.executeQuery();
			VOPrestamo prestamo;
			VOUsuario usuario;
			VOFondo fondo;

			while (res.next()) {
				
				
				pstmt2.setInt(1, res.getInt("id_usuario"));
				pstmt3.setInt(1, res.getInt("id_fondo"));
				
				
				ResultSet res2 = pstmt2.executeQuery();

				
				if (res2.next()) {
					usuario = new VOUsuario(res.getInt("id"), res.getString("nombre"), res.getString("dni"),
							res.getBoolean("sexo"), res.getDate("fecha_nacimiento"), res.getString("direccion"),
							res.getString("telefono"), res.getString("email"));

				}else{
					return null;
				}
				
				ResultSet res3 = pstmt3.executeQuery();

				if (res3.next()) {
					fondo = new VOFondo(res.getInt("id"), res.getString("titulo"), res.getDate("fecha_compra"));
				}else{
					return null;
				}
				
				prestamo = new VOPrestamo(res.getInt("id"), res.getDate("fecha_inicio"), res.getDate("fecha_fin"), usuario, fondo);
				prestamos.add(prestamo);
			}
			return prestamos;

		} catch (

		SQLException e) {
			System.out.println("Error en la consulta");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer anadirPrestamo(VOPrestamo prestamo) {
		Connector connector = new Connector();
		Connection con = connector.getConnection();
		try {

			PreparedStatement pstmt, pstmt2;

			


			String sqlInsert = "INSERT INTO Prestamo "
					+ "(fecha_inicio, id_usuario, id_fondo) "
					+ " VALUES ( ?, ?, ?);";

			pstmt = con.prepareStatement(sqlInsert);
			pstmt.setDate(1, new java.sql.Date(prestamo.getFecha_inicio().getTime()));
			pstmt.setInt(2, prestamo.getUsuario().getId());
			pstmt.setInt(3, prestamo.getFondo().getId());
			
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
	public Integer modificarPrestamo(VOPrestamo prestamo) {
		Connector connector = new Connector();
        Connection con = connector.getConnection();
        try {


            PreparedStatement pstmt, pstmt2;

            String sqlSelect =
                    "SELECT * FROM Prestamo "
                            + " WHERE id = ?;";

            pstmt = con.prepareStatement(sqlSelect);
            pstmt.setInt(1, prestamo.getId());


            String sqlUpdate =
                    "UPDATE Prestamo " +
                            "SET fecha_inicio = ?, " +
                            "fecha_fin = ? " +
                            "WHERE id = ?;";

            pstmt2 = con.prepareStatement(sqlUpdate);
            pstmt2.setDate(1, new java.sql.Date(prestamo.getFecha_inicio().getTime()));
            pstmt2.setDate(2, new java.sql.Date(prestamo.getFecha_fin().getTime()));
            pstmt2.setInt(3, prestamo.getId());
            


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
	public Integer borrarPrestamo(Integer id_prestamo) {
		Connector connector = new Connector();
		Connection con = connector.getConnection();
		try {

			PreparedStatement pstmt, pstmt2;

			String sqlSelect = "SELECT * FROM Prestamo WHERE id = ?;";

			pstmt = con.prepareStatement(sqlSelect);
			pstmt.setInt(1, id_prestamo);

			String sqlUpdate = "DELETE FROM Prestamo WHERE id = ?;";

			pstmt2 = con.prepareStatement(sqlUpdate);
			pstmt2.setInt(1, id_prestamo);

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
