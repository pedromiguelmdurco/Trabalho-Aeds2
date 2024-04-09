
public class ListaFlex {

	private Celula primeiro, ultimo;

	public ListaFlex() {
		primeiro = new Celula();
		ultimo = primeiro;
	}
	
	public ListaFlex(ListaFlex list) {
		primeiro = list.primeiro;
		ultimo = list.ultimo;
	}

	public void inserirInicio(Candidato x) {
		Celula tmp = new Celula(x);
		tmp.setAnt(primeiro);
		tmp.setProx(primeiro.getProx());
		primeiro.setProx(tmp);

		if (primeiro == ultimo) {
			ultimo = tmp;
		} else {
			tmp.getProx().setAnt(tmp);
		}
		tmp = null;
	}

	public void inserirFim(Candidato x) {
		ultimo.setProx(new Celula(x));
		ultimo.getProx().setAnt(ultimo);
		ultimo = ultimo.getProx();

	}

	/*
	 * public Candidato removerInicio() throws Exception { if (primeiro == ultimo) {
	 * throw new Exception("Erro!"); } Celula tmp = primeiro; primeiro =
	 * primeiro.getProx(); Candidato elemento = primeiro.getElemento();
	 * tmp.setProx(null); tmp = null; return elemento; }
	 */

	public Candidato removerFim() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro!");
		}

		Candidato elemento = ultimo.getElemento();
		ultimo = ultimo.getAnt();
		ultimo.getProx().setProx(null);
		ultimo.setProx(null);
		return elemento;
	}

	public void inserir(Candidato x, int pos) throws Exception {
		int tamanho = tamanho();
		if (pos < 0 || pos > tamanho) {
			throw new Exception("Erro!");
		} else if (pos == 0) {
			inserirInicio(x);
		} else if (pos == tamanho) {
			inserirFim(x);
		} else {
			Celula i = primeiro;
			for (int j = 0; j < pos; j++, i = i.getProx())
				;
			Celula tmp = new Celula(x);
			tmp.setAnt(i);
			tmp.setProx(i.getProx());
			tmp.getAnt().setProx(tmp);
			tmp.getProx().setAnt(tmp);

			tmp = null;
			i = null;
		}
	}

	public Candidato remover(int pos) throws Exception {
		Candidato elemento;
		int tamanho = tamanho();
		if (primeiro == ultimo || pos < 0 || pos >= tamanho) {
			throw new Exception("Erro!");
		} else if (pos == 0) {
			elemento = null;// removerInicio(); //pois quando a lista é inicializada é com uma celula nulla que so aponta para o proximo
		} else if (pos == tamanho - 1) {
			elemento = removerFim();
		} else {
			Celula i = primeiro.getProx();
			for (int j = 0; j < pos; j++, i = i.getProx())
				;
			
			i.getAnt().setProx(i.getProx()); 
			i.getProx().setAnt(i.getAnt());
			elemento = i.getElemento();
			i.setProx(null);
			i.setAnt(null);
			i = null;
		}

		return elemento;
	}

	public int tamanho() { // repetidor para ser o tamanho da lista
		int cont = 0;
		Celula aux = this.primeiro;
		while (aux.getProx() != null) {
			cont++;
			aux = aux.getProx();
		}

		return cont;
	}

	public Candidato procurar(int x) throws Exception {//percorrendo pela a lista utilizando pesquisa linear
		Candidato elemento;
		int tamanho = tamanho();
		if (primeiro == ultimo || x < 0 || x > tamanho) {
			throw new Exception("Erro!");
		} else if (x == 0) {
			return this.primeiro.getProx().getElemento();//pegando o proximo pois quando a lista é inicializada é com uma celula nula entao sempre começa do 1
		} else if (x == tamanho) {
			return this.ultimo.getElemento();
		} else {
			Celula i = primeiro;
			for (int j = 0; j < x; j++, i = i.getProx())
				;
			//caso n seja nem o primeiro ou ultimo ele percorre a lista e retornando apenas o elemento
			Celula tmp = i;
			elemento = tmp.getElemento();
			tmp = null;
			i = null;
			return elemento;
		}
	}

	@Override
	public ListaFlex clone() throws CloneNotSupportedException {

		return (ListaFlex) super.clone();
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