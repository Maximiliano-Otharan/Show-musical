package filtros;

import Proyecto.ElementoParticipanteAbs;

public class FiltroGenero extends Filtro{

	private String genero;
	
	public FiltroGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public boolean cumple(ElementoParticipanteAbs p) {
		return p.getListaDeGeneros().contains(genero);
	}

	
}
