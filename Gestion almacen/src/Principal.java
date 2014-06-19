import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.sql.SQLException;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private Trabajadores trabajador;
	private int numtrabajador;
	private Ventanatrabajadores frametrabajador;
	private JComboBox<Trabajadores> comboBox;
	private ArrayList<Trabajadores> trabajador1 = new ArrayList<Trabajadores>();
	 

	// DB
	Connection conexion = null;

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
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/almacen", "root", "formula2962");
		} catch (SQLException exceptionSql) {
			exceptionSql.printStackTrace();

		} catch (ClassNotFoundException noEncontroClase) {
			noEncontroClase.printStackTrace();
		}

		

		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBox = new JComboBox<Trabajadores>();
		
		// Como añadir Trabajadores
		comboBox.addItem(new Trabajadores(conexion));
		contentPane.add(comboBox);
		
		
		//trabajador.leerTrabajador();
		
		

		// Como saber que trabajador se ha seleccionado
		Trabajadores elegido = (Trabajadores) comboBox.getItemAt(0);
		comboBox.setBounds(41, 67, 171, 20);
		contentPane.add(comboBox);

		JLabel lblTrabajadores = new JLabel("Trabajadores");
		lblTrabajadores.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblTrabajadores.setBounds(41, 36, 117, 20);
		contentPane.add(lblTrabajadores);

		// para añadir trabajadorea acceso a su ventana
		JButton buttonmas = new JButton("+");
		buttonmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//LLamamos al metodo de nuevo trabajador
				newtrabajador();
				opentrabajadorwindow();
				

			}
		});
		buttonmas.setBounds(259, 66, 89, 23);
		contentPane.add(buttonmas);

		JLabel lblAadirTrabajador = new JLabel("A\u00F1adir trabajador");
		lblAadirTrabajador.setBounds(259, 40, 117, 14);
		contentPane.add(lblAadirTrabajador);

		passwordField = new JPasswordField();
		passwordField.setBounds(41, 178, 171, 20);
		contentPane.add(passwordField);
		// password para cada usuario
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblPassword.setBounds(41, 153, 123, 14);
		contentPane.add(lblPassword);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(null);
		lblNewLabel.setBounds(259, 109, 96, 89);
		contentPane.add(lblNewLabel);

		// Acceso a partes de trabajo
		JButton btnNewButton = new JButton("  Partes \r\nTrabajo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Almacen frame = new Almacen();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(412, 67, 123, 131);
		contentPane.add(btnNewButton);
	}

	// definimos que es un nuevo trabajador
	private void opentrabajadorwindow() {
		frametrabajador = new Ventanatrabajadores(trabajador, comboBox );
		frametrabajador.setVisible(true);
		frametrabajador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public void newtrabajador() {
		trabajador = new Trabajadores(conexion);
	}

	
}
