package fr.ibformation.projetEcoleFormation.ws;

import javax.validation.constraints.NotNull;

import fr.ibformation.projetEcoleFormation.bo.EvaluationFormateur;
import fr.ibformation.projetEcoleFormation.bo.EvaluationSession;
import fr.ibformation.projetEcoleFormation.bo.SessionFormation;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationDTO {

	private Integer idEvalSession;
	@NotNull
	private Integer noteAccueil;
	@NotNull
	private Integer noteEnvironnement;
	@NotNull
	private Integer noteContenuFormation;
	@NotNull
	private String niveauSatisfaction;
	@NotNull
	private Boolean recommandationFormation;
	@NotNull
	private Boolean autresProjetsFormations;
	@NotNull
	private Integer notePedagogie;
	@NotNull
	private Integer noteMaitriseDomaine;
	@NotNull
	private Integer noteDisponibilite;
	@NotNull
	private Integer noteReponsesQuestions;
	@NotNull
	private Integer noteTechniqueAnimation;
	@NotNull
	private Integer idSession;
	@NotNull
	private String nom;
	
	public SessionFormation toSessionFormation() {
	
		SessionFormation session = new SessionFormation();
		session.setIdSession(this.idSession);
		return session;
	}
	
	public Stagiaire toStagiaire() {
		
		Stagiaire stagiaire = new Stagiaire();
		stagiaire.setNom(this.nom);
		return stagiaire;
	}
	
	public EvaluationSession toEvaluationSession() {
		EvaluationSession evalSession = new EvaluationSession();
		evalSession.setNoteAccueil(this.noteAccueil);
		evalSession.setNoteEnvironnement(this.noteEnvironnement);
		evalSession.setNoteContenuFormation(this.noteContenuFormation);
		evalSession.setNiveauSatisfaction(this.niveauSatisfaction);
		evalSession.setRecommandationFormation(this.recommandationFormation);
		evalSession.setAutresProjetsFormations(this.autresProjetsFormations);
		return evalSession;
	
	}	
	
	
	public EvaluationFormateur toEvaluationFormateur() {
		EvaluationFormateur evalFormateur = new EvaluationFormateur();
		evalFormateur.setNotePedagogie(this.notePedagogie);
		evalFormateur.setNoteMaitriseDomaine(this.noteMaitriseDomaine);
		evalFormateur.setNoteDisponibilite(this.noteDisponibilite);
		evalFormateur.setNoteReponsesQuestions(this.noteReponsesQuestions);
		evalFormateur.setNoteTechniqueAnimation(this.noteTechniqueAnimation);
		return evalFormateur;
	}
	
}
