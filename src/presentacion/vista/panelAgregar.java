package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class panelAgregar extends JPanel {
	public JTextField getTxtDni() {
		return txtDni;
	}

	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	private JTextField txtDni;
	private JTextField txtApellido;
	private JTextField txtNombre;


	public panelAgregar() {
		super(); 
		initialize();
	}
	
	private void initialize () { 
		this.setLayout(null);
		this.setBounds(50,50,504,427);
		JPanel panel = new JPanel(); 
		panel.setBounds(12,13,444,227);;
		this.add(panel);
		panel.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI: ");
		lblDni.setBounds(24, 29, 56, 16);
		panel.add(lblDni);
		
		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setBounds(24, 68, 56, 16);
		panel.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(24, 117, 56, 16);
		panel.add(lblNombre);
		
		txtDni = new JTextField();
		txtDni.setBounds(92, 26, 144, 22);
		panel.add(txtDni);
		txtDni.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(92, 65, 144, 22);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(92, 114, 144, 22);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(24, 165, 152, 25);
		panel.add(btnAceptar);
	}
	
	public void show () {
		this.setVisible(true);
	}
}
