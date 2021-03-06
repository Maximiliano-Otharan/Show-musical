package Proyecto;
import java.util.ArrayList;
import filtros.Filtro;

public class Banda extends ElementoParticipanteAbs {
	
	private ArrayList<ElementoParticipanteAbs> miembros;

	public Banda(String nombre) {
		super(nombre);
		this.miembros = new ArrayList<>();
	}
	
	@Override
	public int getEdad() {
		int promedio = 0;
		int suma = 0;
		
		for (ElementoParticipanteAbs m: miembros) {
			suma += m.getEdad();
			promedio++;
		}
		
		return suma/promedio;
	}
	
	public void addMiembros(Participante participante) {
		if((!this.miembros.contains(participante)) && (participante.getBanda()==null)) {
			this.miembros.add(participante);
			participante.unoBanda(this);
		}
	}
	
	public ArrayList<ElementoParticipanteAbs> getListaDeMiembros(){
		ArrayList<ElementoParticipanteAbs> participantes = new ArrayList<>();
		participantes.addAll(this.miembros);
		return participantes;
	}

	@Override
	public ArrayList<String> getListaDeGeneros() {
		ArrayList<String> duplicado = new ArrayList<>();
		ArrayList<String> aux = new ArrayList<>();
		int cant = -1;
		int control = 0;
		for (ElementoParticipanteAbs m: miembros) {
			duplicado.addAll(m.getListaDeGeneros());
		}
	
		for (String d: duplicado) {
			for (String d2: duplicado) {
				if(d2.equals(d)) {
					cant++;
				}
			}
			control = cant + duplicado.size();
			if(control>duplicado.size()) {
				if(!aux.contains(d)) {
					aux.add(d);
				}
			}
			cant = -1;
		}
		return aux;
	}

	@Override
	public ArrayList<String> getListaDeIdiomas() {
		ArrayList<String> todosIdiomas = new ArrayList<>();
		ArrayList<String> duplicado = new ArrayList<>();
		
		for (ElementoParticipanteAbs m: miembros) {
			todosIdiomas.addAll(m.getListaDeIdiomas());
		}
		
		for (String i: todosIdiomas) {
			if(!duplicado.contains(i)) {
				duplicado.add(i);
			}
		}
		
		return duplicado;
	}

	@Override
	public ArrayList<String> getListaDeInstrumentos() {
		ArrayList<String> todosInstrumentos = new ArrayList<>();
		ArrayList<String> duplicado = new ArrayList<>();
		
		for (ElementoParticipanteAbs m: miembros) {
			todosInstrumentos.addAll(m.getListaDeInstrumentos());
		}
		
		for (String i: todosInstrumentos) {
			if(!duplicado.contains(i)) {
				duplicado.add(i);
			}
		}
		
		return duplicado;
	}

	@Override
	public ArrayList<ElementoParticipanteAbs> getListaDeParticipantesConFiltro(Filtro f) {
		ArrayList<ElementoParticipanteAbs> banda = new ArrayList<>();
		
		if(f.cumple(this)) {
			banda.add(this);
		}else {
			banda.addAll(this.getListaDeParticipantesConFiltro(f));
		}
		
		return banda;
	}

	
	@Override
	public String toString() {
		return "La banda "+ this.getNombre() + " \n" + this.miembros +
				" \n Instrumentos: "+ this.getListaDeInstrumentos();
	}

	
	/*CORRECCION PUEDE INTERPRETAR CANCION*/
	@Override
	public boolean puedeInterpretarCancion(Cancion cancion) {
		for (ElementoParticipanteAbs elemento : miembros) {
			if(elemento.puedeInterpretarCancion(cancion)) {
				return true;
			}
		}
		return false;
	}


	

}
