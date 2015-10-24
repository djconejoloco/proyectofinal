import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class cli extends JFrame {

	private JPanel contentPane;
	private JComboBox<Clientes> clientela;
	private Clientes cliente1;
	private JTextField textField;
	private boolean modifica;
	private Base_datos bs;
	

	public cli(Clientes micliente, JComboBox<Clientes> cli1, Base_datos basedat) {
		clientela = cli1;
		cliente1 = micliente;
		this.bs=basedat;
		

		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 169);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 42, 290, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNombreNuevoCliente = new JLabel("Nombre Nuevo Cliente");
		lblNombreNuevoCliente.setBounds(10, 17, 290, 14);
		contentPane.add(lblNombreNuevoCliente);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(10, 80, 89, 23);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarcli();
				dispose();

			}
		});
		contentPane.add(btnGuardar);
	}

	public void guardarcli() {

		try {
			cliente1.setNombre(textField.getText());

			if (!modifica) {

				clientela.addItem(cliente1);
				this.bs.nuevocliente(cliente1);

			} else {
				Clientes clientelegido = (Clientes) clientela.getSelectedItem();
				clientelegido.setNombre(cliente1.getNombre());
			}
		}

		catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,
					"valor incorrecto, introduce un numero");

		}
	}
}
