package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class Vendedor implements CRUD{
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
		public int add(Object[] o) {
			String sql = "INSERT INTO vendedor (dni ,nombre ,telefono,estado,user) values(?,?,?,?,?)";
			int r = 0;
			try {
				acceso = con.conectar();
				ps = acceso.prepareStatement(sql);
				ps.setObject(1,o[0]);
				ps.setObject(2,o[1]);
				ps.setObject(3,o[2]);
				ps.setObject(4,o[3]);
				ps.setObject(5,o[4]);
				r = ps.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("No se encontro la tabla");
	            System.out.println(e.getMessage());
	            System.out.println(e.getStackTrace());
			}
			return r;
		}
	
		
		public int actualizar(Object[] o) {
			String sql = "UPDATE vendedor set dni=? ,nombre=? ,telefono=?,estado=?,user=? where id_vend =?";
			int r = 0;
			try {
				acceso = con.conectar();
				ps = acceso.prepareStatement(sql);
				ps.setObject(1,o[0]);
				ps.setObject(2,o[1]);
				ps.setObject(3,o[2]);
				ps.setObject(4,o[3]);
				ps.setObject(5,o[4]);
				ps.setObject(6,o[5]);
				r = ps.executeUpdate();
			} catch (Exception e) {
				System.out.println("No se pudo actualizar");
	            System.out.println(e.getMessage());
	            System.out.println(e.getStackTrace());
			}
			
			
			return r;
		}
		
		public void eliminar(int id) {
			String sql = "DELETE from vendedor where id_vend=?";
			try {
				acceso = con.conectar();
				ps = acceso.prepareStatement(sql);
				ps.setInt(1,id);
				ps.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		@Override
		public List listar() {
			// TODO Auto-generated method stub
			return null;
		}
			
		
}
