import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;



public class Base_datos {
	
	

	Connection conexion=null;
	Statement instruccion=null;
	ResultSet conjuntoresultados=null;
	Trabajadores trab_bs  = new Trabajadores();
	
	
	
	
	public Base_datos(Connection conex ) {
		this.conexion=conex;
	
		// TODO Auto-generated constructor stub
		
	}

	public void guardarenBD(){
		
		
		try{
			//consultar base de datos
			Statement instruccion = (Statement) conexion.createStatement();
			//insercion en base de datos
			String sql_inst="INSERT INTO trabajadores (numtrabajador, nombre, password)";
			sql_inst=sql_inst+ "VALUES("+trab_bs.getnumtrabajador()+",'"+trab_bs.getNombre()+"','"+trab_bs.getpassword()+"')";
			
		 
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
			conjuntoresultados= instruccion.executeQuery("SELECT nombre ,password , numtrabajador FROM almacen LIMIT 1");
			//coje el resultado y dame el siguiente
			if(conjuntoresultados!=null){
			conjuntoresultados.next();
			//Almacenar en Trbajador  el nombre y numero de trabajador
			trab_bs.numtrabajador=(int)conjuntoresultados.getObject("numtrabajador");
			trab_bs.Nombre=(String)conjuntoresultados.getObject("nombre");
			trab_bs.password=(String)conjuntoresultados.getObject("password");
			}
		}catch(SQLException exceptionSql){
			exceptionSql.printStackTrace();
		}
		
	}

}
