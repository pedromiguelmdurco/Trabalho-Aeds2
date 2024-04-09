import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ManipulaArq {

	private Scanner leitor;
	private BufferedReader auxleitor;
	private File arq1, arq2;
	private FileWriter saida;

	public ManipulaArq(String caminho, String caminho2) throws IOException {
		super();
		this.arq1 = new File(caminho);// caminho de entrada
		this.arq2 = new File(caminho2);// caminho de saida
		this.auxleitor = new BufferedReader(new FileReader(arq1));// Leitor para linhas
		this.leitor = new Scanner(arq1);// conferir se tem proxima linha
		this.saida = new FileWriter(arq2);// imprimir dados nos arquivos de saida

	}

	public Faculdade LerArq() throws Exception {// primeira funcao a ser chamada e oproveitando e retornando uma faculdade com os candidatos e cursos criados
		String linha = this.auxleitor.readLine();// variavel para armazenar a linha atual do arq
		String[] info = linha.split(";");// separando tudo em um vetor por ;
		Faculdade facul = new Faculdade(Integer.parseInt(info[0])); //enviando o parametro para falar qual sera o tamanho do vetor de curso											
		if (Integer.parseInt(info[1]) > 1000) {// conferindo se tem mais de 1000 candidatos se tiver da erro
			throw new Exception("O numero maximo sao 1000 candidatos");
		}

		int aux = Integer.parseInt(info[0]); // armazenando uma variavel auxiliar para saber quantos cursos tem
		// lendo a proxima linha q seria o primeiro curso para ter os dados corretos na hora do for

		for (int cont = aux; cont > 0; cont--) {
			linha = this.auxleitor.readLine();// passando para proxima linha
			info = linha.split(";");// atualizando o info com a proximo linha
			switch (Integer.parseInt(info[0])) { // para armazenar os dados baseados no id Ex:(info[1, Medicina, 4])
			case 1: {
				facul.setCurso(Integer.parseInt(info[0]) - 1,
						new Curso(Integer.parseInt(info[0]), info[1], Integer.parseInt(info[2])));
				break;
			}
			case 2: {
				facul.setCurso(Integer.parseInt(info[0]) - 1,
						new Curso(Integer.parseInt(info[0]), info[1], Integer.parseInt(info[2])));
				break;
			}
			case 3: {
				facul.setCurso(Integer.parseInt(info[0]) - 1,
						new Curso(Integer.parseInt(info[0]), info[1], Integer.parseInt(info[2])));
				break;
			}
			case 4: {
				facul.setCurso(Integer.parseInt(info[0]) - 1,
						new Curso(Integer.parseInt(info[0]), info[1], Integer.parseInt(info[2])));
				break;
			}

			}// fim do switch

		} // fim do for
		int cont = 0;// contador utilizando para dar parametro de id para os Candidatos
		while (leitor.hasNextLine() && linha != null) {// conferindo se tem proxima linha

			linha = this.auxleitor.readLine();
			if (linha != null) {// tratamento de erro
				info = linha.split(";");
			}

			facul.getCandidatos()// criando candidatos com base na leitura
					.inserirFim(new Candidato(info[0], Double.parseDouble(info[1]), Double.parseDouble(info[2]),
							Double.parseDouble(info[3]), Integer.parseInt(info[4]), Integer.parseInt(info[5]), cont));
			cont++;// aumentando id
			leitor.nextLine(); // passando para proxima linha para conferir se é null
		}
		return facul;
	}// final do lerArq

	public void salvarArq(Faculdade facul) throws Exception {

		DecimalFormat formatador = new DecimalFormat("0.00");// variavel criada para deixar notas com apenas duas casas decimais

		for (int cont = 0; cont < facul.getCursos().length; cont++) {// repitindo primeiro pelo o curso

			saida.write(facul.getCurso(cont).getDescricao() + " " // pegando informações do curso
					+ formatador.format(facul.getCurso(cont).getNotaCorte()) + "\n");

			saida.write("Selecionados----------------------------\n");// pegando selecionados na lista de aprovados
			for (int cont2 = 1; cont2 <= facul.getCurso(cont).getTamanhoListCand(); cont2++) {
				saida.write(
						facul.getCurso(cont).getListaCandidatosCurso().procurar(cont2).getNome() + " "
								+ formatador.format(
										facul.getCurso(cont).getListaCandidatosCurso().procurar(cont2).getMediaNotas())
								+ "\n");
			}

			saida.write("Fila de Espera------------------------------------\n");// passando pela a fila de espera do curso
																				 
			for (int cont2 = 1; cont2 < facul.getCurso(cont).getTamanhoFilaCand(); cont2++) {//passando e pegando os que estao na fila de espera
				saida.write(facul.getCurso(cont).getFilaDeEspera().procurar(cont2).getNome() + " "
						+ formatador.format(facul.getCurso(cont).getFilaDeEspera().procurar(cont2).getMediaNotas())
						+ "\n");
			}
			saida.write("\n");
		}
		saida.close();// fechando e salvando arquivo
	}
}
