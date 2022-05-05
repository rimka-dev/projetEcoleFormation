package fr.ibformation.projetEcoleFormation.ihm;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.ibformation.projetEcoleFormation.bll.UtilisateurManager;
import fr.ibformation.projetEcoleFormation.bo.EvaluationFormateur;
import fr.ibformation.projetEcoleFormation.bo.EvaluationSession;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import fr.ibformation.projetEcoleFormation.ws.EvaluationDTO;

@Controller
@RequestMapping("/evaluation-formation")
public class EvaluationController {

	@Autowired
	private UtilisateurManager utilisateurManager;
	

	@GetMapping("/add")
    public String add(EvaluationDTO evaluationDTO, Model model) {
        model.addAttribute("lstFormateurs", utilisateurManager.getAllEvaluationSession());
        return "evalFormation";
    }
	
		
	@PostMapping("/valid")
	public String validInscription(@Valid EvaluationDTO evaluationDTO, BindingResult errors, Model model) {
		if (errors.hasErrors()) {
			return "evalFormation";
		}
		
		Stagiaire stagiaire = getStagiaire();
		
		EvaluationSession evalSession = evaluationDTO.toEvaluationSession();
		EvaluationFormateur evalFormateur = evaluationDTO.toEvaluationFormateur();

		evalSession.setStagiaire(stagiaire);
		evalFormateur.setStagiaire(stagiaire);
		
		utilisateurManager.addEvaluationFormateur(evalFormateur);
		utilisateurManager.addEvaluationSession(evalSession);
		return "lstFormateurs";
	}

	
	
	////////////////////////////////////////////////////////////
	///// Données de test
	
	Stagiaire getStagiaire() {
		Stagiaire stagiaire;

		stagiaire = utilisateurManager.getAllStagiaire().get(0);
		
		return stagiaire;
	}
	
}