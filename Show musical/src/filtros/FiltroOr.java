package filtros;

import Proyecto.ElementoParticipanteAbs;

public class FiltroOr extends Filtro{

	private Filtro f1;
	private Filtro f2;
	
	
	
	public FiltroOr(Filtro f1, Filtro f2) {
		this.f1 = f1;
		this.f2 = f2;
	}


	@Override
	public boolean cumple(ElementoParticipanteAbs p) {
		return f1.cumple(p)||f2.cumple(p);
	}
	
}
