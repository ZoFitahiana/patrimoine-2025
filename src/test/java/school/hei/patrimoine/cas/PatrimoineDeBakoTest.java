package school.hei.patrimoine.cas;

import static java.time.Month.*;
import static school.hei.patrimoine.modele.Devise.*;

import java.time.LocalDate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import school.hei.patrimoine.cas.example.PatrimoineBako;

@Slf4j
public class PatrimoineDeBakoTest {

    @Test
    void patrimoine_de_bako_au_31_decembre_2025() {
        var patrimoineBako = new PatrimoineBako().get();

        var patrimoineProjete =
                patrimoineBako
                        .projectionFuture(LocalDate.of(2025, DECEMBER, 31))
                        .getValeurComptable(MGA)
                        .ppMontant();

        log.error("{}", patrimoineProjete);
    }
}