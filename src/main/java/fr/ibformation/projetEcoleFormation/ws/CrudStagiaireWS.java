package fr.ibformation.projetEcoleFormation.ws;

import fr.ibformation.projetEcoleFormation.bll.UtilisateurManager;
import fr.ibformation.projetEcoleFormation.bll.UtilisateurManagerException;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/WS")
public class CrudStagiaireWS {
    @Autowired
    private UtilisateurManager manager;

    @GetMapping("/stagiaire")
    public List<Stagiaire> getStagiaires(){
        return manager.getAllStagiaire();
    }

    @GetMapping("/stagiaire/{id}")
    public Stagiaire getStagiaireById(@PathVariable("id") Integer id){
        return manager.getStagiaireById(id);
    }


    @PostMapping("/stagiaire")
    public Stagiaire addStagiaire(@RequestBody Stagiaire stagiaire) {
        manager.addStagiaire(stagiaire);
        return stagiaire;
    }

    @PutMapping("/stagiaire")
    public Stagiaire modifyStagiaire(@RequestBody Stagiaire stagiaire) {
        manager.modifyStagiaire(stagiaire);
        return stagiaire;
    }

    @DeleteMapping("/stagiaire")
    public Stagiaire deleteStagiaire(@RequestBody Stagiaire stagiaire) throws UtilisateurManagerException {
        manager.deleteStagiaire(stagiaire);
        return stagiaire;
    }

    @DeleteMapping("/stagiaire/{id}")
    public  List<Stagiaire> deleteFormateurById(@PathVariable("id") Integer id) throws UtilisateurManagerException {
        manager.deleteStagiaireById(id);
        return manager.getAllStagiaire();
    }

}
