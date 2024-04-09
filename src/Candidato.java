public class Candidato implements Cloneable{
	private String nome;
	private int id;
	private int cursoA;
	private int cursoB;
	private double notaRedacao;
	private double notaMatematica;
	private double notaLinguagens;
	private double mediaNotas;

	public Candidato(String nome, double notaRedacao, double notaMatematica, double notaLinguagens, int cursoA,
			int cursoB, int id) {
		this.nome = nome;
		this.cursoA = cursoA;
		this.cursoB = cursoB;
		this.notaRedacao = notaRedacao;
		this.notaMatematica = notaMatematica;
		this.notaLinguagens = notaLinguagens;
		this.id = id;
		calcularMediaNotas();
	}

	@Override
	public Candidato clone() throws CloneNotSupportedException {

		return (Candidato) super.clone();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCursoA() {
		return cursoA;
	}

	public void setCursoA(int cursoA) {
		this.cursoA = cursoA;
	}

	public int getCursoB() {
		return cursoB;
	}

	public void setCursoB(int cursoB) {
		this.cursoB = cursoB;
	}

	public double getNotaRedacao() {
		return notaRedacao;
	}

	public void setNotaRedacao(double notaRedacao) {
		this.notaRedacao = notaRedacao;
	}

	public double getNotaMatematica() {
		return notaMatematica;
	}

	public void setNotaMatematica(double notaMatematica) {
		this.notaMatematica = notaMatematica;
	}

	public double getNotaLinguagens() {
		return notaLinguagens;
	}

	public void setNotaLinguagens(double notaLinguagens) {
		this.notaLinguagens = notaLinguagens;
	}

	public double getMediaNotas() {
		return mediaNotas;
	}

	private void calcularMediaNotas() {
		mediaNotas = (notaRedacao + notaMatematica + notaLinguagens) / 3;
	}
}
