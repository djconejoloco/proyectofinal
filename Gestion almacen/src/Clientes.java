import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class Clientes implements Serializable {

	public String Nombre;
	private ArrayList<Trabajadores> clientesvarios = new ArrayList<Trabajadores>();
	int parte = 0;

	public Clientes() {
		Nombre = "";

	}

	public Clientes(String nom1) {
		Nombre = nom1;
	}

	public void setNombre(String nom) {
		Nombre = nom;

	}

	public String getNombre() {
		return Nombre;
	}

	public String toString() {
		return Nombre;
	}

	public Trabajadores gettrabajador(int posicion) {
		return clientesvarios.get(posicion);

	}

	public void nparte(int i) {
		i = parte;
	}

	public int numparte() {
		return parte;
	}
}
