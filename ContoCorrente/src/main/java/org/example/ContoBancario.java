package org.example;

public class ContoBancario {
    private double saldo;

    public ContoBancario(Double saldo) throws SaldoInsufficienteException {
        this.saldo = saldo;
        if(saldo < 0){
            throw new SaldoInsufficienteException("Saldo insufficiente", saldo, 0);
        }
    }

    public void preleva(double importo) throws SaldoInsufficienteException {
        if(importo <= 0){
            throw new ImportoNonValidoException("Importo non sufficiente");
        }
        if(saldo - importo < 0){
            throw new SaldoInsufficienteException("Saldo insufficiente", saldo, importo);
        }
        if(saldo - importo >= 0){
            saldo -= importo;
            IO.println("Importo detratto con successo");
        }
    }
}
