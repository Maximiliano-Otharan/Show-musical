package filtros;



import Proyecto.ElementoParticipanteAbs;

public class FiltroMayorEdad extends Filtro {

	private int otraEdad;

	
	
	public FiltroMayorEdad(int otraEdad) {

		this.otraEdad = otraEdad;
	}



	@Override
	public boolean cumple(ElementoParticipanteAbs p) {
		return p.getEdad()>otraEdad;
	}
	
	
	
}
