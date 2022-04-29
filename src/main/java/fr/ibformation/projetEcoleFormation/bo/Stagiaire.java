package fr.ibformation.projetEcoleFormation.bo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
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
	private EntrepriseClient entreprise;
	
	@ManyToOne
	private EvaluationSession evalSession;
	
	public Stagiaire(String nom, String prenom, String mail, String mdp, String statut, String adresse, String codePostal, String ville) {
		super( nom,  prenom,  mail,  mdp,  statut);
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	

	
	@Override
	public String toString() {
		return super.toString()+ "Stagiaire [adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}

	
	
	
	

}
