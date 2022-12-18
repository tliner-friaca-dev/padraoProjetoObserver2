package br.com.projeto.observer.model;

import java.util.Objects;

public class PersonalTrainer {
    
    private long codigo;
    private String nome;

    public PersonalTrainer() {
    }

    private PersonalTrainer(long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public static class PersonalTrainerBuilder {
        
        private long codigo;
        private String nome;

        public PersonalTrainerBuilder comCodigo(long codigo) {
            this.codigo = codigo;
            return this;
        }

        public PersonalTrainerBuilder comNome(String nome) {
            this.nome = nome;
            return this;
        }

        public PersonalTrainer construir(){
            return new PersonalTrainer(codigo, nome);
        }
    }

    public long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PersonalTrainer codigo(long codigo) {
        setCodigo(codigo);
        return this;
    }

    public PersonalTrainer nome(String nome) {
        setNome(nome);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PersonalTrainer)) {
            return false;
        }
        PersonalTrainer personalTrainer = (PersonalTrainer) o;
        return codigo == personalTrainer.codigo && Objects.equals(nome, personalTrainer.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome);
    }

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", nome='" + getNome() + "'" +
            "}";
    }

}
