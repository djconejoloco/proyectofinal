import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Toolkit;

import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;

public class Almacen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public JTextField Trabcombo;
	private Clientes cliente;
	private Trabajadores ventanatrabajador;
	private cli ventanaclientes;
	private JTextField textField_5;
	private Base_datos bs;
	JComboBox<Trabajadores> comboBox;
	JComboBox<Clientes> client;
	JComboBox <Base_datos> combopart;
	
	private JTable table;

	
	Principal p = new Principal();
	
	
	public Almacen(JComboBox<Trabajadores> combo1, Base_datos basedat) {
		setBackground(new Color(255, 255, 255));

		this.comboBox = combo1;
		this.bs = basedat;
		setTitle("Almacen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 548);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblCliente = new JLabel("Clientes");
		lblCliente.setBounds(13, 74, 81, 14);
		lblCliente.setFont(new Font("Trebuchet MS", Font.BOLD, 12));

		textField = new JTextField();
		textField.setBounds(15, 256, 305, 75);
		textField.setColumns(10);

		JLabel lblTrabajoRealizado = new JLabel("Trabajo realizado");
		lblTrabajoRealizado.setBounds(13, 231, 124, 14);
		lblTrabajoRealizado.setFont(new Font("Trebuchet MS", Font.BOLD, 12));

		textField_1 = new JTextField();
		textField_1.setBounds(15, 367, 86, 20);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(111, 367, 169, 20);
		textField_2.setText(fechaactual());
		textField_2.setColumns(10);

		// BOTON AÑADIR A JTABLE
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBounds(10, 407, 273, 23);
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Añadir();
				Sumarcolum();
				limpiar();
			}
		});

		// TEXTO DIA
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(119, 342, 86, 14);
		lblDia.setFont(new Font("Tahoma", Font.BOLD, 12));
		// TEXTO TIEMPO
		JLabel lblTiempo = new JLabel("Tiempo");
		lblTiempo.setBounds(15, 342, 81, 14);
		lblTiempo.setFont(new Font("Trebuchet MS", Font.BOLD, 12));

		// CAMPO DONDE EXPORTA EL TRABAJADOR
		Trabcombo = new JTextField();
		Trabcombo.setBounds(13, 43, 169, 20);
		// creamos una variable de string que sea igual a la captura del item
		String pro = this.comboBox.getSelectedItem().toString();
		// con un setText que nos pase la variable por su constructor mostramos
		// el resultado
		Trabcombo.setText(pro);
		Trabcombo.setEditable(false);
		Trabcombo.setColumns(10);

		JLabel lblTrabajador = new JLabel("Trabajador");
		lblTrabajador.setBounds(13, 18, 169, 14);
		lblTrabajador.setFont(new Font("Trebuchet MS", Font.BOLD, 12));

		final JButton btnGuartarEnArchivo = new JButton("Guardar Parte");
		btnGuartarEnArchivo.setBounds(953, 384, 197, 23);
		btnGuartarEnArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser elegir = new JFileChooser();
				int opcion = elegir.showOpenDialog(btnGuartarEnArchivo);
				if (opcion == JFileChooser.APPROVE_OPTION) {
					String pathArchivo = elegir.getSelectedFile().getPath();
					// Obtiene path del archivo
					String nombre = elegir.getSelectedFile().getName();
					// obtiene nombre del archivo
					int tamaño = (int) elegir.getSelectedFile().getUsableSpace();
					String fich1 = elegir.getSelectedFile().getParent();
					Trabcombo.setText(nombre);
				}
			}
		});

		textField_5 = new JTextField();
		textField_5.setBounds(1064, 353, 86, 20);
		textField_5.setColumns(10);

		JLabel lblTotalHorasDiarias = new JLabel("Total horas diarias");
		lblTotalHorasDiarias.setBounds(1031, 315, 119, 20);
		lblTotalHorasDiarias.setFont(new Font("Tahoma", Font.BOLD, 12));

		client = new JComboBox<Clientes>();
		client.setBounds(13, 99, 169, 22);
		leerclient();

		// boton de creacion de clientes con acceso
		JButton button = new JButton("+");
		button.setBounds(207, 80, 89, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				acceso();
				newcliente();
				opencli();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(354, 31, 796, 259);

		// Jtable
		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo);
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "N\u00BA parte", "Dia", "Cliente", "Trabajo Ralizado", "Trabajador", "Horas" }));
		table.getColumnModel().getColumn(3).setPreferredWidth(216);
		scrollPane.setViewportView(table);
		contentPane.setLayout(null);
		contentPane.add(lblCliente);
		contentPane.add(textField);
		contentPane.add(lblTrabajoRealizado);
		contentPane.add(textField_1);
		contentPane.add(textField_2);
		contentPane.add(btnAadir);
		contentPane.add(lblDia);
		contentPane.add(lblTiempo);
		contentPane.add(Trabcombo);
		contentPane.add(lblTrabajador);
		contentPane.add(btnGuartarEnArchivo);
		contentPane.add(textField_5);
		contentPane.add(lblTotalHorasDiarias);
		contentPane.add(client);
		contentPane.add(button);
		contentPane.add(scrollPane);
		
		//boton de borrar clientes 
		JButton button_1 = new JButton("-");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				bs.borrarcliente(client);

			}

		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_1.setBounds(207, 114, 89, 23);
		contentPane.add(button_1);

		JLabel lblNParteTrabajo = new JLabel("N\u00BA Parte trabajo");
		lblNParteTrabajo.setForeground(new Color(0, 0, 0));
		lblNParteTrabajo.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		lblNParteTrabajo.setBounds(13, 163, 109, 14);
		contentPane.add(lblNParteTrabajo);

		JButton btnBorrarLinea = new JButton("Borrar Linea");
		btnBorrarLinea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrarlinea();
				Sumarcolum();
			}
		});
		btnBorrarLinea.setBounds(354, 308, 109, 23);
		contentPane.add(btnBorrarLinea);

		JButton btnNuevoParte = new JButton("Nuevo Parte");
		btnNuevoParte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				generarparte();
			}

		});
		btnNuevoParte.setBounds(120, 187, 176, 23);
		contentPane.add(btnNuevoParte);
		
		combopart = new JComboBox <Base_datos>();
		combopart.setBounds(13, 188, 89, 20);
		contentPane.add(combopart);

	}

	public void leerclient() {
		comboBox.removeAllItems();
		bs.leercli(client);

	}

	// metodo para capturar fecha automaticamente.
	public static String fechaactual() {
		Date fecha = new Date();
		SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
		return formatofecha.format(fecha);

	}

	// Metodo para acceso con contraseña
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

	public void newcliente() {
		cliente = new Clientes();

	}

	private void opencli() {

		ventanaclientes = new cli(cliente, this.client, bs);
		ventanaclientes.setVisible(true);
		ventanaclientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	// Metodo para añadir filas a el jtable
	public void Añadir() {

		int numcolum = table.getModel().getColumnCount();
		Object[] fila = new Object[numcolum];

		String Trealizado = "";
		String clientes = "";
		String Trbajad = "";
		String temp1 = "";
		String day1 = "";
		String nparte = "";
		int num = 0;
		int tiempo = 0;

		try {
			Trealizado = textField.getText();
			clientes = client.getSelectedItem().toString();
			Trbajad = Trabcombo.getText();
			temp1 = textField_1.getText();
			day1 = textField_2.getText();
			nparte = (String) combopart.getSelectedItem();
			num = Integer.parseInt(nparte);
			tiempo = Integer.parseInt(temp1);

			fila[0] = num;
			fila[1] = day1;
			fila[2] = clientes;
			fila[3] = Trealizado;
			fila[4] = Trbajad;
			fila[5] = tiempo;
			((DefaultTableModel) table.getModel()).addRow(fila);

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Introduzca todos los datos");
		}

	}

	// metodo para sumar columnas
	public void Sumarcolum() {

		double sumatoria1 = 0.0;
		int totalRow = table.getRowCount();
		totalRow -= 1;
		for (int i = 0; i <= (totalRow); i++) {
			double sumatoria = Double.parseDouble(String.valueOf(table.getValueAt(i, 5)));
			// en la parte de arriba indica el primer parametro la fila y el
			// segundo la columna la cual estaras //manejando
			sumatoria1 += sumatoria;
			// para cojer lasuma de las horas y mostrarla por el textfield
			textField_5.setText(String.valueOf(sumatoria1));

		}

	}

	// metodo para borrar linea seleccionada
	public void borrarlinea() {
		try{
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.removeRow(table.getSelectedRow());
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Seleccione Una Linea");
			
			
		}
	}

	public void limpiar() {
		textField.setText("");
		//combopart.;("");
		textField_1.setText("");

	}

	public void generarparte() {
		
	bs.generarparte();

		

	}
}
