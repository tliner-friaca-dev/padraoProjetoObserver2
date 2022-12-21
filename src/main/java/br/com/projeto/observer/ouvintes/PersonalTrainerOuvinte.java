package br.com.projeto.observer.ouvintes;

import java.util.List;

import br.com.projeto.observer.model.FichaAlteracaoPeso;
import br.com.projeto.observer.notificador.Notificador;

public class PersonalTrainerOuvinte implements OuvinteInt {

    private Notificador notificador;

    public PersonalTrainerOuvinte(Notificador notificador) {
        this.notificador = notificador;
        this.notificador.registrarOuvinte(this);
    }

    @Override
    public void avisarAlteracaoPeso() {
        
        List<FichaAlteracaoPeso> fichasAlteracaoPeso = this.notificador.getFichasAlteracaoPeso();

        for (FichaAlteracaoPeso fichaAlteracaoPeso : fichasAlteracaoPeso) {
            
            System.out.printf("Olá %s. Aqui é o personal trainer %s. Devido a alteração seu peso para %,.2f vou montar um novo treino.\n", 
                                fichaAlteracaoPeso.getAluno().getNome().toUpperCase(),
                                fichaAlteracaoPeso.getPersonalTrainer().getNome().toUpperCase(),
                                Double.parseDouble(fichaAlteracaoPeso.getAluno().getPeso().toString()));

        }

    }
    
}
