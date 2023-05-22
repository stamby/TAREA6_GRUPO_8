package presentacion.vista;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entidad.Persona;
import javax.swing.JTextField;

public class panelModificar extends JPanel {

	//Atributos
		private JList<Persona> list;
		private JLabel lblModificarUsuarios; 
		private JButton btnModificar;
		private JTextField txtApellido;
		private JTextField txtNombre;
		private JTextField txtDni;
		
		
		//Getters y setters
		public JList getList() {
			return list;
		}

		public void setList(JList<Persona> list) {
			this.list = list;
		}

		public JLabel getLblModificarUsuarios() {
			return lblModificarUsuarios;
		}

		public void setLblModificarUsuarios(JLabel lblModificarUsuarios) {
			this.lblModificarUsuarios = lblModificarUsuarios;
		}

		public JButton getBtnModificar() {
			return btnModificar;
		}

		public void setBtnModificar(JButton btnModificar) {
			this.btnModificar = btnModificar;
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

		public JTextField getTxtDni() {
			return txtDni;
		}

		public void setTxtDni(JTextField txtDni) {
			this.txtDni = txtDni;
		}
		
		public panelModificar() {
			this.setLayout(null);
			this.setBounds(50,50,504,427);
			JPanel panel = new JPanel(); 
			panel.setBounds(12,0,444,288);;
			this.add(panel);
			panel.setLayout(null);
			
				lblModificarUsuarios = new JLabel("Seleccione la persona que desea modificar");
			lblModificarUsuarios.setBounds(29, 13, 274, 16);
			panel.add(lblModificarUsuarios);
			
			 list = new JList();
			list.setBounds(29, 42, 403, 175);
			panel.add(list);
			
			 btnModificar = new JButton("Modificar");
			btnModificar.setBounds(343, 230, 89, 25);
			panel.add(btnModificar);
			
			txtApellido = new JTextField();
			txtApellido.setBounds(29, 230, 91, 25);
			panel.add(txtApellido);
			txtApellido.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(132, 230, 91, 25);
			panel.add(txtNombre);
			
			txtDni = new JTextField();
			txtDni.setColumns(10);
			txtDni.setBounds(236, 230, 91, 25);
			panel.add(txtDni);
			
			

		}
		

		public void show() { 
			this.setVisible(true);
		}
		
		public void setListData(List<Persona> data) {
	        list.setListData(data.toArray(new Persona[0]));
	    }
		
		public void mostrarMensaje(String msj) { 
			JOptionPane.showMessageDialog(null, msj);
		}
}
