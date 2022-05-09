package fr.ibformation.projetEcoleFormation.ihm;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.ibformation.projetEcoleFormation.bll.FormationException;
import fr.ibformation.projetEcoleFormation.bll.FormationManager;
import fr.ibformation.projetEcoleFormation.bll.UtilisateurManager;
import fr.ibformation.projetEcoleFormation.bo.EvaluationFormateur;
import fr.ibformation.projetEcoleFormation.bo.EvaluationSession;
import fr.ibformation.projetEcoleFormation.bo.Formateur;
import fr.ibformation.projetEcoleFormation.bo.SessionFormation;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import fr.ibformation.projetEcoleFormation.ws.EvaluationDTO;

@Controller
@RequestMapping("/evaluation-formation")
public class EvaluationController {

	@Autowired
	private UtilisateurManager utilisateurManager;
	@Autowired
	private FormationManager formationManager;

	@GetMapping("/add/{id}")
    public String add(@PathVariable("id") Integer id, Model model) {
        Stagiaire stagiaire = getStagiaire();

		EvaluationDTO evaluationDTO = new EvaluationDTO();
		
		evaluationDTO.setIdSession(id);
		evaluationDTO.setNom(stagiaire.getNom());

        model.addAttribute("evaluation", evaluationDTO);
        
    	//SessionFormation session = formationManager.getSessionFormationById(id);
    	
        model.addAttribute("nom", evaluationDTO);
        
        return "evalFormation";
    }
	
		
	@PostMapping("/valid/{id}")
	public String validInscription(@Valid EvaluationDTO evaluationDTO, @PathVariable("id") Integer id, BindingResult errors, Model model) throws FormationException {
		if (errors.hasErrors()) {
			return "evalFormation";
		}
		
		Stagiaire stagiaire = getStagiaire();
		Formateur formateur = getFormateur();
		
		
		EvaluationSession evalSession = evaluationDTO.toEvaluationSession();
		EvaluationFormateur evalFormateur = evaluationDTO.toEvaluationFormateur();
        SessionFormation session = evaluationDTO.toSessionFormation();
        evalSession.setSessionFormation(session);
        evalFormateur.setFormateur(formateur);
        evalFormateur.setSessionFormation(session);
		evalSession.setStagiaire(stagiaire);
		evalFormateur.setStagiaire(stagiaire);
        evaluationDTO.toStagiaire();
		utilisateurManager.addEvaluationFormateur(evalFormateur);
		utilisateurManager.addEvaluationSession(evalSession);
		formationManager.addSessionFormation(session);
		utilisateurManager.addStagiaire(stagiaire);
		return "lstFormateurs";
	}

	
	
	////////////////////////////////////////////////////////////
	///// Données de test
	
	Stagiaire getStagiaire() {
		Stagiaire stagiaire;

		stagiaire = utilisateurManager.getAllStagiaire().get(0);
		
		return stagiaire;
	}
	
	Formateur getFormateur() {
		Formateur formateur;

		formateur = utilisateurManager.getAllFormateur().get(0);
		
		return formateur;
	}
	
}