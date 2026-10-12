package org.example;

public class SaldoInsufficienteException extends Exception {
    private double attuale;
    private double importo;

    public SaldoInsufficienteException(String message, double attuale, double importo) {
        super(message + "\nSaldo attuale: " + attuale + "\nImporto richiesto: " + importo);
        this.importo = importo;
        this.attuale = attuale;
    }

    public double getAttuale() {
        return attuale;
    }

    public double getImporto() {
        return importo;
    }
}
