import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.JButton;





public class Ventanatrabajadores extends JFrame {

	private JPanel contentPane;
	private Trabajadores trabajador;
	private JComboBox<Trabajadores> trabajador2;
	private boolean modifica;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	private Base_datos bs;
	  


	/**
	 * Create the frame.
	 */
	public Ventanatrabajadores(Trabajadores miTrabajador, JComboBox<Trabajadores> micombobox, Base_datos bsdatos) {
		trabajador = miTrabajador;
		this.bs= bsdatos;
		trabajador2=micombobox;
		
		
		
		
		
		
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoNombreTrabador = new JLabel("Nuevo Nombre Trabajador");
		lblNuevoNombreTrabador.setBounds(27, 11, 165, 14);
		lblNuevoNombreTrabador.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		contentPane.add(lblNuevoNombreTrabador);
		
		textField = new JTextField();
		textField.setBounds(27, 36, 165, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(27, 67, 165, 14);
		lblContrasea.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		contentPane.add(lblContrasea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(27, 92, 165, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		final JButton btnImagen = new JButton("Imagen");
		btnImagen.setBounds(27, 133, 165, 23);
		 btnImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser elegir = new JFileChooser();
				int opcion = elegir.showOpenDialog(btnImagen);
				if (opcion == JFileChooser.APPROVE_OPTION) {
					String pathArchivo = elegir.getSelectedFile().getPath();
					// Obtiene path del archivo
					String nombre = elegir.getSelectedFile().getName();
					// obtiene nombre del archivo
					int tamaño = (int) elegir.getSelectedFile().getUsableSpace();
					String fich1= elegir.getSelectedFile().getParent();
					textField_2.setText(nombre);
					
				}
			}
		});
			getContentPane().add(btnImagen);
			



		btnImagen.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		contentPane.add(btnImagen);
		
		textField_2 = new JTextField();
		textField_2.setBounds(27, 204, 165, 23);
		textField_2.setEditable(false);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFichero = new JLabel("Fichero");
		lblFichero.setBounds(27, 179, 165, 14);
		lblFichero.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		contentPane.add(lblFichero);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(290, 78, 89, 103);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//accion para llamar al metodo donde almacenaremos en un archivo al pulsar guardar
				GuardarTrabajador();
				// esto hace que se cierre la ventana
				dispose();
			}
		});
		btnGuardar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		contentPane.add(btnGuardar);
		
	}






	//metodo para guardar trabajador
	public void  GuardarTrabajador(){
		try{
		trabajador.setNombre(textField.getText());
		trabajador.setpassword(textField_1.getText());
		
		if(!modifica){
			trabajador2.addItem(trabajador);
		
			this.bs.guardarenBD();
		}
		else
		{
			// si se modifica  se coge de aqui el nombre
			Trabajadores trabajadorelegido=(Trabajadores)trabajador2.getSelectedItem();
			// con este  parametro se le cambia el nombre
			trabajadorelegido.setNombre(trabajador.getNombre());
			}}
		
		catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,"valor incorrecto, introduce un numero");
				
			}
			
		}		// metodo que recoge en que fichero guardar el equipo

		
}
