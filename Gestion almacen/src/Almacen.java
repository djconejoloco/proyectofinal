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
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;



public class Almacen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private Trabajadores ventanatrabajador;
	
	private JTable table;
	 Principal p= new Principal();
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Almacen() {
		setTitle("Almacen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 606, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10, 89, 81, 14);
		lblCliente.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		contentPane.add(lblCliente);
		
		textField = new JTextField();
		textField.setBounds(10, 190, 305, 75);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTrabajoRealizado = new JLabel("Trabajo realizado");
		lblTrabajoRealizado.setBounds(10, 165, 124, 14);
		lblTrabajoRealizado.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		contentPane.add(lblTrabajoRealizado);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 301, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(124, 301, 86, 20);
		textField_2.setText(new Date().toString());
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBounds(225, 300, 89, 23);
		contentPane.add(btnAadir);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(124, 276, 86, 14);
		lblDia.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblDia);
		
		JLabel lblTiempo = new JLabel("Tiempo");
		lblTiempo.setBounds(10, 276, 81, 14);
		lblTiempo.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		contentPane.add(lblTiempo);
		
		textField_3 = new JTextField();
		textField_3.setText(String.valueOf(p.comboBox.getSelectedItem()));
		textField_3.setBounds(10, 43, 169, 20);
		textField_3.setEditable(false);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	
		
		JLabel lblTrabajador = new JLabel("Trabajador");
		lblTrabajador.setBounds(10, 18, 169, 14);
		lblTrabajador.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		contentPane.add(lblTrabajador);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 114, 273, 23);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		final JButton btnGuartarEnArchivo = new JButton("Guartar en archivo");
		btnGuartarEnArchivo.setBounds(341, 300, 197, 23);
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
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setBounds(325, 18, 265, 256);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Trabajador", "Cliente", "Trabajo realizado", "Tiempo", "Dia"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(129);
		table.getColumnModel().getColumn(2).setPreferredWidth(236);
		table.getColumnModel().getColumn(3).setPreferredWidth(98);
		table.getColumnModel().getColumn(4).setPreferredWidth(91);
		table.setBackground(SystemColor.inactiveCaption);
		contentPane.add(table);
	}	
}
