package Proyecto;

import java.util.ArrayList;


public class Cancion {

	/*Atributos*/
	
	protected String titulo;
	protected String idioma;
	protected ArrayList<String> generos;
	protected ArrayList<String> instrumentos;
	
	/*Constructor*/
	public Cancion(String titulo, String idioma) {
		this.titulo = titulo;
		this.idioma = idioma;
		this.generos = new ArrayList<>();
		this.instrumentos = new ArrayList<>();
	}

	/*Getters*/
	public String getTitulo() {
		return titulo;
	}
	public String getIdioma() {
		return idioma;
	}

	/*Setter*/

	
	/*Adicionadores*/
	public void addGenero(String genero) {
		if (!this.generos.contains(genero)) {
			generos.add(genero);
		}
	}
	public void addInstrumento(String instrumento) {
		if (!this.instrumentos.contains(instrumento)) {
			instrumentos.add(instrumento);
		}
	}
	
	
	/*Listados*/
	public ArrayList<String> getListaDeGeneros(){
		ArrayList<String> generos = new ArrayList<>();
		generos.addAll(this.generos);
		return generos;
	}
	public ArrayList<String> getListaDeInstrumentos(){
		ArrayList<String> instrumentos = new ArrayList<>();
		instrumentos.addAll(this.instrumentos);
		return instrumentos;
	}
	
	@Override
	public String toString() {
		return this.getTitulo() + ", " + this.getIdioma() + ". " + this.getListaDeGeneros() + ". " + this.getListaDeInstrumentos(); 
	}

	/*Equals*/
	@Override
	public boolean equals(Object otro) {
		try {
			Cancion cancion = (Cancion) otro;
			return this.getTitulo().equals(cancion.getTitulo());
		}catch(Exception e){
			return false;
		}
		
	}
	
	/*CORRECCION, LA CANCION SABE SI EL TEMA ES INTERPRETABLE O NO*/
	
	/*EL TEMA ES INTERPRETABLE?*/
	public boolean esInterpretable(Participante participante) {
		for (String genero : this.getListaDeGeneros()) {
			if(participante.getListaDeGeneros().contains(genero)) {             /*Al menos un genero*/
				if(participante.getListaDeIdiomas().contains(this.getIdioma())) {                  /*Cantan en un idioma*/
					return true;		
				}
			}
		}
		return false;
	}
	

	
}
