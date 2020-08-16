package modelo;

import java.util.List;

import vista.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteCrud implements CRUD{
	Connection con;
	Conexion cn = new Conexion();
	PreparedStatement ps;
	ResultSet rs;
	public ClienteM ListarId(String dni) {
		ClienteM c = new ClienteM();
		String sql = "select * from cliente where dni_cli=?";
		try {
			con = cn.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1,dni);
			rs = ps.executeQuery();
			while(rs.next()) {
				c.setId(rs.getInt(1));
				c.setDni(rs.getString(2));
				c.setNom(rs.getString(3));
				c.setDir(rs.getString(4));
				c.setEmail(rs.getString(5));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return c;
	}
	@Override
	
	public List listar() {
		List<ClienteM> lista = new ArrayList();
		String sql = "SELECT * FROM cliente";
		try {
			con =cn.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ClienteM c = new ClienteM();
				c.setId(rs.getInt(1));
				c.setDni(rs.getString(2));
				c.setNom(rs.getString(3));
				c.setDir(rs.getString(4));
				c.setEmail(rs.getString(5));
				lista.add(c);
				
			}
		} catch (Exception e) {
			System.out.println("No se encontro la tabla");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
		}
		return lista;
	}
	@Override
	public int add(Object[] o) {
		String sql = "INSERT INTO cliente (dni_cli,nom_cli,direc_cli,email) values(?,?,?,?)";
		int r = 0;
		try {
			con = cn.conectar();
			ps = con.prepareStatement(sql);
			ps.setObject(1,o[0]);
			ps.setObject(2,o[1]);
			ps.setObject(3,o[2]);
			ps.setObject(4,o[3]);
			
			r = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("No se encontro la tabla");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
		}
		return r;
	}
	@Override
	public int actualizar(Object[] o) {
		String sql = "UPDATE cliente set dni_cli=?,nom_cli=?,direc_cli=?,email=? where id_cli =?";
		int r = 0;
		try {
			con = cn.conectar();
			ps = con.prepareStatement(sql);
			ps.setObject(1,o[0]);
			ps.setObject(2,o[1]);
			ps.setObject(3,o[2]);
			ps.setObject(4,o[3]);
			ps.setObject(5,o[4]);
			r = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("No se pudo actualizar");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
		}
		
		
		return r;
	}
	@Override
	public void eliminar(int id) {
		String sql = "DELETE from cliente where id_cli=?";
		try {
			con = cn.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
}