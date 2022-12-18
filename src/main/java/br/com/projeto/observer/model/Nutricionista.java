package br.com.projeto.observer.model;

import java.util.Objects;

public class Nutricionista {

    private long codigo;
    private String nome;

    public Nutricionista() {
    }

    private Nutricionista(long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public static class NutricionistaBuilder {
        
        private long codigo;
        private String nome;

        public NutricionistaBuilder comCodigo(long codigo) {
            this.codigo = codigo;
            return this;
        }

        public NutricionistaBuilder comNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Nutricionista construir() {
            return new Nutricionista(codigo, nome);
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

    public Nutricionista codigo(long codigo) {
        setCodigo(codigo);
        return this;
    }

    public Nutricionista nome(String nome) {
        setNome(nome);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Nutricionista)) {
            return false;
        }
        Nutricionista nutricionista = (Nutricionista) o;
        return codigo == nutricionista.codigo && Objects.equals(nome, nutricionista.nome);
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
