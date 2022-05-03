package fr.ibformation.projetEcoleFormation;

import java.time.LocalDate;

import javax.transaction.Transactional;

import fr.ibformation.projetEcoleFormation.bll.UtilisateurManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import fr.ibformation.projetEcoleFormation.bll.LieuFormationManager;

import fr.ibformation.projetEcoleFormation.bll.FormationManager;

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
import fr.ibformation.projetEcoleFormation.dal.SousThemeFormationDAO;
import fr.ibformation.projetEcoleFormation.dal.StagiaireDAO;

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
	SousThemeFormationDAO sousThemeFormationDAO;
	@Autowired
	SessionFormationDAO sessionFormationDAO;

	
//================== BLL Manager ================
	
	@Autowired
	LieuFormationManager lieuManager;
	


	@Autowired
	UtilisateurManager utilisateurManager;


	@Autowired
	private FormationManager formationManager;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetEcoleFormationApplication.class, args);
		
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		//===================== Celine ==============================
		
		EntrepriseClient entrepriseManag = new EntrepriseClient("Manag","6 rue de la bergerie","66000","Perpignan");
		entrepriseClientDAO.save(entrepriseManag);
		Stagiaire stagiaireManag = new Stagiaire("Manag","Jean","fdsfsd@fdsfds.com","fdsfdsf","Stagiaire","5 rue fdsfsd","31000","Toulouse");
	
		
		// CRUD Session Formation ///
		
		/// ==== Create =====
		SessionFormation sessionManag = new SessionFormation(LocalDate.of(2022,05,10), LocalDate.of(2022,05,15), "intra-entreprise-manag", true, true, true, false, false, false, false, false);
		sessionManag.setEntreprise(entrepriseManag);
		sessionManag.addStagiaire(stagiaireManag);
		
		
		SessionFormation sessionManag2 = new SessionFormation(LocalDate.of(2022,05,10), LocalDate.of(2022,05,15), "inter-entreprise-manag", true, true, true, false, false, false, false, false);
		sessionManag.setEntreprise(entrepriseManag);
		sessionManag.addStagiaire(stagiaireManag);
		
		
		formationManager.addSessionFormation(sessionManag);
		Integer idSession = sessionManag.getIdSession();
		
		
		/// ==== Modify =====
		sessionManag2.setDateFin(LocalDate.of(2022, 10, 20));
		formationManager.modifySessionFormation(sessionManag2);
		
		
		/// ==== Liste =====
		formationManager.getListeSessionsFormation().forEach(System.out::println);
		
		formationManager.getSessionFormationById(idSession);
		
		/// ==== Delete =====
	
		formationManager.deleteSessionFormationById(idSession);
		
		
		
		
		// CRUD Sous-Theme Formation ///
		SousThemeFormation sousTheme1Manag = new SousThemeFormation("JAVA");
		SousThemeFormation sousTheme2Manag = new SousThemeFormation("HTML");
		SousThemeFormation sousTheme3Manag = new SousThemeFormation("CSS");
		
		/// ==== Create =====
		formationManager.addSousThemeFormation(sousTheme1Manag, sousTheme2Manag, sousTheme3Manag);
		
		/// ==== Modify =====
		sousTheme2Manag.setNomSousTheme("Javascript");
		formationManager.modifySousThemeFormation(sousTheme2Manag);
		
		
		/// ==== Liste =====
		formationManager.getListeSousThemesFormation().forEach(System.out::println);
		
		
		
		/// ==== Delete =====
		Integer idSousTheme = sousTheme1Manag.getIdSousTheme();
		formationManager.deleteSousThemeFormationById(idSousTheme);
		
		
		
		// CRUD Formation ///
		
		Formation formation1 = new Formation ("InformatiqueManag", "Apprendre le developpement JAVA", "description", 1040, "Langages de développement");
		Formation formation2 = new Formation ("InformatiqueManag", "Apprendre le developpement PYTHON", "description", 1040, "Langages de développement");
		
		/// ==== Create =====
		formationManager.addFormation(formation1);
		formationManager.addFormation(formation2);
		
		
		formationManager.addSousThemeToFormation(formation1, sousTheme1Manag, sousTheme2Manag, sousTheme3Manag);
		
		/// ==== Modify =====
		formation1.setNomFormation("Parcourir le JAVA");
		formationManager.modifyFormation(formation1);
		
		/// ==== Liste =====
		formationManager.getListeFormations().forEach(System.out::println);
		
		Integer idFormation = formation1.getIdFormation();
		formationManager.getFormationById(idFormation);
		
		/// ==== Delete =====
		
		Integer idFormation2 = formation2.getIdFormation();
		formationManager.deleteFormationById(idFormation2);
		
		formation1.addSessionFormation(sessionManag2);
		formationManager.modifySessionFormation(sessionManag2);
		
		
		
		//===================== Anael ==================================

		Stagiaire s1 = new Stagiaire("Larue","Benoit","fdsfds@gmail.com","mdp","Stagiaire","6 rue du coq","31000","Toulouse");
		EvaluationSession e1 = new EvaluationSession(5,5,5,true,true);
		utilisateurManager.addEvaluationSessionToStagiaire(s1,e1);
		System.out.println("--------------------------------------");
		utilisateurManager.getAllStagiaire().forEach(System.out::println);
		System.out.println("--------------------------------------");


		//===================== Karim ======================================
		
		/**
		 * CRUD Salle de formation
		 */
		
		SalleFormation salleVerte = new SalleFormation("Salle verte", 3);
		SalleFormation salleRouge = new SalleFormation("Salle Rouge", 1);
		//=== Create =========
		lieuManager.addSalleFormation(salleVerte);
		lieuManager.addSalleFormation(salleRouge);
		//======== Update =====
		salleRouge.setEtage(4);
		lieuManager.updateSalleFormation(salleRouge);
		//======= Read all ======
		lieuManager.getAllSalle().forEach(System.out::println);
		//====== Read by ID =========
		Integer id = salleRouge.getIdSalleFormation();
		System.out.println("salle par id "+lieuManager.getSalleById(id));
		// === Delete =========
		lieuManager.deleteSalle(salleVerte);
		
		//lieuManager.deleteSalle(salleVerte); //test de delete un élément qui n'existe pas 
		
		/**
		 * CRUD Centre de formation 
		 */
		
		CentreFormation centre1 = new CentreFormation("ibFormation","rue de la defense" , "92742","Nanterre");
		CentreFormation centre2 = new CentreFormation("ibCegos","rue de la liberte" , "75010","Paris");
		//=== Create =========
		centre2.addSalleFormation(salleRouge);
		lieuManager.addCentreFormation(centre1);
		lieuManager.addCentreFormation(centre2);
		
		//======== Update ==================
		centre2.setCodePostal("75018");
		lieuManager.updateCentreFormation(centre2);
		// =========== get all =============
		lieuManager.getAllCentreFormation().forEach(System.out::println);
		// ========== get by ID ============
		Integer id1 = centre1.getIdCentreFormation();
		System.out.println("Centre de formation par ID "+lieuManager.getCentreFormationById(id1)); 
		//========= delete by ID ===========
		lieuManager.deleteCentreFormationById(id1);
		//lieuManager.deleteCentreFormationById(id1); //test element n'existe pas
		
		/**
		 * CRUD Entreprise
		 */
		
		EntrepriseClient entrepriseOne = new EntrepriseClient("Sogeti", "Boulevard des entreprises", "92130", "issy les moulineaux");
		EntrepriseClient entrepriseTwo = new EntrepriseClient("Microsoft", "Boulevard des entreprises", "90001", "californie");
		//======== Create ======================
		lieuManager.addEntreprise(entrepriseOne);
		lieuManager.addEntreprise(entrepriseTwo);
		//======== Update ======================
		entrepriseOne.setNomEntreprise("Capgemini");
		lieuManager.updateEntreprise(entrepriseOne);
		//======== get all ======================
		lieuManager.getAllEntreprise().forEach(System.out::println);
		//======== get by id ====================
		Integer idEntreprise = entrepriseOne.getIdEntrepriseClient();
		System.out.println("Entreprise par ID "+lieuManager.getEntrepriseById(idEntreprise));
		//======== delete by ID =================
		lieuManager.deleteEntrepriseById(idEntreprise);
		
		
		
	
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
		
		Formation formation1bis = new Formation ("Informatique", "Apprendre le developpement JAVA", "description", 1040, "Langages de développement");
		formation1bis.addSousThemeFormation(sousTheme1);
		formation1bis.addSousThemeFormation(sousTheme2);
		formation1bis.addSousThemeFormation(sousTheme3);
		formation1bis.addSessionFormation(session1);
		formationDAO.save(formation1bis);
		
		
		sousTheme1.addFormation(formation1bis);
		sousThemeFormationDAO.save(sousTheme1);
		sousThemeFormationDAO.save(sousTheme2);
		sousThemeFormationDAO.save(sousTheme3);
		
		System.out.println(formation1bis.getListeSousThemeFormation());
	}
	
}
