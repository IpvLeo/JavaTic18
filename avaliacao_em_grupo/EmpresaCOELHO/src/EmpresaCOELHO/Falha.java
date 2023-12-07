package EmpresaCOELHO;
import java.time.LocalDate;

public class Falha {

    public Falha(Imovel imovel, String descricao, LocalDate previsao) {
        this.setImovel(imovel);
        this.setDescricao(descricao);
        this.setPrevisao(previsao);
    }
    
    private Imovel imovel;
    private String descricao;
    private LocalDate previsao;
    private LocalDate dataInicio;
    private LocalDate dataFim;

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getPrevisao() {
		return previsao;
	}

	public void setPrevisao(LocalDate previsao) {
		this.previsao = previsao;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
}