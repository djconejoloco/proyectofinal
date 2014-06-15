import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;


public class Trabajadores {
	private String Nombre;
	private int numtrabajador;
	private int horastrabajo;
	private int horasextra;
	private String password;
	private Clientes cliente;
	
	private Connection conexion=null;

	// pasamos datos por el constructor para que los pueda cojer el segundo
	public Trabajadores(String nom,int numtra, int horas, int extras, String pass) {
		Nombre=nom;
		numtrabajador=numtra;
		horastrabajo=horas;
		horasextra=extras;
		password=pass;
		
	}
	public Trabajadores(){
		Nombre="";
		numtrabajador=0;
		horastrabajo=0;
		horasextra=0;
		password="";
		
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
	public void sethorastrabajo(int horas){
		horastrabajo=horas;
		
	}
	public int hethorastrabajo(){
		return horastrabajo;
	}
	public void sethorasextras(int extras){
		horasextra=extras;
	}
	public int gethorasextras(){
		return horasextra;
		
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
	
	public void guardarenBD(){
		try{
			//consultar base de datos
			Statement instruccion = (Statement) conexion.createStatement();
			//insercion en base de datos
			String sql_inst="INSERT INTO trabajador (numtrabajador, nombre)";
			sql_inst=sql_inst+ "VALUES("+this.numtrabajador+"'"+this.Nombre+"')";
		 
		  instruccion.executeUpdate(sql_inst);
		  }
		catch(SQLException excepcionSql){
			excepcionSql.printStackTrace();
			
		}
	
	}
	
	public void BDnewcliente(Clientes cliente){
		try{
			//consultar base de datos
			Statement instruccion = (Statement) conexion.createStatement();
			//insercion en base de datos
			//String sql_inst="INSERT INTO equipos (idLiga, nombreEquipo, golesFavor, golesEnContra, partidosGanados, partidosPerdidos)";
			//sql_inst=sql_inst+ "VALUES('"+"',"+Equipo.getGolesFavor()+","+Equipo.getGolesContra()+","+Equipo.getPartidosGanados()+","+Equipo.getPartidosPerdidos()+")";
		 
		  instruccion.executeUpdate(sql_inst);
		  }
		catch(SQLException excepcionSql){
			excepcionSql.printStackTrace();
			
		}
	}
	public void add(Trabajadores trabajadores) {
		// TODO Auto-generated method stub
		
	}
	
}