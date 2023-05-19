package presentacion.controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentacion.vista.*;
import negocio.PersonaNegocio;
import entidad.Persona;


public class Controlador implements ActionListener {
	private ventanaPrincipal ventanaPrincipal; 
	private PersonaNegocio pNeg;
	private panelAgregar pnlAgregar;
	
	
	public Controlador (ventanaPrincipal vista, PersonaNegocio pNeg) {
		this.ventanaPrincipal = vista; 
		this.pNeg = pNeg;
		
		//Instancio Los paneles
		this.pnlAgregar = new panelAgregar();
		
		
		//Eventos del FRAME principla => ventanaPrincipal
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a -> EventoClickMenu_AbrirPanel_AgregarPersona(a));
		
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
