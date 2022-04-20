package Proyecto;

public class DesafioCantGenero extends Desafio {
	
	@Override
	public int compare(ElementoParticipanteAbs p1, ElementoParticipanteAbs p2) {
		return p1.getListaDeGeneros().size()-p2.getListaDeGeneros().size();
	}

}
