package fr.ibformation.projetEcoleFormation.ihm;

import fr.ibformation.projetEcoleFormation.bll.UtilisateurManager;
import fr.ibformation.projetEcoleFormation.bo.Formateur;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import fr.ibformation.projetEcoleFormation.dal.FormateurDAO;
import fr.ibformation.projetEcoleFormation.dal.StagiaireDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/login")
public class ConnexionController {
    @Autowired
    UtilisateurManager manager;

    @Autowired
    StagiaireDAO stagiaireDAO;

    @Autowired
    FormateurDAO formateurDAO;


    @GetMapping("/formateur")
    public String get(Formateur formateur, Model model) {
        model.addAttribute("lstFormateurs", manager.getAllFormateur());
        return "connexionFormateur";
    }

    @PostMapping("/formateur-login")
    public String valid(@Valid Formateur formateur, BindingResult errors, Model model) {
        if(errors.hasErrors()) {
            return "connexionFormateur";
        }
        Formateur checkUserMailExist = formateurDAO.findFormateurByEmail(formateur.getMail());
        if(checkUserMailExist != null && checkUserMailExist.getMdp().equals(formateur.getMdp())){
            return "index";
        }
        return "connexionFormateur";
    }

    @GetMapping("/stagiaire")
    public String get(Stagiaire stagiaire, Model model) {
        model.addAttribute("lstFormateurs", manager.getAllFormateur());
        return "connexionStagiaire";
    }

    @PostMapping("/stagiaire-login")
    public String valid(@Valid Stagiaire stagiaire, BindingResult errors, Model model) {
        if(errors.hasErrors()) {
            return "connexionStagiaire";
            }
        Stagiaire checkUserMailExist = stagiaireDAO.findStagiaireByEmail(stagiaire.getMail());
        if(checkUserMailExist != null && checkUserMailExist.getMdp().equals(stagiaire.getMdp())){
            return "index";
        }
        return "connexionStagiaire";
    }
}

