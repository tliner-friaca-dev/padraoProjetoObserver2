package br.com.projeto.observer.model;

import java.util.Objects;

public class Academia {
    
    private long codigo;
    private String descricao;

    public Academia() {
    }

    private Academia(long codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static class AcademiaBuilder {
        
        private long codigo;
        private String descricao;

        public AcademiaBuilder comCodigo(long codigo) {
            this.codigo = codigo;
            return this;
        }

        public AcademiaBuilder comDescricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Academia construir() {
            return new Academia(codigo, descricao);
        }
    }

    public long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Academia codigo(long codigo) {
        setCodigo(codigo);
        return this;
    }

    public Academia descricao(String descricao) {
        setDescricao(descricao);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Academia)) {
            return false;
        }
        Academia academia = (Academia) o;
        return codigo == academia.codigo && Objects.equals(descricao, academia.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descricao);
    }

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", descricao='" + getDescricao() + "'" +
            "}";
    }

}
