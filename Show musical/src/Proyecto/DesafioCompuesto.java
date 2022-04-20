package Proyecto;


import java.util.Comparator;

public class DesafioCompuesto extends Desafio {
	
	private Comparator<ElementoParticipanteAbs> d1;
	private Comparator<ElementoParticipanteAbs> d2;
	
	public DesafioCompuesto(Comparator<ElementoParticipanteAbs> d1, Comparator<ElementoParticipanteAbs> d2) {
        this.d1 = d1;
        this.d2 = d2;
    }

	@Override
	public int compare(ElementoParticipanteAbs p1, ElementoParticipanteAbs p2) {
		int res =d1.compare(p1, p2);
		if(res == 0 && d2!=null) {
			return d2.compare(p1, p2);
		}
		return res;
	}

}
