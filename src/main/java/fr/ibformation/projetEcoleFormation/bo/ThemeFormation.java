package fr.ibformation.projetEcoleFormation.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ThemeFormation extends Formation {
	@Id
	@GeneratedValue
	private Integer idTheme;
	private String nomTheme;
	public ThemeFormation(String nomTheme) {
		super();
		this.nomTheme = nomTheme;
	}
	@Override
	public String toString() {
		return "ThemeFormation [idTheme=" + idTheme + ", nomTheme=" + nomTheme + "]";
	}
	
	

}
