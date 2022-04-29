package fr.ibformation.projetEcoleFormation.bo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
public class Formation {
	@Id
	@GeneratedValue
	private Integer idFormation;
	private String nomDomaine;
	private String nomFormation;
	private String description;
	private Integer prix;
	
	public Formation(String nomDomaine, String nomFormation, String description, Integer prix) {
		super();
		this.nomDomaine = nomDomaine;
		this.nomFormation = nomFormation;
		this.description = description;
		this.prix = prix;
	}
	
	
	@Override
	public String toString() {
		return "Formation [idFormation=" + idFormation + ", nomDomaine=" + nomDomaine + ", nomFormation=" + nomFormation
				+ ", description=" + description + ", prix=" + prix + "]";
	}
	
	

}
