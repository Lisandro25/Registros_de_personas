package Presentacion.Vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;

import Entidad.Persona;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelModificar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txtNombreMostrar;
	private JTextField txtApellidoMostrar;
	private JTextField txtDniMostrar;
	private JScrollPane scrollPane;
    private JList<Persona> listPersonas;
    private JButton btnModificar;
    
    /**
	 * Create the panel.
	 */
	public PanelModificar() {
		setLayout(null);
		
		JLabel lblSeleccione = new JLabel("Seleccione la persona que desea modificar");
		lblSeleccione.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSeleccione.setBounds(12, 0, 381, 16);
		add(lblSeleccione);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 27, 381, 137);
		add(scrollPane);
		
		listPersonas = new JList<Persona>();
		listPersonas.setBounds(12, 27, 381, 137);
		scrollPane.setViewportView(listPersonas);
		//add(listPersonas);
		
		txtNombreMostrar = new JTextField();
		txtNombreMostrar.setBounds(12, 196, 80, 20);
		add(txtNombreMostrar);
		txtNombreMostrar.setColumns(10);
		
		txtApellidoMostrar = new JTextField();
		txtApellidoMostrar.setBounds(104, 196, 80, 20);
		add(txtApellidoMostrar);
		txtApellidoMostrar.setColumns(10);
		
		txtDniMostrar = new JTextField();
		txtDniMostrar.setEditable(false);
		txtDniMostrar.setBounds(196, 196, 80, 20);
		add(txtDniMostrar);
		txtDniMostrar.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(288, 194, 105, 25);
		add(btnModificar);
	}

	public JTextField getTxtNombreMostrar() {
		return txtNombreMostrar;
	}

	public JTextField getTxtApellidoMostrar() {
		return txtApellidoMostrar;
	}

	public JTextField getTxtDniMostrar() {
		return txtDniMostrar;
	}

	public JList<Persona> getListPersonas() {
		return listPersonas;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}
	
	
	
}
