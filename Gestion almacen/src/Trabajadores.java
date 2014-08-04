import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;






import com.mysql.jdbc.Statement;


public class Trabajadores implements Serializable {
	public String Nombre;
	public int numtrabajador;
	public String password;
	private ArrayList<Trabajadores> trabajador1 = new ArrayList<Trabajadores>();
	
	
	//bd
		
		
		public Trabajadores(){
			
			Nombre="";
			numtrabajador=0;
			password="";
		}
		public Trabajadores(String nom,int numtra,String pass){
		Nombre=nom;
		numtrabajador=numtra;
		password=pass;
		
		for (int i = 0; i < numtrabajador; i++);
		

		
		
	}
	public void setNombre(String nom){
		Nombre=nom;
		
	}
	
	public String getNombre(){
		return Nombre;
	}
	
	public void  setnumtrabajador(int numtra){
		numtrabajador=numtra;
		
	}
	public int getnumtrabajador(){
		return numtrabajador;
		
	}
	
	public void setpassword(String pass){
		password=pass;
		
	}
	public String getpassword(){
		return password;
		
	}
	public String toString(){
		return Nombre;
	}
	public Trabajadores gettrabajador(int posicion) {
		return trabajador1.get(posicion);
	}

	
	}
	
	
	
