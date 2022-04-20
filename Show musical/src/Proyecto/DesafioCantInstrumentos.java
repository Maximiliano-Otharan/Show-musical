package Proyecto;

public class DesafioCantInstrumentos extends Desafio{

	@Override
	public int compare(ElementoParticipanteAbs p1, ElementoParticipanteAbs p2) {
		return p1.getListaDeInstrumentos().size()-p2.getListaDeInstrumentos().size();
	}

}
