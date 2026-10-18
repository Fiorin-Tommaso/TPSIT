package org.example;

import net.datafaker.Faker;

public class Reclutatore {
    private Faker faker = new Faker();

    public void reclutaPerMissione(int difficolta) throws EroeNonIdoneoException {
        String nome = faker.superhero().name();
        int potere = faker.number().numberBetween(1, 101);

        System.out.println("Candidato: " + nome + " - Potere: " + potere);

        if (potere < difficolta) {
            throw new EroeNonIdoneoException(nome, potere);
        }

        System.out.println("Reclutato!");
    }
}