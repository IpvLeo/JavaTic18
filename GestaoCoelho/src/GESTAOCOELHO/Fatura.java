package GESTAOCOELHO;

import java.time.LocalDate;

public class Fatura {
 private double leituraAnterior;
 private double leituraAtual;
 private LocalDate dataEmissao;
 private double valorCalculado;
 private boolean quitada;

 public Fatura(double leituraAnterior, double leituraAtual) {
     this.leituraAnterior = leituraAnterior;
     this.leituraAtual = leituraAtual;
     this.dataEmissao = LocalDate.now();
     this.valorCalculado = calcularValor();
     this.quitada = false;
 }

 public double getLeituraAnterior() {
     return leituraAnterior;
 }

 public double getLeituraAtual() {
     return leituraAtual;
 }

 public LocalDate getDataEmissao() {
     return dataEmissao;
 }

 public double getValorCalculado() {
     return valorCalculado;
 }

 public boolean isQuitada() {
     return quitada;
 }

 public void quitarFatura() {
     this.quitada = true;
 }

 private double calcularValor() {
    
     double consumo = leituraAtual - leituraAnterior;
     return consumo * 10;
 }
}
