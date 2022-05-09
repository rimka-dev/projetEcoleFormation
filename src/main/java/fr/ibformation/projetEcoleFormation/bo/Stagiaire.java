package fr.ibformation.projetEcoleFormation.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Stagiaire extends Utilisateur {
	private String adresse;
	private String codePostal;
	private String ville;
	
	
	@ManyToOne
	@JsonBackReference
	private EntrepriseClient entreprise;
	
	@OneToMany(mappedBy = "stagiaire")
	@JsonBackReference(value="evaluation-session-stagiaire")
	private Set <EvaluationSession> listeEvalSession = new HashSet<>();
	
	@OneToMany(mappedBy = "stagiaire")
	@JsonBackReference(value="evaluation-formateur-stagiaire")
	private Set <EvaluationFormateur> listeEvalFormateur = new HashSet<>();
	
	@ManyToMany
	@JsonBackReference(value="session-formation-stagiaire")
	private Set <SessionFormation> listeSessionFormation = new HashSet<>();

	
	public Stagiaire(String nom, String prenom, String mail, String mdp, String statut, String adresse, String codePostal, String ville) {
		super( nom,  prenom,  mail,  mdp,  statut);
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	

	public void addEvalSession(EvaluationSession evalSession) {
		this.listeEvalSession.add(evalSession);
		evalSession.setStagiaire(this);
	}
	
	public void addEvalFormateur(EvaluationFormateur evalFormateur) {
		this.listeEvalFormateur.add(evalFormateur);
		evalFormateur.setStagiaire(this);
	}
	
	
	public void addSessionFormation(SessionFormation sessionFormation) {
		this.listeSessionFormation.add(sessionFormation);
		sessionFormation.getListeStagiaires().add(this);
	}
	
	@Override
	public String toString() {
		return super.toString()+ "Stagiaire [adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}

	
	
	
	

}
