import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import com.mysql.jdbc.Statement;

public class Base_datos implements Serializable {

	Connection conexion = null;
	Statement instruccion = null;
	ResultSet rs = null;
	Trabajadores trab_bs = new Trabajadores();
	JComboBox<Trabajadores> combobs;
	

	public Base_datos(Connection conex) {
		this.conexion = conex;
		

		// TODO Auto-generated constructor stub

	}

	public void guardarenBD(Trabajadores trab_bs1) {
		this.trab_bs = trab_bs1;

		try {
			// consultar base de datos
			Statement instruccion = (Statement) conexion.createStatement();
			// insercion en base de datos
			String sql_inst = "INSERT INTO trabajadores ( Nombre ,numtrabajador, password )";
			sql_inst = sql_inst + "VALUES('" + trab_bs1.getNombre() + "',"
					+ trab_bs1.getnumtrabajador() + ",'"
					+ trab_bs1.getpassword() + "')";

			instruccion.executeUpdate(sql_inst);

		} catch (SQLException excepcionSql) {
			excepcionSql.printStackTrace();

		}

	}

	public void leerTrabajador(JComboBox<Trabajadores> combo) {
		this.combobs = combo;

		try {

			instruccion = (Statement) conexion.createStatement();
			Statement stat = (Statement) conexion.createStatement();
			DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
			// la consulta en la base de datos
			rs = stat.executeQuery("SELECT Nombre FROM trabajadores ");
			// coje el resultado y dame el siguiente
			while (rs.next()) {
				modeloCombo.addElement(rs.getObject("nombre"));
			}
			rs.close();
			combobs.setModel(modeloCombo);

		} catch (SQLException exceptionSql) {
			exceptionSql.printStackTrace();

		}
	}

}
