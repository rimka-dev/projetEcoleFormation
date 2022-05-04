package fr.ibformation.projetEcoleFormation.ws;

import fr.ibformation.projetEcoleFormation.bo.EntrepriseClient;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StagiaireDTO {

	private String nom;
	private String prenom;
	private String mail;
	private String mdp;
	private String adresse;
	private String codePostal;
	private String ville;
	private String statut;
	private String nomEntreprise;
	private String adresseEntreprise;
	private String codePostalEntreprise;
	private String villeEntreprise;
	
	public StagiaireDTO(Stagiaire stagiaire) {
		this.nom = stagiaire.getNom();
		this.prenom = stagiaire.getPrenom();
		this.mail = stagiaire.getMail();
		this.mdp = stagiaire.getMdp();
		this.adresse = stagiaire.getAdresse();
		this.codePostal = stagiaire.getCodePostal();
		this.ville = stagiaire.getVille();
		this.statut = stagiaire.getStatut();
		this.nomEntreprise = stagiaire.getEntreprise().getNomEntreprise();
		this.adresseEntreprise = stagiaire.getEntreprise().getAdresse();
		this.codePostalEntreprise = stagiaire.getEntreprise().getCodePostal();
		this.villeEntreprise = stagiaire.getEntreprise().getVille();
	}
	
	public Stagiaire toStagiaire() {
		Stagiaire stagiaire = new Stagiaire();
		stagiaire.setNom(this.nom);
		stagiaire.setPrenom(this.prenom);
		stagiaire.setMail(this.mail);
		stagiaire.setMdp(this.mdp);
		stagiaire.setAdresse(this.adresse);
		stagiaire.setCodePostal(this.codePostal);
		stagiaire.setVille(this.ville);
		stagiaire.setStatut(this.statut);
		return stagiaire;
	}
	
	public EntrepriseClient toEntreprise() {
		EntrepriseClient entreprise = new EntrepriseClient();
		entreprise.setNomEntreprise(this.nomEntreprise);
		entreprise.setAdresse(this.adresseEntreprise);
		entreprise.setCodePostal(this.codePostalEntreprise);
		entreprise.setVille(this.villeEntreprise);
		return entreprise;
	}
	
}
