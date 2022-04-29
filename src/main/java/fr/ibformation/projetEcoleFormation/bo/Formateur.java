package fr.ibformation.projetEcoleFormation.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Formateur {
	@Id
	@GeneratedValue
	private Integer idFormateur;
	private String adresse;
	private String codePostal;
	private String ville;
	public Formateur(String adresse, String codePostal, String ville) {
		super();
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	@Override
	public String toString() {
		return "Formateur [idFormateur=" + idFormateur + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + "]";
	}
	
	
	

}
