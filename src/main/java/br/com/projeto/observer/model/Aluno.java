package br.com.projeto.observer.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Aluno {
    
    private long codigo;
    private String nome;
    private BigDecimal peso;

    public Aluno() {
    }

    private Aluno(long codigo, String nome, BigDecimal peso) {
        this.codigo = codigo;
        this.nome = nome;
        this.peso = peso;
    }

    public static class AlunoBuilder {
        
        private long codigo;
        private String nome;
        private BigDecimal peso;
        
        public AlunoBuilder comCodigo(long codigo){
            this.codigo = codigo;
            return this;
        }

        public AlunoBuilder comNome(String nome){
            this.nome = nome;
            return this;
        }
        
        public AlunoBuilder comPeso(BigDecimal peso){
            this.peso = peso;
            return this;
        }

        public Aluno construir(){
            return new Aluno(codigo, nome, peso);
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

    public BigDecimal getPeso() {
        return this.peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Aluno codigo(long codigo) {
        setCodigo(codigo);
        return this;
    }

    public Aluno nome(String nome) {
        setNome(nome);
        return this;
    }

    public Aluno peso(BigDecimal peso) {
        setPeso(peso);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Aluno)) {
            return false;
        }
        Aluno Aluno = (Aluno) o;
        return codigo == Aluno.codigo && Objects.equals(nome, Aluno.nome) && Objects.equals(peso, Aluno.peso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, peso);
    }

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", nome='" + getNome() + "'" +
            ", peso='" + getPeso() + "'" +
            "}";
    }

}
