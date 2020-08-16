package modelo;

import java.util.Date;

public class VentasM {
	int id;
	int idCliente;
	int idVendedor;
	int numVentas;
	String fecha;
	double monto;
	
	public VentasM() {
		
	}

	public VentasM(int id, int idCliente, int idVendedor, int numVentas, String fecha, double monto) {
		this.id = id;
		this.idCliente = idCliente;
		this.idVendedor = idVendedor;
		this.numVentas = numVentas;
		this.fecha = fecha;
		this.monto = monto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int id) {
		this.idCliente = id;
	}

	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	public int getNumVentas() {
		return numVentas;
	}

	public void setNumVentas(int numVentas) {
		this.numVentas = numVentas;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public void setString(String date) {
		// TODO Auto-generated method stub
		
	}
	

}