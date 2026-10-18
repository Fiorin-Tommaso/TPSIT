package org.example;

public class Main {
    public static void main(String[] args) {
        Reclutatore reclutatore = new Reclutatore();
        int difficolta = 75;

        for (int i = 0; i < 5; i++) {
            try {
                reclutatore.reclutaPerMissione(difficolta);
            } catch (EroeNonIdoneoException e) {
                System.out.println("Scartato: " + e.getMessage());
            }
        }
    }
}