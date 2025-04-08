package school.hei.patrimoine.cas.example;

import static java.time.Month.*;
import static school.hei.patrimoine.modele.Argent.*;
import static school.hei.patrimoine.modele.Devise.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.function.Supplier;
import school.hei.patrimoine.modele.Patrimoine;
import school.hei.patrimoine.modele.Personne;
import school.hei.patrimoine.modele.possession.Compte;
import school.hei.patrimoine.modele.possession.FluxArgent;
import school.hei.patrimoine.modele.possession.Materiel;
import school.hei.patrimoine.modele.possession.Possession;
import school.hei.patrimoine.modele.possession.TransfertArgent;

public class PatrimoineBako implements Supplier<Patrimoine> {
    private static final LocalDate AU_8_AVRIL_2025 = LocalDate.of(2025, APRIL, 8);

    @Override
    public Patrimoine get() {
        var Bako = new Personne("Bako");
        return Patrimoine.of(
                "Bien de Bako", MGA, AU_8_AVRIL_2025, Bako, possessionsBako());
    }

    private static Set<Possession> possessionsBako() {
        var compteBNI =
                new Compte("Compte principal BNI", AU_8_AVRIL_2025, ariary(2_000_000));

        var compteBMOI =
                new Compte("Compte épargne BMOI", AU_8_AVRIL_2025, ariary(625_000));

        var coffreFort = new Compte("Argent en espèces à domicile", AU_8_AVRIL_2025, ariary(1_750_000));

        var salaire =
                new FluxArgent(
                        "Revenu du contrat CDI",
                        compteBNI,
                        AU_8_AVRIL_2025,
                        LocalDate.MAX,
                        2,
                        ariary(2_125_000));

        var virementEpargne =
                new TransfertArgent(
                        "Transfert vers l’épargne",
                        compteBNI,
                        compteBMOI,
                        AU_8_AVRIL_2025,
                        LocalDate.MAX,
                        3,
                        ariary(200_000));

        var loyer =
                new FluxArgent(
                        "Paiement loyer colocation",
                        compteBNI,
                        AU_8_AVRIL_2025,
                        LocalDate.MAX,
                        26,
                        ariary(-600_000));

        var trainDeVie =
                new FluxArgent(
                        "Frais quotidiens : repas, déplacement, etc.",
                        compteBNI,
                        AU_8_AVRIL_2025,
                        LocalDate.MAX,
                        1,
                        ariary(-700_000));

        var ordinateurPortable =
                new Materiel(
                        "Ordinateur portable Acer Nitro", AU_8_AVRIL_2025, AU_8_AVRIL_2025, ariary(3_000_000), -0.12);

        return Set.of(
                compteBNI,
                compteBMOI,
                coffreFort,
                salaire,
                virementEpargne,
                loyer,
                trainDeVie,
                ordinateurPortable);
    }
}
