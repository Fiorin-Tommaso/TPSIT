import org.example.ContoBancario;
import org.example.ImportoNonValidoException;
import org.example.SaldoInsufficienteException;

public void main() throws SaldoInsufficienteException {

    double saldo = 100;
    double importo = 200;

    ContoBancario mio = new ContoBancario(saldo);

    try{
        mio.preleva(importo);
    } catch (SaldoInsufficienteException e) {
        IO.println(e.toString());;
    }

    importo = -100;

    try {
        mio.preleva(importo);
    } catch (ImportoNonValidoException e) {
       IO.println(e.toString());
    }

    importo = 50;

    mio.preleva(importo);

}