import static java.lang.IO.println;

void main() {
    Azienda azienda = new Azienda();

    azienda.aggiungi(new Impiegato("Mauro", 10));
    azienda.aggiungi(new Manager("Luigi", 11, 1));
    azienda.aggiungi(new Venditore("Matteo", 8d, 3, 30d));
    azienda.aggiungi(new Stagista("Alfonso", 10));

    println("Costo totale: " + azienda.constoTotale());
    azienda.stampaTutti();
    println("Più pagato: " + azienda.piuPagato().descrizione());
}

public abstract class Dipendente {
    protected String nome;
    protected double stipendioBase;

    public Dipendente(String nome, double stipendioBase) {
        this.nome = nome;
        this.stipendioBase = stipendioBase;
    }

    public abstract double calcolaStipendio();

    public String descrizione() {
        return "dipendente: " + nome;
    };

    @Override
    public String toString() {
        return descrizione() + " stipendio: " + calcolaStipendio();
    }
}

class Impiegato extends Dipendente {

    public Impiegato(String nome, double stipendioBase) {
        super(nome, stipendioBase);
    }

    @Override
    public double calcolaStipendio() {
        return stipendioBase;
    }
}

public class Manager extends Dipendente {

    public Integer bonus;

    public Manager(String nome, double stipendioBase, Integer bonus) {
        super(nome, stipendioBase);
        this.bonus = bonus;
    }

    @Override
    public double calcolaStipendio() {
        return bonus + stipendioBase;
    }

    @Override
    public String descrizione() {
        return super.descrizione() + "(manager)";
    }
}

public class Venditore extends Dipendente {
    public Integer vendite;
    public Double percentualeCommizione;

    public Venditore(String nome,Double stipendio , Integer vendite, Double percentualeCommizione) {
        super(nome, stipendio);
        this.vendite = vendite;
        this.percentualeCommizione = percentualeCommizione;
    }

    @Override
    public double calcolaStipendio() {
        return vendite * percentualeCommizione / 100 + stipendioBase;
    }
}

public class Stagista extends Impiegato {

    public Stagista(String nome, double stipendioBase) {
        super(nome, stipendioBase);
    }

    @Override
    public double calcolaStipendio() {
        return stipendioBase / 2;
    }
}

public class Azienda {
    private ArrayList<Dipendente> dipendenti;

    public Azienda() {
        dipendenti = new ArrayList<>();
    }

    public void aggiungi(Dipendente d) {
        dipendenti.add(d);
    }

    public double constoTotale() {
        double total = 0f;
        for (Dipendente d : dipendenti) {
            total += d.calcolaStipendio();
        }
        return total;
    }

    public void stampaTutti() {
        for (Dipendente d : dipendenti) {
            println(d.descrizione());
        }
    }

    public Dipendente piuPagato() {
        Dipendente d = new Impiegato("default", -1);
        for (Dipendente dp : dipendenti) {
            if(d.calcolaStipendio() <= dp.calcolaStipendio()) {
                d = dp;
            }
        }
        return d;
    }
}
