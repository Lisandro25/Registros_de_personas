package Main;

import Presentacion.Vista.Ventana_Principal;
import Negocio.PersonaNegocio;
import NegocioImpl.PersonaNegocioImpl;
import Presentacion.Controlador.Controlador;

public class Principal {

	public static void main(String[] args) {

		Ventana_Principal vista = new Ventana_Principal();
		PersonaNegocio negocio = new PersonaNegocioImpl();
		Controlador controlador = new Controlador(vista,negocio);
		controlador.inicializar();
	}
}
