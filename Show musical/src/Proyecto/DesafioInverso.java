package Proyecto;


import java.util.Comparator;

public class DesafioInverso extends Desafio {
	private Comparator<ElementoParticipanteAbs> desafio;
	
	public DesafioInverso(Comparator<ElementoParticipanteAbs> desafio) {
        this.desafio = desafio;
    }
	
	@Override
	public int compare(ElementoParticipanteAbs p1, ElementoParticipanteAbs p2) {
		return -desafio.compare(p1, p2);
	}

}
