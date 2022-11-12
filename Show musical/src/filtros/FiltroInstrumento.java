package filtros;



import Proyecto.ElementoParticipanteAbs;

public class FiltroInstrumento extends Filtro{
	private String instrumento;
	
	
	
	public FiltroInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}



	@Override
	public boolean cumple(ElementoParticipanteAbs p) {
		return p.getListaDeInstrumentos().contains(instrumento);
	}

	
}
