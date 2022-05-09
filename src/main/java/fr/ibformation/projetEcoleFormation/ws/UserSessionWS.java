package fr.ibformation.projetEcoleFormation.ws;

import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class UserSessionWS {
    @Resource(name = "stagiaireSession")
    Stagiaire sessionScopedStagiaire;

    @GetMapping("/session")
    public Stagiaire getSessionStagiaire(){
        return sessionScopedStagiaire;
    }
}
