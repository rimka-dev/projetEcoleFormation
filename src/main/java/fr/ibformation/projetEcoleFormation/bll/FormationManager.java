package fr.ibformation.projetEcoleFormation.bll;

import java.util.List;

import fr.ibformation.projetEcoleFormation.bo.Formation;
import fr.ibformation.projetEcoleFormation.bo.SessionFormation;
import fr.ibformation.projetEcoleFormation.bo.SousThemeFormation;

public interface FormationManager {
	public void addFormation(Formation formation);
	public List<Formation> getListeFormations();
	public void modifyFormation(Formation formation);
	public void deleteFormationById(Integer idFormation) throws FormationException;
	public Formation getFormationById(Integer idFormation);
	
	
	public void addSousThemeFormation(SousThemeFormation... sousThemesFormation);
	public void addSousThemeToFormation(Formation formation, SousThemeFormation... sousThemesFormation);
	public List<SousThemeFormation> getListeSousThemesFormation();
	public void modifySousThemeFormation(SousThemeFormation sousThemeFormation);
	public void deleteSousThemeFormationById(Integer idSousThemeFormation) throws FormationException;
	
	
	public void addSessionFormation(SessionFormation sessionFormation);
	public List<SessionFormation> getListeSessionsFormation();
	public void modifySessionFormation(SessionFormation sessionFormation);
	public void deleteSessionFormationById(Integer idSessionFormation) throws FormationException;
	public SessionFormation getSessionFormationById(Integer idSessionFormation);
	
	
}
