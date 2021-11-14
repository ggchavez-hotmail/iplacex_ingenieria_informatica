package modelo;

import java.io.Serializable;

public class Slafi implements Serializable {
	private String nombre;
	private String apellido;
	private int edad;
	private int contribucion;
	private int pension;
	private String afp;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getContribucion() {
		return contribucion;
	}

	public void setContribucion(int contribucion) {
		this.contribucion = contribucion;
	}

	public int getPension() {
		return pension;
	}

	public void setPension(int pension) {
		this.pension = pension;
	}

	public String getAfp() {
		return afp;
	}

	public void setAfp(String afp) {
		this.afp = afp;
	}

}
