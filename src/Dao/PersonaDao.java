package Dao;

import java.util.List;

import Entidad.Persona;

public interface PersonaDao {

	public boolean insert(Persona persona);
	public boolean update(Persona persona_a_modificar);
	public boolean delete(Persona persona_a_eliminar);
	public List<Persona> readAll();
	
	public boolean ExisteDNI(Persona persona);
}
