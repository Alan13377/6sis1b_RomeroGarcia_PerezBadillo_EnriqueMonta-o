package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoCrud implements CRUD{
	Connection con;
	Conexion cn = new Conexion();
	PreparedStatement ps;
	ResultSet rs;
	
	public ProductoM ListarId(int ide) {
		ProductoM p = new ProductoM();
		
		String sql = "select * from producto where id_prod=?";
		try {
			con = cn.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1,ide);
			rs = ps.executeQuery();
			while(rs.next()) {
				p.setId(rs.getInt(1));
				p.setProd(rs.getString(2));
				p.setPrecio(rs.getFloat(3));
				p.setStock(rs.getInt(4));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return p;
	}
	@Override
	
	public List listar() {
		List<ProductoM> lista = new ArrayList();
		String sql = "SELECT * FROM producto";
		try {
			con =cn.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductoM c = new ProductoM();
				c.setId(rs.getInt(1));
				c.setProd(rs.getString(2));
				c.setPrecio(rs.getFloat(3));
				c.setStock(rs.getInt(4));
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
		String sql = "INSERT INTO producto (id_prod,nom_prod,Precio,Stock) values(?,?,?,?)";
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
		String sql = "UPDATE producto set dni_cli=?,nom_cli=?,direc_cli=?,email=? where id_cli =?";
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
		String sql = "DELETE from producto where id_cli=?";
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
