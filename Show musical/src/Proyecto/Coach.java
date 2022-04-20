package Proyecto;

import java.util.ArrayList;
import java.util.Collections;

import filtros.*;

public class Coach {

	/*Atributos*/
	protected String nombre, apellido;
	protected ArrayList<ElementoParticipanteAbs> participantes;
	
	/*Constructor*/
	public Coach(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.participantes = new ArrayList<>();
	}

	/*Getters*/
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	
	/*Adicionadores*/
	public void addParticipante (ElementoParticipanteAbs participante) {
		if(!participantes.contains(participante)) {
			participantes.add(participante);
		}
	}

	/*Listados*/
	public ArrayList<ElementoParticipanteAbs> getListaDeParticipantes(){
		ArrayList<ElementoParticipanteAbs> participantes = new ArrayList<>();
		participantes.addAll(this.participantes);
		return participantes;
	}
	
	/*Metodos*/
	
	public Double getPromedioEdad() {
		Double acumulador = 0.00;
		int cantParticipantes = this.participantes.size();
		for (ElementoParticipanteAbs participante : participantes) {
			acumulador+= participante.getEdad();
		}
		return acumulador/cantParticipantes;
	}
	
	/*Buscar/Criterio*/
	
	public ArrayList<String> getListaDeInstrumentos(){
		ArrayList<ElementoParticipanteAbs> participantes = this.getListaDeParticipantes();
		ArrayList<String> instrumentos = new ArrayList<>();
		ArrayList<String> aux = new ArrayList<>();
		
		for (ElementoParticipanteAbs participante : participantes) {
			instrumentos.addAll(participante.getListaDeInstrumentos());
			for (String instrumento : instrumentos) {
				if(!aux.contains(instrumento)) {
					aux.add(instrumento);
				}
			}
		}
		return aux;
	}
	
	public ArrayList<String> getListaDeIdiomas(){
		ArrayList<ElementoParticipanteAbs> participantes = this.getListaDeParticipantes();
		ArrayList<String> idiomas = new ArrayList<>();
		ArrayList<String> aux = new ArrayList<>();
		
		for (ElementoParticipanteAbs participante : participantes) {
			idiomas.addAll(participante.getListaDeIdiomas());
			for (String idioma : idiomas) {
				if(!aux.contains(idioma)) {
					aux.add(idioma);
				}
			}
		}
		return aux;
	}

	
	public ArrayList<String> getListaOrdenadaDeGeneros(){
		ArrayList<ElementoParticipanteAbs> participantes = this.getListaDeParticipantes();
		ArrayList<String> generos = new ArrayList<>();
		ArrayList<String> aux = new ArrayList<>();
		
		for (ElementoParticipanteAbs participante : participantes) {
			generos.addAll(participante.getListaDeGeneros());
			for (String genero : generos) {
				if(!aux.contains(genero)) {
					aux.add(genero);
				}
			}
		}
		Collections.sort(aux);
		return aux;
	}
	
	/*Busqueda filtrada*/
	public ArrayList<ElementoParticipanteAbs> getListaDeParticipantesConFiltro(Filtro f){
		ArrayList<ElementoParticipanteAbs> participantes = this.getListaDeParticipantes();
		for (ElementoParticipanteAbs participante : participantes) {
			participantes.addAll(participante.getListaDeParticipantesConFiltro(f));
		}
		return participantes;
	}
	
	
	/*CORRECCION, YA NO PREGUNTA POR BATALLAFINAL*/
	public ElementoParticipanteAbs getParticipantesBatalla(Cancion tema, Desafio desafio) {
		ArrayList<ElementoParticipanteAbs> aux = new ArrayList<>();
		for (ElementoParticipanteAbs participante : participantes) {
			if(participante.puedeInterpretarCancion(tema)) {
				aux.add(participante);
			}
		}
		Collections.sort(aux, desafio);
		if(aux.size() > 0) {
			return aux.get(0);
		}else {
			return null;
		}
	}
	

	
	
	
	@Override
	public String toString() {
		return "<----------------------------------------------------------------->\n"+
				"<-----EL EQUIPO DE " + this.getNombre().toUpperCase() + " " + this.getApellido().toUpperCase() + 
				":----->\n Idiomas de equipo: " + this.getListaDeIdiomas() +
				".\n Instrumentos de equipo: " + this.getListaDeInstrumentos() + 
				".\n Generos de equipo: " + this.getListaOrdenadaDeGeneros() + 
				".\n El promedio de edad del equipo es de: " + this.getPromedioEdad() + " años." + 
				"\n <<<PARTICIPANTES>>>: " + this.getListaDeParticipantes() + 
				"\n<----------------------------------------------------------------->" ;
	}
	
	
}