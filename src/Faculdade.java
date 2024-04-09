
public class Faculdade {
	private ListaFlex candidatos;
	private Curso[] cursos;

	public Faculdade(int cursos) {
		super();
		this.candidatos = new ListaFlex();
		this.cursos = new Curso[cursos];
	}

	public void organizarCand() throws Exception {
		
		quicksort(this.candidatos, 0, this.candidatos.tamanho());
		for (int cont = 1; cont < candidatos.tamanho(); cont++) {
			Candidato tmp = candidatos.procurar(cont);

			tmp = inserirCurso(tmp.getCursoA(), tmp);
			if (tmp != null) {
				inserirCurso(tmp.getCursoB(), tmp);
			}

		}
	}

	private Candidato inserirCurso(int curso, Candidato tmp) {
		switch (curso) {
		case 1: {
			return this.cursos[0].inserirCands(tmp);

		}
		case 2: {
			return this.cursos[1].inserirCands(tmp);

		}
		case 3: {
			return this.cursos[2].inserirCands(tmp);

		}
		case 4: {
			return this.cursos[3].inserirCands(tmp);

		}
		default:
			return null;
		}

	}

	public void quicksort(ListaFlex list, int esq, int dir) throws Exception {
		int cont = esq, cont2 = dir;
		ListaFlex aux = new ListaFlex(list);
		double pivo = aux.procurar((esq + dir) / 2).getMediaNotas();

		while (cont < cont2) {
			while (cont < list.tamanho() && list.procurar(cont).getMediaNotas() > pivo) {
				cont++;
			}
			while (cont2 > -1 && list.procurar(cont2).getMediaNotas() < pivo) {
				cont2--;
			}
			if (cont <= cont2) {
				trocar(cont, cont2);
				cont++;
				cont2--;
			}
		}
		if (esq < cont2) {
			quicksort(list, esq, cont2);
		}
		if (cont < dir) {
			quicksort(list, cont, dir);
		}
	}

	private void trocar(int cont, int cont2) throws Exception {

		Celula j = candidatos.getPrimeiro().getProx();

		for (int i = 1; i < cont; i++, j = j.getProx())
			;

		Celula j2 = candidatos.getPrimeiro().getProx();
		for (int i = 1; i < cont2; i++, j2 = j2.getProx())
			;

		if (j.getElemento().getMediaNotas() == j2.getElemento().getMediaNotas()
				&& j.getElemento().getId() != j2.getElemento().getId()) {
			
			if (j.getElemento().getNotaRedacao() > j2.getElemento().getNotaRedacao()) {
				Celula aux = j.clone();
				j.setElemento(j2.getElemento());
				j2.setElemento(aux.getElemento());
			}
			
		}

		Celula tmp = j.clone();
		Celula tmp2 = null;
		if (j2 != null) {
			tmp2 = j2.clone();
		}

		if (j2.getAnt() != j && j2.getProx() != j) {

			if (j.getAnt() != null) {
				j.getAnt().setProxElemt(tmp2.getElemento());
			}
			
			if (j2.getAnt() != null) {
				j2.getAnt().setProxElemt(tmp.getElemento());
			}
			
		} else {

			if (j2.getProx() != null) {
				j2.getProx().setAntElement(tmp.getElemento());
			}
			if (j.getAnt() != null) {
				j.getAnt().setProxElemt(tmp2.getElemento());
			}

		}
	}


	public ListaFlex getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(ListaFlex candidatos) {
		this.candidatos = candidatos;
	}

	public Curso[] getCursos() {
		return cursos;
	}

	public void setCursos(Curso[] cursos) {
		this.cursos = cursos;
	}

	public Curso getCurso(int x) {
		return cursos[x];
	}

	public void setCurso(int x, Curso curso) {
		this.cursos[x] = curso;
	}

}
