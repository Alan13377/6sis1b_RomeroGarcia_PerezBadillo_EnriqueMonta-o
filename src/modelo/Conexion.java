package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
		private static final String Controlador = "com.mysql.jdbc.Driver";
		private static final String URL = "jdbc:mysql://localhost:3306/ventas?autoReconnect=true&useSSL=false";
		private static final String USUARIO = "root";
		private static final String CLAVE = "1337259";
		PreparedStatement ps;
		ResultSet rs;

		public static Connection conectar() {
			Connection con = null;
			try {
				Class.forName(Controlador);
				con = DriverManager.getConnection(URL, USUARIO, CLAVE);
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null,"Error al cargar el driver");
				e.printStackTrace();
			}catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Error al generar conexion");
				e.printStackTrace();
			}
			return con;
		}

	}


