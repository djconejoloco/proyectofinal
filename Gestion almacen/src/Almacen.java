import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JFileChooser;



public class Almacen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table_1;
	private JTextField textField_4;
	private Trabajadores ventanatrabajador;
	private Principal almacenprincipal;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Almacen() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 564, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblCliente.setBounds(10, 89, 81, 14);
		contentPane.add(lblCliente);
		
		textField = new JTextField();
		textField.setBounds(10, 190, 305, 75);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTrabajoRealizado = new JLabel("Trabajo realizado");
		lblTrabajoRealizado.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblTrabajoRealizado.setBounds(10, 165, 124, 14);
		contentPane.add(lblTrabajoRealizado);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 301, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText(new Date().toString());
		textField_2.setBounds(124, 301, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBounds(225, 300, 89, 23);
		contentPane.add(btnAadir);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDia.setBounds(124, 276, 86, 14);
		contentPane.add(lblDia);
		
		JLabel lblTiempo = new JLabel("Tiempo");
		lblTiempo.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblTiempo.setBounds(10, 276, 81, 14);
		contentPane.add(lblTiempo);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(10, 43, 169, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		//textField_2.setText(String.valueOf(almacenprincipal.));
		
		JLabel lblTrabajador = new JLabel("Trabajador");
		lblTrabajador.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblTrabajador.setBounds(10, 18, 169, 14);
		contentPane.add(lblTrabajador);
		
		table_1 = new JTable();
		table_1.setBounds(341, 19, 197, 249);
		contentPane.add(table_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 114, 273, 23);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		final JButton btnGuartarEnArchivo = new JButton("Guartar en archivo");
		btnGuartarEnArchivo .setBounds(341, 300, 197, 23);
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
				String fich1= elegir.getSelectedFile().getParent();
			textField_3.setText(nombre); 
				}
			}
		});

	
		
		contentPane.add(btnGuartarEnArchivo);
	}}
