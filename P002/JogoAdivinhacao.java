import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {

	public static void main(String[] args) 
	
	{
		Random random = new Random();
		int aleatorio = random.nextInt(100);
		
		for( int i = 0; i < 10; i++) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println(":.:Jogo de Adivinhacao:.:\nQual é o numero secreto?");
		
		int valor = sc.nextInt();
		
		
		
		if(valor > aleatorio)
		{
			
			System.out.println("Tente novamento o valor é menor que esse.");
		
		}
		
		else if(valor < aleatorio)
		{
			System.out.println("Tente novamente o valor é maior que esse.");
		}
		
		else if(valor == aleatorio)
		{
			System.out.println("Voce acertou!!! \nO numero é --> " + aleatorio + " <--");
			break;
		}
		
		
		
		}	
		
	
	}
}
	
