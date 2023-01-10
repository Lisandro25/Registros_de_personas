package NegocioImpl;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Dao.PersonaDao;
import DaoImpl.PersonaDaoImpl;
import Entidad.Persona;
import Negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio {

	PersonaDao Pdao = new PersonaDaoImpl();
	
	@Override
	public boolean insert(Persona persona) {
		
		boolean estado = false;
		
		if(persona.getNombre().trim().length()>0 && persona.getApellido().trim().length()>0 && persona.getDni().trim().length()>0) {
		estado = Pdao.insert(persona);
		}
		
		return estado;
	}
	

	@Override
	public boolean update(Persona persona_a_modificar) {
		boolean estado = false;

		estado = Pdao.update(persona_a_modificar);
					
		return estado;
	}

	@Override
	public boolean delete(Persona persona_a_eliminar) {
		
		boolean estado = false;
		
		estado = Pdao.delete(persona_a_eliminar);
		
		return estado;
	}

	@Override
	public List<Persona> readAll() {
		return Pdao.readAll();
	}

	@Override
	public boolean ExisteDNI(Persona persona) {
		
		boolean estado = false;
		
		if(persona.getDni().trim().length() >0) {
			estado = Pdao.ExisteDNI(persona);
		}
		return estado;
	}


	@Override
	public void llenarJList(JList<Persona> JList) {
        
		DefaultListModel<Persona> model = new DefaultListModel<Persona>();
		
		List<Persona> Lista = Pdao.readAll();
				
		Lista.forEach((persona)->{
			model.addElement(persona);
		});
		JList.setModel(model);
		
	}

}




















