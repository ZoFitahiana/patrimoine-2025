package school.hei.patrimoine.cas;

import static java.time.Month.APRIL;
import static java.time.Month.DECEMBER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static school.hei.patrimoine.modele.Argent.ariary;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import school.hei.patrimoine.cas.example.PatrimoineBakoAu31Decembre2025;
import school.hei.patrimoine.modele.Patrimoine;

class PatrimoineDeBakoTest {

  private final PatrimoineBakoAu31Decembre2025 patrimoineDeBakoSupplier =
      new PatrimoineBakoAu31Decembre2025();

  private Patrimoine patrimoineDeBako8Avril2025() {
    return patrimoineDeBakoSupplier.get();
  }

  @Test
  void bako_projection_fin_annee_2025() {
    var patrimoineDeBakoAu8Avril = patrimoineDeBako8Avril2025();
    var projeté = patrimoineDeBakoAu8Avril.projectionFuture(LocalDate.of(2025, DECEMBER, 31));

    assertEquals(ariary(13_925_000), projeté.getValeurComptable());
  }
}
