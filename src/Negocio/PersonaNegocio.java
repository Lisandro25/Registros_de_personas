package Negocio;

import java.util.List;

import javax.swing.JList;

import Entidad.Persona;

public interface PersonaNegocio {

	public boolean insert(Persona persona);
	public boolean update(Persona persona_a_modificar);
	public boolean delete(Persona persona_a_eliminar);
	public List<Persona> readAll();
	
	public void llenarJList(JList<Persona> JList);
	public boolean ExisteDNI(Persona persona);
	
}
