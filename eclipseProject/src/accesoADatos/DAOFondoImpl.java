package accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

		} catch (

		SQLException e) {
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

		} catch (

		SQLException e) {
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

			String sqlSelect = "SELECT * FROM Fondo " + 
			" WHERE fecha_compra between ? AND ?;";

			pstmt = con.prepareStatement(sqlSelect);
			pstmt.setDate(1, new java.sql.Date(desde.getTime()));
			pstmt.setDate(2, new java.sql.Date(hasta.getTime()));

			ResultSet res = pstmt.executeQuery();
			
			ArrayList<VOFondo> fondos = new ArrayList<>();

			while (res.next()) {
				VOFondo fondo = new VOFondo(res.getInt("id"), res.getString("titulo"), res.getDate("fecha_compra"));
				return fondo;
			}

		} catch (

		SQLException e) {
			System.out.println("Error en la consulta");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public VOFondo getFondoByISBN(String ISBN) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOFondo> getFondos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOFondo> getFondosByAutor(String autor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOFondo> getFondosByAnoEdicion(Date desde, Date hasta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOFondo> getFondosByEditorial(String editorial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOFondo> getFondosByAutorYTitulo(String autor, String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOLibro> getLibros() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer anadirFondo(VOFondo fondo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer anadirLibro(VOLibro libro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer modificarFondo(VOFondo fondo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer modificarLibro(VOLibro libro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarFondo(VOFondo fondo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarFondo(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarFondo(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarLibro(String ISBN) {
		// TODO Auto-generated method stub
		return null;
	}

}
