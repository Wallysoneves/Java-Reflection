package br.com.reflection;

public class Endereco {

    public Endereco(String rua, Integer numero) {
        this.rua = rua;
        this.numero = numero;
    }

    private String rua;
    private Integer numero;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
