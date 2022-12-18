package br.com.projeto.observer.ouvintes;

import java.util.List;

import br.com.projeto.observer.model.FichaAlteracaoPeso;
import br.com.projeto.observer.notificador.Notificador;

public class NutricionistaOuvinte implements OuvinteInt {

    private Notificador notificador;

    public NutricionistaOuvinte(Notificador notificador) {
        this.notificador = notificador;
        this.notificador.registrarOuvinte(this);
    }

    @Override
    public void avisarAlteracaoPeso() {
        
        List<FichaAlteracaoPeso> fichasAlteracaoPeso = this.notificador.getFichasAlteracaoPeso();

        for (FichaAlteracaoPeso fichaAlteracaoPeso : fichasAlteracaoPeso) {
            
            System.out.printf("Olá %s. Aqui é a nutricionista %s. Devido a alteração seu peso para %2f vou montar um novo cardápio.\n", 
                                fichaAlteracaoPeso.getAluno().getNome().toUpperCase(),
                                fichaAlteracaoPeso.getNutricionista().getNome().toUpperCase(),
                                fichaAlteracaoPeso.getAluno().getPeso());

        }

    }
    
}
