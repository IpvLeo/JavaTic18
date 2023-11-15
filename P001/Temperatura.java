import java.util.Scanner;

public class Temperatura {
		private float f;
		private float c;
		private float t;
		private float u;
	public
	
	// metodo para imprimir e calcular dados de fahrenheit
	void fahrenheit()
	{
		float f = (t *9/5) +32;
		System.out.println(t + " Celsius convertidos em Fahrenheit é: "+ f +"°F");
	}
	
	// metodo para imprimir e calcular dados de celsius
	void celsius()
	{
		float c = (t-32) *5/9;
		System.out.println( t + " Fahrenheit convertidos em Celsius é: " + c +"°C");
	}
	
	//metodo de interface( contem loop e condicões).
	void conversor()
	{
		for(int i = 0; i <=2; i++) {
			Scanner sc = new Scanner(System.in);
			
			
			System.out.println("Qual temperatura voce deseja converter?");
			t = sc.nextFloat();
			System.out.println("Digite 1 para a conversão de Celsius em Fahrenheit.\nDigite 2 para a conversão de Fahrenheit em Celsius.\n");
			u = sc.nextInt();
			if(u == 1) 
			{	
				fahrenheit();
			}
			
			else if(u == 2) 
			{
				celsius();	
			}
			else if(u > 2)
			{
				System.out.println("Opção invalida. Tente novamente por favor.\n");
			}
		}
	
	}
	
	
public static void main(String[] args) {
	
	Temperatura t;
	t = new Temperatura();
	t.conversor();
	//saida do codigo
	
	
	
	
	}
}