package EmpresaCOELHO;

import java.time.LocalDate;

public class FalhaGeracao extends Falha {
    public FalhaGeracao(Imovel imovel, String descricao, LocalDate previsao) {
        super(imovel, descricao, previsao);
    }
}
