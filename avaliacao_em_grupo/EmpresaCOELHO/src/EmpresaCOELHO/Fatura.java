package EmpresaCOELHO;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Fatura { 
		
		public Fatura(Imovel imovel,  int ultimaLeitura, int penultimaLeitura) {
			this.imovel = imovel;
			this.ultimaLeitura = ultimaLeitura;
			this.penultimaLeitura = penultimaLeitura;
			this.dataEmissao = new Date();
			this.valorCalculado = calcularValor();
			this.quitada = false;
			this.id = ++proximoId; 
			pagamentos = new ArrayList<Pagamento>();
		}
		
		private Long id;
		private Imovel imovel;
		private int ultimaLeitura;
		private int penultimaLeitura;
		private Date dataEmissao;
		private double valorCalculado;
		private static Long proximoId = 0L; 
		private List<Pagamento> pagamentos;	
		private boolean quitada;


		public Long getId() {
			return id;
		}

		public Imovel getImovel() {
			return imovel;
		}

		public double getUltimaLeitura() {
			return ultimaLeitura;
		}

		public double getPenultimaLeitura() {
			return penultimaLeitura;
		}

		public Date getDataEmissao() {
			return dataEmissao;
		}

		public double getValorCalculado() {
			return valorCalculado;
		}

		public boolean isQuitada() {
			return quitada;
		}

		public List<Pagamento> getPagamentos() {
			return pagamentos;
		}

		@Override
		public String toString() {
		    StringBuilder sb = new StringBuilder();

		    sb.append("Id: ").append(id)
		      .append("\nMatrícula do Imóvel: ").append(imovel.getMatricula())
		      .append("\nData de Emissão: ").append(dataEmissao)
		      .append("\nÚltima Leitura: ").append(ultimaLeitura)
		      .append("\nPenúltima Leitura: ").append(penultimaLeitura);

		    double valorParcial = valorPago();
		    if (valorParcial > 0) {
		        sb.append("\nValor Pago Parcial: ").append(valorParcial);
		    }

		    sb.append("\nValor Calculado: ").append(valorCalculado)
		      .append("\nQuitada: ").append(quitada)
		      .append("\n---------------------");

		    return sb.toString();
		}
		

		private double calcularValor() {
			return (ultimaLeitura - penultimaLeitura) * 10;
		}

		public void adicionaPagamento(Pagamento pagamento) {
		    final double valorFatura = calcularValor();
		    final double valorPago = valorPago();

		    if (quitada) {
		        System.out.println("Fatura quitada! Não é possível pagar.");
		        return;
		    }

		    pagamentos.add(pagamento);

		    if (valorPago >= valorFatura) {
		        quitada = true;

		        if (valorPago > valorFatura) {
		            double valorExcedente = valorPago - valorFatura;
		            pagamento.geraReembolso(valorExcedente);
		            System.out.printf("Fatura quitada - reembolso de R$%.2f%n", pagamento.getReembolso().getValor());
		        } else {
		            System.out.println("Fatura quitada.");
		        }
		    }
		}


		public double valorPago() {
		    return pagamentos.stream()
		            .mapToDouble(Pagamento::getValor)
		            .sum();
		}

}
