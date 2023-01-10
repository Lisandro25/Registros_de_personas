package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.PersonaDao;
import Entidad.Persona;

public class PersonaDaoImpl implements PersonaDao {

	private static final String insert = "INSERT INTO personas(Dni, Nombre, Apellido) VALUES(?,?,?)";
	private static final String update = "UPDATE personas SET Nombre=?, Apellido=? WHERE Dni=?";
	private static final String delete = "DELETE FROM personas WHERE Dni = ?";
	private static final String readAll = "SELECT * FROM personas";
	
	private static final String ExisteDNI = "SELECT * FROM personas WHERE Dni =?";
	
	@Override
	public boolean insert(Persona persona) {
		
		PreparedStatement Statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean InsertExitoso=false;
		try {
		    Statement = conexion.prepareStatement(insert);
			Statement.setString(1, persona.getDni());
			Statement.setString(2, persona.getNombre());
			Statement.setString(3, persona.getApellido());
			
			if(Statement.executeUpdate()> 0) {
				conexion.commit();
				InsertExitoso = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
		return InsertExitoso;
	}

	@Override
	public boolean update(Persona persona) {
		
		PreparedStatement Statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean UpdateExitoso = false;
		
		try {
			Statement = conexion.prepareStatement(update);
			Statement.setString(1, persona.getNombre());
			Statement.setString(2, persona.getApellido());
			Statement.setString(3, persona.getDni());
			
			if(Statement.executeUpdate()>0) {
				conexion.commit();
				UpdateExitoso = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return UpdateExitoso;
	}

	@Override
	public boolean delete(Persona persona) {
		
	    PreparedStatement Statement;
	    Connection conexion = Conexion.getConexion().getSQLConexion();
	    boolean DeleteExitoso = false;
	    
	    try {
	    	Statement = conexion.prepareStatement(delete);
	    	Statement.setString(1, persona.getDni());
	    	
	    	if(Statement.executeUpdate()>0) {
	    		conexion.commit();
	    		DeleteExitoso = true;
	    	}
	    	
	    }
	    catch(SQLException e) {
	    	e.printStackTrace();
	    }
		
		return DeleteExitoso;
	}

	@Override
	public List<Persona> readAll() {
		PreparedStatement Statement;
		ResultSet resultSet;
		ArrayList<Persona> Lpersonas= new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		
		try {
			Statement = conexion.getSQLConexion().prepareStatement(readAll);
			resultSet = Statement.executeQuery();
			while(resultSet.next()) {
				Lpersonas.add(getPersona(resultSet));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return Lpersonas;
	}
	
	private Persona getPersona(ResultSet resultSet) throws SQLException
	{
		String Nombre = resultSet.getString("Nombre");
		String Apellido = resultSet.getString("Apellido");
		String Dni = resultSet.getString("Dni");
		return new Persona( Nombre, Apellido, Dni);
	}

	@Override
	public boolean ExisteDNI(Persona persona) {

		PreparedStatement Statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		boolean Existedni = false; 
		
		try {
			Statement = conexion.getSQLConexion().prepareStatement(ExisteDNI);
			Statement.setString(1, persona.getDni());
			resultSet = Statement.executeQuery();
			if(resultSet.next()) {
				Existedni = true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return Existedni;
	}
	
	
	

}










