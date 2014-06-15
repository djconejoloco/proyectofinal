import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;



public class Ventanatrabajadores extends JFrame {

	private JPanel contentPane;
	private Trabajadores trabajador;
	private JComboBox <Trabajadores>  trabaj;
	private boolean modifica;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	

	
	
	/**
	 * Create the frame.
	 */
	public Ventanatrabajadores(boolean modifica,JComboBox <Trabajadores>  trabaj , Trabajadores trabajador) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoNombreTrabador = new JLabel("Nuevo Nombre Trabador");
		lblNuevoNombreTrabador.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNuevoNombreTrabador.setBounds(27, 11, 165, 14);
		contentPane.add(lblNuevoNombreTrabador);
		
		textField = new JTextField();
		textField.setBounds(27, 36, 165, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblContrasea.setBounds(27, 67, 165, 14);
		contentPane.add(lblContrasea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(27, 92, 165, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		final JButton btnImagen = new JButton("Imagen");
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
		btnImagen.setBounds(27, 133, 165, 23);
		contentPane.add(btnImagen);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(27, 204, 165, 23);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFichero = new JLabel("Fichero");
		lblFichero.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblFichero.setBounds(27, 179, 165, 14);
		contentPane.add(lblFichero);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//accion para llamar al metodo donde almacenaremos en un archivo al pulsar guardar
				GuardarTrabajador();
				// esto hace que se cierre la ventana
				dispose();
			}
		});
		btnGuardar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnGuardar.setBounds(290, 78, 89, 103);
		contentPane.add(btnGuardar);
	}
	//metodo para guardar trabajador
	public void  GuardarTrabajador(){
		try{
		trabajador.setNombre(textField.getText());
		trabajador.setpassword(textField_1.getText());
		
		if(!modifica){
			trabaj.addItem(trabajador);
		}
		else
		{
			// si se modifica  se coge de aqui el nombre
			Trabajadores trabajadorelegido=(Trabajadores)trabaj.getSelectedItem();
			// con este  parametro se le cambia el nombre
			trabajadorelegido.setNombre(trabajador.getNombre());
			}}
		
		catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,"valor incorrecto, introduce un numero");
				
			}
			
		}	
		
}
