package CalculadoraDeDivisao;

//Definição da exceção personalizada
class DivisionByZeroException extends Exception {
 public DivisionByZeroException(String message) {
     super(message);
 }
}

//Classe da Calculadora
public class calculadoradedivisao {
 
 public int soma(int a, int b) {
     return a + b;
 }

 public int subtracao(int a, int b) {
     return a - b;
 }

 public int multiplicacao(int a, int b) {
     return a * b;
 }

 public int divisaoInteira(int a, int b) throws DivisionByZeroException {
     if (b == 0) {
         throw new DivisionByZeroException("Divisão por zero não é permitida");
     }
     return a / b;
 }

 public float divisaoFloat(float a, float b) throws DivisionByZeroException {
     if (b == 0) {
         throw new DivisionByZeroException("Divisão por zero não é permitida");
     }
     return a / b;
 }

 public static void main(String[] args) {
     calculadoradedivisao calc = new calculadoradedivisao();

     try {
         System.out.println("Soma: " + calc.soma(5, 3));
         System.out.println("Subtração: " + calc.subtracao(10, 4));
         System.out.println("Multiplicação: " + calc.multiplicacao(6, 7));
         System.out.println("Divisão Inteira: " + calc.divisaoInteira(10, 2));
         System.out.println("Divisão Float: " + calc.divisaoFloat(15.5f, 3.5f));
         // Tentativa de divisão por zero
         System.out.println("Divisão por Zero: ");
         System.out.println("Divisão Inteira: " + calc.divisaoInteira(8, 0));
         System.out.println("Divisão Float: " + calc.divisaoFloat(10.5f, 0f));
     } catch (DivisionByZeroException e) {
         System.out.println("Erro: " + e.getMessage());
     }
 }
}
