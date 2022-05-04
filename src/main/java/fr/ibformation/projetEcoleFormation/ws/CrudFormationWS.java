package fr.ibformation.projetEcoleFormation.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ibformation.projetEcoleFormation.bll.FormationException;
import fr.ibformation.projetEcoleFormation.bll.FormationManager;
import fr.ibformation.projetEcoleFormation.bo.Formation;
@CrossOrigin
@RestController
@RequestMapping("/WS")
public class CrudFormationWS {

	@Autowired
	private FormationManager formationManager;
	
	
	@GetMapping("/formation")
	public List<Formation> getFormations(){
		return formationManager.getListeFormations();
	}
	
	@GetMapping("/formation/{id}")
	public Formation getFormationById(@PathVariable("id") Integer id){
		return formationManager.getFormationById(id);
	}
	
	@PostMapping("/formation")
	public Formation addFormation(@RequestBody Formation formation) {
		formationManager.addFormation(formation);
		return formation;
	}
	
	@PutMapping("/formation")
	public Formation modifyFormation(@RequestBody Formation formation) {
		formationManager.modifyFormation(formation);
		return formation;
	}
	
	@DeleteMapping("/formation/{id}")
	public void deleteFormationById(@PathVariable("id") Integer id) throws FormationException {
		formationManager.deleteFormationById(id);
	}
	
}
