package presentacion.vista;

import javax.swing.JPanel;

import entidad.Persona;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class panelEliminar extends JPanel {
	//Atributos
	private JList<Persona> list;
	private JLabel lblEliminarUsuarios; 
	private JButton btnEliminar;
	private JLabel lblUsuarioselec;
	
	
	//Getters y setters
	public JList getList() {
		return list;
	}

	public void setList(JList<Persona> list) {
		this.list = list;
	}

	public JLabel getLblEliminarUsuarios() {
		return lblEliminarUsuarios;
	}

	public void setLblEliminarUsuarios(JLabel lblEliminarUsuarios) {
		this.lblEliminarUsuarios = lblEliminarUsuarios;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	
	public panelEliminar() {
		this.setLayout(null);
		this.setBounds(50,50,504,427);
		JPanel panel = new JPanel(); 
		panel.setBounds(12,0,444,288);;
		this.add(panel);
		panel.setLayout(null);
		
		 lblEliminarUsuarios = new JLabel("Eliminar Usuarios");
		lblEliminarUsuarios.setBounds(157, 13, 114, 16);
		panel.add(lblEliminarUsuarios);
		
		 list = new JList();
		list.setBounds(72, 42, 337, 175);
		panel.add(list);
		
		 btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(73, 230, 122, 25);
		panel.add(btnEliminar);
		
		lblUsuarioselec = new JLabel("");
		lblUsuarioselec.setBounds(265, 234, 56, 16);
		panel.add(lblUsuarioselec);

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
