package Presentacion.Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import Entidad.Persona;
import NegocioImpl.PersonaNegocioImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelAgregar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	//PersonaNegocioImpl PerNeg;
	
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnAceptar;
	//private static DefaultListModel<Persona> listModel;

	
	public PanelAgregar() {
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(100, 13, 56, 16);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(100, 68, 56, 16);
		add(lblApellido);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(100, 123, 56, 16);
		add(lblDni);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(100, 177, 150, 25);
		add(btnAceptar);
		
		txtNombre = new JTextField();
		
		txtNombre.setBounds(215, 10, 150, 22);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		
		txtApellido.setBounds(215, 65, 150, 22);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(215, 120, 150, 22);
		add(txtDni);
		txtDni.setColumns(10);
    }
	
	
	
	public JTextField getTxtNombre() {
		return txtNombre;
	}



	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}



	public JTextField getTxtApellido() {
		return txtApellido;
	}



	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}



	public JTextField getTxtDni() {
		return txtDni;
	}



	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}



	public JButton getBtnAceptar() {
		return btnAceptar;
	}



	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}


	

}
