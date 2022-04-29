package fr.ibformation.projetEcoleFormation.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Utilisateur {
	@Id
	@GeneratedValue
	private Integer idUtilisateur;
	private String nom;
	private String prenom;
	private String mail;
	private String mdp;
	private String statut;
		
	
	public Utilisateur(String nom, String prenom, String mail, String mdp, String statut) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.statut = statut;
	}
	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail
				+ ", mdp=" + mdp + ", statut=" + statut + "]";
	}
	
	
	
	
	
	

}
