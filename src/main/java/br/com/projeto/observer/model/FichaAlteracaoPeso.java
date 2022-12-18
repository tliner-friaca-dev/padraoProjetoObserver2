package br.com.projeto.observer.model;

import java.math.BigDecimal;
import java.util.Objects;

public class FichaAlteracaoPeso {
    
    private Academia academia;
    private Aluno aluno;
    private Nutricionista nutricionista;
    private PersonalTrainer personalTrainer;

    public FichaAlteracaoPeso() {
    }

    private FichaAlteracaoPeso(Academia academia, Aluno aluno, Nutricionista nutricionista, PersonalTrainer personalTrainer) {
        this.academia = academia;
        this.aluno = aluno;
        this.nutricionista = nutricionista;
        this.personalTrainer = personalTrainer;
    }

    public static class FichaAlteracaoPesoBuilder {

        private Academia academia;
        private Aluno aluno;
        private Nutricionista nutricionista;
        private PersonalTrainer personalTrainer;

        public FichaAlteracaoPesoBuilder comAcademia(long codigo, String descricao) {
            Academia academia = new Academia();
            academia.setCodigo(codigo);
            academia.setDescricao(descricao);

            this.academia = academia;

            return this;
        }
        
        public FichaAlteracaoPesoBuilder comAluno(long codigo, String nome, BigDecimal peso) {
            Aluno aluno = new Aluno();
            aluno.setCodigo(codigo);
            aluno.setNome(nome);
            aluno.setPeso(peso);

            this.aluno = aluno;

            return this;
        }
        
        public FichaAlteracaoPesoBuilder comNutricionista(long codigo, String nome) {
            Nutricionista nutricionista = new Nutricionista();
            nutricionista.setCodigo(codigo);
            nutricionista.setNome(nome);

            this.nutricionista = nutricionista;

            return this;
        }
        
        public FichaAlteracaoPesoBuilder comPersonalTrainer(long codigo, String nome) {
            PersonalTrainer personalTrainer = new PersonalTrainer();
            personalTrainer.setCodigo(codigo);
            personalTrainer.setNome(nome);

            this.personalTrainer = personalTrainer;

            return this;
        }

        public FichaAlteracaoPeso construir() {

            return new FichaAlteracaoPeso(academia, aluno, nutricionista, personalTrainer);

        }
    }

    public Academia getAcademia() {
        return this.academia;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Nutricionista getNutricionista() {
        return this.nutricionista;
    }

    public void setNutricionista(Nutricionista nutricionista) {
        this.nutricionista = nutricionista;
    }

    public PersonalTrainer getPersonalTrainer() {
        return this.personalTrainer;
    }

    public void setPersonalTrainer(PersonalTrainer personalTrainer) {
        this.personalTrainer = personalTrainer;
    }

    public FichaAlteracaoPeso academia(Academia academia) {
        setAcademia(academia);
        return this;
    }

    public FichaAlteracaoPeso aluno(Aluno aluno) {
        setAluno(aluno);
        return this;
    }

    public FichaAlteracaoPeso nutricionista(Nutricionista nutricionista) {
        setNutricionista(nutricionista);
        return this;
    }

    public FichaAlteracaoPeso personalTrainer(PersonalTrainer personalTrainer) {
        setPersonalTrainer(personalTrainer);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof FichaAlteracaoPeso)) {
            return false;
        }
        FichaAlteracaoPeso ficha = (FichaAlteracaoPeso) o;
        return Objects.equals(academia, ficha.academia) && Objects.equals(aluno, ficha.aluno) && Objects.equals(nutricionista, ficha.nutricionista) && Objects.equals(personalTrainer, ficha.personalTrainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(academia, aluno, nutricionista, personalTrainer);
    }

    @Override
    public String toString() {
        return "{" +
            " academia='" + getAcademia() + "'" +
            ", aluno='" + getAluno() + "'" +
            ", nutricionista='" + getNutricionista() + "'" +
            ", personalTrainer='" + getPersonalTrainer() + "'" +
            "}";
    }

}
