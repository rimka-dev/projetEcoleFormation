package fr.ibformation.projetEcoleFormation.bo;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Formateur extends Utilisateur {
	private String adresse;
	private String codePostal;
	private String ville;
	
	
	@OneToMany(mappedBy = "formateur")
	private Set <EvaluationFormateur> listeEvalFormateur = new HashSet<>();
	
	@OneToMany(mappedBy = "formateur")
	private Set <SessionFormation> listeSessionFormation = new HashSet<>();
	
	public Formateur(String nom, String prenom, String mail, String mdp, String statut, String adresse, String codePostal, String ville) {
		super( nom,  prenom,  mail,  mdp,  statut);
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	public void addEvalFormateur(EvaluationFormateur evalFormateur) {
		this.listeEvalFormateur.add(evalFormateur);
		evalFormateur.setFormateur(this);
	}
	
	public void addSessionFormation(SessionFormation session) {
		this.listeSessionFormation.add(session);
		session.setFormateur(this);
	}
	
	@Override
	public String toString() {
		return "Formateur [adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + "]";
	}
	
	
	

}
