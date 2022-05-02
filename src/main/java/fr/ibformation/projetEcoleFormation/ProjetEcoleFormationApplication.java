package fr.ibformation.projetEcoleFormation;

import java.time.LocalDate;

import javax.transaction.Transactional;

import fr.ibformation.projetEcoleFormation.bll.UtilisateurManager;
import fr.ibformation.projetEcoleFormation.bll.UtilisateurManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.ibformation.projetEcoleFormation.bo.CentreFormation;
import fr.ibformation.projetEcoleFormation.bo.EntrepriseClient;
import fr.ibformation.projetEcoleFormation.bo.EvaluationFormateur;
import fr.ibformation.projetEcoleFormation.bo.EvaluationSession;
import fr.ibformation.projetEcoleFormation.bo.Formateur;
import fr.ibformation.projetEcoleFormation.bo.Formation;
import fr.ibformation.projetEcoleFormation.bo.SalleFormation;
import fr.ibformation.projetEcoleFormation.bo.SessionFormation;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import fr.ibformation.projetEcoleFormation.bo.SousThemeFormation;
import fr.ibformation.projetEcoleFormation.dal.CentreFormationDAO;
import fr.ibformation.projetEcoleFormation.dal.EntrepriseClientDAO;
import fr.ibformation.projetEcoleFormation.dal.EvaluationFormateurDAO;
import fr.ibformation.projetEcoleFormation.dal.EvaluationSessionDAO;
import fr.ibformation.projetEcoleFormation.dal.FormateurDAO;
import fr.ibformation.projetEcoleFormation.dal.FormationDAO;
import fr.ibformation.projetEcoleFormation.dal.SalleFormationDAO;
import fr.ibformation.projetEcoleFormation.dal.SessionFormationDAO;
import fr.ibformation.projetEcoleFormation.dal.StagiaireDAO;
import fr.ibformation.projetEcoleFormation.dal.ThemeFormationDAO;

@SpringBootApplication
public class ProjetEcoleFormationApplication implements CommandLineRunner {
	@Autowired
	StagiaireDAO stagiaireDAO;
	@Autowired
	FormateurDAO formateurDAO;
	@Autowired
	EntrepriseClientDAO entrepriseClientDAO;
	@Autowired
	EvaluationSessionDAO evaluationSessionDAO;
	@Autowired
	EvaluationFormateurDAO evaluationFormateurDAO;
	@Autowired
	CentreFormationDAO centreFormationDAO;
	@Autowired
	SalleFormationDAO salleFormationDAO;
	@Autowired
	FormationDAO formationDAO;
	@Autowired
	ThemeFormationDAO themeFormationDAO;
	@Autowired
	SessionFormationDAO sessionFormationDAO;

	@Autowired
	UtilisateurManager utilisateurManager;

	public static void main(String[] args) {
		SpringApplication.run(ProjetEcoleFormationApplication.class, args);
		
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		//===================== Celine ==============================
		
		
		//===================== Anael ==================================

		Stagiaire s1 = new Stagiaire("Larue","Benoit","fdsfds@gmail.com","mdp","Stagiaire","6 rue du coq","31000","Toulouse");
		EvaluationSession e1 = new EvaluationSession(5,5,5,true,true);
		utilisateurManager.addEvaluationSessionToStagiaire(s1,e1);
		System.out.println("--------------------------------------");
		utilisateurManager.getAllStagiaire().forEach(System.out::println);
		System.out.println("--------------------------------------");


		//===================== Karim ======================================
		
		
		
		
		
		
		
		
		
		
		
		
	
		//===================== test BO DAL (BDD) =================================================
		Stagiaire stagiaire1 = new Stagiaire("Dupont","Jean","fdsfsd@fdsfds.com","fdsfdsf","Stagiaire","5 rue fdsfsd","31000","Toulouse");
		Formateur formateur1 = new Formateur("Dufdfds","Pierre","fdsfsd@fdsfds.com","fdsfdsf","Formateur","5 rue fdsfsd","31000","Toulouse");
		stagiaireDAO.save(stagiaire1);
		formateurDAO.save(formateur1);
		EntrepriseClient entreprise1 = new EntrepriseClient("Boufdsf","6 rue de la bergerie","66000","Perpignan");
		entreprise1.addStagiaire(stagiaire1);
		System.out.println(stagiaire1.getEntreprise());
		entrepriseClientDAO.save(entreprise1);
		System.out.println(entreprise1.getListeStagiaires());

		entreprise1.getListeStagiaires().forEach(stagiaire -> stagiaire.setMail("toto@yopmail.fr"));
	
		
		
		EvaluationSession evalSession1 = new EvaluationSession(2,3,4,true, true);
		evalSession1.setStagiaire(stagiaire1);
	    evaluationSessionDAO.save(evalSession1);

	    
		EvaluationFormateur evalForm1 = new EvaluationFormateur(2,3,4,5,3,4);
		evalForm1.setFormateur(formateur1);
		evaluationFormateurDAO.save(evalForm1);
		
		
	    formateur1.addEvalFormateur(evalForm1);
	    formateurDAO.save(formateur1);
	    
		stagiaire1.addEvalFormateur(evalForm1);
		stagiaire1.addEvalSession(evalSession1);
		stagiaireDAO.save(stagiaire1);
		

		SessionFormation session1 = new SessionFormation(LocalDate.of(2022,05,10), LocalDate.of(2022,05,15), "intra-entreprise", true, true, true, false, false, false, false, false);
		session1.setEntreprise(entreprise1);
		session1.addStagiaire(stagiaire1);
		sessionFormationDAO.save(session1);
		
		formateur1.addSessionFormation(session1);
	    formateurDAO.save(formateur1);
	    
		SalleFormation salleForm1 = new SalleFormation ("Seine", 1);
		salleForm1.addSessionFormation(session1);
		salleFormationDAO.save(salleForm1);
		
		
		CentreFormation centreForm1 = new CentreFormation ("Ib Cegos", "rue de Paris", "75000", "PARIS");
		centreForm1.addSalleFormation(salleForm1);
		centreFormationDAO.save(centreForm1);
		
		SousThemeFormation sousTheme1 = new SousThemeFormation("JAVA");
		SousThemeFormation sousTheme2 = new SousThemeFormation("HTML");
		SousThemeFormation sousTheme3 = new SousThemeFormation("CSS");
		
		
		entreprise1.addSessionFormation(session1);
		entrepriseClientDAO.save(entreprise1);
		
		Formation formation1 = new Formation ("Informatique", "Apprendre le developpement JAVA", "description", 1040, "Langages de développement");
		formation1.addSousThemeFormation(sousTheme1);
		formation1.addSousThemeFormation(sousTheme2);
		formation1.addSousThemeFormation(sousTheme3);
		formation1.addSessionFormation(session1);
		formationDAO.save(formation1);
		
		
		sousTheme1.addFormation(formation1);
		themeFormationDAO.save(sousTheme1);
		themeFormationDAO.save(sousTheme2);
		themeFormationDAO.save(sousTheme3);
		
		System.out.println(formation1.getListeSousThemeFormation());
	}
}
