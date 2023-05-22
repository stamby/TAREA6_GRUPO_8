package presentacion.vista;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entidad.Persona;

public class panelListar extends JPanel {

	//Atributos
		private JList<Persona> list;
		private JLabel lblListarUsuarios; 
		
		
		//Getters y setters
		public JList getList() {
			return list;
		}

		public void setList(JList<Persona> list) {
			this.list = list;
		}

		public JLabel getLblListarUsuarios() {
			return lblListarUsuarios;
		}

		public void setLblListarUsuarios(JLabel lblListarUsuarios) {
			this.lblListarUsuarios = lblListarUsuarios;
		}

		
		public panelListar() {
			this.setLayout(null);
			this.setBounds(50,50,504,427);
			JPanel panel = new JPanel(); 
			panel.setBounds(12,0,444,288);;
			this.add(panel);
			panel.setLayout(null);
			
			lblListarUsuarios = new JLabel("Listar Usuarios");
			lblListarUsuarios.setBounds(157, 13, 114, 16);
			panel.add(lblListarUsuarios);
			
			list = new JList<Persona>();
			list.setBounds(72, 42, 337, 175);
			panel.add(list);

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
