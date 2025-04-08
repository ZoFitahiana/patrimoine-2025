package school.hei.patrimoine.cas;


import static java.time.Month.MARCH;
import static school.hei.patrimoine.modele.Devise.MGA;

import java.time.LocalDate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import school.hei.patrimoine.cas.example.PatrimoineDeTiana;

@Slf4j
public class PatrimoineDeTianaTest {
    @Test
    void patrimoine_de_Tiana_au_31_decembre_2025() {
        var patrimoineDeTiana = new PatrimoineDeTiana().get();

        var valeurPatrimoineProjete =
                patrimoineDeTiana
                        .projectionFuture(LocalDate.of(2026, MARCH, 31))
                        .getValeurComptable(MGA)
                        .ppMontant();

        log.error("{}", valeurPatrimoineProjete);
    }
}