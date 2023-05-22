package negocioImpl;

import java.util.List;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;


public class PersonaNegocioImpl implements PersonaNegocio {
	PersonaDao pdao = new PersonaDaoImpl();
	
	private boolean validoDNI (String DNI) { 
		try {
			boolean estado=true;
			int dniIngresado = Integer.parseInt(DNI); 
			return true;
		}
		catch (Exception Ex) { 
			return false;
		}
	}
	
	public boolean insert(Persona persona) {
		
		boolean estado=false;
		if(persona.getNombre().trim().length()>0 && persona.getDni().trim().length()>0 && persona.getApellido().trim().length()>0)
		{
			boolean esValorNumerico = validoDNI(persona.getDni());
			if (esValorNumerico) { 
				estado = pdao.insert(persona);
			}
		}
		return estado;
	}

	public boolean delete(Persona persona_a_eliminar) {
		boolean estado=false;
		if(persona_a_eliminar.getDni().length()>0 )//Tambi�n se puede preguntar si existe ese ID 
		{
			estado=pdao.delete(persona_a_eliminar);
		}
		return estado;
	}
	
	public boolean update(Persona persona) {
		boolean estado=false;
		boolean esValorNumerico = validoDNI(persona.getDni());
		if (esValorNumerico) { 
			estado = pdao.update(persona);
		}
		return estado;
	}

	public List<Persona> readAll() {
		return pdao.readAll();
	}
}
