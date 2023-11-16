# Po1 Java #

### **1. O que é uma classe em Java e qual é a diferença entre uma classe e um objeto? Dê 5 exemplos mostrando-os em C++ e em Java.**

##### R: É um modelo ou especificação que define um tipo de objeto por exemplo: em uma biblioteca, tenho livros separados por seções de diversos gêneros, e autores. Esses tipos de livros que serão os objetos da minha classe livro exemplo descrito no codigo abaixo #####

~~~java
public class Livro {

private String nome; 
private String autor;
private double preco;

public Livro(String nome, String autor, double preco) {
     this.nome = nome; 
     this.autor = autor; 
     this.preco = preco;
    }
}
~~~~

### **1.1 Diferença na declaração do modificador de acesso:** 
##### R: Em C++ o modificador de acesso private é declarado antes dos atributos, onde os atributos ficam dentro desse escopo como mostrado abaixo. #####

~~~ c++
class Paciente {
private:
    string nome;
    string cpf;
    string dataNascimento;
}
~~~
##### R: Já em Java cada atributo que seja private vai conter a declaração do modificador de acesso antes do nome de cada atributo ou metodo privado. #####

~~~java
public class Livro {

    // Membros de dados privados
    private String titulo;
    private String autor;
    private int numPaginas;
}
~~~

### **1.2. Diferença na declaração e implementação do atributos:** ###

##### R: Em C ++ é usado para fins organizacionais e a fragmentação dos elementos de uma classe, geralmente dividindo em uma arquivo CPP e outro HPP, nos arquivos CPP estão as implementações que precisam de “::“ para dizer de onde veio a classe . Já nos arquivos HPP estão guardadas as declarações, como atributos e todo o cabeçalho que também usam “::” na criação, chamando a classe, mas tbm podendo optar pela opção de fazer todo o codigo no msm arquivo, mas ainda sim a chamada da classe terá que ser feita. #####

~~~ c++
// Livro.cpp

#include "Livro.hpp"
#include "Autor.hpp"  // Incluindo a declaração da classe Autor

// Implementação do construtor
Livro::Livro(const std::string& titulo, Autor* autor, int numPaginas)
    : titulo(titulo), autor(autor), numPaginas(numPaginas) {}

// Métodos públicos
std::string Livro::getTitulo() const {
    return titulo;
}

std::string Livro::getNomeAutor() const {
    return autor->getNome();
}

int Livro::getNumPaginas() const {
    return numPaginas;
}

void Livro::exibirDetalhes() const {
    std::cout << "Livro: " << titulo << std::endl;
    std::cout << "Autor: " << autor->getNome() << std::endl;
    std::cout << "Número de Páginas: " << numPaginas << std::endl;
}
~~~


##### R: Já em Java toda declaração e implementação da classe se encontra no mesmo repositorio atraves de import que uma classe se relaciona com a outra, não necessitando chamadas da mesma classe com o operador de resolução de escopo . #####


### **1.3. Alocação dinâmica e manipulação da memoria:** ###
##### R: Em C ++ quando criamos um vetor que necessita de um valor mas não sabemos qual é o espaço necessário que será utilizado, usamos o operador **new** para alocar uma memoria dinâmica, quando o uso dessa memoria tem seu fim, precisa ser apagada por uma operação delete ou um destrutor para evitar futuros problemas assim como o exemplo: #####

~~~ c++
#include <iostream>
using namespace std;

class Test
{
    public:
        Test();
        ~Test();
};

Test::Test()
{
    cout << "Constructor" << endl;
}

Test::~Test()
{
    cout << "Destructor" << endl;
}

int main()
{
    Test t;

    return 0;
}
~~~

##### R: Já em Java por conta do garbage collection não é necessário o destrutor declarar um delete da alocação dinâmica, pois toda memória dinâmica que o garbage collection entende como nula é desalocada, assim como o exemplo abaixo: #####

~~~ java
public class TesteColetor {

public static void main(String[] args) {
StringBuffer sb = new StringBuffer("abcd");
// O StringBuffer é alcançável pela referência sb
// e não é elegível para coleta de lixo
System.out.println(sb);
sb = null;
// Agora o StringBuffer deixa de ser referenciado
// por sb e torna-se candidato à coleta de lixo
    }
}
~~~

### **1.4. Ponteiro em java e C ++:** ###
##### R: Em C++ o ponteiro é passado pelo operador “*” antes da variável e referenciado com “&” para retornar o valor do ponteiro como descrito no codigo. #####

~~~ c++
#include <iostream>
using namespace std;

class Menu
{
   public:
      int validaEscolha();
      static int stValidaEscolha();
      int inicial();
};


int Menu::validaEscolha()
{
   cout << 1232 << endl;
   return 1;
}

int Menu::stValidaEscolha()
{
   cout << 1232 << endl;
   return 1;
}

int Menu::inicial()
{
   // ponteiro para método não estático
   int (Menu::*funcs)() = &Menu::validaEscolha;
   (this->*funcs)();

   // ponteiro para método estático
   int (*stFuncs)() = &Menu::stValidaEscolha;
   stFuncs();

   return 0;
}
~~~
##### R: Já em Java o que não for primitivo, na verdade e um tipo de ponteiro, não necessitando de declaraçoes explicítas. #####


### **1.5. Java é interpretado e C ++ é compilado:** ###
##### R: Em C++ é traduzido o código fonte para o código de maquina em tempo de execução lento, mas o fator importante é a capacidade de corrigir erros antes da execução do programa, tendo um melhor uso para programas mais robustos. #####

![Alt text](https://img-c.udemycdn.com/course/750x422/2270882_2d50_8.jpg)



##### R: Já em Java essa tradução para a execução é em tempo real, o problema é que os erros só serão percebidos na execução do programa. Um ponto forte é a versatilidade, pode funcionar em diferentes Sistemas e arquiteturas. #####

![Alt text](https://miro.medium.com/v2/resize:fit:1024/1*jkOCjQlkGZjbhWdvh7LfRA.png)


### **2. Como você declara uma variável em Java e quais são os tipos de dados primitivos mais comuns? Faça um paralelo entre isso e a mesma coisa na linguagem C++** ###

##### R: Em java os tipos são mais livres em relação a declaração, mas tambem colocando limites, mas somente dentro das quatidade de numeros ou bytes e não criando mais sub- tipos, assim como você pode observa no meu codigo abaixo. #####

~~~ java
public class Nome {
	public static void main(String[] args) {
		boolean verdade = true; //1bit
		boolean falso = false;// 1bit
		//boolean pode ser somente verdadeiro ou falso na conversão usando o casting ele não é o unico não utilizado.
		
			byte b = -128; 
			//contem 1 bytes é usado geralmente para guarda valores pequenos entre -128 a 127.
			
			short s = -32768; 
			//contem 2bytes tambem é usado para economia de memoria quando possivel, seus valores vão de -32768 a 32767.
			
			int i = -2147483648; 
			 //  contem 4 bytes e é o dado inteiro padrão seu valores são bem extensos de -2147483648 a -2147483647.
			
			long l = -9223372036854775808l;
			 /* O tipo long contem 8bytes e necessita do L para declarar grande valores, bastante utiizado para declarar numeros gigantes.
			 tendo valores de -9.223.372.036.854.775.808 a 9.223.372.036.854.775.807.
			 */
			
			float f = 22.2254351f;
			//contem 4 bytes e sua faixa de valor é ilimitada, para utiliza-lo o "f" tem que ser descrito no fim do valor recebido.
			// sua precisão e de 7 digitos decimais fracionarios.
			
			double d = 2.324324324324328942d;
			//contem 8 bytes e sua faixa de ilimitada, porem sua preci~sao e de 14 a 15 digitos, e em sua utilização deve ser usado o o d.
			
			char c = 99;
			//contem 2 bytes é utilizado para impressao de caracteres especiais.
			
	}

}
~~~
##### R: Ja no c++ os tipos primitivos tem outros nomes quando pode limitar  os valores das variaveis, sendo somente positivos é usado o "unsigned". ja quando os valores podem ser positivo e negativos é utilizado o "signed" + os nomes dos tipos primitivos. Tambem existe um fusão de tipos primitivos fazendo por exemplo um short int, que seria uma combinação de dois tipos primitivos que pode ser declarado  tambem com "unsigned" ou "signed". #####
## unsigned ##
~~~ c++
#include <iostream>
#include <limits>

int main() {
    // Tamanhos em bytes dos tipos de dados
    std::cout << "Tipo de Dado\t|\tCom Sinal\t|\tSem Sinal\t|\tTamanho (bytes)" << std::endl;
    std::cout << "--------------------------------------------------------------" << std::endl;

    // char
    std::cout << "char\t\t|\t" << std::numeric_limits<char>::min() << "\t\t|\t"
              << static_cast<unsigned char>(std::numeric_limits<char>::min()) << "\t\t|\t" << sizeof(char) << std::endl;

    // short
    std::cout << "short\t\t|\t" << std::numeric_limits<short>::min() << "\t\t|\t"
              << static_cast<unsigned short>(std::numeric_limits<short>::min()) << "\t\t|\t" << sizeof(short) << std::endl;

    // int
    std::cout << "int\t\t|\t" << std::numeric_limits<int>::min() << "\t|\t"
              << static_cast<unsigned int>(std::numeric_limits<int>::min()) << "\t\t|\t" << sizeof(int) << std::endl;

    // long
    std::cout << "long\t\t|\t" << std::numeric_limits<long>::min() << "\t|\t"
              << static_cast<unsigned long>(std::numeric_limits<long>::min()) << "\t\t|\t" << sizeof(long) << std::endl;

    // long long
    std::cout << "long long\t|\t" << std::numeric_limits<long long>::min() << "\t|\t"
              << static_cast<unsigned long long>(std::numeric_limits<long long>::min()) << "\t\t|\t" << sizeof(long long) << std::endl;

    return 0;
}
~~~

## signed ##
~~~ c++
#include <iostream>
#include <limits>

int main() {
    // Tamanhos em bytes dos tipos de dados
    std::cout << "Tipo de Dado\t|\tCom Sinal\t|\tValor Mínimo\t|\tValor Máximo\t|\tTamanho (bytes)" << std::endl;
    std::cout << "-----------------------------------------------------------------------------" << std::endl;

    // char
    std::cout << "char\t\t|\tsigned char\t|\t" << static_cast<int>(std::numeric_limits<signed char>::min()) << "\t\t|\t"
              << static_cast<int>(std::numeric_limits<signed char>::max()) << "\t\t|\t" << sizeof(signed char) << std::endl;

    // short
    std::cout << "short\t\t|\tsigned short\t|\t" << std::numeric_limits<short>::min() << "\t\t|\t"
              << std::numeric_limits<short>::max() << "\t\t|\t" << sizeof(signed short) << std::endl;

    // int
    std::cout << "int\t\t|\tsigned int\t|\t" << std::numeric_limits<int>::min() << "\t|\t"
              << std::numeric_limits<int>::max() << "\t\t|\t" << sizeof(signed int) << std::endl;

    // long
    std::cout << "long\t\t|\tsigned long\t|\t" << std::numeric_limits<long>::min() << "\t|\t"
              << std::numeric_limits<long>::max() << "\t\t|\t" << sizeof(signed long) << std::endl;

    // long long
    std::cout << "long long\t|\tsigned long long\t|\t" << std::numeric_limits<long long>::min() << "\t|\t"
              << std::numeric_limits<long long>::max() << "\t\t|\t" << sizeof(signed long long) << std::endl;

    return 0;
}
~~~

### **3. Explique o conceito de herança em Java e como você pode criar umasubclasse a partir de uma classe existente. Faça um paralelo com C++, apresentando 5 exemplos.** ###
##### R: em java o conceito de herança é o mesmo da linguagem c ++ a diferença esta na declaração da sub-classe em relação a super-classe herdada é que se usa uma palavra chave chamada **extends** para dizer que irar usar metodos e atributos da super-classe(esse acesso não é direto, quando o modificador de acesso é private). #####

~~~java



##### Em c++ a declaração da super-classe dentro da sub-classe é usando o acento ":", assim como no codigo abaixo. #####

~~~ c++
#include <iostream>

    using namespace std;

    class Veiculo {
        //super-classe de Terrestre

    protected:
        string nome;

    public:

        Veiculo(const char *nome) {
            this->nome = string(nome);
            cout << "Criação de Veículo" << nome << endl;
        }

        ~Veiculo(){
            cout << "Destruição de Veículo" << nome << endl;
        }

    };

    class Terrestre : public Veiculo {
        //na declaração da sub-classe contem o chamado para a super-classe
    public:

        Terrestre() : Veiculo(nome){
            this->nome = Veiculo::nome;
            cout << "Criação de Terrestre" << nome << endl;
        };

        ~Terrestre() : Veiculo() {
            cout << "Destruição de Terrestre" << nome << endl;
        }
    };
~~~

### **4. Quando declaramos uma variável em Java, temos, na verdade, um ponteiro.Em C++ é diferente. Discorra sobre esse aspecto.** ###

##### R: Somente as variaveis de tipos objetos que armazenam refencia para os objetos, sendo a gestão dessa memoria quando é criado um novo alocamento na memoria com o **new** sendo encarregada para o Garbage Collection. As variáveis de tipo primitvos armazenam o valor real. ######

##### Já em c++ a gestão desse ponteiro é de resposabilidade do programador, sendo assim toda vez que um novo espaço na memoria é alocada com o operador **new** ele precisa ser destruido para não ocorrer futuros bugs ou erros no codigo. #####


