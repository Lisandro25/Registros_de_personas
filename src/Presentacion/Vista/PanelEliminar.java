package Presentacion.Vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Entidad.Persona;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelEliminar extends JPanel {

	private static final long serialVersionUID = 1L;

	private JList<Persona> listEliminar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	
	public PanelEliminar() {
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 30, 395, 135);
		add(scrollPane);
		
		listEliminar = new JList<Persona>();
		scrollPane.setColumnHeaderView(listEliminar);
		scrollPane.setViewportView(listEliminar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(103, 179, 194, 25);
		add(btnEliminar);
		
		
		
		JLabel lblEliminarUsuarios = new JLabel("Eliminar usuarios");
		lblEliminarUsuarios.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblEliminarUsuarios.setBounds(12, 0, 166, 15);
		add(lblEliminarUsuarios);

	}

	public JList<Persona> getListEliminar() {
		return listEliminar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	
	
}
