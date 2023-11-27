import java.util.Random;
import java.util.Scanner;

public class ManipularArray {

	private int[] array;

	public void criarArray() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o tamanho do seu array: ");

		int tamanho = sc.nextInt();
		array = new int[tamanho];

		System.out.println("Digite os elementos inteiros para o seu array: ");
		for (int i = 0; i < tamanho; i++) {
			array[i] = sc.nextInt();
			System.out.println("Numero armazenado " + array[i] + " Com index " + i);
		}

		for (int c = 0; c < array.length; c++) {
			System.out.println("Elementos do array são: " + array[c]);
		}

	}

	public void arrayAleatorio() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o tamanho para seu array com valores aleatorios: ");

		Random random = new Random();
		int tamanho = sc.nextInt();
		array = new int[tamanho];

		for (int c = 0; c < array.length; c++) {

			array[c] = random.nextInt();
			System.out.println(array[c]);

		}
	}

	public void somarArray() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o tamanho para seu array: ");
		int soma = 0;

		int tamanho = sc.nextInt();
		array = new int[tamanho];

		for (int i = 0; i < tamanho; i++) {
			System.out.println("Digite o valor que quer em seu array: ");
			array[i] = sc.nextInt();
		}

		for (int n : array) {
			soma = soma + n;
		}
		System.out.println("A soma dos numeros sao: " + soma);

	}

	public void menorValor() {

		int menor = array[0];

		for (int i = 0; i < array.length; i++) {
			if (array[i] < menor) {
				menor = array[i];

			}

		}
		System.out.println(" o menor numero do array: " + menor);

	}

	public void maiorValor() {
		int maior = array[0];

		for (int i = 1; i < array.length; i++) {
			if (array[i] > maior) {
				maior = array[i];

			}

		}
		System.out.println(" o maior numero do array: " + maior);

	}

	public static void main(String[] args) {

		ManipularArray manipularArray = new ManipularArray();
		Scanner sc = new Scanner(System.in);

		int opcao;
		do {
			System.out.println("								<<<Manipulando Array>>>\nEscolha uma opção: ");
			System.out.println("1. Criar um array");
			System.out.println("2. Criar um array com valores aleatorios");
			System.out.println("3. Criar array para Somar");
			System.out.println("4. Obter o menor valor do Array");
			System.out.println("5. Obter o maior valor do Array");
			System.out.println("6. Sair");

			System.out.print("Digite a opção desejada: ");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				manipularArray.criarArray();
				break;

			case 2:
				manipularArray.arrayAleatorio();
				break;

			case 3:
				manipularArray.somarArray();
				break;

			case 4:
				manipularArray.menorValor();
				break;

			case 5:
				manipularArray.maiorValor();
				break;

			case 6:
				System.out.println("Saindo do programa. Até Mais!");
				break;

			default:
				System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
			}
		} while (opcao != 6);

		sc.close();
	}
}
