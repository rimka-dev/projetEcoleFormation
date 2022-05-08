package fr.ibformation.projetEcoleFormation.ihm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.ibformation.projetEcoleFormation.bll.FormationManager;
import fr.ibformation.projetEcoleFormation.bll.UtilisateurManager;
import fr.ibformation.projetEcoleFormation.bo.Formateur;
import fr.ibformation.projetEcoleFormation.bo.Formation;
import fr.ibformation.projetEcoleFormation.bo.SessionFormation;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import fr.ibformation.projetEcoleFormation.ws.NoteExperienceFormateurDTO;
import fr.ibformation.projetEcoleFormation.ws.SessionStagiaireDTO;

@Controller
@RequestMapping("/admin")
public class AdminFormationController {

	@Autowired
	private UtilisateurManager utilisateurManager;
	@Autowired
	private FormationManager formationManager;

	@GetMapping("/note-experience-formateur")
	public String listNoteExpFormateur(Model model) {
		
		List <NoteExperienceFormateurDTO> noteExpFormateurs = new ArrayList<>();
		
		
		for (Formateur formateur : utilisateurManager.getAllFormateur()) {
			NoteExperienceFormateurDTO sessionoteExpFormateurDTO = new NoteExperienceFormateurDTO();
			sessionoteExpFormateurDTO.setNomFormateur(formateur.getNom());
			sessionoteExpFormateurDTO.setPrenomFormateur(formateur.getPrenom());
			Integer id = formateur.getIdUtilisateur();
			
			Double noteMoyenneGlobal = utilisateurManager.getNoteMoyenneGlobalFormateur(id);
			sessionoteExpFormateurDTO.setNoteMoyenne(noteMoyenneGlobal);
			
			Integer expFormateur = formationManager.getExperienceGlobalFormateur(id);
			sessionoteExpFormateurDTO.setExperienceFormateur(expFormateur);
			
			noteExpFormateurs.add(sessionoteExpFormateurDTO);
			
		}
		
		model.addAttribute("noteExpFormateurs", noteExpFormateurs);
		
		return "lstNoteExpFormateur";
	}
	
		
	
	////////////////////////////////////////////////////////////
	///// Données de test
	
	Stagiaire getStagiaire() {
		Stagiaire stagiaire;

		stagiaire = utilisateurManager.getAllStagiaire().get(0);
		
		return stagiaire;
	}
	
}