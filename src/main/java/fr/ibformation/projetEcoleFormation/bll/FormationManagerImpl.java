package fr.ibformation.projetEcoleFormation.bll;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibformation.projetEcoleFormation.bo.EvaluationFormateur;
import fr.ibformation.projetEcoleFormation.bo.Formation;
import fr.ibformation.projetEcoleFormation.bo.SessionFormation;
import fr.ibformation.projetEcoleFormation.bo.SousThemeFormation;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import fr.ibformation.projetEcoleFormation.dal.FormationDAO;
import fr.ibformation.projetEcoleFormation.dal.SessionFormationDAO;
import fr.ibformation.projetEcoleFormation.dal.SousThemeFormationDAO;

@Service
public class FormationManagerImpl implements FormationManager {

	@Autowired
	private FormationDAO formationDAO;
	@Autowired
	private SousThemeFormationDAO sousThemeFormationDAO;
	@Autowired
	private SessionFormationDAO sessionFormationDAO;
	
	@Override
	@Transactional
	public void addFormation(Formation formation) {
		formationDAO.save(formation);
	}
	@Override
	public List<Formation> getListeFormations() {
		return (List<Formation>) formationDAO.findAll();
	}
	@Override
	@Transactional
	public void modifyFormation(Formation formation) {
		formationDAO.save(formation);
		
	}
	@Override
	@Transactional
	public void deleteFormationById(Integer idFormation)  throws FormationException {
		Formation formation = formationDAO.findById(idFormation)
				.orElseThrow(() -> new FormationException("Formation Inexistante"));
		
		for (SessionFormation session : formation.getListeSessionFormation()) {
			deleteSessionFormationById(session.getIdSession());
		}
		formation.getListeSessionFormation().clear();
		
		//https://stackoverflow.com/a/38302308
		for (SousThemeFormation sousTheme : formation.getListeSousThemeFormation()) {
			sousTheme.getListeFormations().remove(formation);
		}
		
		formation.getListeSousThemeFormation().clear();
		
		
		formationDAO.save(formation);
		
		formationDAO.deleteById(idFormation);
		
	}
	@Override
	public Formation getFormationById(Integer idFormation) {
		return formationDAO.findById(idFormation).orElse(null);
	}
	@Override
	@Transactional
	public void addSousThemeFormation(SousThemeFormation... sousThemesFormation) {
		for (SousThemeFormation sousThemeFormation : sousThemesFormation) {
			sousThemeFormationDAO.save(sousThemeFormation);
		}
	}
	@Override
	@Transactional
	public void addSousThemeToFormation(Formation formation, SousThemeFormation... sousThemesFormation) {
		for (SousThemeFormation sousThemeFormation : sousThemesFormation) {
			formation.addSousThemeFormation(sousThemeFormation);
		}
		formationDAO.save(formation);
	}

	@Override
	public List<SousThemeFormation> getListeSousThemesFormation() {
		return (List<SousThemeFormation>) sousThemeFormationDAO.findAll();
	}
	
	@Override
	@Transactional
	public void modifySousThemeFormation(SousThemeFormation sousThemeFormation) {
		sousThemeFormationDAO.save(sousThemeFormation);
		
	}
	@Override
	@Transactional
	public void deleteSousThemeFormationById(Integer idSousThemeFormation) throws FormationException {
		SousThemeFormation sousThemeFormation = sousThemeFormationDAO.findById(idSousThemeFormation)
				.orElseThrow(() -> new FormationException("Sous-Theme Formation Inexistant"));
		sousThemeFormationDAO.deleteById(idSousThemeFormation);
		
	}
	
	@Override
	@Transactional
	public void addSessionFormation(SessionFormation sessionFormation) {
		sessionFormationDAO.save(sessionFormation);
		
	}
	@Override
	public List<SessionFormation> getListeSessionsFormation() {
		return (List<SessionFormation>) sessionFormationDAO.findAll();
	}
	@Override
	@Transactional
	public void modifySessionFormation(SessionFormation sessionFormation) {
		sessionFormationDAO.save(sessionFormation);
		
	}
	@Override
	@Transactional
	public void deleteSessionFormationById(Integer idSessionFormation) throws FormationException {
		SessionFormation session = sessionFormationDAO.findById(idSessionFormation)
				.orElseThrow(() -> new FormationException("SessionFormation Inexistant"));
		//on doit supprimer le lien entre stagiaire et sessionFormation
		//https://stackoverflow.com/a/38302308
		for (Stagiaire stagiaire : session.getListeStagiaires()) {
			stagiaire.getListeSessionFormation().remove(session);
		}
        session.getListeStagiaires().clear();
		
        sessionFormationDAO.save(session);
		sessionFormationDAO.deleteById(idSessionFormation);
		
	}
	@Override
	public SessionFormation getSessionFormationById(Integer idSessionFormation) {
		return sessionFormationDAO.findById(idSessionFormation).orElse(null);
	}
	@Override
	public Integer getExperienceGlobalFormateur(Integer idFormateur) {
		Integer jour = 0; 
		  for (SessionFormation session : sessionFormationDAO.findAllByFormateur(idFormateur)) {
			  
			 jour = (int) ChronoUnit.DAYS.between(session.getDateDebut(), session.getDateFin());
			 jour++;
	        }
		return jour;
	}
	
}
