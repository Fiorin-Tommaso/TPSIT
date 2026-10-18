package org.example;

public class EroeNonIdoneoException extends Exception {
    private String nome;
    private int livello;

    public EroeNonIdoneoException(String nome, int livello) {
        super("Eroe " + nome + " non idoneo con potere " + livello);
        this.nome = nome;
        this.livello = livello;
    }

    public String getNome() {
        return nome;
    }

    public int getLivello() {
        return livello;
    }
}