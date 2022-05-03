package fr.ibformation.projetEcoleFormation.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class EvaluationFormateur {
	@Id
	@GeneratedValue
	private Integer idEvalFormateur;
	private Integer notePedagogie;
	private Integer noteMaitriseDomaine;
	private Integer noteDisponibilite;
	private Integer noteReponsesQuestions;
	private Integer noteTechniqueAnimation;
	private Integer noteMoyenneFormateur;
	
	@ManyToOne
	@JsonBackReference
	private Formateur formateur;
	
	@ManyToOne
	@JsonBackReference(value="formateur-evaluation-stagiaire")
	private Stagiaire stagiaire;
	
	public EvaluationFormateur(Integer notePedagogie, Integer noteMaitriseDomaine, Integer noteDisponibilite,
			Integer noteReponsesQuestions, Integer noteTechniqueAnimation, Integer noteMoyenneFormateur) {
		super();
		this.notePedagogie = notePedagogie;
		this.noteMaitriseDomaine = noteMaitriseDomaine;
		this.noteDisponibilite = noteDisponibilite;
		this.noteReponsesQuestions = noteReponsesQuestions;
		this.noteTechniqueAnimation = noteTechniqueAnimation;
		this.noteMoyenneFormateur = noteMoyenneFormateur;
	}

	@Override
	public String toString() {
		return "EvaluationFormateur [idEvalFormateur=" + idEvalFormateur + ", notePedagogie=" + notePedagogie
				+ ", noteMaitriseDomaine=" + noteMaitriseDomaine + ", noteDisponibilite=" + noteDisponibilite
				+ ", noteReponsesQuestions=" + noteReponsesQuestions + ", noteTechniqueAnimation="
				+ noteTechniqueAnimation + ", noteMoyenneFormateur=" + noteMoyenneFormateur + "]";
	}
	
	
	
	
	
	

}
