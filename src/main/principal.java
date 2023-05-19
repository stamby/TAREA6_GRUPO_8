package main;
import presentacion.vista.*;
import presentacion.controlador.Controlador;
import negocioImpl.PersonaNegocioImpl;
import negocio.PersonaNegocio;
import daoImpl.PersonaDaoImpl;
public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ventanaPrincipal vista = new ventanaPrincipal(); 
		PersonaNegocio negocio = new PersonaNegocioImpl();
		Controlador controlador = new Controlador(vista, negocio); 
		controlador.inicializar();
		
	}

}
