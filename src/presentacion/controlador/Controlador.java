package presentacion.controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import presentacion.vista.*;
import negocio.PersonaNegocio;
import entidad.Persona;


public class Controlador implements ActionListener {
	private ventanaPrincipal ventanaPrincipal; 
	private PersonaNegocio pNeg;
	private panelAgregar pnlAgregar;
	private panelEliminar pnlEliminar;
	private panelListar pnlListar;
	private panelModificar pnlModificar;
	
	public Controlador (ventanaPrincipal vista, PersonaNegocio pNeg) {
		this.ventanaPrincipal = vista; 
		this.pNeg = pNeg;
		
		//Instancio Los paneles
		this.pnlAgregar = new panelAgregar();
		this.pnlEliminar = new panelEliminar();
		this.pnlListar = new panelListar();
		this.pnlModificar = new panelModificar();
		
		//Eventos del FRAME principla => ventanaPrincipal
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a -> EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMenuEliminar().addActionListener(a -> EventoClickMenu_AbrirPanel_EliminarPersona(a));
		this.ventanaPrincipal.getMenuListar().addActionListener(a -> EventoClickMenu_AbrirPanel_ListarPersona(a));
		this.ventanaPrincipal.getMenuModificar().addActionListener(a -> EventoClickMenu_AbrirPanel_ModificarPersona(a));
		
		//Eventos del PANEL AgregarPersonas 
		this.pnlAgregar.getBtnAceptar().addActionListener(a -> EventoClickBoton_AgregarPersona_PanelAgregar(a));
		
		//Eventos del PANEL EliminarPersona 
		this.pnlEliminar.getBtnEliminar().addActionListener(a -> EventoClickBoton_EliminarPersona_PanelEliminar(a));
		
		//Eventos del PANEL EliminarPersona 
		this.pnlModificar.getBtnModificar().addActionListener(a -> EventoClickBoton_ModificarPersona_PanelModificar(a));

		panelModificar pnlModificar = this.pnlModificar;
		this.pnlModificar.getList().addListSelectionListener(
				new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
					      if (pnlModificar.getList().getSelectedValue() != null) {
					    	  int index = e.getFirstIndex();
					    	  
					    	  Persona seleccion = (Persona) pnlModificar.getList().getModel().getElementAt(index);
					    	  pnlModificar.setTxtNombre(seleccion.getNombre());
					    	  pnlModificar.setTxtApellido(seleccion.getApellido());
					    	  pnlModificar.setTxtDni(seleccion.getDni());
					      }
				}});
				//a -> EventoValueChanged_ModificarPersona_PanelModificar(a));
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
	
	private void EventoClickMenu_AbrirPanel_ListarPersona(ActionEvent a) {
		List<Persona> lstPersona = pNeg.readAll();
		cargaList(lstPersona);
		pnlListar.show();
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlListar);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
		
		
	}
	public void cargaList(List<Persona> dataList) {
        //this.dataList = dataList;
		pnlEliminar.setListData(dataList);
		pnlListar.setListData(dataList);
		pnlModificar.setListData(dataList);
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
	
	private void EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a) {
		List<Persona> lstPersona = pNeg.readAll();
		cargaList(lstPersona);
		pnlModificar.show();
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlModificar);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
		
	}
	
	
	
	private void EventoClickBoton_ModificarPersona_PanelModificar(ActionEvent a) {
		// TODO Auto-generated method stub
		String msjAlerta="";
		Persona personaSelec = (Persona) pnlModificar.getList().getSelectedValue(); 
		 
		if (personaSelec != null) { 
			
			Boolean estado = pNeg.update(personaSelec);
			if (estado) { 
				this.pnlModificar.setTxtNombre(personaSelec.getNombre());
				this.pnlModificar.setTxtApellido(personaSelec.getApellido());
				this.pnlModificar.setTxtDni(personaSelec.getDni());
				List<Persona> lstPersona = pNeg.readAll();
				cargaList(lstPersona);
			}
		} 
		else {
			msjAlerta = "La persona seleccionada no se pudo eliminar.";
		}
		
		this.pnlModificar.mostrarMensaje(msjAlerta);
		
	}
	
	private void EventoValueChanged_ModificarPersona_PanelModificar(ListSelectionEvent a) {
		// Persona personaSelec = (Persona)
		
		
		
	}

	
	public void inicializar () {
		this.ventanaPrincipal.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	} 
	
	
}
