package fr.ibformation.projetEcoleFormation.ihm;

import fr.ibformation.projetEcoleFormation.bll.UtilisateurManager;
import fr.ibformation.projetEcoleFormation.bo.Formateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/ihm/connexion")
public class ConnexionController {
    @Autowired
    UtilisateurManager manager;

    @GetMapping("/valid")
    public String get(Formateur formateur, Model model) {
        model.addAttribute("lstFormateurs", manager.getAllFormateur());
        return "connexion";
    }

    @PostMapping("/formateur")
    public String valid(@Valid Formateur formateur, BindingResult errors, Model model) {
        if(errors.hasErrors()) {
            return "connexion";
        }
        manager.addFormateur(formateur);
        return "index";
    }
}

