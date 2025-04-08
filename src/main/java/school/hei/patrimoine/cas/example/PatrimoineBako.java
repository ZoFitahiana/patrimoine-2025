package school.hei.patrimoine.cas.example;

import static java.time.Month.APRIL;
import static java.time.Month.DECEMBER;
import static school.hei.patrimoine.modele.Argent.ariary;
import static school.hei.patrimoine.modele.Devise.MGA;

import java.time.LocalDate;
import java.util.Set;
import java.util.function.Supplier;
import school.hei.patrimoine.modele.Patrimoine;
import school.hei.patrimoine.modele.Personne;
import school.hei.patrimoine.modele.possession.Compte;
import school.hei.patrimoine.modele.possession.FluxArgent;
import school.hei.patrimoine.modele.possession.Materiel;
import school.hei.patrimoine.modele.possession.Possession;

public class PatrimoineBakoAu31Decembre2025 implements Supplier<Patrimoine> {

  public static final LocalDate AU_8_AVRIL_2025 = LocalDate.of(2025, APRIL, 8);
  public static final LocalDate AU_31_DECEMBRE_2025 = LocalDate.of(2025, DECEMBER, 31);

  private static Set<Possession> possessionsDu8Avril2025(
      Compte compteBNI, Compte compteBMOI, Compte coffreFort, Materiel ordinateur) {
    return Set.of(compteBNI, compteBMOI, coffreFort, ordinateur);
  }

  private static Set<Possession> fluxArgentMensuels(Compte compteBNI, Compte compteBMOI) {
    new FluxArgent(
        "salaire mensuel",
        compteBNI,
        AU_8_AVRIL_2025,
        AU_31_DECEMBRE_2025,
        2,
        ariary(2_125_000));
    new FluxArgent(
        "épargne mensuelle",
        compteBMOI,
        AU_8_AVRIL_2025.plusDays(1),
        AU_31_DECEMBRE_2025,
        3,
        ariary(200_000));
    new FluxArgent(
        "loyer mensuel",
        compteBNI,
        AU_8_AVRIL_2025,
        AU_31_DECEMBRE_2025,
        26,
        ariary(-600_000));
    new FluxArgent(
        "dépenses mensuelles",
        compteBNI,
        AU_8_AVRIL_2025,
        AU_31_DECEMBRE_2025,
        1,
        ariary(-700_000));
    return Set.of();
  }

  private Compte compteBNI() {
    return new Compte("compte BNI", AU_8_AVRIL_2025, ariary(2_000_000));
  }

  private Compte compteBMOI() {
    return new Compte("compte BMOI", AU_8_AVRIL_2025, ariary(625_000));
  }

  private Compte coffreFort() {
    return new Compte("coffre fort", AU_8_AVRIL_2025, ariary(1_750_000));
  }

  private Materiel ordinateur() {
    return new Materiel(
        "ordinateur", AU_8_AVRIL_2025, AU_8_AVRIL_2025, ariary(3_000_000), -0.12);
  }

  @Override
  public Patrimoine get() {
    var bako = new Personne("Bako");
    var compteBNI = compteBNI();
    var compteBMOI = compteBMOI();
    var coffreFort = coffreFort();
    var ordinateur = ordinateur();

    Set<Possession> possessionsDu8Avril =
        possessionsDu8Avril2025(compteBNI, compteBMOI, coffreFort, ordinateur);
    Set<Possession> fluxMensuels = fluxArgentMensuels(compteBNI, compteBMOI);

    return Patrimoine.of(
        "Bako au 31 décembre 2025", MGA, AU_31_DECEMBRE_2025, bako,
        Set.of(possessionsDu8Avril, fluxMensuels));
  }
}
