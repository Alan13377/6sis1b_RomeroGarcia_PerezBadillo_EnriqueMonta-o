package modelo;

public class ClienteM {
	int id;
	String dni;
	String nom;
	String dir;
	String email;
	
	public ClienteM() {
		
	}

	public ClienteM(int id, String dni, String nom, String dir, String email) {
		
		this.id = id;
		this.dni = dni;
		this.nom = nom;
		this.dir = dir;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
