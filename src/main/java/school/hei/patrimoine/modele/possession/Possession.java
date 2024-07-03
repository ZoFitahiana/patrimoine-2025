package school.hei.patrimoine.modele.possession;

import static school.hei.patrimoine.modele.Devise.ARIARY;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import school.hei.patrimoine.modele.Devise;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
public sealed abstract class Possession implements Serializable /*note(no-serializable)*/ permits
	Argent, FluxArgent, TransfertArgent,
	Materiel, AchatMaterielAuComptant,
	GroupePossession {
	protected final String nom;
	protected final LocalDate t;
	protected final int valeurComptable;
	protected final Devise devise;

	public final int valeurComptableFuture(LocalDate tFutur) {
		return projectionFuture(tFutur).getValeurComptable(this.devise, tFutur);
	}

	public abstract Possession projectionFuture(LocalDate tFutur);

	public final int getValeurComptable(Devise autreDevise, LocalDate tFutur) {
		double valeurEnAriaryAutreDeviseATempsT = autreDevise.valeurEnAriary(tFutur);
		return (int) ((this.valeurComptable * this.devise.valeurEnAriary(tFutur)) / valeurEnAriaryAutreDeviseATempsT);
	}
}
