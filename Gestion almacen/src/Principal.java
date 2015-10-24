import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.awt.SystemColor;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private Trabajadores trabajador;
	private Ventanatrabajadores frametrabajador;
	JComboBox<Trabajadores> comboBox;

	// DB
	Connection conexion = null;
	Base_datos bs = new Base_datos(conexion);
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			// establece conexion con msql
			conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/almacen", "root", "formula2962");
		} catch (SQLException exceptionSql) {
			exceptionSql.printStackTrace();

		} catch (ClassNotFoundException noEncontroClase) {
			noEncontroClase.printStackTrace();
		}
		
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 354);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// COMBOBOX

		comboBox = new JComboBox<Trabajadores>();
		// Como añadir Trabajadores
		// comboBox.addItem(new Trabajadores());
		newtrabajador();
		lbd();
		contentPane.add(comboBox);
		comboBox.setBounds(41, 67, 171, 20);

		// label trabajadores
		JLabel lblTrabajadores = new JLabel("Trabajadores");
		lblTrabajadores.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblTrabajadores.setBounds(41, 36, 117, 20);
		contentPane.add(lblTrabajadores);

		// para añadir trabajadorea acceso a su ventana
		JButton buttonmas = new JButton("+");
		buttonmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// LLamamos al metodo de nuevo trabajador
				acceso();
				newtrabajador();
				opentrabajadorwindow();

			}
		});
		buttonmas.setBounds(259, 66, 89, 23);
		contentPane.add(buttonmas);

		JLabel lblAadirTrabajador = new JLabel("A\u00F1adir trabajador");
		lblAadirTrabajador.setBounds(259, 40, 117, 14);
		contentPane.add(lblAadirTrabajador);

		// contenedor donde colocoar el password
		passwordField = new JPasswordField();
		passwordField.setBounds(41, 178, 171, 20);
		contentPane.add(passwordField);
	

		// password para cada usuario
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblPassword.setBounds(41, 153, 123, 14);
		contentPane.add(lblPassword);

		// Acceso a partes de trabajo
		JButton btnNewButton = new JButton("  Partes \r\nTrabajo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Almacen frame = new Almacen(comboBox, bs);
				frame.setVisible(true);
				lbd();
			}
		});
		btnNewButton.setBounds(412, 67, 123, 131);
		contentPane.add(btnNewButton);
	}

	// definimos que es un nuevo trabajador
	private void opentrabajadorwindow() {
		frametrabajador = new Ventanatrabajadores(trabajador, this.comboBox, bs);
		frametrabajador.setVisible(true);
		frametrabajador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	// creamso metodo para crear un nuevo trabajador
	public void newtrabajador() {
		trabajador = new Trabajadores();
		bs = new Base_datos(conexion);
	}

	// metodo para añadir datos cd db a combobox
	public void lbd() {
		comboBox.removeAllItems();
		bs = new Base_datos(conexion);
		bs.leerTrabajador(this.comboBox);

	}

	// acceso a trabajadores con user and password
	public static void acceso() {
		

		String pass = "";
		do {

			pass = JOptionPane.showInputDialog(null, "curvas cano");
			

			if (pass.equals("admin"))
				JOptionPane.showMessageDialog(null, "contraseña correcta");

			else
				JOptionPane.showMessageDialog(null, "contraseña incorrecta");

		} while (pass.equals("admin") == false);

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
