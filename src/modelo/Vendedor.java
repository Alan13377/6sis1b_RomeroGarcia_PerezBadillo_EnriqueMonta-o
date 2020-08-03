package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Vendedor {
		PreparedStatement ps;
		ResultSet rs;
		
		
		Conexion con = new Conexion();
		Connection acceso;
		
		public Evendedor ValidarVendedor(String dni,String user) {
			Evendedor ev = new Evendedor();
			
			String sql = "SELECT * FROM vendedor where dni=? and user=?";
			try {
				acceso = con.conectar();
				ps = acceso.prepareStatement(sql);
				ps.setString(1,dni);
				ps.setString(2, user);
				rs = ps.executeQuery();
				while(rs.next()) {
					ev.setId(rs.getInt(1));
					ev.setDni(rs.getString(2));
					ev.setNom(rs.getString(3));
					ev.setTel(rs.getString(4));
					ev.setEsta(rs.getString(5));
					ev.setUser(rs.getString(6));
					
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return ev;
		}
			
		
}
