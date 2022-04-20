package Proyecto;

public class DesafioEdad extends Desafio {

	@Override
	public int compare(ElementoParticipanteAbs p1, ElementoParticipanteAbs p2) {
		return p1.getEdad()-p2.getEdad();
	}

}
