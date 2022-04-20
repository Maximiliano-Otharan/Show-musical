package filtros;



import Proyecto.ElementoParticipanteAbs;

public class FiltroIdioma extends Filtro{

	private String idioma;
	
	
	
	public FiltroIdioma(String idioma) {
		this.idioma = idioma;
	}



	@Override
	public boolean cumple(ElementoParticipanteAbs p) {
		return p.getListaDeIdiomas().contains(idioma);
	}

	
	
}
