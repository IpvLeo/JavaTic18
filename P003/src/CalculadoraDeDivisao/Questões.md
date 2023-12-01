1. O que é uma exceção em Java e qual é o propósito de usá-las em programas?

Em Java, uma exceção é um evento anormal que ocorre durante a execução de um programa e interrompe o fluxo normal de instruções. Elas representam situações inesperadas, como erros de tempo de execução ou condições imprevistas. O propósito principal das exceções é lidar com esses casos excepcionais de forma estruturada, permitindo que o programa se recupere ou termine de maneira controlada, evitando a interrupção brusca ou a corrupção dos dados.

2. Pesquise sobre a diferença entre exceções verificadas e não verificadas em
Java. Dê exemplos de cada uma.

Exceções Verificadas: São exceções que o compilador obriga o programador a tratar ou lançar, através do uso das palavras-chave throws ou try-catch. Exemplos incluem IOException, SQLException. Exemplo:

      import java.io.IOException;
      public class ExcecaoVerificadaExemplo {
              public void metodoComExcecao() throws IOException {
                    throw new IOException("Exemplo de exceção verificada");
              }
      }

Exceções Não Verificadas: São exceções que herdam de RuntimeException ou Error. O compilador não obriga o tratamento ou lançamento delas. Exemplos incluem NullPointerException, ArrayIndexOutOfBoundsException. Exemplo:

      public class ExcecaoNaoVerificadaExemplo {
          public void metodoComExcecao() {
              throw new NullPointerException("Exemplo de exceção não verificada");
          }
      }

3. Como você pode lidar com exceções em Java? Quais são as palavras-chave e
as práticas comuns para tratamento de exceções?

As palavras-chave principais para lidar com exceções são try, catch, finally, throws. A prática comum é:

    try-catch: Envolver o código que pode gerar uma exceção em um bloco try e capturar a exceção usando um ou mais blocos catch.
    finally: É usado para executar código que deve ser executado independentemente de ocorrer uma exceção ou não, como fechar recursos.
    throws: É usado para declarar exceções que um método pode lançar, transferindo a responsabilidade do tratamento para quem chama esse método.

4. O que é o bloco "try-catch" em Java? Como ele funciona e por que é
importante usá-lo ao lidar com exceções?

O bloco try-catch é usado para controlar exceções em Java. O código propenso a gerar exceções é colocado dentro do bloco try, e o código de tratamento da exceção é colocado dentro do bloco catch. Se uma exceção for lançada dentro do bloco try, o fluxo de controle é transferido para o bloco catch correspondente.

5. Quando é apropriado criar suas próprias exceções personalizadas em Java e
como você pode fazer isso? Dê um exemplo de quando e por que você criaria
uma exceção personalizada.

Criar exceções personalizadas é apropriado quando os tipos de exceção existentes não conseguem descrever adequadamente o problema específico que ocorreu. Para criar uma exceção personalizada, é necessário criar uma classe que estenda Exception (ou uma de suas subclasses). Por exemplo:

      public class MeuErroPersonalizado extends Exception {
          public MeuErroPersonalizado(String mensagem) {    
              super(mensagem);        
          }    
      }

Você pode criar uma exceção personalizada quando um cenário específico do seu programa requer tratamento especializado. Por exemplo, se você está desenvolvendo um sistema de pagamento e precisa lidar com um tipo específico de erro de pagamento, pode criar uma exceção personalizada para isso.
