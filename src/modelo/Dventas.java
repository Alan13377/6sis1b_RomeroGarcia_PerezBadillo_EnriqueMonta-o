package modelo;

public class Dventas {
	int id;
	int idVentas;
	int idProd;
	int cant;
	float precVenta;
	
	
	public Dventas (){
		
	}


	public Dventas(int id, int idVentas, int idProd, int cant, float precVenta) {
		this.id = id;
		this.idVentas = idVentas;
		this.idProd = idProd;
		this.cant = cant;
		this.precVenta = precVenta;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdVentas() {
		return idVentas;
	}


	public void setIdVentas(int idVentas) {
		this.idVentas = idVentas;
	}


	public int getIdProd() {
		return idProd;
	}


	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}


	public int getCant() {
		return cant;
	}


	public void setCant(int cant) {
		this.cant = cant;
	}


	public float getPrecVenta() {
		return precVenta;
	}


	public void setPrecVenta(float precVenta) {
		this.precVenta = precVenta;
	}
	
	
}		
