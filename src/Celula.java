public class Celula implements Cloneable {

	private Candidato elemento;
	private Celula prox, ant;

	public Celula() {
		this(null);
	}

	public Celula(Candidato x) {
		this.elemento = x;
		this.prox = null;
		this.ant = null;
	}
	
	@Override public Celula clone()throws CloneNotSupportedException {
		
		return (Celula) super.clone();
	}

	public Candidato getElemento() {
		return elemento;
	}

	public void setElemento(Candidato elemento) {
		this.elemento = elemento;
	}

	public Celula getProx() {
		return prox;
	}

	public void setProx(Celula prox) {
		this.prox = prox;
	}

	public Celula getAnt() {
		return ant;
	}

	public void setAnt(Celula ant) {
		this.ant = ant;
	}
	
//---------------------------
	
	public Candidato getProxElet() {
		return prox.elemento;
	}

	public void setProxElemt(Candidato prox) {
		this.prox.elemento = prox;
	}

	public Candidato getAntElent() {
		return ant.elemento;
	}

	public void setAntElement(Candidato ant) {
		this.ant.elemento = ant;
	}
	

}