package Presentacion.Vista;


import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Entidad.Persona;


public class PanelListar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JTable TablaPersonas;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"Nombre", "Apellido","Dni"};
	
	public PanelListar() {
		setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(31, 13, 347, 183);
		add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		TablaPersonas = new JTable(modelPersonas);
		
		TablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(100);
		TablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		TablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		TablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		TablaPersonas.getColumnModel().getColumn(2).setPreferredWidth(100);
		TablaPersonas.getColumnModel().getColumn(2).setResizable(false);
		
		
		spPersonas.setViewportView(TablaPersonas);
	}
	
	
	
	public void llenarTabla(ArrayList<Persona> personasEnTabla) {
		// TODO Auto-generated method stub
		this.getModelPersonas().setRowCount(0);
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());
		
		for (Persona p : personasEnTabla) 
		{
			String dni = p.getDni();
			String nombre = p.getNombre();
			String apellido = p.getApellido();
			Object[] fila = {nombre,apellido,dni};
			this.getModelPersonas().addRow(fila);
		}
	}
	
	
	
	public DefaultTableModel getModelPersonas() {
		return modelPersonas;
	}
	
	public String[] getNombreColumnas() {
		return nombreColumnas;
	}
	
}
