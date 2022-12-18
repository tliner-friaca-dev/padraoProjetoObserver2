package br.com.projeto.observer.notificador;

import java.util.List;

import br.com.projeto.observer.model.FichaAlteracaoPeso;
import br.com.projeto.observer.ouvintes.OuvinteInt;

public interface Notificador {

    public void registrarOuvinte(OuvinteInt ouvinteInt);
    public void removerOuvinte(OuvinteInt ouvinteInt);
    public void notificarOuvintes();

    public void novosAlunosComAlteracaoDePeso(List<FichaAlteracaoPeso> fichasAlteracaoPeso);
    public List<FichaAlteracaoPeso> getFichasAlteracaoPeso();
    
}
