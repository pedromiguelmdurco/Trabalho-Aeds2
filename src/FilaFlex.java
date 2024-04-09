
public class FilaFlex {
	private Celula primeiro, ultimo;

	public FilaFlex() {
		primeiro = new Celula();
		ultimo = primeiro;
	}

	public void inserir(Candidato x) {
		ultimo.setProx(new Celula(x));
		ultimo.getProx().setAnt(ultimo);
		ultimo = ultimo.getProx();
	}

	public Candidato remover() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro!");
		}
		Celula tmp = primeiro.getProx();
		primeiro.setProx(tmp.getProx());
		Candidato elemento = tmp.getElemento();
		tmp.getProx().setAnt(primeiro);
		tmp.setProx(null);
		tmp.setAnt(null);
		tmp = null;
		
		return elemento;
	}

	public int tamanho() {
		int cont = 1;
		Celula aux = this.primeiro;
		while (aux.getProx() != null) {
			cont++;
			aux = aux.getProx();
		}

		return cont;
	}

	public Candidato procurar(int x) throws Exception {
		Candidato elemento;
		int tamanho = tamanho();
		if (primeiro == ultimo || x < 0 || x > tamanho) {
			throw new Exception("Erro!");
		} else if (x == 0) {
			return this.primeiro.getProx().getElemento();
		} else if (x == tamanho) {
			return this.ultimo.getElemento();
		} else {
			Celula i = primeiro;
			for (int j = 0; j < x; j++, i = i.getProx())
				;
			
			elemento = i.getElemento();
			i = null;
			return elemento;
		}
	}

	public Celula getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(Celula primeiro) {
		this.primeiro = primeiro;
	}

	public Celula getUltimo() {
		return ultimo;
	}

	public void setUltimo(Celula ultimo) {
		this.ultimo = ultimo;
	}

}
