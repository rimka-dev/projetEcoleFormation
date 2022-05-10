package fr.ibformation.projetEcoleFormation.ws;


import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserSessionWS {

    @Autowired
    private Stagiaire user;

    @GetMapping("/session")
    public String getUserSession() {
        System.out.println(user);
        return user.getPrenom();
    }
}
