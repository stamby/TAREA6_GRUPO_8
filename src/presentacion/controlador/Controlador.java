package presentacion.controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;

import presentacion.vista.*;
import negocio.PersonaNegocio;
import entidad.Persona;


public class Controlador implements ActionListener {
	private ventanaPrincipal ventanaPrincipal; 
	private PersonaNegocio pNeg;
	private panelAgregar pnlAgregar;
	private panelEliminar pnlEliminar;
	
	public Controlador (ventanaPrincipal vista, PersonaNegocio pNeg) {
		this.ventanaPrincipal = vista; 
		this.pNeg = pNeg;
		
		//Instancio Los paneles
		this.pnlAgregar = new panelAgregar();
		this.pnlEliminar = new panelEliminar();
		
		//Eventos del FRAME principla => ventanaPrincipal
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a -> EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMenuEliminar().addActionListener(a -> EventoClickMenu_AbrirPanel_EliminarPersona(a));
		
		//Eventos del PANEL AgregarPersonas 
		this.pnlAgregar.getBtnAceptar().addActionListener(a -> EventoClickBoton_AgregarPersona_PanelAgregar(a));
		
		//Eventos del PANEL EliminarPersona 
		this.pnlEliminar.getBtnEliminar().addActionListener(a -> EventoClickBoton_EliminarPersona_PanelEliminar(a));
		
	}
	

	private void EventoClickBoton_EliminarPersona_PanelEliminar(ActionEvent a) {
		// TODO Auto-generated method stub
		String msjAlerta="";
		Persona personaSelec = (Persona) pnlEliminar.getList().getSelectedValue(); 
		 
		if (personaSelec != null) { 
			Boolean estado = pNeg.delete(personaSelec);
			if (estado) { 
				 
				msjAlerta = "Se ha eliminado correctamente.";
				List<Persona> lstPersona = pNeg.readAll();
				cargaList(lstPersona);
			}
		} 
		else {
			msjAlerta = "La persona seleccionada no se pudo eliminar.";
		}
		
		this.pnlEliminar.mostrarMensaje(msjAlerta);
		
	}


	private void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a) {
		List<Persona> lstPersona = pNeg.readAll();
		cargaList(lstPersona);
		pnlEliminar.show();
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlEliminar);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
		
		
	}
	public void cargaList(List<Persona> dataList) {
        //this.dataList = dataList;
		pnlEliminar.setListData(dataList);
    }

	private void EventoClickBoton_AgregarPersona_PanelAgregar(ActionEvent a) {
		// TODO Auto-generated method stub
		String msj;
		String Dni = this.pnlAgregar.getTxtDni().getText();
		String nombre = this.pnlAgregar.getTxtNombre().getText();
		String apellido = this.pnlAgregar.getTxtApellido().getText();
		Persona nuevaPersona = new Persona(Dni, nombre, apellido);
		
		boolean estado = pNeg.insert(nuevaPersona);
		
		if (estado) { 
			msj = "Persona agregada correctamente.";
			this.pnlAgregar.getTxtNombre().setText("");
			this.pnlAgregar.getTxtApellido().setText("");
			this.pnlAgregar.getTxtDni().setText("");
		}
		else { 
			msj = "Persona no agregada, revise los campos.";
		}
		this.pnlAgregar.mostrarMensaje(msj);
		
	}

	private void EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a) {
		pnlAgregar.show();
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlAgregar);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}

	
	public void inicializar () {
		this.ventanaPrincipal.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	} 
	
	
}
