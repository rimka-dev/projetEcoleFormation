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

@Controller
public class InscriptionFormateurController {

	@Autowired
	private UtilisateurManager utilisateurManager;
	
	@GetMapping("/inscription-formateur/add")
	public String addFormateur(Formateur formateur, Model model) {
		return "formFormateur";
	}
	
	@PostMapping("/inscription-formateur/valid")
	public String validInscription(@Valid Formateur formateur, BindingResult errors, Model model) {
		if (errors.hasErrors()) {
			return "formFormateur";
		}
		utilisateurManager.addFormateur(formateur);
		return "redirect:/";
	}
	
	@GetMapping("/lstFormateurs")
	public String listFormations(Model model) {
		model.addAttribute("lstFormateurs", utilisateurManager.getAllFormateur());
		return "lstFormateurs";
	}
	
}
