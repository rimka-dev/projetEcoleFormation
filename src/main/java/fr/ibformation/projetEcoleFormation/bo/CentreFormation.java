package fr.ibformation.projetEcoleFormation.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CentreFormation {
	@Id
	@GeneratedValue
	private Integer idCentreFormation;
	private String nom;
	private String codePostal;
	private String ville;
	
	public CentreFormation(String nom, String codePostal, String ville) {
		super();
		this.nom = nom;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	@Override
	public String toString() {
		return "CentreFormation [idCentreFormation=" + idCentreFormation + ", nom=" + nom + ", codePostal=" + codePostal
				+ ", ville=" + ville + "]";
	}
	
	
	

}
