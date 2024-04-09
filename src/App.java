import java.util.Scanner;

public class App {

	public static void main(String[] args) throws Exception {
		Scanner teclado = new Scanner(System.in);
		Faculdade Stark;

		//String teste1,teste2;		
		/*System.out.println("Digite o caminho de entrada:");
		teste1 = teclado.next();
															se precisar escrever o caminho do arquivo
		System.out.println("Digite agora o caminho de Saida");
		teste2 = teclado.next();
		*/
		
		ManipulaArq arq = new ManipulaArq("Candidatos.txt","saida.txt");
		
		Stark = arq.LerArq();
		
		Stark.organizarCand();
		
		arq.salvarArq(Stark);
		
		System.out.println("Foi");
		
		teclado.close();

	}

}
