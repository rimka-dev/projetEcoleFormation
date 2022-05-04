package fr.ibformation.projetEcoleFormation.ihm;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.ibformation.projetEcoleFormation.bll.UtilisateurManager;
import fr.ibformation.projetEcoleFormation.bo.Formateur;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import fr.ibformation.projetEcoleFormation.bo.Utilisateur;

@Controller
public class InscriptionStagiaireController {

	@Autowired
	private UtilisateurManager utilisateurManager;
	
	
	@GetMapping("/inscription-stagiaire/add")
	public String addStagiaire(Stagiaire stagiaire, Model model) {
		return "formAddStagiaire";
	}
	
	@PostMapping("/inscription-stagiaire/valid")
	public String validInscription(@Valid Stagiaire stagiaire, BindingResult errors, Model model) {
		if (errors.hasErrors()) {
			return "formAddStagiaire";
		}
		utilisateurManager.addStagiaire(stagiaire);
		return "redirect:/";
	}
	
}
