	package Proyecto;


import java.util.ArrayList;
import filtros.Filtro;

public abstract class ElementoParticipanteAbs{
	
	private String nombre;
	
	
	public ElementoParticipanteAbs(String nombre) {
		this.nombre = nombre;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public abstract int getEdad();
	
	public abstract ArrayList<String> getListaDeGeneros();
	
	public abstract ArrayList<String> getListaDeIdiomas();
	
	public abstract ArrayList<String> getListaDeInstrumentos();
	
	public abstract ArrayList<ElementoParticipanteAbs> getListaDeParticipantesConFiltro(Filtro f);
	
	
	/*CORRECCION PUEDE INTERPRETAR CANCION*/
	public abstract boolean puedeInterpretarCancion(Cancion cancion);
	
	
	

}
