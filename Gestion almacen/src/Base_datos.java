import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class Base_datos implements Serializable {

	Connection conexion = null;
	Statement instruccion = null;
	ResultSet rs = null;
	Trabajadores trab_bs = new Trabajadores();
	JComboBox<Trabajadores> combobs;
	JComboBox<Clientes> cli1;
	Clientes nuevocliente = new Clientes();
	

	public Base_datos(Connection conex) {
		this.conexion = conex;

		// TODO Auto-generated constructor stub

	}

	public void guardarenBD(Trabajadores trab_bs1) {
		this.trab_bs = trab_bs1;

		try {
			// consultar base de datos
			instruccion = (Statement) conexion.createStatement();
			// insercion en base de datos
			String sql_inst = "INSERT INTO trabajadores ( Nombre ,numtrabajador, password )";
			sql_inst = sql_inst + "VALUES('" + trab_bs1.getNombre() + "'," + trab_bs1.getnumtrabajador() + ",'"
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
			rs = stat.executeQuery("SELECT Nombre, password FROM trabajadores ");
			// coje el resultado y dame el siguiente
			while (rs.next()) {
				modeloCombo.addElement(rs.getObject("nombre"));

			}
			// rs.close();
			combobs.setModel(modeloCombo);

		} catch (SQLException exceptionSql) {
			exceptionSql.printStackTrace();

		}
	}

	public void nuevocliente(Clientes cliente1) {
		nuevocliente = cliente1;
		try {
			instruccion = (Statement) conexion.createStatement();
			String sql_inst = "INSERT INTO clientes (nombre)";
			sql_inst = sql_inst + "VALUES('" + nuevocliente.getNombre() + "')";

			instruccion.executeUpdate(sql_inst);

		} catch (SQLException excepcionSql) {
			excepcionSql.printStackTrace();

		}

	}

	public void leercli(JComboBox<Clientes> cli) {
		this.cli1 = cli;
		try {

			Statement stat = (Statement) conexion.createStatement();
			DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
			// la consulta en la base de datos
			rs = stat.executeQuery("SELECT nombre FROM clientes ");
			// coje el resultado y dame el siguiente
			while (rs.next()) {
				modeloCombo.addElement(rs.getObject("nombre"));

			}

			cli.setModel(modeloCombo);

		} catch (SQLException exceptionSql) {
			exceptionSql.printStackTrace();

		}
	}

	public void borrarcliente(JComboBox<Clientes> cli) {
		this.cli1 = cli;
		try {
			Statement stat = (Statement) conexion.createStatement();
			rs = stat.executeQuery("SELECT nombre FROM  clientes ");

			while (rs.next()) {

				cli1.removeItem(rs.getString("nombre"));
				rs.absolute(cli1.getSelectedIndex() + 1);
				// String sql_inst="DELETE INTO clientes( nombre)";

			}

		} catch (SQLException exceptionSql) {
			exceptionSql.printStackTrace();

		}

	}

	public void generarparte() {

		String sql = "SELECT LAST_INSERT_ID(Numparte)+1 FROM tbl_partes ORDER BY Numparte DESC LIMIT 1";

		try {
			Statement stat = (Statement) conexion.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()){
				
			}
		} catch (Exception e) {
			// NOTA: So hubo error muestra el error
			JOptionPane.showMessageDialog(null, e);

		}
	}
}
