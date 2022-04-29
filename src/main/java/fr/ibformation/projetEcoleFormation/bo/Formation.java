package fr.ibformation.projetEcoleFormation.bo;


import java.util.HashSet;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	@OneToMany
	Set <ThemeFormation> listeThemeFormation = new HashSet<>();
	
	@OneToMany
	Set <SessionFormation> listeSessionFormation = new HashSet<>();
	
	public Formation(String nomDomaine, String nomFormation, String description, Integer prix) {
		super();
		this.nomDomaine = nomDomaine;
		this.nomFormation = nomFormation;
		this.description = description;
		this.prix = prix;
	}
	

	public void addThemeFormation(ThemeFormation theme) {
		this.listeThemeFormation.add(theme);
		theme.setFormation(theme);
	}
	
	
	public void addSessionFormation(SessionFormation session) {
		this.listeSessionFormation.add(session);
		session.setFormation(this);
	}
	
	@Override
	public String toString() {
		return "Formation [idFormation=" + idFormation + ", nomDomaine=" + nomDomaine + ", nomFormation=" + nomFormation
				+ ", description=" + description + ", prix=" + prix + "]";
	}
	
	

}
