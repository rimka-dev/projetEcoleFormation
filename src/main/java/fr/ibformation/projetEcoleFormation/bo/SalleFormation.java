package fr.ibformation.projetEcoleFormation.bo;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SalleFormation {
	@Id
	@GeneratedValue
	private Integer idSalleFormation;
	private String nom;
	private Integer etage;

	@OneToOne
	private SessionFormation sessionFormation;

	@ManyToOne
	private CentreFormation centreFormation;

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
