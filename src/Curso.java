
public class Curso {
    private int id;
    private double notaCorte;
    private int quantVagas;
    private String descricao;
    private ListaFlex listaCandidatosCurso;
    private FilaFlex filaDeEspera;

    public Curso(int id, String desc, int quatVagas) {
        this.id = id;
        this.quantVagas = quatVagas;
        this.descricao = desc;
        this.listaCandidatosCurso = new ListaFlex();
        this.filaDeEspera = new FilaFlex();
    }

    
    public Candidato inserirCands(Candidato cand) {
    	
    	if(getTamanhoListCand() < this.quantVagas) {
    		this.listaCandidatosCurso.inserirFim(cand);
    		cand = null;
    	}else {
    		this.filaDeEspera.inserir(cand);
    	}
    	setNotaCorte(this.listaCandidatosCurso.getUltimo().getElemento().getMediaNotas());
    	return cand;
    }
    
    // getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNotaCorte() {
        return notaCorte;
    }

    public void setNotaCorte(double notaCorte) {
        this.notaCorte = notaCorte;
    }

    public int getQuantVagas() {
        return quantVagas;
    }

    public void setQuantVagas(int quatVagas) {
        this.quantVagas = quatVagas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ListaFlex getListaCandidatosCurso() {
        return listaCandidatosCurso;
    }

    public void setListaCandidatosCurso(ListaFlex listaCandidatosCurso) {
        this.listaCandidatosCurso = listaCandidatosCurso;
    }

    public FilaFlex getFilaDeEspera() {
        return filaDeEspera;
    }

    public void setFilaDeEspera(FilaFlex filaDeEspera) {
        this.filaDeEspera = filaDeEspera;
    }
    
    public int getTamanhoListCand() {
    	return this.listaCandidatosCurso.tamanho();
    }
    
    public int getTamanhoFilaCand() {
    	return this.filaDeEspera.tamanho();
    }
}
