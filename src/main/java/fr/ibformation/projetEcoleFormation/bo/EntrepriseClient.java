package fr.ibformation.projetEcoleFormation.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class EntrepriseClient {
	@Id
	@GeneratedValue
	private Integer idEntrepriseClient;
	private String nomEntreprise;
	private String adresse;
	private String codePostal;
	private String ville;
	public EntrepriseClient(String nomEntreprise, String adresse, String codePostal, String ville) {
		super();
		this.nomEntreprise = nomEntreprise;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	@Override
	public String toString() {
		return "EntrepriseClient [idEntrepriseClient=" + idEntrepriseClient + ", nomEntreprise=" + nomEntreprise
				+ ", adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	
	

}
