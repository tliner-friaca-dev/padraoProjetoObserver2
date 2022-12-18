package br.com.projeto.observer.notificador;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.projeto.observer.model.FichaAlteracaoPeso;
import br.com.projeto.observer.ouvintes.OuvinteInt;

public class NotificadorAlteracaoPeso implements Notificador {

    private Set<OuvinteInt> ouvintesInt;
    private List<FichaAlteracaoPeso> fichasAlteracaoPeso;

    public NotificadorAlteracaoPeso() {
        this.ouvintesInt = new HashSet<>();
    }

    @Override
    public void registrarOuvinte(OuvinteInt ouvinteInt) {
        this.ouvintesInt.add(ouvinteInt);
    }

    @Override
    public void removerOuvinte(OuvinteInt ouvinteInt) {
        this.ouvintesInt.remove(ouvinteInt);
    }

    @Override
    public void notificarOuvintes() {
        for (OuvinteInt ouvinteInt : ouvintesInt) {
            ouvinteInt.avisarAlteracaoPeso();
        }
    }

    @Override
    public void novosAlunosComAlteracaoDePeso(List<FichaAlteracaoPeso> fichasAlteracaoPeso) {
        this.fichasAlteracaoPeso = fichasAlteracaoPeso;
        this.notificarOuvintes();
    }

    @Override
    public List<FichaAlteracaoPeso> getFichasAlteracaoPeso() {
        return this.fichasAlteracaoPeso;
    }

}
