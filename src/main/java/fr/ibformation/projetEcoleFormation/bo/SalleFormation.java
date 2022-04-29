package fr.ibformation.projetEcoleFormation.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SalleFormation {
	@Id
	@GeneratedValue
	private Integer idSalleFormation;
	private String nom;
	private Integer etage;
	
	public SalleFormation(String nom, Integer etage) {
		super();
		this.nom = nom;
		this.etage = etage;
	}

	@Override
	public String toString() {
		return "SalleFormation [idSalleFormation=" + idSalleFormation + ", nom=" + nom + ", etage=" + etage + "]";
	}

	

}
