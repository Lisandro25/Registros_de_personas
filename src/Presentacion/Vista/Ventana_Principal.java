package Presentacion.Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidad.Persona;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JMenuItem ItemAgregar;
	private JMenuItem ItemModificar;
	private JMenuItem ItemEliminar;
	private JMenuItem ItemListar;
	
	//private static DefaultListModel<Persona> listModel;

	
	public Ventana_Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu MenuPersona = new JMenu("Persona");
		menuBar.add(MenuPersona);
		
		ItemAgregar = new JMenuItem("Agregar");
		MenuPersona.add(ItemAgregar);
		
		
		ItemModificar = new JMenuItem("Modificar");
		MenuPersona.add(ItemModificar);
		
		
		ItemEliminar = new JMenuItem("Eliminar");
		MenuPersona.add(ItemEliminar);
		
		
		
		ItemListar = new JMenuItem("Listar");
		MenuPersona.add(ItemListar);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	

	public JMenuItem getItemAgregar() {
		return ItemAgregar;
	}

	public void setItemAgregar(JMenuItem itemAgregar) {
		ItemAgregar = itemAgregar;
	}

	public JMenuItem getItemModificar() {
		return ItemModificar;
	}

	public void setItemModificar(JMenuItem itemModificar) {
		ItemModificar = itemModificar;
	}

	public JMenuItem getItemEliminar() {
		return ItemEliminar;
	}

	public void setItemEliminar(JMenuItem itemEliminar) {
		ItemEliminar = itemEliminar;
	}

	public JMenuItem getItemListar() {
		return ItemListar;
	}

	public void setItemListar(JMenuItem itemListar) {
		ItemListar = itemListar;
	}
	
	

}
