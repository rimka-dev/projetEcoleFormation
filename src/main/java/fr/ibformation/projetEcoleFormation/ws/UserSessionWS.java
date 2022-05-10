package fr.ibformation.projetEcoleFormation.ws;


import fr.ibformation.projetEcoleFormation.bo.Utilisateur;
import fr.ibformation.projetEcoleFormation.ihm.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/WS")
public class UserSessionWS {

    @Autowired
    private UserSession user;

    @GetMapping("/session")
    public Utilisateur getUserSession() {
        return user.getUtilisateur();
    }
}
