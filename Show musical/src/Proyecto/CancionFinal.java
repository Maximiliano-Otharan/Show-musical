package Proyecto;

import java.util.ArrayList;

public class CancionFinal extends Cancion {

	private int requisitoCantInstrumentos;

	public CancionFinal(String titulo, String idioma, int requisitoCantInstrumentos) {
		super(titulo, idioma);
		this.requisitoCantInstrumentos = requisitoCantInstrumentos;
	}

	public int getRequisitoCantInstrumentos() {
		return requisitoCantInstrumentos;
	}

	public void setRequisitoCantInstrumentos(int requisitoCantInstrumentos) {
		this.requisitoCantInstrumentos = requisitoCantInstrumentos;
	}

	/* INTERPRETABLE TEMA FINAL */
	public boolean esInterpretable(Participante participante) {
		if (super.esInterpretable(participante)
				&& requisitoFinal(participante.getListaDeInstrumentos()) >= this.getRequisitoCantInstrumentos())
			return true;
		return false;
	}

	/* METODO QUE VERIFICA CANTIDAD DE INSTRUMENTOS QUE PARTICIPANTES TOCAN */
	public int requisitoFinal(ArrayList<String> instrumentos) {
		int recuento = 0;
		for (String instrumento : instrumentos) {
			if (this.getListaDeInstrumentos().contains(instrumento)) {
				recuento++;
			}
		}
		return recuento;
	}

}
