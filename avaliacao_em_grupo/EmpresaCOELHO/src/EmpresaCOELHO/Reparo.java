package EmpresaCOELHO;

import java.time.LocalDate;

public class Reparo {   

    public Reparo(String descricaoAtividade, LocalDate previsao) {
        this.descricaoAtividade = descricaoAtividade;
        this.previsao = previsao;
        this.dataInicio = LocalDate.now();
        this.resolvido = false;
    }
    
    private String descricaoAtividade;
    private LocalDate previsao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private boolean resolvido;

    public String getDescricaoAtividade() {
		return descricaoAtividade;
	}

	public void setDescricaoAtividade(String descricaoAtividade) {
		this.descricaoAtividade = descricaoAtividade;
	}

	public LocalDate getPrevisao() {
		return previsao;
	}

	public void setPrevisao(LocalDate previsao) {
		this.previsao = previsao;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public void setResolvido(boolean resolvido) {
		this.resolvido = resolvido;
	}

	public void finalizarReparo(boolean resolvido) {
        this.dataFim = LocalDate.now();
        this.resolvido = resolvido;
    }

    public boolean isResolvido() {
        return resolvido;
    }
}
