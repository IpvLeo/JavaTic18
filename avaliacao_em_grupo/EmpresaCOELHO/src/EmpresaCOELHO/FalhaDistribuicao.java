package EmpresaCOELHO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FalhaDistribuicao extends Falha {

    public FalhaDistribuicao(Imovel imovel, String descricao, LocalDate previsao) {
        super(imovel, descricao, previsao);
        this.reparos = new ArrayList<>();
    }
    private List<Reparo> reparos;

    public void adicionarReparo(Reparo reparo) {
        reparos.add(reparo);
    }
}
