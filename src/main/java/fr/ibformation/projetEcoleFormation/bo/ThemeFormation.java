package fr.ibformation.projetEcoleFormation.bo;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ThemeFormation {
	@Id
	@GeneratedValue
	private Integer idTheme;
	private String nomTheme;
	
	@ManyToOne
	private Formation formation;
	
	
	public ThemeFormation(String nomTheme) {
		super();
		this.nomTheme = nomTheme;
	}
	
	
	@Override
	public String toString() {
		return "ThemeFormation [idTheme=" + idTheme + ", nomTheme=" + nomTheme + "]";
	}
	
}
