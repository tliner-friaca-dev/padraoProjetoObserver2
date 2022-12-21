package br.com.projeto.observer.repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import br.com.projeto.observer.model.FichaAlteracaoPeso;

public class FichaAlteracaoPesoRepository {

    public List<FichaAlteracaoPeso> buscarFichaAlteracaoPeso() {

        FichaAlteracaoPeso fichaAlteracaoPeso1 = new FichaAlteracaoPeso.FichaAlteracaoPesoBuilder()
                                                    .comAcademia(1, "Academia-1")
                                                    .comAluno(1, "Aluno-1", new BigDecimal("50.3"))
                                                    .comNutricionista(1, "Nutricionista-1")
                                                    .comPersonalTrainer(1, "Personal Trainer-1")
                                                    .construir();

    FichaAlteracaoPeso fichaAlteracaoPeso2 = new FichaAlteracaoPeso.FichaAlteracaoPesoBuilder()
                                                    .comAcademia(2, "Academia-2")
                                                    .comAluno(2, "Aluno-2", new BigDecimal("60.3"))
                                                    .comNutricionista(2, "Nutricionista-2")
                                                    .comPersonalTrainer(2, "Personal Trainer-2")
                                                    .construir();

    FichaAlteracaoPeso fichaAlteracaoPeso3 = new FichaAlteracaoPeso.FichaAlteracaoPesoBuilder()
                                                    .comAcademia(3, "Academia-3")
                                                    .comAluno(3, "Aluno-3", new BigDecimal("70.3"))
                                                    .comNutricionista(3, "Nutricionista-3")
                                                    .comPersonalTrainer(3, "Personal Trainer-3")
                                                    .construir();

        return Arrays.asList(fichaAlteracaoPeso1, fichaAlteracaoPeso2, fichaAlteracaoPeso3);

    }
    
}
