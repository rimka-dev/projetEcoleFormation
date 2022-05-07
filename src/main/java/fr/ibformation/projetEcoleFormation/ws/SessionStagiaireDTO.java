package fr.ibformation.projetEcoleFormation.ws;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import fr.ibformation.projetEcoleFormation.bo.EntrepriseClient;
import fr.ibformation.projetEcoleFormation.bo.Formation;
import fr.ibformation.projetEcoleFormation.bo.SessionFormation;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionStagiaireDTO {

	@NotBlank(message =  "Champs Code Postal vide")
	private String nomFormation;
	
	@NotBlank(message =  "Champs Ville vide")
	private Integer idSession;
	@NotBlank(message =  "Champs Nom Entreprise vide")
	private LocalDate dateDebut;
	@NotBlank(message =  "Champs Adresse Entreprise vide")
	private LocalDate dateFin;
	@NotBlank(message =  "Champs Code Postal Entreprise vide")
	private String typeFormation;
	
	

	public Formation toFormation() {
		Formation formation = new Formation();
		formation.setNomFormation(this.nomFormation);
		return formation;
	}
	
	public SessionFormation toSessionFormation() {
		SessionFormation sessionFormation = new SessionFormation();
		sessionFormation.setIdSession(this.idSession);
		sessionFormation.setDateDebut(this.dateDebut);
		sessionFormation.setDateFin(this.dateFin);
		sessionFormation.setTypeFormation(this.typeFormation);
		return sessionFormation;
	}
}
