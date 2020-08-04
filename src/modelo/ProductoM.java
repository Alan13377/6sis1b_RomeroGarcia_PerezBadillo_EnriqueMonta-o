package modelo;

public class ProductoM {
	int ide;
	String prod;
	float precio;
	int stock;
	
	public ProductoM() {
		
	}

	public ProductoM(int ide, String prod, float precio, int stock) {
		this.ide = ide;
		this.prod = prod;
		this.precio = precio;
		this.stock = stock;
	}

	public int getId() {
		return ide;
	}

	public void setId(int ide) {
		this.ide = ide;
	}

	public String getProd() {
		return prod;
	}

	public void setProd(String prod) {
		this.prod = prod;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
