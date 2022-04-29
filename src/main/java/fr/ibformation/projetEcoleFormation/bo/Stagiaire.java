package fr.ibformation.projetEcoleFormation.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Stagiaire {
	@Id
	@GeneratedValue
	private Integer idStagiaire;
	private String adresse;
	private String codePostal;
	private String ville;
	public Stagiaire(String adresse, String codePostal, String ville) {
		super();
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	@Override
	public String toString() {
		return "Stagiaire [idStagiaire=" + idStagiaire + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + "]";
	}
	
	
	

}
