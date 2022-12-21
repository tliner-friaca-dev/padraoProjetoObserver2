package br.com.projeto.observer.ouvintes;

import java.math.BigDecimal;
import java.util.List;

import br.com.projeto.observer.model.FichaAlteracaoPeso;
import br.com.projeto.observer.notificador.Notificador;

public class AcademiaOuvinte implements OuvinteInt {

    private Notificador notificador;

    public AcademiaOuvinte(Notificador notificador) {
        this.notificador = notificador;
        this.notificador.registrarOuvinte(this);
    }
    
    @Override
    public void avisarAlteracaoPeso() {

        List<FichaAlteracaoPeso> fichasAlteracaoPeso = this.notificador.getFichasAlteracaoPeso();

        for (FichaAlteracaoPeso fichaAlteracaoPeso : fichasAlteracaoPeso) {
            
            System.out.printf("Olá %s. A academia %s, avisa que vc teve uma alteração em seu peso para: %,.2f\n", 
                                fichaAlteracaoPeso.getAluno().getNome().toUpperCase(),
                                fichaAlteracaoPeso.getAcademia().getDescricao().toUpperCase(),
                                Double.parseDouble(fichaAlteracaoPeso.getAluno().getPeso().toString()));

        }
        
    }
    
}
