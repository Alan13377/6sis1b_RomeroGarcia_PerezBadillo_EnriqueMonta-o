package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JOptionPane;

public class VentasCRUD{
	
	Conexion cn = new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int r = 0;
	public String IdVentas() {
		String idv="";
		String sql = "SELECT max(IdVentas) FROM ventas";
		try {
			con = cn.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				idv = rs.getString(1);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return idv;
	}
	
	public int GuardarVentas(VentasM v) {	
		String sql = "INSERT INTO venta (id_cli, id_vend, num_ventas, fecha, monto) values(?,?,?,?,?)";
		try {
			con = cn.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, v.getIdCliente());
			ps.setInt(2, v.getIdVendedor());
			ps.setInt(3, v.getNumVentas());
			ps.setString(4, v.getFecha());
			ps.setDouble(5, v.getMonto());
			r = ps.executeUpdate();
		} catch (Exception e) {
			
		}
		return r;
	}
	
	public int GuardarDetalle(Dventas dv) {
		String  sql = "INSERT INTO dventas (id_vent,id_prod,cantidad,prec_vent) values(?,?,?,?)";
		try {
			con = cn.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, dv.getIdVentas());
			ps.setInt(2,dv.getIdProd());
			ps.setInt(3, dv.getCant());
			ps.setDouble(4,dv.getPrecVenta());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return r;
	}

}