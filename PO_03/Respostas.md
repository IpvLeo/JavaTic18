# Conceitos Iniciais de Programação em Java

## 1. O que é uma exceção em Java e qual é o propósito de usá-las em programas?

Em Java, uma exceção é um evento que ocorre durante a execução de um programa e interrompe o fluxo normal de instruções. O propósito das exceções é lidar com situações imprevistas e tratar erros de forma elegante, permitindo que o programa reporte e trate erros de maneira adequada, em vez de simplesmente quebrar.

## 2. Diferença entre exceções verificadas e não verificadas em Java:

- **Exceções verificadas:** São exceções que o compilador exige que sejam tratadas explicitamente no código. Exemplos incluem `IOException` e `SQLException`.

- **Exceções não verificadas:** São exceções que o compilador não obriga a serem tratadas explicitamente. Exemplos incluem `NullPointerException` e `ArrayIndexOutOfBoundsException`.

## 3. Como lidar com exceções em Java?

Em Java, as exceções podem ser tratadas usando as palavras-chave `try`, `catch`, `finally` e `throw`. O bloco `try` contém o código que pode gerar exceções, o bloco `catch` lida com as exceções e o bloco `finally` é opcional e contém código que será executado independentemente de ocorrer ou não uma exceção.

## 4. O que é o bloco "try-catch" em Java?

O bloco `try-catch` é usado para envolver um bloco de código que pode gerar exceções. O bloco `try` contém o código que pode lançar uma exceção, e o bloco `catch` contém o código que será executado se uma exceção específica for lançada no bloco `try`. Isso é fundamental para o tratamento de exceções, permitindo que o programa continue sua execução mesmo após um erro.

## 5. Quando é apropriado criar suas próprias exceções personalizadas em Java?

É apropriado criar exceções personalizadas quando você precisa lidar com situações específicas do seu domínio de aplicação que não são adequadamente representadas pelas exceções padrão do Java. Isso ajuda a tornar seu código mais legível e a manter a consistência nas mensagens de erro.

   
