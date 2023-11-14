import java.util.Scanner;

public class Calculadora1 {
	private int x;
	private int y;
	private int escolha;
	
	
	public 
	void somando()			//metodo para somar.
	{
		int somar = x + y;
		System.out.println("A Soma de " + x + "+" + y + " = "+ somar);
	}
	
	
	void subtraindo()		//metodo para subtrair.
	{
		int subtrair = x - y;
		System.out.println("A Subtracao de " + x +  "-" + y + " = " + subtrair);
	}
	
	void multiplicando()	//metodo para multiplicar.
	{
		int multiplicar = x * y;
		System.out.println("A Multiplicacao de " + x + "*" + y + " = " + multiplicar + "\n");
	}
	
	void dividindo()		//metodo para dividir.
	{
		int dividir = x / y;
		System.out.println("A Divisao de "+ x + "/" + y +" = " + dividir);
	}
	
	//metodo para interface e saida.
	void calculando()
	{
		//um for para criar o loop da lista
		for(int i = 0; i <=4;i++ ) {	
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite o Primeiro numero: ");
			x = sc.nextInt();
			System.out.println("Digite o numero o Segundo numero: ");
			y = sc.nextInt();
			
			System.out.println("Digite 0 para Sair\nDigite 1 para Somar\nDigite 2 para Subtrair\nDigite 3 para Multiplicar\nDigite 4 para Dividir\nQual operação voce deseja realizar?");
			escolha = sc.nextInt();
			
			// if para criar condiçoes a qual o usuario pode optar.
			if(escolha == 1) 
			{
				somando();
			}
			if(escolha == 2) {
				subtraindo();
			}
			if(escolha == 3) {
				multiplicando();
			}
			if(escolha == 4) {
				dividindo();
			}
			else if(escolha > 4)
			{
				System.out.println("Opção invalida. Tente novamente!");
			}
			else if(escolha == 0)
			{
				break;
			}
		}
	}
	



public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getEscolha() {
		return escolha;
	}

	public void setEscolha(int escolha) {
		this.escolha = escolha;
	}

	
public static void main(String[] args) 
	{	
		Calculadora1 c;
		c = new Calculadora1();
		
		
		c.calculando();
		//Impressão do codigo.
	
	}	
	
}
