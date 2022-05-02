package fr.ibformation.projetEcoleFormation.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy = "salleFormation")
	private Set <SessionFormation> listeSessionsFormation = new HashSet<>();

	@ManyToOne
	private CentreFormation centreFormation;

	public SalleFormation(String nom, Integer etage) {
		super();
		this.nom = nom;
		this.etage = etage;
	}
	
	public void addSessionFormation(SessionFormation session) {
		this.listeSessionsFormation.add(session);
		session.setSalleFormation(this);
	}

	@Override
	public String toString() {
		return "SalleFormation [idSalleFormation=" + idSalleFormation + ", nom=" + nom + ", etage=" + etage + "]";
	}

}
