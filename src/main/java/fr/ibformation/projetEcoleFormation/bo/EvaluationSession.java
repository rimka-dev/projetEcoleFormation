package fr.ibformation.projetEcoleFormation.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class EvaluationSession {
	@Id
	@GeneratedValue
	private Integer idEvalSession;
	private Integer noteEnvironnement;
	private Integer noteContenuFormation;
	private Integer niveauSatisfaction;
	private Boolean recommandationFormation;
	private Boolean autresProjetsFormations;
	
	@ManyToOne
	private Stagiaire stagiaire;
	
	public EvaluationSession(Integer noteEnvironnement, Integer noteContenuFormation, Integer niveauSatisfaction,
			Boolean recommandationFormation, Boolean autresProjetsFormations) {
		super();
		this.noteEnvironnement = noteEnvironnement;
		this.noteContenuFormation = noteContenuFormation;
		this.niveauSatisfaction = niveauSatisfaction;
		this.recommandationFormation = recommandationFormation;
		this.autresProjetsFormations = autresProjetsFormations;
	}

	@Override
	public String toString() {
		return "EvaluationSession [idEvalSession=" + idEvalSession + ", noteEnvironnement=" + noteEnvironnement
				+ ", noteContenuFormation=" + noteContenuFormation + ", niveauSatisfaction=" + niveauSatisfaction
				+ ", recommandationFormation=" + recommandationFormation + ", autresProjetsFormations="
				+ autresProjetsFormations + ", stagiaire=" + stagiaire + "]";
	}

}
