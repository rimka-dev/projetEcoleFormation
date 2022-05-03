package fr.ibformation.projetEcoleFormation.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ibformation.projetEcoleFormation.bll.LieuFormationManager;
import fr.ibformation.projetEcoleFormation.bo.SalleFormation;

@RestController
@RequestMapping("/WS")
public class CrudSalleFormation {
	@Autowired
	private LieuFormationManager manager;
	
	@GetMapping("/salleFormation")
	public List<SalleFormation> getSalleFormation(){
		return manager.getAllSalle();
		
	}
	
	@GetMapping("/salleFormation/{id}")
	public SalleFormation getSalleById(@PathVariable("id") Integer id) {
		return manager.getSalleById(id);
		
	}
	
	@PostMapping("/salleFormation")
	public SalleFormation addSalleFormation(@RequestBody SalleFormation salle ) {
		 manager.addSalleFormation(salle);
		 return salle;
		
	}
	
	

}
