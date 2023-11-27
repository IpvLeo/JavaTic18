import java.util.Scanner;

public class ConversorDeMoedas {
	private double dolar;
	private double dr;
	private double taxa;
	
	
	
	public

	// função para converte o valor de dolar para a taxa escolhida, nesse contexto é o real 
	void conversao()
	{
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Diga o valor em dolar para a conversao: ");
		dolar = sc.nextDouble();
		System.out.println("Digte a taxa de Cambio para conversao do real: ");
		taxa = sc.nextDouble();
		dr = dolar * taxa;
		System.out.println("O valor é " + dr + "R$");
	
	
	}
 

	//acesso a valores privados
	public double getDolar() {
		return dolar;
	}
	
	
	public double getDr() {
		return dr;
	}
	
	
	
	public double getTaxa() {
		return taxa;
	}

	



	public static void main(String[] args) 
	{	
		ConversorDeMoedas co;
		co = new ConversorDeMoedas();
	
		co.conversao();
		// execução do programa 
		
	}
}