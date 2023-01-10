package Presentacion.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;

import Entidad.Persona;
import Negocio.PersonaNegocio;
import Presentacion.Vista.PanelAgregar;
import Presentacion.Vista.PanelModificar;
import Presentacion.Vista.PanelEliminar;
import Presentacion.Vista.PanelListar;
import Presentacion.Vista.Ventana_Principal;


public class Controlador implements ActionListener{

	private Ventana_Principal ventanaPrincipal;
	private PersonaNegocio Pneg;
	
	private PanelAgregar PanelAgregar;
	private PanelModificar PanelModificar;
	private PanelEliminar PanelEliminar;
	private PanelListar PanelListar;
	
	private ArrayList<Persona> personasEnTabla;
	
	public Controlador(Ventana_Principal vista, PersonaNegocio pNeg) {
		this.ventanaPrincipal = vista;
		this.Pneg = pNeg;
		
		this.PanelAgregar = new PanelAgregar();
		this.PanelModificar = new PanelModificar();
		this.PanelListar = new PanelListar();
		this.PanelEliminar = new PanelEliminar();
		
		
		this.ventanaPrincipal.getItemAgregar().addActionListener(a->EventoAbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getItemModificar().addActionListener(a->EventoAbrirPanel_ModificarPersona(a));
		this.ventanaPrincipal.getItemEliminar().addActionListener(a->EventoAbrirPanel_EliminarPersona(a));
		this.ventanaPrincipal.getItemListar().addActionListener(a->EventoAbrirPanel_ListarPersona(a));
		
		
		
		///SOLO INGRESO DE LETRAS EN TXTNOMBRE DE MODIFICAR
		this.PanelModificar.getTxtNombreMostrar().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				int key = arg0.getKeyChar();
				
				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean espacio = key == 32;
				
				if (!(minusculas || mayusculas || espacio))arg0.consume();
			}
		});
		
		///SOLO INGRESO DE LETRAS EN TXTAPELLIDO DE MODIFICAR
		this.PanelModificar.getTxtApellidoMostrar().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				int key = arg0.getKeyChar();
				
				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean espacio = key == 32;
				
				if (!(minusculas || mayusculas || espacio))arg0.consume();
			}
		});
		
		///AGREGAR
		this.PanelAgregar.getBtnAceptar().addActionListener(a->EventoAgregarPersona(a));
		
			
		///VALIDACION DE LETRAS
		this.PanelAgregar.getTxtNombre().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

			    boolean mayusculas = key >= 65 && key <= 90;
			    boolean minusculas = key >= 97 && key <= 122;
			    boolean espacio = key == 32;
			            
			     if (!(minusculas || mayusculas || espacio)) e.consume();
			}
		});
		
		///VALIDACION DE LETRAS
		this.PanelAgregar.getTxtApellido().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				int key = arg0.getKeyChar();

			    boolean mayusculas = key >= 65 && key <= 90;
			    boolean minusculas = key >= 97 && key <= 122;
			    boolean espacio = key == 32;
			            
			     if (!(minusculas || mayusculas || espacio))arg0.consume();
			}
		});
		
		///VALIDACION DE NUMEROS
		this.PanelAgregar.getTxtDni().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (!(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')) ke.consume();				
			}
		});
		
		
		
		///RELLENAR TXT
		this.PanelModificar.getListPersonas().addListSelectionListener(a->EventoClickLista_ModificarPersona(a));
		//MODIFICAR
		this.PanelModificar.getBtnModificar().addActionListener(a->EventoBoton_ModifcarPersona(a));
		
		
		//ELIMINAR
		this.PanelEliminar.getBtnEliminar().addActionListener(a->EventoBoton_EliminarPersona(a));
		
	}
	///ABRIR AGREGAR PERSONA
	private void EventoAbrirPanel_AgregarPersona(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(PanelAgregar);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	///ABRIR MODIFICAR PERSONA
	private void EventoAbrirPanel_ModificarPersona(ActionEvent a) {
		PanelModificar_LimpiarTXT();
		Pneg.llenarJList(PanelModificar.getListPersonas());
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(PanelModificar);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	//ABRIR ELIMINAR PERSONA
	private void EventoAbrirPanel_EliminarPersona(ActionEvent a) {
		Pneg.llenarJList(PanelEliminar.getListEliminar());
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(PanelEliminar);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	//ABRIR LISTAR PERSONAS
	private void EventoAbrirPanel_ListarPersona(ActionEvent a) {
		refrescarTabla();
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(PanelListar);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	
	
	///EVENTO AGREGAR
	private void EventoAgregarPersona(ActionEvent a) {
		String Nombre = this.PanelAgregar.getTxtNombre().getText().trim();
		String Apellido = this.PanelAgregar.getTxtApellido().getText().trim();
		String Dni = this.PanelAgregar.getTxtDni().getText().trim();
		Persona persona = new Persona(Nombre, Apellido, Dni);
		
		String Mensaje;
		
		if(!Pneg.ExisteDNI(persona)) {
			
			if(Pneg.insert(persona)) Mensaje="Persona agregada con Exito";
			else Mensaje="Debe completar todos los campos";
		}
		else Mensaje="El DNI ingresado ya existe en la BD";
			
		mostrarMensaje(Mensaje);
		PanelAgregar_LimpiarTXT();
		refrescarTabla();
	}
	
	///EVENTO RELLENAR TXT PARA MODIFICAR
	private void EventoClickLista_ModificarPersona(ListSelectionEvent Listener) {
		Persona P1 = PanelModificar.getListPersonas().getSelectedValue();
		if(P1!=null) {
			PanelModificar.getTxtNombreMostrar().setText(P1.getNombre());
			PanelModificar.getTxtApellidoMostrar().setText(P1.getApellido());
			PanelModificar.getTxtDniMostrar().setText(P1.getDni());
		}
	}
	
	///EVENTO MODIFICAR
	private void EventoBoton_ModifcarPersona(ActionEvent a) {
		String Nombre = PanelModificar.getTxtNombreMostrar().getText().trim();
		String Apellido = PanelModificar.getTxtApellidoMostrar().getText().trim();
		String Dni = PanelModificar.getTxtDniMostrar().getText().trim();
		Persona P1 = new Persona(Nombre,Apellido, Dni);
		
		if(PanelModificar.getTxtNombreMostrar().getText().trim().length()>0 && 
			PanelModificar.getTxtApellidoMostrar().getText().trim().length()>0) {
			
			if(Pneg.update(P1)) {
				mostrarMensaje("Persona Modificada con EXITO");
			}
			else mostrarMensaje("ERROR al modificar");
			
		} else mostrarMensaje("ERROR al modificar, se encontro un Campo VACIO");
		
		Pneg.llenarJList(PanelModificar.getListPersonas());
		PanelModificar_LimpiarTXT();
	}
	
	
	
	///EVENTO ELIMINAR
	private void EventoBoton_EliminarPersona(ActionEvent a) {
		if(PanelEliminar.getListEliminar().getSelectedValue() !=null) {
			if(Pneg.delete(PanelEliminar.getListEliminar().getSelectedValue())) {
				Pneg.llenarJList(PanelEliminar.getListEliminar());
				mostrarMensaje("Persona Eliminada con EXITO!");
			}
			else mostrarMensaje("La persona no se pudo eliminar");
		}
		else mostrarMensaje("Debe seleccionar una persona para eliminar!");
		
	}
	
	
	
	public void inicializar() {
		this.ventanaPrincipal.setVisible(true);
	}
	
	private void refrescarTabla()
	{
		this.personasEnTabla = (ArrayList<Persona>) Pneg.readAll();
		this.PanelListar.llenarTabla(this.personasEnTabla);
	}
	
	
	private void PanelModificar_LimpiarTXT() {
		PanelModificar.getTxtNombreMostrar().setText("");
		PanelModificar.getTxtApellidoMostrar().setText("");
		PanelModificar.getTxtDniMostrar().setText("");
	}
	
	private void PanelAgregar_LimpiarTXT() {
	   PanelAgregar.getTxtNombre().setText("");
	   PanelAgregar.getTxtApellido().setText("");
	   PanelAgregar.getTxtDni().setText("");
	}	
	
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}

	
}
