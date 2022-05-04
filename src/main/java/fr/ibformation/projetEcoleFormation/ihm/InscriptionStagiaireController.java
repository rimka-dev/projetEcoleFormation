package fr.ibformation.projetEcoleFormation.ihm;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.ibformation.projetEcoleFormation.bll.LieuFormationManager;
import fr.ibformation.projetEcoleFormation.bll.UtilisateurManager;
import fr.ibformation.projetEcoleFormation.bo.EntrepriseClient;
import fr.ibformation.projetEcoleFormation.bo.Formateur;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;

@Controller
@RequestMapping("/inscription-stagiaire")
public class InscriptionStagiaireController {

	@Autowired
	private UtilisateurManager utilisateurManager;
	
	@Autowired
	private LieuFormationManager lieuFormationManager;
	
	@GetMapping("/lstStagiaires")
	public String listStagiaires(Stagiaire stagiaire, Model model) {
		model.addAttribute("lstStagiaires", utilisateurManager.getAllStagiaire());
		return "lstStagiaires";
	}
	
	@GetMapping("/add")
    public String add(Stagiaire stagiaire, Model model) {
        model.addAttribute("lstStagiaires", utilisateurManager.getAllStagiaire());
        return "formStagiaire";
    }
	
		
	@PostMapping("/valid")
	public String validInscription(@Valid Stagiaire stagiaire, BindingResult errors, Model model) {
		if (errors.hasErrors()) {
			return "formStagiaire";
		}
		stagiaire.setStatut("Stagiaire");
		utilisateurManager.addStagiaire(stagiaire);
		return "redirect:/inscription-stagiaire/addEntreprise";
	}
	
	
@PostMapping("/validEntreprise")
public String validEntreprise(@Valid EntrepriseClient entreprise, BindingResult errors, Model model) {
	if (errors.hasErrors()) {
		return "formEntreprise";
	}
	lieuFormationManager.addEntreprise(entreprise);
	return "lstEntreprises";
}
	
	@GetMapping("/addEntreprise")
    public String addEntreprise(EntrepriseClient entreprise, Model model) {
        model.addAttribute("lstEntreprises", lieuFormationManager.getAllEntreprise());
        return "formEntreprise";
    }
	
}