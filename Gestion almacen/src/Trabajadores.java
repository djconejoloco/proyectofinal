import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;






import com.mysql.jdbc.Statement;


public class Trabajadores implements Serializable {
	private String Nombre;
	private int numtrabajador;
	private String password;
	private ArrayList<Trabajadores> trabajador1 = new ArrayList<Trabajadores>();
	
	
	//bd
		private Connection conexion=null;
		Statement instruccion=null;
		ResultSet conjuntoresultados=null;

	
	
		
		public Trabajadores(Connection conexion){
			this.conexion=conexion;
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

	public void guardarenBD(){
		try{
			//consultar base de datos
			Statement instruccion = (Statement) conexion.createStatement();
			//insercion en base de datos
			String sql_inst="INSERT INTO trabajadores (numtrabajador, nombre, password)";
			sql_inst=sql_inst+ " VALUES("+this.numtrabajador+",'"+this.Nombre+"','"+this.password+"')";
			
			System.out.println(sql_inst);
		 
		  instruccion.executeUpdate(sql_inst);
		  }
		catch(SQLException excepcionSql){
			excepcionSql.printStackTrace();
			
		}
	}
	public void leerTrabajador(){
		try{
			instruccion=(Statement) conexion.createStatement();
			//la consulta en la base de datos
			conjuntoresultados= instruccion.executeQuery("SELECT nombre ,password ,  numtrabajador FROM almacen LIMIT 1");
			//coje el resultado y dame el siguiente
			if(conjuntoresultados!=null){
			conjuntoresultados.next();
			//Almacenar en liga el nombre y numequipos
			this.numtrabajador=(int)conjuntoresultados.getObject("numtrabajador");
			this.Nombre=(String)conjuntoresultados.getObject("nombre");
			this.password=(String)conjuntoresultados.getObject("password");
			}
		}catch(SQLException exceptionSql){
			exceptionSql.printStackTrace();
		}
		
	}
	}
	
	
	
